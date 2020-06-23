/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lczaikowski
 */
public class Placar {
    
    public String mostrarNome(modelo.Jogador jogador) throws SQLException, NoSuchAlgorithmException {
        
        ConnectionFactory con = new ConnectionFactory();
        Statement st = con.conexao.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM jogador WHERE nome_jogador = '" + jogador.getNome() + "'");
        
        while(rs.next()) {
             
            String nome = rs.getString("nome_jogador");
            System.out.println("Jogador: " + nome);//mostra os dados da tabela jogador no console
            con.closeConnection();
            
            return nome;
        }
        return "";
    }
        
    public String vitoria(modelo.Jogador jogador) throws SQLException, NoSuchAlgorithmException {
        
        ConnectionFactory con = new ConnectionFactory();
        Statement st = con.conexao.createStatement();
        
        st.executeUpdate("UPDATE jogador SET vitoria = vitoria + 1 WHERE nome_jogador = '" 
                + jogador.getNome()+"'");
        
        ResultSet rs = st.executeQuery("SELECT * FROM jogador WHERE nome_jogador = '" + jogador.getNome() + "'");
        
        while(rs.next()) {
            String vitoria = rs.getString("vitoria");
            String derrota = rs.getString("derrota"); 
            
            System.out.println("Vitórias: " + vitoria + "\nDerrotas: " + derrota);//mostra os dados da tabela jogador no console   
            con.closeConnection();
            return vitoria + "/" + derrota;
        }
        
        return "";
    }
    
    public String derrota(modelo.Jogador jogador) throws SQLException, NoSuchAlgorithmException {
        
        ConnectionFactory con = new ConnectionFactory();
        Statement st = con.conexao.createStatement();
        
        st.executeUpdate("UPDATE jogador SET `derrota` = `derrota` + 1 where `nome_jogador` = '" 
                + jogador.getNome()+"'");
        
        ResultSet rs = st.executeQuery("SELECT * FROM jogador WHERE nome_jogador = '" + jogador.getNome() + "'");
        
        while(rs.next()) {
            String vitoria = rs.getString("vitoria");
            String derrota = rs.getString("derrota");   
            System.out.println("Vitórias: " + vitoria + "\nDerrotas: " + derrota);//mostra os dados da tabela jogador no console
            con.closeConnection();
            
            return vitoria + "/" + derrota;
        }
        return "";
    }
}
