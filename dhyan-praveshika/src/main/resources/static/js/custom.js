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

$('#Examole1').DataTable1{
	
	var api = this.api(), data;
	
	var intVal = function ( i ) {
        return typeof i === 'string' ?
            i.replace(/[\$,]/g, '')*1 :
            typeof i === 'number' ?
                i : 0;
    };
    
    
    total = api
    .column( 4 )
    .data()
    .reduce( function (a, b) {
        return intVal(a) + intVal(b);
    }, 0 );

// Total over this page
pageTotal = api
    .column( 4, { page: 'current'} )
    .data()
    .reduce( function (a, b) {
        return intVal(a) + intVal(b);
    }, 0 );

// Update footer
$( api.column( 4 ).footer() ).html(
    '$'+pageTotal +' ( $'+ total +' total)'
);
}
} );

