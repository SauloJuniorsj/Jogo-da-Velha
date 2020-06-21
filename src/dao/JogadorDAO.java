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
public class JogadorDAO {

    public void recebeDados(modelo.Jogador jogador) throws SQLException, NoSuchAlgorithmException {

        ConnectionFactory con = new ConnectionFactory();
        Jogo jogar = new Jogo();

        Statement st = con.conexao.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM jogador WHERE nome_jogador = '"
                + jogador.getNome() + "'");//Select na tabela jogador

        if (rs.next()) {
            String usuario = rs.getString("nome_jogador");
            if (jogador.getNome().equals(usuario)) {
                System.out.println("Nome de cadastro em uso!");
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "Nome de cadastro em uso!!", "Aviso", JOptionPane.ERROR_MESSAGE, null);
            }
        }
        
        if (!rs.next()) {

            MessageDigest senhaCriptografada = MessageDigest.getInstance("MD5");//criptografa a senha

            byte[] senhabytes = jogador.getSenha().getBytes();
            senhaCriptografada.update(senhabytes, 0, senhabytes.length);
            BigInteger i = new BigInteger(1, senhaCriptografada.digest());
            String jujuba = String.format("%1$032X", i);

            st.executeUpdate("insert into jogador "
                    +// insere no banco
                    "(nome_jogador,senha,vitoria,derrota)"
                    + " values ('" + jogador.getNome() + "', '" + jujuba + "',0,0)");
            con.closeConnection();
            System.out.println("Cadastro realizado com sucesso");
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Bem Vindo :D", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
            jogar.recebeJogador(jogador);
            jogar.setVisible(true);
        }
    }
}
