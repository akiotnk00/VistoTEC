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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author akiot
 */
@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "codigo")
    private long codigo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datapagamento")
    private Date datapagamento;
    
    @Column(name = "formapagamento",length=20)
    private String formapagamento;

    @Column(name = "valorcobrado")
    private Double valorcobrado;
    
    @OneToOne(mappedBy="pagamento")
    @JoinColumn(name = "vistoria", nullable = true)
    private Vistoria vistoria;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Date getDatapagamento() {
        return datapagamento;
    }

    public void setDatapagamento(Date datapagamento) {
        this.datapagamento = datapagamento;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public Double getValorcobrado() {
        return valorcobrado;
    }

    public void setValorcobrado(Double valorcobrado) {
        this.valorcobrado = valorcobrado;
    }

    public Vistoria getVistoria() {
        return vistoria;
    }

    public void setVistoria(Vistoria vistoria) {
        this.vistoria = vistoria;
    }

   
    
    
}
