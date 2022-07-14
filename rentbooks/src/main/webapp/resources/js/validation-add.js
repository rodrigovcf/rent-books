
$().ready(function(){
  $("#form").bind("invalid-form.validate",function(){
    $("#error").html("Invalid Details ").css("color","red");

  }).validate({
		rules : {
			name : {
				required : true,
				minlength : 1,
				maxlength : 30
			},
			password : {
				required : true,
				minlength : 1,
				maxlength : 30	
			}
		},
		messages : {
			name : {
				required : "Fields cannot be empty",
				minlength : "The Username must be at least 1 characters long",
				maxlength : "The Username must be a maximum of 30 characters"
			},
			password : {
				required : "Fields cannot be empty",
				minlength : "The password must be at least 1 characters long",
				maxlength : "The name must be at least 3 characters long"
			}
		}
	});

});