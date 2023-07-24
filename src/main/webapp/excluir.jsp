<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="assents/css/excluir.css">
<title>Sistema de Notas - Excluir Aluno</title>


</head>
<body>

    <header>
    
        <nav class="nav-bar">
            <div class="logo">
                <h1><i class="fa-solid fa-school" style="color: #ffffff;"></i></i></h1>
            </div>
            <div class="logoNome">Excluir Aluno</div>
            <div class="login-btt">
                <button><a href="home">Home</a></button>
            </div>

            <div class="mobile-menu-icon">
                <button><i id="icon-bar" class="fa-solid fa-bars"></i></button>
            </div>
        </nav>

        <!--Mobile-->
        <div class="mobile-menu">

            <div class="login-btt">
                <button><a href="home">Home</a></button>
            </div>
        </div>
        
    </header>
    
    <main>
	    <form class="cadastro-form" action="excluir">
	   	 	<h2>Excluir Aluno</h2>
	    
	        <div class="box">
	            <input type="number" name="ra" required placeholder="Digite o RA">
	        </div>

			<div class="alunosList" style="display: block">
			</div>
	        <input type="submit" class="btn" value="excluir"> 
		</form>
    </main>
    
<script src="assents/js/home.js"></script>

</body>
</html>







