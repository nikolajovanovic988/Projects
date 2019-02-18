<%@ include file="../common/header.jspf" %> 

<%@ include file="../common/navigation.jspf" %> 	

	<div class="container">
		<p>Welcome ${name}</p><br>
		<p>Add new number.</p>
		
		<form action="/add-phonebook.do" method="post">
			<fieldset>
				<label>Name:</label>
				<input name="name" type="text" class="form-control" /> <br/>
			</fieldset>
			<fieldset>
				<label>Number:</label>
				<input name="number" type="text" class="form-control"/> <br/>
			</fieldset>
			<input name="add" type="submit" class="btn btn-success" value="Submit"/> <br/>
		</form>
	</div>
	
<%@ include file="../common/footer.jspf" %>