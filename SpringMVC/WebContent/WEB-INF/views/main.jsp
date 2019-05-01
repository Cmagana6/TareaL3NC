<!-- Cabecera que importa la libreria core de jstl -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Cabecera que importa la libreria fmt de jstl -->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 
<!-- Cabecera para importar la libreria xml de jstl -->
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Uso de etiqueta "c:out"</h1>
	<c:out value="Imprimiendo este mensaje con c:out"/><p>
	<h1>Uso de etiqueta "X:"</h1>
	 <c:set var = "Books_Table">
	         <books>
	            <book>
	               <name>Los secretos de la mente</name>
	               <author>Unknown</author>
	               <price>$58.00</price>
	            </book>
	            
	            <book>
	               <name>El quijote de la mancha</name>
	               <author>Miguel de Cervantes</author>
	               <price>$80.00</price>
	            </book>
	         </books>
	      </c:set>
	      
	  <!-- Parseando estructura HTML a XML -->   
	      <x:parse xml = "${Books_Table}" var = "Showstructure"/>
      
     <!-- Imprimiendo estructura con x:forEach -->
	     <table border="2">
            <tr>
	       		<td>Book name: </td>
	         	<td>Author: </td>
	      		<td>Price: </td> 
	        </tr>
		    <x:forEach select = "$Showstructure/books/book" var="Showstructure">
		        <tr>       
		      		<td><x:out select="name" /></td>
		         	<td><x:out select="author" /></td>
		      		<td><x:out select="price" /></td>                      
		        </tr>       
		   </x:forEach>
	  	</table>
	
	
	<h1>Uso de etiqueta "fmt"</h1>
	 <c:set var = "fechaActual" value = "<%=new java.util.Date()%>" />
	      
	     <p>Fecha con formato original:
	     	<c:out value="${fechaActual}"/><p>
	     </p>
	    	    
	    <!-- Imprimiendo fecha con formato DATE-->
		    <p>Fecha con formato fmt: 
				<fmt:formatDate type="date" value="${fechaActual}"/>
	         </p>
 	<!--  <h1>${message}</h1>-->
 	<br><br>
 	<h2>Formulario</h2>
 	
 	<!-- IMPORTANTE: Siempre agregar el contenido dentro de los corchetes cada vez que hagan un formulario -->
 	<form action="${pageContext.request.contextPath}/formData" method="post">
 	<label>Nombre: </label><input type="text" name="name"><br>
 	<label>Apellido: </label><input type="text" name="lname"><br>
 	<label>Fecha de nacimiento: </label><input type="date" name="bdate"><br>
 	<label>Carrera: </label><input type="text" name="career"><br>
 	<label>Experiencia: </label><input type="text" name="experience"><br>
 	<input type="submit" value="Enviar">
 	</form>
</body>
</html>