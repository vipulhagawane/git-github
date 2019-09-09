$(document).ready(function () {
  $('#example').DataTable();
  //Editor
  
  
  $.ajax({
	    type: "get",
	    url: "/isEventAdd",
	   
	    success: function(data){
	    
	     // alert(data);
	     if(data == "")
	    	 {
	    	 $('#events').DataTable().ajax.reload();
	    	 }
	     else if(data == "success")
	    	 {
	    	 swal("Event has been added!", {
	 			  icon: "success",
	 			});
	       	
	       	 $('#events').DataTable().ajax.reload();
	    	 }
	     else if(data == "fail")
		 {
	     swal("Failed to add!");
	   	
	   	 $('#events').DataTable().ajax.reload();
		 }
	    },
	    error: function(){      
	     alert('Error while request..');
	    }
	   });
  
  
  $('#events').DataTable({
	  
	  ajax : {
		  url : '/getEvents',
			  dataSrc : ''
	  },
	  columns:[
		  {title : 'Title' , data : 'title'},
		  {title : 'Description' , data : 'description'},
		  {title : 'Date' , data : 'eventDate'},
		  {title : 'Time' , data : 'eventTime'},
		  {title : 'Location' , data : 'location'},
		  {title : 'Actions' , data : 'id', "render": function (data) {
              return "<a class='btn btn-info tblBtn' onclick='getRowID("+data+")'><i class='fa fa-pencil'></i></a><a class='btn btn-warning tblBtn'><i class='fa fa-eye'></i></a><a class='btn btn-danger tblBtn' onclick='deleteevent("+data+")'><i class='fa fa-trash'></i></a>"}
                      
		  }
		  ]
});
  
  $('.modal').on('hidden.bs.modal', function (e) {
	  $(this)
	    .find("input,textarea,select")
	       .val('')
	       .end()
	    .find("input[type=checkbox], input[type=radio]")
	       .prop("checked", "")
	       .end();
	});
  
  $('#eventSelectImage').on('click', function () {
      $('#hiddenFileOpner').trigger('click');
      $('#hiddenFileOpner[type="file"]').change(function (e) {
        var fileName = e.target.files[0].name;
        $('#imageNameShowBox').val(fileName);
      });

    });

});

function getRowID(id){
	//alert(id);
	 $.ajax({
		 type : 'GET',
         url : "/getEvent?id="+id,
         
         success : function(data,request) {
             //alert(JSON.stringify(data));
             $('#id').val(data.id);
             $('#title').val(data.title);
             $('#date').val(data.date);
             $('#time').val(data.time);
             $('#location').val(data.location);
             $('#description').val(data.description);
           // $('#image').val(data.eventFile);
            // console.log(data.encodedString);
             if(data.encodedString !== null){
            	 $('#image').attr('src', 'data:image/' + $('#extension').val(data.extension) + ';base64,' + data.encodedString);
            	 $('#image').show();
             }
             
             $('#editAddEventModal').modal('show');
         }
     });
}

//Sweetalert
function deleteevent(id){
	  swal({
		  title: "Are you sure?",
		  text: "Once deleted, you will not be able to recover this record!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  
				$.ajax("/deleteEvent?id="+id,   // request url
					    {
					        success: function () {
					        	swal("Record has been deleted!", {
					  			  icon: "success",
					  			});
					        	
					        	 $('#events').DataTable().ajax.reload();
					    }
					});
			  
			
		  } else {
			swal("Your record is safe!");
		  }
		});
		
}



