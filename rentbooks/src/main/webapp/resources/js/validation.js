
$().ready(function(){
  var validator = $("#form").bind("invalid-form.validate",function(){
    $("#error").html("This form has "+ validator.numberOfInvalids()+" error(s)").css("color","red");

  }).validate({
		rules : {
			name : {
				required : true
			},
			price : {
				required : true
			}
		},
		messages : {
			name : {
				required : "Fields cannot be empty"
			},
			price : {
				required : "Fields cannot be empty"
			}
		}
	});

});