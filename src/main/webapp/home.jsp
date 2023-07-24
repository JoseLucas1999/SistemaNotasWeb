<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Alunos"%>
<%@ page import="java.util.ArrayList" %>

<%
	ArrayList<Alunos> alunos = (ArrayList<Alunos>) request.getAttribute("alunos");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="assents/css/home.css">
    <link rel="stylesheet" href="assents/css/home-table.css">
    <title>Sistema de Notas Home</title>
</head>
<body>
    <header>
        <nav class="nav-bar">
            <div class="logo">
                <h1><i class="fa-solid fa-school" style="color: #ffffff;"></i></i></h1>
            </div>
			
			<div class="list">
			
            <div class="nav-list">
                <ul>
                	<li class="nav-item"><a href="home" class="nav-link">Home</a></li>
                    <li class="nav-item"><a href="aprovados" class="nav-link">Aprovados</a></li>
                    <li class="nav-item"><a href="reprovados" class="nav-link">Reprovados</a></li>
                    <li class="nav-item"><a href="cadastrar.jsp" class="nav-link">Cadastrar Aluno</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">Pesquisar Aluno</a></li>
                    <li class="nav-item"><a href="excluir.jsp" class="nav-link">ExcluirAluno</a></li>
                </ul>
            </div>
           
            </div>
            
            <script>
                  function buscar(){
            	  const pesquisa = document.querySelector(".pesquisar")
            	  pesquisa.style.display = "block"
            	}
            </script>

            <div class="login-btt">
                <button><a href="index.jsp">Login</a></button>
            </div>

            <div class="mobile-menu-icon">
                <button><i id="icon-bar" class="fa-solid fa-bars"></i></button>
            </div>
           

        </nav>
        

        <!--Mobile-->
        <div class="mobile-menu">
            <ul>
                    <li class="nav-item"><a href="home" class="nav-link">Home</a></li>
                    <li class="nav-item"><a href="aprovados" class="nav-link">Aprovados</a></li>
                    <li class="nav-item"><a href="reprovados" class="nav-link">Reprovados</a></li>
                    <li class="nav-item"><a href="cadastrar.jsp" class="nav-link">Cadastrar Aluno</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">Pesquisar Aluno</a></li>
                    <li class="nav-item"><a href="excluir.jsp" class="nav-link">ExcluirAluno</a></li>
            </ul>

            <div class="login-btt">
                <button><a href="index.jsp">Login</a></button>
            </div>
        </div>
        <!--Mobile end-->
        
    </header>
    
    <main>
	<h1><%out.print(request.getAttribute("titulo"));%></h1>
    <table>
    	<thead>
	    	<tr>
		    	<th>RA</th>
		    	<th>Nome</th>
		    	<th>Nota 1</th>
		    	<th>Nota 2</th>
		    	<th>Nota 3</th>
		    	<th>Nota 4</th>
		    	<th>Média</th>
		    	<th>Situação</th>
	    	</tr>
    	</thead>
    	<tbody>
    		<% 
    		for(Alunos a : alunos){
    		%>
    		<tr>
    			<td><%=a.getRa()%></td>
				<td><%=a.getNome()%></td>
				<td><%=a.getNotas().getNota1()%></td>
				<td><%=a.getNotas().getNota2()%></td>
				<td><%=a.getNotas().getNota3()%></td>
				<td><%=a.getNotas().getNota4()%></td>
				<td><%=a.getMedia()%></td>
				<td><%=a.getSituacao()%></td>
    		</tr>
    		<%}%>

    	</tbody>
    </table>
     <a href="calcular" class="btn">Gerar Média e Situação</a>
    </main>
   

    
<script src="assents/js/home.js"></script>
</body>
</html>