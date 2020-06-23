/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import gui.Jogo;
import java.awt.Component;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author lczaikowski
 */
public class Logar {
    
    public boolean Autenticar(modelo.Jogador jogador) throws SQLException, NoSuchAlgorithmException {
    
            ConnectionFactory con = new ConnectionFactory(); 
            Jogo jogar = new Jogo();
            Statement st = con.conexao.createStatement();
            
            MessageDigest senhaCriptografada=MessageDigest.getInstance("MD5");//criptografa a senha
            
            byte[] senhabytes = jogador.getSenha().getBytes();
            senhaCriptografada.update(senhabytes,0,senhabytes.length);
            BigInteger i = new BigInteger(1,senhaCriptografada.digest());
            String jujuba = String.format("%1$032X", i);
            
            
            ResultSet rs = st.executeQuery("Select * from jogador where nome_jogador = '" + jogador.getNome()+"'"
                                           + " and senha = '"+ jujuba +"'");
            
            if(rs.next()){
                String usuario = rs.getString("nome_jogador");
//                String senha2 = rs.getString("senha");
                
                
                    System.out.println("\n--------- Logado com sucesso ---------\n"
                            + "bem vindo " + usuario);
                    con.closeConnection();
                    Component rootPane = null;
                    JOptionPane.showMessageDialog(rootPane, "Logado com sucesso bem vindo\n" + usuario, "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
                    
                    jogar.recebeJogador(jogador);
                    jogar.setVisible(true);           
                    return true;
                }  
            
            if (!rs.next()){
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "Usuario não existe\n ou senha e nome incorretos", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
            }
       return false;
    }
}