package factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //cria conexao com banco de dados
    String serverName = "sql10.freemysqlhosting.net"; //caminho do servidor BD
    String mydatabase = "sql10349868"; //nome do banco de dados
    String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
    String username = "sql10349868"; //nome do usuario do bd
    String password = "MRZQuZHRQI"; //senha do banco
    
    public Connection conexao;
  
    public ConnectionFactory() throws SQLException {
        conexao = DriverManager.getConnection(url, username, password);
    }
    
    public void closeConnection(){
        conexao = null;
    }
}