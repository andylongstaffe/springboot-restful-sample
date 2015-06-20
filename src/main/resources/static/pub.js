function addNewRow(pubrequest) {
    
    $('#pending_requests > tbody:last').append('<tr><td>' + pubrequest.id + '</td><td>' + pubrequest.requestDate + '</td></tr>');

}

function getMockPendingRequests() {
	return [{"id":"234","requestDate":null,"status":"pending","requestUser":"tobedone"},{"id":"123","requestDate":null,"status":"pending","requestUser":"tobedone"}];

} 

function populatePendingRequests() {
	console.log('Getting all pending publication requests');
	$.get( "publication/request/design/pending", function( data ) {
		// clear existing rows first
		$("#pending_requests tbody").empty();
		// add all requests
		$.each( data, function( idx, pubrequest ) {
	        addNewRow(pubrequest);
	    });
    });
   
}

	  $(document).ready(function () {
	
		  	populatePendingRequests();
		  	
	        $("#btnPubRequest").click(
	            function () {         
	                console.log('Pub requested');
	                appNumber = $('#app_number').val();
	                $.ajax({
	                	  method: "PUT",
	                	  url: "publication/request/design/" + appNumber
	                });
	                // update table
	                populatePendingRequests();
	            }            
	        );
	      
	        $("#btnRefresh").click(
		            function () {         
		                console.log('Refreshing...');
		                populatePendingRequests();
		                console.log('Refreshing complete.');
		            }            
		    );
	        
	      
	      
	    });
