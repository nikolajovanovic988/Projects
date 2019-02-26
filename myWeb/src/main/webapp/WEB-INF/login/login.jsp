<%@ include file="../common/header.jspf" %> 

<%@ include file="../common/navigation.jspf" %> 	

	<div class="container">
		<form action="/login.do" method="post">
			<p>
				<font color="red">${errorMassage}</font>
				<p> >Hello, this is my project using Servlets and Tomcat, Bootstrap, JSP, Maven.<br>
					It is wary simple and I did not wanted to make it large and piled up with files to save data.<br>
					I just wanted to play with Servlet and to learn how it work :).
					
					To run just do right click on project /run as/Maven build/Goals:tomcat7:run
				</p>
				<p> Use name: Nikola, and password: pass</p>
			</p>
			Name <input type="text" name="name" /> Password <input
				type="password" name="pass" /><input type="submit" value="Login" />
		
		</form>
		
	</div>
	
<%@ include file="../common/footer.jspf" %> 