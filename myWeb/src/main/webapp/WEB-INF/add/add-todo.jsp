<%@ include file="../common/header.jspf" %> 

<%@ include file="../common/navigation.jspf" %> 	

	<div class="container">
		<p>Welcome ${name}</p><br>
		<p>Add new item.</p>
		
		<form action="/add-todo.do" method="post">
			<fieldset>
				<label>Description:</label>
				<input name="todo" type="text" class="form-control" /> <br/>
			</fieldset>
			<fieldset>
				<label>Category:</label>
				<input name="category" type="text" class="form-control"/> <br/>
			</fieldset>
			<input name="add" type="submit" class="btn btn-success" value="Submit"/> <br/>
		</form>
		
	</div>
	
	
<%@ include file="../common/footer.jspf" %>