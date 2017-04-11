function myFuction1(){
		var email=$("#email").val();
		var name=$("#name").val();
		var password=$("password").val();
		var isValid= true;
		if(email == ''){
			isValid= false;
			$("#erroremail").html("Email is empty");
		}
		else{
			$("#erroremail").html("");
		}
		if(password == ''){
			isValid = false;
			$("#errorpassword").html("password is empty");
		}
		else{
			$("#errorpassword").html("");
		}
		if(name == ''){
			isValid = false;
			$("#errorname").html("name is empty");
		}
		else{
			$("#errorname").html("");
		}
		if(isValid == true){
		}else{
			return false; 
		}
}