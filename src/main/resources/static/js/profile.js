$(function(){
	
	$('#profileTable').DataTable();
	
	$('#profileTable tbody').on('click', 'tr', function(){
		var id = $(this).attr('value');
		window.location.replace("/view/?id="+id);
	});
});