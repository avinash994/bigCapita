<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="audit_form.css">
</head>
<body>
	  <h1>Accounting Contact Form.</h1>
   <div class="info"><p> Made with <i class="fa fa-heart"></i> by bigCAPITA </p></a></div>
  
  <form method="POST" action="DoEditAccountingServlet">
	    <h1>Please Fill the Required Field for Accounting :</h1>
	    
    <div class="contentform">
    	<div id="sendmessage"> Your message has been sent successfully. Thank you. </div>


    	<div class="leftcontact">
			      <div class="form-group">
			        <p>Company UserID <span>*</span></p>
			        <span class="icon-case"><i class="fa fa-male"></i></span>
				        <input type="text" name="companyId" id="nom" data-rule="required" data-msg="V�rifiez votre saisie sur les champs : Le champ 'Nom' doit �tre renseign�."/>
                <div class="validation"></div>
       </div> 

            <div class="form-group">
            <p>Company Name <span>*</span></p>
            <span class="icon-case"><i class="fa fa-user"></i></span>
				<input type="text" name="companyName" id="prenom" data-rule="required" data-msg="V�rifiez votre saisie sur les champs : Le champ 'Pr�nom' doit �tre renseign�."/>
                <div class="validation"></div>
			</div>
			
			<p>Number Of Required Accountant <span>*</span></p>
			<span class="icon-case"><i class="fa fa-location-arrow"></i></span>
				<input type="text" name="noOfAccountant" id="adresse" data-rule="required" data-msg="V�rifiez votre saisie sur les champs : Le champ 'Adresse' doit �tre renseign�."/>
                <div class="validation"></div>
			</div>

	</div>

	<div class="rightcontact">	
			<div class="form-group">
			<div class="form-group">
			<p>Department of Work <span>*</span></p>
			<span class="icon-case"><i class="fa fa-map-marker"></i></span>
				<input type="text" name="department" id="postal" data-rule="required" data-msg="V�rifiez votre saisie sur les champs : Le champ 'Code postal' doit �tre renseign�."/>
                <div class="validation"></div>
			</div>	
			
			<div class="form-group">
			<p>Qualification Required <span>*</span></p>
			<span class="icon-case"><i class="fa fa-building-o"></i></span>
				<input type="text" name="qualification" id="ville" data-rule="required" data-msg="V�rifiez votre saisie sur les champs : Le champ 'Ville' doit �tre renseign�."/>
                <div class="validation"></div>
			</div>	

			<div class="form-group">
			<p>Work Experience <span>*</span></p>	
			<span class="icon-case"><i class="fa fa-phone"></i></span>
				<input type="text" name="workExperience" id="phone" data-rule="maxlen:10" data-msg="V�rifiez votre saisie sur les champs : Le champ 'T�l�phone' doit �tre renseign�. Minimum 10 chiffres"/>
                <div class="validation"></div>
			</div>	
	</div>
	</div>
<button type="submit" class="bouton-contact">Edit</button>
	
</form>	

  
</body>
</html>