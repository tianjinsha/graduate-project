$.fn.extend({
  /**
   * 元素电脑剧中
   * @param htmldom
   */
  center: function (htmldom) {
    var h = $(window).height();
    var w = $(window).width();
    var height = $(this).outerHeight();
    var width = $(this).outerWidth();
    $(this).css({
      "display":"block",
      "position": "flexd",
      "top": (h - height) / 2 > 0 ? (h - height) / 2 : 0,
      "left": (w - width) / 2 > 0 ? (w - width) / 2 : 0
    })
  },
  lock: function (htmldom) {
    screen = $("<div class='screen'></div>");
    var height = $(document).height();
    var width = $(document).width();
    $(this).append(screen);
    screen.css({
      "position": "absolute",
      "top": "0",
      "left": "0",
      "display": "none",
      "background": "#000",
      "z-index": "251",
      "opacity": "0.3",
      "width": width,
      "height": height,
    });
    screen.fadeIn();
  },
  unlock: function (htmldom) {
    $(this).fadeOut(function () {
      $(this).remove();
    });
    // $(this).remove();
  }

})
$.extend({})


