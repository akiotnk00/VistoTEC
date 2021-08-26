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
@Table(name = "contaapagar")
public class ContaAPagar implements Serializable {
   
    
    
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "codigo")
    private long codigo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "vencimento")
    private Date vencimento;
    
    @Column(name = "descricao", length = 155, nullable = false)
    private String descricao;

    @Column(name = "valor")
    private Double valor;
    
    @Column(name = "codigodebarras")
    private long codigodebarras;

    @Column(name = "situacao")
    private String situacao;
    
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public long getCodigodebarras() {
        return codigodebarras;
    }

    public void setCodigodebarras(long codigodebarras) {
        this.codigodebarras = codigodebarras;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
  
    
    
    
}
