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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author akiot
 */
@Entity
@Table(name = "agendamento")
public class Agendamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "codigo")
    private long codigo;
        
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data")
    private Date dataagendamento;
        
    @Column(name = "endereco", length=155)
    private String endereco;    
    
    @Column(name= "telefone", length=15)
    private String telefone;
    
    @Column(name = "observacao", length=155)
    private String observacao; 
    
    @Column(name ="tipoveiculo", length=20)
    private String tipoveiculo;
    
    @Column(name = "status")
    private char status;
    
    
    @ManyToOne
    @JoinColumn(name = "caixa", nullable = true)
    private Caixa caixa = new Caixa();
    
    @ManyToOne
    @JoinColumn(name = "parceiro", nullable = true)
    private Parceiro parceiro = new Parceiro();
    
    @ManyToOne
    @JoinColumn(name = "cliente", nullable = true)
    private Cliente cliente = new Cliente();    

 // Getters e Setters Abaixo:

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Date getDataagendamento() {
        return dataagendamento;
    }

    public void setDataagendamento(Date dataagendamento) {
        this.dataagendamento = dataagendamento;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTipoveiculo() {
        return tipoveiculo;
    }

    public void setTipoveiculo(String tipoveiculo) {
        this.tipoveiculo = tipoveiculo;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Parceiro getParceiro() {
        return parceiro;
    }

    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }



    
   
    
    
    
    
    
}
