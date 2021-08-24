/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    
    @Column (name = "nomeusuario")
    private String nomeusuario;
    
    @Column (name = "nome")
    private String nome;
    
    @Column(name = "senha")
    private String senha;
    
    @Column (name = "nvacesso")
    private int nvacesso;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ultimoLogin")
    private Date ultimoLogin;

    @OneToMany(mappedBy="Usuario")
    private List<Agendamento> agendamentos;
    
    @OneToMany(mappedBy="Usuario")
    private List<Vistoria> vistorias;
    
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
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

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public List<Vistoria> getVistorias() {
        return vistorias;
    }

    public void setVistorias(List<Vistoria> vistorias) {
        this.vistorias = vistorias;
    }



 


    
    
}
