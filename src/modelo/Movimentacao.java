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
@Table(name = "movimentacao")
public class Movimentacao implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "codigo")
    private long codigo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data")
    private Date data;
    
    @Column(name = "tipo",length=20)
    private String tipo;
    
    @Column(name = "descricao",length=70)
    private String descricao;
    
    @Column(name = "valor")
    private Double valor;    
    
    @Column(name = "origem",length=20)
    private String origem;

    @ManyToOne
    @JoinColumn(name = "caixa", nullable = false)
    private Caixa caixa = new Caixa();
    
    @ManyToOne
    @JoinColumn(name = "contaapagar", nullable = true)
    private ContaAPagar contaapagar = new ContaAPagar();
    
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
   
    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public ContaAPagar getContaapagar() {
        return contaapagar;
    }

    public void setContaapagar(ContaAPagar contaapagar) {
        this.contaapagar = contaapagar;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
