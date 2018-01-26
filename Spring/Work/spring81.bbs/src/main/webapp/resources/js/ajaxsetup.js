$(document).ajaxStart(function() {
	// 통신이 시작되기 전
	// beforeSend() 메서드와 같은 것
	$('body').prepend('<img src="/resources/images/loading.gif"/>');
});

$(document).ajaxComplete(function(data, textStatus, xhr) {
	// 통신이 실패했어도 성공했어도 이 함수를 타게 된다. 표출된 시계 감추기..
	// always() 메서드와 같은 것
	$('body img[src$="loading.gif"]').remove();
	
});

$(document).ajaxError(function(xhr, textStatus, error) {
	// 통신이 실패했을 떄 이 함수를 타게 된다
	// fail() 메서드와 같은 것
	console.log(error);
});