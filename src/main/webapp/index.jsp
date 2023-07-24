<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Notas Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" 
    integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" 
    crossorigin="anonymous" 
    referrerpolicy="no-referrer" />
    
    <link rel="stylesheet" href="assents/css/index.css">
    <link rel="stylesheet" href="assents/css/index-header.css">
</head>
<body>
    <header>
        <nav class="nav-bar">
            <div class="logo">
                <h1><i class="fa-solid fa-school" style="color: #ffffff;"></i></i></h1>
            </div>
            <div class="logoNome">Sistema de Notas escolar</div>
        </nav>
    </header>
    <main>
        <form class="login-form" action="logar">
            <h2>Login</h2>
                <div class="box-user">
                    <input type="text" name="usuario" required>
                    <label>Usúario</label>
                </div>
                <div class="box-user">
                    <input type="password" name="senha" required>
                    <label>Senha</label>
                </div>
                
                <span id="message"></span>
          
                <div>
                    <a href="#" class="forget">Esqueceu a Senha?</a>
                </div>
                <input type="submit" class="btn" value="Entrar"> 
                <a href="entrar" class="btn">Entrar Sem Logar</a>
                <br><br>
                <span>Login: notas | Senha: 12345</span>
        </form>
    </main>
	<script src="assents/js/index.js"></script>
</body>
</html>