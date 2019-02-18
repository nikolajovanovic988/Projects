<%@ include file="../common/header.jspf" %> 

<%@ include file="../common/navigation.jspf" %> 	

	<div class="container">
		<p>Welcome ${name}</p>
		
		<table class="table table-stiped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Phonebook</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${phonebook}" var="phonebook">
					<tr>
						<td>${phonebook.name}</td>
						<td>${phonebook.number}</td>
						<td><a class="btn btn-danger" href="/delete-phonebook.do?name=${phonebook.name}&number=${phonebook.number}" >Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a class="btn btn-success" href="/add-phonebook.do">Add new number</a>
	</div>
	
<%@ include file="../common/footer.jspf" %>