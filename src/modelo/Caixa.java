/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author akiot
 */
@Entity
@Table(name = "caixa")
public class Caixa implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "codigo")
    private long codigo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "abertura")
    private Date abertura;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechamento")
    private Date fechamento;
    
    @Column(name = "valorinicial")
    private BigDecimal valorinicial;    
    
    @ManyToOne
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario = new Usuario();
    
    @OneToMany(mappedBy="Caixa")
    private List<Movimentacao> movimentacoes;
    
    @OneToMany(mappedBy="Caixa")
    private List<Vistoria> vistorias;
    
    @OneToMany(mappedBy="Caixa")
    private List<ContaAPagar> contas;
    
    @OneToMany(mappedBy="Caixa")
    private List<Agendamento> agendamentos;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    public Date getFechamento() {
        return fechamento;
    }

    public void setFechamento(Date fechamento) {
        this.fechamento = fechamento;
    }

    public BigDecimal getValorinicial() {
        return valorinicial;
    }

    public void setValorinicial(BigDecimal valorinicial) {
        this.valorinicial = valorinicial;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public List<Vistoria> getVistorias() {
        return vistorias;
    }

    public void setVistorias(List<Vistoria> vistorias) {
        this.vistorias = vistorias;
    }

    public List<ContaAPagar> getContas() {
        return contas;
    }

    public void setContas(List<ContaAPagar> contas) {
        this.contas = contas;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
    
    
    
    
    
}
