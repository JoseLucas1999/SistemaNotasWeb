<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="assents/css/home.css">
    <link rel="stylesheet" href="assents/css/cadastrar-form.css">
    <title>Sistema de Notas Home</title>
</head>
<body>
    <header>
    
        <nav class="nav-bar">
            <div class="logo">
                <h1><i class="fa-solid fa-school" style="color: #ffffff;"></i></i></h1>
            </div>
            <div class="logoNome">Cadastrar Aluno</div>
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
	    <form class="cadastro-form" action="inserir">
	   	 	<h2>Cadastrar Aluno</h2>
	    
	        <div class="box">
	            <input type="text" name="nome" required placeholder="Nome">
	        </div>
	        
	        <div class="box">
	            <input type="number" name="nota1" placeholder="Nota 01">
	            <input type="number" name="nota2" placeholder="Nota 02">
	            <input type="number" name="nota3" placeholder="Nota 03">
	            <input type="number" name="nota4" placeholder="Nota 04">
	        </div>
	        <input type="submit" class="btn" value="Inserir"> 
		</form>
    </main>

    
<script src="assents/js/home.js"></script>
</body>
</html>