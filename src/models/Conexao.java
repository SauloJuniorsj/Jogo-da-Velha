package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    //cria conexao com banco de dados
    String serverName = "remotemysql.com"; //caminho do servidor BD
    String mydatabase = "abrlFX5cl5"; //nome do banco de dados
    String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
    String username = "abrlFX5cl5"; //nome do usuario do bd
    String password = "gWJZHn3JEf"; //senha do banco
    
    public static Connection conexao;
    
    public Conexao() throws SQLException {
        
        if(conexao == null){
            conexao = DriverManager.getConnection(url, username, password);
        
        }
    }
    
    public void closeConnection(){
        conexao=null;
    }
}
