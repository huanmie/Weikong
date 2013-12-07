/**
 * 下拉刷新组件
 * @author: youxiao@alibaba-inc.com
 * @version: 1-0-0
 * @onlineVersion:
 */
;(function(){
    /**
     * @class PullToRefresh
     * @param options
     *      @param {String} [options.id] iScroll的容器ID
     *      @param {Number} [options.offset] 下拉刷新的生效距离
     *      @param {Function} [options.pullDownAction] 下拉刷新生效的回调，数据加载成功后，主动调用callback完成一次加载
     *
     *          {
     *              pullDownAction: function(callback){
     *                  $.ajax({
     *                      url: xxx,
     *                      success: function(){
     *                          ...
     *                          callback();
     *                      }
     *                  })
     *              }
     *          }
     *
     *      @param {Function} [options.pullUpAction] 上拉刷新生效的回调，数据加载成功后，主动调用callback完成一次加载
     *      @param {String} [options.pullDownLabelPull] 下拉刷新的提示
     *      @param {String} [options.pullDownLabelRelease] 下拉后松开进行刷新的提示
     *      @param {String} [options.pullDownLabelLoading] 下拉刷新后开始加载的提示
     *      @param {String} [options.pullUpLabelPull] 上拉加载的提示
     *      @param {String} [options.pullUpLabelRelease] 上拉后松开进行加载的提示
     *      @param {String} [options.pullUpLabelLoading] 上拉后开始加载的提示
     * @constructor
     */
    function PullToRefresh(options){
        var _this = this;
        this.$el = $('#' + options.id);

        this.$el.addClass('pull-to-refresh');

        var pullDownLabelPull = options.pullDownLabelPull || '下拉可以刷新...',
            pullUpLabelPull = options.pullUpLabelPull || '上拉可以加载更多...',
            pullDownLabelRelease = options.pullDownLabelRelease || '松开刷新...',
            pullUpLabelRelease = options.pullUpLabelRelease || '松开刷新加载更多...',
            pullDownLabelLoading = options.pullDownLabelLoading || '加载中...',
            pullUpLabelLoading = options.pullUpLabelLoading || '加载中...',
            offset = options.offset || 10;

        var $pullDownEl,
            $pullUpEl,
            pullDownAction = options.pullDownAction,
            pullUpAction = options.pullUpAction;

        var $scroller = this.$el.children().eq(0);
        if(pullDownAction){
            $pullDownEl = $('<div class="pull-down"><span class="icon"></span><span class="label">'+pullDownLabelPull+'</span></div>');
            $scroller.prepend($pullDownEl);
        }
        if(pullUpAction){
            $pullUpEl = $('<div class="pull-up"><span class="icon"></span><span class="label">'+pullUpLabelPull+'</span></div>');
            $scroller.append($pullUpEl);
        }

        this.iscroll = new iScroll(options.id, {
            useTransition: true,
            topOffset: $pullDownEl.height() || 50,
            onBeforeScrollStart: function(e){
                var tagName = e.target.tagName;
                if (tagName != 'SELECT' && tagName != 'INPUT' && tagName != 'TEXTAREA'){
                    e.preventDefault();
                }
            },
            onRefresh: function () {
                if (pullDownAction && !_this.pullDownDisabled && $pullDownEl.hasClass('loading')) {
                    $pullDownEl.removeClass('loading');
                    $pullDownEl.find('.label').text(pullDownLabelPull);
                } else if (pullUpAction && !_this.pullUpDisabled && $pullUpEl.hasClass('loading')) {
                    $pullUpEl.removeClass('loading');
                    $pullUpEl.find('.label').text(pullUpLabelPull);
                }
            },
            onScrollMove: function () {
                if (pullDownAction && !_this.pullDownDisabled && this.y > offset && !$pullDownEl.hasClass('flip')) {
                    $pullDownEl.addClass('flip');
                    $pullDownEl.find('.label').text(pullDownLabelRelease);
                    this.minScrollY = 0;
                } else if (pullDownAction && !_this.pullDownDisabled && this.y < offset && $pullDownEl.hasClass('flip')) {
                    $pullDownEl.removeClass('flip');
                    $pullDownEl.find('.label').text(pullDownLabelPull);
                    this.minScrollY = -offset;
                } else if (pullUpAction && !_this.pullUpDisabled && this.y < (this.maxScrollY - offset) && !$pullUpEl.hasClass('flip')) {
                    $pullUpEl.addClass('flip');
                    $pullUpEl.find('.label').text(pullUpLabelRelease);
                } else if (pullUpAction && !_this.pullUpDisabled && this.y >= (this.maxScrollY - offset) && $pullUpEl.hasClass('flip')) {
                    $pullUpEl.removeClass('flip');
                    $pullUpEl.find('.label').text(pullUpLabelPull);
                }
            },
            onScrollEnd: function () {
                var _self = this;
                if (pullDownAction && !_this.pullDownDisabled && $pullDownEl.hasClass('flip')) {
                    $pullDownEl.removeClass('flip').addClass('loading');
                    $pullDownEl.find('.label').text(pullDownLabelLoading);
                    pullDownAction.call(this, function(){
                        _self.refresh();
                    });
                } else if (pullUpAction&& !_this.pullUpDisabled  && $pullUpEl.hasClass('flip')) {
                    $pullUpEl.removeClass('flip').addClass('loading');
                    $pullUpEl.find('.label').text(pullUpLabelLoading);
                    pullUpAction.call(this, function(){
                        _self.refresh();
                    });
                }
            }
        });
    }
    PullToRefresh.prototype = {
        constructor: PullToRefresh,
        /**
         * 数据请求完成后调用
         * @method refresh
         */
        refresh: function(){
            this.iscroll.refresh();
        },
        /**
         * 禁用下拉、上拉更新功能
         * @method disable
         * @param {String} [direction] 禁用哪个方向，`down` 或者 `up`，默认全部禁用
         */
        disable: function(direction){
            var $down = this.$el.find('.pull-down'),
                $up = this.$el.find('.pull-up');
            if(direction === 'up'){
                this.pullUpDisabled = true;
                $up.hide();
                return;
            }else if(direction === 'down'){
                this.pullDownDisabled = true;
                $down.hide();
            }else{
                this.pullUpDisabled = true;
                this.pullDownDisabled = true;
                $up.hide();
                $down.hide();
            }
            if(direction === 'down' || !direction){
                this.iscroll.options.topOffset = 0;
                this.iscroll.y = 0;
                this.$el.children().eq(0).css('-webkit-transform', 'translateY(0)');
                this.iscroll.refresh();
            }
        },
        /**
         * 启用下拉、上拉更新功能
         * @method enable
         * @param {String} [direction] 启用哪个方向，`down` 或者 `up`，默认全部启用
         */
        enable: function(direction){
            var $down = this.$el.find('.pull-down'),
                $up = this.$el.find('.pull-up');
            if(direction === 'up'){
                this.pullUpDisabled = false;
                $up.show();
                return;
            }else if(direction === 'down'){
                this.pullDownDisabled = false;
                $down.show();
            }else{
                this.pullUpDisabled = false;
                this.pullDownDisabled = false;
                $up.show();
                $down.show();
            }
            if(direction === 'down' || !direction){
                this.iscroll.options.topOffset = $down.height() || 50;
                this.iscroll.minScrollY = -this.iscroll.options.topOffset;
                this.iscroll.refresh();
            }
        },
        /**
         * 销毁自己
         * @method destroy
         */
        destroy: function(){
            this.$el.find('.pull-down').remove();
            this.$el.find('.pull-up').remove();
            this.iscroll.destroy();
        }
    };
    window.PullToRefresh = PullToRefresh;
})();