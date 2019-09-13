$(document).ready(function () {
  $('#example').DataTable();

$('#users').DataTable({
	  
	  ajax : {
		  url : '/dhyanpraveshika-web/getUsers',
			  dataSrc : ''
	  },
	  columns:[
		  {title : 'Full Name' , data : 'full_name'},
		  {title : 'Email' , data : 'email'},
		  {title : 'Contact Number' , data : 'phoneNo'},
		  {title : 'City' , data : 'city'},
		  {title : 'State' , data : 'state'},
		  {title : 'Country' , data : 'country'},
	  ]
});



$('#donations').DataTable({
	  
	  ajax : {
		  url : '/dhyanpraveshika-web/getDonations',
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

