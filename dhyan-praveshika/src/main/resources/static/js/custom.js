$(document).ready(function () {
  $('#example').DataTable();
  //Editor
 
});

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
	  ]
});