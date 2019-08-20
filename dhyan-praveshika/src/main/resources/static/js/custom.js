$(document).ready(function () {
  $('#example').DataTable();

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
});

// vipul

