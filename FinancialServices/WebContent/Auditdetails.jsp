<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
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
    $("#confirm").click(function confirm() {
        alert("Your request has been successfully received. \n We will get back to your shortly.");
        redirect('index.jsp');
    });
}
</script>
</head>
<body>
	<div class="box"><h2 align="center">Audit Details Preview</h2>
		<hr>
		<br/>
		<br/>
		<br/>
		<table style="width: 100%">
			<tr>
				<th>COMPANY ID</th>
				<th>COMPANY NAME</th>
				<th>COMPANY ADDRESS</th>
			</tr>
			<tr>
				<td> ${companyId.companyId}</td>
			
				<td> ${companyId.companyName}</td>
				
			
				<td>${companyId.address}</td>
			</tr>
		</table>
		<br/>
		<br/>
		<br/>
		<hr>
		<table style="width: 100%">
			<tr>
				<th>BUDGET</th>
				<th>NATURE OF AUDIT</th>
				
			</tr>
			<tr>
				<td>${companyId.budget}</td>
			
				<td>  ${companyId.auditNature}</td>

			</tr>
		</table>

	</div>
	<button type="submit" class="bouton-contact" id="confirm" onclick="location.href='index.jsp'">Confirm</button>
	<button type="submit" class="bouton-contact" id="edit" onclick="location.href='EditAudit.jsp'">Edit</button>
</body>
</html>