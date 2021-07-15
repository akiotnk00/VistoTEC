/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author akiot
 */
@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {
    
    @Id
    @Column(name = "placa", length = 7)
    private String placa;
    
    @Column(name = "tipo", length = 12, nullable = false)
    private String tipo;
    
    @Column(name = "marca", length = 70, nullable = false)
    private String marca;
    
    @Column(name = "modelo", length = 70, nullable = false)
    private String modelo;
    
    @Column(name = "cor", length = 15, nullable = false)
    private String cor;
    
    @OneToMany(mappedBy="Veiculo")
    private List<Vistoria> vistorias;
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }     

    public List<Vistoria> getVistorias() {
        return vistorias;
    }

    public void setVistorias(List<Vistoria> vistorias) {
        this.vistorias = vistorias;
    }
        
    
}
