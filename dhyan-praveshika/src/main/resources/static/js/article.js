$(document).ready(function () {
 
$('#article').DataTable({
	  
	  ajax : {
		  url : '/getBlogs',
			  dataSrc : ''
	  },
	  columns:[
		  {title : 'Name Of Article' , data : 'title'},
		  {title : 'Date' , data : 'date'},
		  {title : 'Created By' , data : 'author'},
		  {title : 'Category' , data : 'category'},
		  {title : 'Actions' , data : 'id', "render": function (data) {
              return "<a class='btn btn-info tblBtn' onclick='getRowID("+data+")'><i class='fa fa-pencil'></i></a><a class='btn btn-warning tblBtn'><i class='fa fa-eye'></i></a><a class='btn btn-danger tblBtn' onclick='deleteArticle("+data+")'><i class='fa fa-trash'></i></a>"}
                      
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

$('#articleSelectImage').on('click', function () {
    $('#hiddenFileOpner').trigger('click');
    $('#hiddenFileOpner[type="file"]').change(function (e) {
      var fileName = e.target.files[0].name;
      $('#imageNameShowBox').val(fileName);
    });

  });


});
function getRowID(id){
	//window.location.href = "/getArticle?id="+id;
	 $.ajax({
		 type : 'GET',
         url : "/getArticle?id="+id,
         
         success : function(data) {
             //alert(JSON.stringify(data.id));
             $('#id').val(data.id);
             $('#articleTital').val(data.title);
             $('#authorName').val(data.author);
             $('#category').val(data.category);
             CKEDITOR.instances.editor12.setData(data.description)
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
