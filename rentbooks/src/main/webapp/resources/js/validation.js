
$().ready(function(){
  var validator = $("#form").bind("invalid-form.validate",function(){
    $("#error").html("This form has "+ validator.numberOfInvalids()+" error(s)").css("color","red");

  }).validate({
		rules : {
			name : {
				required : true,
				minlength : 5
			},
			price : {
				required : true,
				minlength : 2	
			}
		},
		messages : {
			name : {
				required : "Fields cannot be empty",
				minlength : "The name must be at least 3 characters long"
			},
			price : {
				required : "Fields cannot be empty",
				minlength : "The name must be at least 3 characters long"
			}
		}
	});

});