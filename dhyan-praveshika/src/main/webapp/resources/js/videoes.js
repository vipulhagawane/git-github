$(document).ready(function () {
	
	 $.ajax({
		   
		    url: '/dhyanpraveshika-web/isVideoAdd',
		   
		    success: function(data){
		    
		     //alert(data);
		     if(data == "")
		    	 {
		    	 $('#videoes').DataTable().ajax.reload();
		    	 }
		     else if(data == "success")
		    	 {
		    	 swal("Video has been added!", {
		 			  icon: "success",
		 			});
		       	
		       	 $('#videoes').DataTable().ajax.reload();
		    	 }
		     else if(data == "fail")
			 {
		     swal("Failed to add!");
		   	
		   	 $('#videoes').DataTable().ajax.reload();
			 }
		    },
		    error: function(){      
		     //alert('Error while request..');
		    }
		   });
		 

 $('#videoes').DataTable({
	 
	  ajax : {
		  url : '/dhyanpraveshika-web/getVideoes',
			  dataSrc : ''
	  },
	  columns:[
		  {title : 'Video Name' , data : 'title'},
		  {title : 'Video Url' , data : 'path'},
		  {title : 'Video Category' , data : 'category'},
		  {title : 'Actions' , data : 'id', "render": function (data) {
			   return "<a class='btn btn-info tblBtn' onclick='getRowID("+data+")'><i class='fa fa-pencil'></i></a><button class='btn btn-warning tblBtn' onclick='openVideoUrl(event)'><i class='fa fa-eye'></i></button><a class='btn btn-danger tblBtn' onclick='deleteRow("+data+")'><i class='fa fa-trash'></i></a>"}
                      
		  }
		  ]
});
 
 $('.modal').on('hidden.bs.modal', function (e) {
	  $(this)
	    .find("input,textarea,select,img")
	       .val('')
	       .end()
	    .find("input[type=checkbox], input[type=radio]")
	       .prop("checked", "")
	       .end();
	});

});




//Sweetalert
function deleteRow(id){
	  swal({
		  title: "Are you sure?",
		  text: "Once deleted, you will not be able to recover this record!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  
				$.ajax("/dhyanpraveshika-web/deleteVideo?id="+id,   // request url
					    {
					        success: function () {
					        	swal("Record has been deleted!", {
					  			  icon: "success",
					  			});
					        	
					        	 $('#videoes').DataTable().ajax.reload();
					    }
					});
			  
			
		  } else {
			swal("Your record is safe!");
		  }
		});
		
}

//getVideos
function getRowID(id){
	 //alert("hiii");
	$.ajax({
		 type : 'GET',
       url : "/dhyanpraveshika-web/getVideo?id="+id,
       
       success : function(data) {
           //alert(JSON.stringify(data.id));
           $('#id').val(data.id);
           $('#title').val(data.title);
           $('#category').val(data.category);
           $('#path').val(data.path);
     
           
           /*CKEDITOR.instances.editor12.setData(data.description)*/
           $('#editAddVideoModal').modal('show');
       }
       
	 });
}


function openVideoUrl(event){
	var selectedRow = event.target.closest('tr');
	var VID_REGEX = /(?:youtube(?:-nocookie)?\.com\/(?:[^\/\n\s]+\/\S+\/|(?:v|e(?:mbed)?)\/|\S*?[?&]v=)|youtu\.be\/)([a-zA-Z0-9_-]{11})/;
    var VideoId =  selectedRow.children[1].textContent.match(VID_REGEX)[1];
	
	 window.open("https://www.youtube.com/embed/" + VideoId);
}




