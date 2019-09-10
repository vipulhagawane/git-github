$(document).ready(function () {
	
	alert("at home");
	$.ajax({
    type: "get",
    url: "/isArticleAdd",
   
    success: function(data){
    
     alert(data);
     if(data == "")
    	 {
    	 $('#article').DataTable().ajax.reload();
    	 }
     else if(data == "success")
    	 {
    	 swal("Article has been added!", {
 			  icon: "success",
 			});
       	
       	 $('#article').DataTable().ajax.reload();
    	 }
     else if(data == "fail")
	 {
     swal("Failed to add!");
   	
   	 $('#article').DataTable().ajax.reload();
	 }
    },
    error: function(){      
     alert('Error while request..');
    }
   });
 
$('#article').DataTable({
	  
	alert('article');
	  ajax : {
		  type: 'get',
		  url : '/getBlogs',
			  dataSrc : ''
	  },
	  alert('data'+data);
	  columns:[
		  {title : 'Name Of Article' , data : 'title'},
		  {title : 'Date' , data : 'created_date'},
		  {title : 'Created By' , data : 'author'},
		  {title : 'Category' , data : 'category'},
		  {title : 'Actions' , data : 'id', "render": function (data) {
              return "<a class='btn btn-info tblBtn' onclick='getArticle("+data+")'><i class='fa fa-pencil'></i></a><a class='btn btn-warning tblBtn' href='/viewArticle?id="+data+"'><i class='fa fa-eye'></i></a><a class='btn btn-danger tblBtn' onclick='deleteArticle("+data+")'><i class='fa fa-trash'></i></a>"}
                      
		  }
	  ]
});

//to delete data from modal
$('.modal').on('hidden.bs.modal', function (e) {
	  $(this)
	    .find("input,textarea,select,img")
	       .val('')
	       .end()
	    .find("input[type=checkbox], input[type=radio]")
	       .prop("checked", "")
	       .end();
	});

$('#articleSelectImage').on('click', function () {
    $('#hiddenFileOpner').trigger('click');
    $('#hiddenFileOpner[type="file"]').change(function (e) {
      var fileName = e.target.files[0].name;
      $('#imageNameShowBox').val(fileName);
    });

  });


});

	
function getArticle(id){
	//window.location.href = "/getArticle?id="+id;
	 $.ajax({
		 type : 'GET',
         url : "/getArticle?id="+id,
         
         success : function(data) {
             //alert(JSON.stringify(data));
             $('#id').val(data.id);
             $('#articleTital').val(data.title);
             $('#authorName').val(data.author);
             $('#category').val(data.category);
             CKEDITOR.instances.editor12.setData(data.description);
             //alert(data.encodedString);
             if(data.encodedString !== null){
            	 $('#image').attr('src', 'data:image/' + $('#extension').val(data.extension) + ';base64,' + data.encodedString);
            	 $('#image').show();
             }
             $('#editViewArticleModal').modal('show');
         }
     });
	//$('#editViewArticleModal').modal('show');
}
function deleteArticle(id){
	  swal({
		  title: "Are you sure?",
		  text: "Once deleted, you will not be able to recover this record!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  
				$.ajax("/deleteArticle?id="+id,   // request url
					    {
					        success: function () {
					        	swal("Record has been deleted!", {
					  			  icon: "success",
					  			});
					        	
					        	 $('#article').DataTable().ajax.reload();
					    }
					});
			  
			
		  } else {
			swal("Your record is safe!");
		  }
		});
		
}


function saveForm1(id){
	  swal({
		  title: "Are you sure?",
		  text: "Once deleted, you will not be able to recover this record!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  
				$.ajax("/deleteArticle?id="+id,   // request url
					    {
					        success: function () {
					        	swal("Record has been deleted!", {
					  			  icon: "success",
					  			});
					        	
					        	 $('#article').DataTable().ajax.reload();
					    }
					});
			  
			
		  } else {
			swal("Your record is safe!");
		  }
		});
		
}
