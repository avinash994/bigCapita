<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="shadow.css">
<style>
	#edit{
		margin-left:416px;
	}
</style>
<script>
function confirm() {
    $("#confirm").click(function () {
        alert("Your request has been successfully received. \n We will get back to your shortly.");
        redirect('index.jsp');
    });
}
</script>
</head>
<body>
	<div class="box"><h2 align="center">Accounting Details Preview</h2>
		<hr>
		<br/>
		<br/>
		<br/>
		<table style="width: 100%">
			<tr>
				<th>COMPANY ID</th>
				<th>COMPANY NAME</th>
				<th>No OF Accountants Required</th>
			</tr>
			<tr>
				<td> ${companyId.companyId}</td>
				<td> ${companyId.companyName}</td>
				<td>${companyId.noOfAccountant}</td>
			</tr>
		</table>
		<br/>
		<br/>
		<br/>
		<hr>
		<table style="width: 100%">
			<tr>
				<th>Department</th>
				<th>Qualification</th>
				<th>Work Experience</th>
				
			</tr>
			<tr>
				<td>${companyId.department}</td>
				<td>  ${companyId.qualification}</td>
				<td>  ${companyId.workExperience}</td>
			</tr>
		</table>
		
	</div>
	<button type="submit" class="bouton-contact" id="confirm" onclick="confirm()">Confirm</button>
	<button type="submit" class="bouton-contact" id="edit" onclick="location.href='EditAccounting.jsp'">Edit</button>
</body>
</html>