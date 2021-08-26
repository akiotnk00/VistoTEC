/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author akiot
 */
@Entity
@Table(name = "Vistoria")
public class Vistoria implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "codigo")
    private long id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    private Date data;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "hora")
    private Date hora;
    
    @Column(name = "motivo")
    private String motivo;
    
    @Column(name = "situacao_de_pagamento")
    private String situacaoPagamento;
    
    @Column(name = "valor_cobrado")
    private double valorCobrado;
    
    @Column(name = "resultado")
    private char resultado;
    
    @Column(name = "kilometragem")
    private long kilometragem;
    
    @ManyToOne
    @JoinColumn(name = "veiculo", nullable = false)
    private Veiculo veiculo = new Veiculo();
    
    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente = new Cliente();
    
    @ManyToOne
    @JoinColumn(name = "parceiro", nullable = true)
    private Parceiro parceiro = new Parceiro();   

    @ManyToOne
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario = new Usuario();   

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   
    public String getSituacaoPagamento() {
        return situacaoPagamento;
    }

    public void setSituacaoPagamento(String situacaoPagamento) {
        this.situacaoPagamento = situacaoPagamento;
    }

    public double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Parceiro getParceiro() {
        return parceiro;
    }

    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }    

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public char getResultado() {
        return resultado;
    }

    public void setResultado(char resultado) {
        this.resultado = resultado;
    }



    public long getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(long kilometragem) {
        this.kilometragem = kilometragem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    @Override
    public String toString() {
        return "Dados da Vistoria"
                +"\n"+"Placa do Veiculo:"+veiculo.getPlaca()
                +"\n"+"Modelo do Veiculo:"+veiculo.getModelo()
                +"\n"+"Data/Horário da Vistoria:"+data+hora
                +"\n"+"Valor Cobrado:"+valorCobrado
                +"\n"+"Motivo:"+motivo
                +"\n"+"Resultado:"+resultado;
    
    }
    
}
