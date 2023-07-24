package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Metodos {

	public boolean logarSistema(Usuario usuario) {
		String sql = "SELECT * FROM usuario WHERE usuario = ? and senha = ?";
		try {
			DAO dao = new DAO();
			Connection con = dao.conectar();

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());

			ResultSet resultado = stmt.executeQuery();

			if (resultado.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public ArrayList<Alunos> puxarAlunosBanco() {
		String sql = "SELECT * FROM alunos";
		try {
			DAO dao = new DAO();
			Connection con = dao.conectar();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Alunos> alunos = new ArrayList<Alunos>();

			while (rs.next()) {
				int RA = rs.getInt("ra");
				String nome = rs.getString("nome");
				Notas notas = new Notas(rs.getInt("nota1"), rs.getInt("nota2"), rs.getInt("nota3"), rs.getInt("nota4"));
				int media = rs.getInt("media");
				String situacao = rs.getNString("situacao");

				alunos.add(new Alunos(RA, nome, notas, media, situacao));
			}
			stmt.close();
			dao.conectar().close();
			return alunos;

		} catch (Exception e) {
			System.out.println("erro");
			return null;
		}
	}
	
	//pesquisar um aluno
	public ArrayList<Alunos> pesquisarAluno(Alunos aluno) {
		String sql = "SELECT * FROM alunos WHERE ra = ?";
		try {
			DAO dao = new DAO();
			Connection con = dao.conectar();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Alunos> alunos = new ArrayList<Alunos>();

			while (rs.next()) {
				int RA = rs.getInt("ra");
				String nome = rs.getString("nome");
				Notas notas = new Notas(rs.getInt("nota1"), rs.getInt("nota2"), rs.getInt("nota3"), rs.getInt("nota4"));
				int media = rs.getInt("media");
				String situacao = rs.getNString("situacao");

				alunos.add(new Alunos(RA, nome, notas, media, situacao));
			}
			stmt.close();
			dao.conectar().close();
			return alunos;

		} catch (Exception e) {
			System.out.println("erro");
			return null;
		}
	}


	public void inserrAlunos(Alunos aluno) {
		String sql = "insert into alunos (nome,nota1,nota2,nota3,nota4) values(?,?,?,?,?)";
		try {
			DAO dao = new DAO();
			Connection con = dao.conectar();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getNotas().getNota1());
			stmt.setInt(3, aluno.getNotas().getNota2());
			stmt.setInt(4, aluno.getNotas().getNota3());
			stmt.setInt(5, aluno.getNotas().getNota4());
			stmt.execute();
			stmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Calcular média final
	public void calcularMedia() {
		String sql = "UPDATE alunos SET media = ?, situacao = ? WHERE ra = ?;";
		try {
			DAO dao = new DAO();
			Connection con = dao.conectar();

			List<Alunos> aluno = puxarAlunosBanco();

			for (Alunos a : aluno) {
				int mediaFinal = a.getNotas().getNota1() + a.getNotas().getNota2() + a.getNotas().getNota3()
						+ a.getNotas().getNota4();
				mediaFinal = mediaFinal / 4;

				String situacao;
				if (mediaFinal >= 6) {
					situacao = "aprovado";
				} else {
					situacao = "reprovado";
				}
				PreparedStatement stmt = con.prepareStatement(sql);

				stmt.setInt(1, mediaFinal);
				stmt.setString(2, situacao);
				stmt.setInt(3, a.getRa());
				stmt.execute();
			}
			con.close();
		} catch (Exception e) {
		}
	}
	
	public ArrayList<Alunos> selecionarAprovados(){
		String sql = "SELECT * FROM alunos WHERE media >= 6";
		try {
			DAO dao = new DAO();
			Connection con = dao.conectar();
			Statement stmt = con.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			ArrayList<Alunos> alunos = new ArrayList<Alunos>();
			while (resultado.next()) {
				int ra = resultado.getInt("ra");
				String nome = resultado.getString("nome");
				Notas notas = new Notas(resultado.getInt("nota1"), resultado.getInt("nota2"), resultado.getInt("nota3"),
						resultado.getInt("nota4"));
				int mediaFinal = resultado.getInt("media");
				String situacao = resultado.getString("situacao");

				alunos.add(new Alunos(ra, nome, notas, mediaFinal,situacao));
			}
			stmt.close();
			return alunos;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	//selecionar Alunos reprovaos
	public ArrayList<Alunos> selecionarReprovados(){
		String sql = "SELECT * FROM alunos WHERE media < 6";
		try {
			DAO dao = new DAO();
			Connection con = dao.conectar();
			Statement stmt = con.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			ArrayList<Alunos> alunos = new ArrayList<Alunos>();
			while (resultado.next()) {
				int ra = resultado.getInt("ra");
				String nome = resultado.getString("nome");
				Notas notas = new Notas(resultado.getInt("nota1"), resultado.getInt("nota2"), resultado.getInt("nota3"),
						resultado.getInt("nota4"));
				int mediaFinal = resultado.getInt("media");
				String situacao = resultado.getString("situacao");

				alunos.add(new Alunos(ra, nome, notas, mediaFinal,situacao));
			}
			stmt.close();
			return alunos;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public void ExcluirAluno(Alunos alunos) {
		String sql = "DELETE FROM alunos WHERE ra = ?";
		try {
			DAO dao = new DAO();
			Connection con = dao.conectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, alunos.getRa());
			stmt.execute();
			stmt.close();

			con.close();
		} catch (Exception e) {
			
		}
	}
}
