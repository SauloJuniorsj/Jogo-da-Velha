/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interfaceGame.TelaJogoController;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;


public class contraPC {
    Jogo jogar = new Jogo();
    TelaJogoController input = new TelaJogoController();
    
    public void recebeValor(String valor){
        char a = valor.charAt(0); // X sera o usuário
        char b = valor.charAt(1);
       jogar.JogadaMatriz(a, b, "X");
    }
    
    public void comecarJogo(controllers.Jogador jogador) throws SQLException, NoSuchAlgorithmException{
        
        Scanner ler = new Scanner(System.in);
        String posicao;
        int valida = 0, jogada = 0;
        
         System.out.println("Jogo começou");
            jogar.Mostrar();

            while (true) {

                do {
                    System.out.println(jogador.getNome() + " insira posição: ");
                    posicao = ler.next();
                    
                    while (!jogar.Valida(posicao)) {
                        System.out.println("Jogada inválida");
                        System.out.println(jogador.getNome() + " insira posição: ");
                        posicao = ler.next();
                        valida = 0;
                    }
                    jogar.Jogada(posicao, "X");
                    valida = 1;

                } while (valida == 0); //fim jog 1

                jogada++;
                valida = 0;
                jogar.Mostrar();

                if (!jogar.Ganhou(jogada, jogador).equals("null")) {
                    break;
                }

                do {
                    posicao = Integer.toString((int) (Math.random() * 10));
                    while (!jogar.Valida(posicao)) {
                        posicao = Integer.toString((int) (Math.random() * 10));
                        valida = 0;
                    }
                    jogar.Jogada(posicao, "O");
                    valida = 1;

                } while (valida == 0); //fim jog 1
                System.out.println("A máquina jogou: \n");
                jogada++;
                valida = 0;
                jogar.Mostrar();

                if (!jogar.Ganhou(jogada, jogador).equals("null")) {
                    break;
                }
            }
            comecarJogo(jogador);
        }
    }

