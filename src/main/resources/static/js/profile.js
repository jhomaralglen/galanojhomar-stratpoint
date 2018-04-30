$(function(){
	
	$("#profileTable").DataTable();
	
	$('.trow').on('click', function(){
		var id = $(this).attr('value');
		window.location.replace("/view/?id="+id);
	});
});