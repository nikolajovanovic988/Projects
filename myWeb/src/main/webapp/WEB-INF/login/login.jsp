<%@ include file="../common/header.jspf" %> 

<%@ include file="../common/navigation.jspf" %> 	

	<div class="container">
		<form action="/login.do" method="post">
			<p>
				<font color="red">${errorMassage}</font>
				<p> Use name: Nikola, and password: pass</p>
			</p>
			Name <input type="text" name="name" /> Password <input
				type="password" name="pass" /><input type="submit" value="Login" />
		
		</form>
		
	</div>
	
<%@ include file="../common/footer.jspf" %> 