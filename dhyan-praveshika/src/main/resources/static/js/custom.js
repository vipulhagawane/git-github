$(document).ready(function () {
  $('#example').DataTable();

$('#users').DataTable({
	  
	  ajax : {
		  url : '/getUsers',
			  dataSrc : ''
	  },
	  columns:[
		  {title : 'Full Name' , data : 'full_name'},
		  {title : 'Email' , data : 'email'},
		  {title : 'Contact Number' , data : 'phoneNo'},
		  {title : 'city' , data : 'city'},
		  {title : 'state' , data : 'state'},
		  {title : 'country' , data : 'country'},
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
		  {title : 'Transaction Date' , data : 'created_date'},
		  {title : 'Transaction ID' , data : 'transaction_id'},
		  {title : 'Amount' , data : 'amount'},
		  ]
});
});

// vipul

