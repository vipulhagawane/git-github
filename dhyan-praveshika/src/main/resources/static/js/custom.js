$(document).ready(function () {
  $('#example').DataTable();
  //Editor
 


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


//Vipul Videoes
$('#videoes').DataTable({
	  
	  ajax : {
		  url : '/getVideoes',
			  dataSrc : ''
	  },
	  columns:[
		  {title : 'Video Name' , data : 'title'},
		  {title : 'Video Url' , data : 'path'},
		 // {title : 'Video Category' , data : 'category'},
		  {title : 'Actions' , data : 'id', "render": function (data) {
			   return "<a class='btn btn-info tblBtn' onclick='getRowID("+data+")'><i class='fa fa-pencil'></i></a><a class='btn btn-warning tblBtn'><i class='fa fa-eye'></i></a><a class='btn btn-danger tblBtn'><i class='fa fa-trash'></i></a>"}
                      
		  }
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


