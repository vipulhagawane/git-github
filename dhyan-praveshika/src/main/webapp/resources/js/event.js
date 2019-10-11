$(document).ready(function () {
  
  //Editor
  
  
  $.ajax({
	    type: "get",
	    url: '/dhyanpraveshika-web/isEventAdd',
	   
	    success: function(data){
	    
	    // alert(data);
	    // if(data == "")
	    	if(sessionStorage.getItem("addEvent") == null)
	    	 {
	    		
	    	 $('#events').DataTable().ajax.reload();
	    	 }
	     //else if(data == "success")
	    	 else if(sessionStorage.getItem("addEvent") == "success") 
	    	 {
	    	 swal("Event has been added!", {
	 			  icon: "success",
	 			});
	       	
	       	 $('#events').DataTable().ajax.reload();
	       	sessionStorage.setItem("addEvent",null);
	    	 }
	     else if(data == "fail")
		 {
	     swal("Failed to add!");
	   	
	   	 $('#events').DataTable().ajax.reload();
	   	sessionStorage.setItem("addEvent",null);
		 }
	    },
	    error: function(){      
	     //alert('Error while isEventAdd..');
	    }
	   });
  
  
  $('#events').DataTable({
	  
	  ajax : {
		  url : '/dhyanpraveshika-web/getEvents',
			  dataSrc : ''
	  },
	  columns:[
		  {title : 'Title' , data : 'title'},
		  {title : 'Description' , data : 'description'},
		  {title : 'Date' , data : 'eventDate'},
		  {title : 'Time' , data : 'eventTime'},
		  {title : 'Location' , data : 'location'},
		  {title : 'Actions' , data : 'id', "render": function (data) {
              return "<a class='btn btn-info tblBtn' onclick='getRowID("+data+")'><i class='fa fa-pencil'></i></a><a class='btn btn-danger tblBtn' onclick='deleteevent("+data+")'><i class='fa fa-trash'></i></a>"}
                      
		  }
		  ]
});
  
 /* $('.modal').on('hidden.bs.modal', function (e) {
	  $(this)
	    .find("input,textarea,select")
	       .val('')
	       .end()
	    .find("input[type=checkbox], input[type=radio]")
	       .prop("checked", "")
	       .end();
	});*/
  $('.modal').on('hidden.bs.modal', function (e) {
	  $(this)
	    .find("input,textarea,select,img")
	       .val('')
	       .end()
	    .find("input[type=checkbox], input[type=radio]")
	       .prop("checked", "")
	       .end()
	       .find("img")
	       .attr("src", "")
	       .end();
	  //CKEDITOR.instances.editor12.setData('');
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
         url : "/dhyanpraveshika-web/getEvent?id="+id,
         
         success : function(data,request) {
            // alert(JSON.stringify(data.eventDate));
             $('#id').val(data.id);
             $('#title').val(data.title);
             $('#date').val(data.eventDate);
             $('#time').val(data.eventTime);
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
			  
				$.ajax("/dhyanpraveshika-web/deleteEvent?id="+id,   // request url
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






