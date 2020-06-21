/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author lczaikowski
 */
public class Jogador {
    
    private String nome;
    private String senha;
    private String conf_senha;
    
    public void setNome(String nome){
        this.nome = nome;
    }
          
    public String getNome() {
        return nome;
    }   
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setConf_Senha(String conf_senha){
        this.conf_senha = conf_senha;
    }
    
    public String getConf_Senha() {
        return conf_senha;
    }
}
