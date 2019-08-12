$(document).ready(function () {
  $('#example').DataTable();
  //Editor
 
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
              return "<a class='btn btn-info tblBtn' onclick='getRowID("+data+")'><i class='fa fa-pencil'></i></a><a class='btn btn-warning tblBtn'><i class='fa fa-eye'></i></a><a class='btn btn-danger tblBtn'><i class='fa fa-trash'></i></a>"}
                      
		  }
	  ]
});

});
function getRowID(id){
	//window.location.href = "/getArticle?id="+id;
	 alert("hiii");
	 $.ajax({
		 type : 'GET',
         url : "/getArticle?id="+id,
         
         success : function(data) {
             alert(JSON.stringify(data.id));
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
