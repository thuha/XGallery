
	$(function() {
		// sortable
		$( "#sortable" ).sortable();
		$( "#sortable" ).disableSelection();	

		$("#like-btn").button({
		    	icons: {
		       		primary: "ui-icon-heart",		        	
		    	}
		});
		$("#refresh-btn").button({
	    	icons: {
	       		primary: "ui-icon-arrowrefresh-1-n",		        	
	    	}
		});
	});
