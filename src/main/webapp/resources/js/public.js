/**
 * 
 */
 
 $(function(){
	$(window).scroll(function(){
		var top = $(this).scrollTop();
		if(top>=401){
			$('.mypage-nav').addClass('scroll');
		}else {
			$('.mypage-nav').removeClass('scroll');
		}
	})
})