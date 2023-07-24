package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	final private String driver = "com.mysql.cj.jdbc.Driver";
	final private String url = "jdbc:mysql://localhost:/sistemanotas?verifyServerCertificate=false&usesSSL=true";
	final private String user = "root";
	final private String password = "12345";

	public Connection conectar() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			//System.out.println("conectado com sucesso");
			return con;
		} catch (Exception e) {
			System.out.println("ERRO AO CONECTAR: " + e);
			return null;
		}
	}

	// teste de conexão
	public void testeConecxao() {
		try {
			Connection con = conectar();
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
