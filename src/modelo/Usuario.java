/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author akiot
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "codigo")
    private long codigo;
    
    @Column (name = "user")
    private String usuario;
    
    @Column (name = "nome")
    private String nome;
    
    @Column(name = "senha")
    private String senha;
    
    @Column (name = "nvacesso")
    private int nvacesso;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ultimoLogin")
    private Date ultimoLogin;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getUser() {
        return usuario;
    }

    public void setUser(String user) {
        this.usuario = user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNvacesso() {
        return nvacesso;
    }

    public void setNvacesso(int nvacesso) {
        this.nvacesso = nvacesso;
    }

    public Date getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(Date ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }



 


    
    
}
