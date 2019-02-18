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
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.name}</td>
						<td>${todo.category}</td>
						<td><a class="btn btn-danger" href="/delete-todo.do?name=${todo.name}&category=${todo.category}" >Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a class="btn btn-success" href="/add-todo.do">Add new number</a>
	</div>
	
<%@ include file="../common/footer.jspf" %>