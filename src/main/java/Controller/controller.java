package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Alunos;
import Model.DAO;
import Model.Metodos;
import Model.Notas;
import Model.Usuario;

@WebServlet(urlPatterns = {"/controller","/entrar","/logar","/home","/inserir","/calcular","/aprovados","/reprovados","/excluir"})
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	Usuario usuario = new Usuario();
	Metodos metodos = new Metodos();
	Alunos alunos = new Alunos();
	Notas notas = new Notas();
	
	public controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/entrar") || action.equals("/home") ) {
			listarAlunos(request,response);			
			response.sendRedirect("home.jsp");
		}else if(action.equals("/logar")) {
			logar(request,response);
		}else if(action.equals("/inserir")) {
			cadastrarAluno(request,response);
			response.sendRedirect("cadastrar.jsp");
		}else if(action.equals("/calcular")) {
			gerarMedia(request,response);
		}else if(action.equals("/aprovados")) {
			listarAprovados(request,response);
			response.sendRedirect("home.jsp");
		}else if(action.equals("/reprovados")) {
			listarReprovados(request,response);
			response.sendRedirect("home.jsp");
		}else if(action.equals("/excluir")) {
			excluirAluno(request,response);
			response.sendRedirect("excluir.jsp");
		}
	}
	
	protected void logar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		usuario.setUsuario(user);
		usuario.setSenha(senha);
		
		boolean autenticar = metodos.logarSistema(usuario);
		
		if(autenticar == true) {
			listarAlunos(request,response);
			response.sendRedirect("home.jsp");
		}else {
			String mensagem = "Login ou senha errados";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			}
		}
	
	//listar contatos em home.jsp
	//criamos um método em Metodos retornando todos o dados do banco
	//em controller inserimos o retorno em um array e direcionamos para home.jsp
	//em home.jsp listamos todos os dados em uma tabela usando um um for dentro scriptlet
	protected void listarAlunos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Alunos> alunos = metodos.puxarAlunosBanco();
		
		System.out.println(alunos);
		String titulo = "Todos os Alunos";
		//enviar alunos para home.jsp
		request.setAttribute("alunos", alunos);
		request.setAttribute("titulo", titulo);
		
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}
	
	protected void listarAprovados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//guardar alunos em um arraylist
		ArrayList<Alunos> alunos = metodos.selecionarAprovados();
		
		System.out.println(alunos);
		String titulo = "Alunos Aprovados";
		
		request.setAttribute("alunos", alunos);
		request.setAttribute("titulo", titulo);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);	
	}
	
	protected void listarReprovados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//guardar alunos em um arraylist
		ArrayList<Alunos> alunos = metodos.selecionarReprovados();
		
		System.out.println(alunos);
		String titulo = "Alunos Reprovados";
		
		request.setAttribute("alunos", alunos);
		request.setAttribute("titulo", titulo);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);

	}
	
	protected void cadastrarAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		int nota1 = Integer.parseInt(request.getParameter("nota1"));
		int nota2 = Integer.parseInt(request.getParameter("nota2"));
		int nota3 = Integer.parseInt(request.getParameter("nota3"));
		int nota4 = Integer.parseInt(request.getParameter("nota4"));
		
		
		notas.setNota1(nota1);
		notas.setNota2(nota2);
		notas.setNota3(nota3);
		notas.setNota4(nota4);
		alunos.setNome(nome);
		alunos.setNotas(notas);
		
		metodos.inserrAlunos(alunos);
		
	}
	
	protected void gerarMedia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		metodos.calcularMedia();
		listarAlunos(request,response);
		response.sendRedirect("home.jsp");
	}

	protected void excluirAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int ra = Integer.parseInt(request.getParameter("ra"));
		alunos.setRa(ra);
		metodos.ExcluirAluno(alunos);
	}
	
}
