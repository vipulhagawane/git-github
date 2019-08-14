$(document).ready(function () {

 $('#videoes').DataTable({
	  
	  ajax : {
		  url : '/getVideoes',
			  dataSrc : ''
	  },
	  columns:[
		  {title : 'Video Name' , data : 'title'},
		  {title : 'Video Url' , data : 'path'},
		  {title : 'Video Category' , data : 'category'},
		  {title : 'Actions' , data : 'id', "render": function (data) {
			   return "<a class='btn btn-info tblBtn' onclick='getRowID("+data+")'><i class='fa fa-pencil'></i></a><a class='btn btn-warning tblBtn'><i class='fa fa-eye'></i></a><a class='btn btn-danger tblBtn' onclick='deleteRow("+data+")'><i class='fa fa-trash'></i></a>"}
                      
		  }
		  ]
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
			  
				$.ajax("/deleteVideo?id="+id,   // request url
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
	 alert("hiii");
	$.ajax({
		 type : 'GET',
       url : "/getVideos?id="+id,
       
       success : function(data) {
           alert(JSON.stringify(data.id));
           $('#id').val(data.id);
           $('#title').val(data.title);
           $('#category').val(data.category);
           $('#path').val(data.path);
     
           
           /*CKEDITOR.instances.editor12.setData(data.description)*/
           $('#editAddVideoModal').modal('show');
       }
       
	 });
}





