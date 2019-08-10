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

$('#users').DataTable({
	  
	  ajax : {
		  url : '/getUsers',
			  dataSrc : ''
	  },
	  columns:[
		  {title : 'First Name' , data : 'firstName'},
		  {title : 'Last Name' , data : 'lastName'},
		  {title : 'User Type' , data : 'userType'},
		  {title : 'Email' , data : 'email'},
		  {title : 'Contact Number' , data : 'phoneNo'},
		  {title : 'Password' , data : 'password'},
	  ]
});

$('#videoes').DataTable({
	  
	  ajax : {
		  url : '/getVideoes',
			  dataSrc : ''
	  },
	  columns:[
		  {title : 'Video Name' , data : 'title'},
		  {title : 'Video Url' , data : 'path'},
		  ]
});

$('#donations').DataTable({
	  
	  ajax : {
		  url : '/getDonations',
			  dataSrc : ''
	  },
	  columns:[
		  {title : 'Donar Name' , data : 'donar'},
		  {title : 'Email' , data : 'email'},
		  {title : 'Transaction Date' , data : 'date'},
		  {title : 'Transaction ID' , data : 'transaction_id'},
		  {title : 'Amount' , data : 'amount'},
		  ]
});

$('#events').DataTable({
	  
	  ajax : {
		  url : '/getEvents',
			  dataSrc : ''
	  },
	  columns:[
		  {title : 'Title' , data : 'title'},
		  {title : 'Description' , data : 'description'},
		  {title : 'Date' , data : 'date'},
		  {title : 'Time' , data : 'time'},
		  {title : 'Location' , data : 'location'},
		  ]
});

});
function getRowID(id){
	window.location.href = "/getArticle?id="+id;
}
