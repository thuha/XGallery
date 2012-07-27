$(function() {		
	// popover demo
	$("a[rel=popover]").popover()	      
});



function viewPhoto(title,url){
	$("#modal_photo_title").replaceWith('<h2>'+title+'</h2>');
	$("#modal_photo_content").attr("src", url);
	
	$("#pix-modal").modal("show");
}

