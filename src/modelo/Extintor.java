/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Alyson
 */
public class Extintor {
    
    private Date validade;
    private String setor, tipo;
    private int peso, idExtintor, idUsuario;

    public Extintor(Date validade, String setor, String tipo, int peso, int idUsuario) {
        this.validade = validade;
        this.setor = setor;
        this.tipo = tipo;
        this.peso = peso;
        this.idUsuario = idUsuario;
    }
    
    
    public Extintor(Date validade, String setor, String tipo, int peso, int idUsuario, int idExtintor) {
        this.validade = validade;
        this.setor = setor;
        this.tipo = tipo;
        this.peso = peso;
        this.idUsuario = idUsuario;
    }
   
    
    
    
    public Extintor() {
    }

    
    
    
    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getIdExtintor() {
        return idExtintor;
    }

    public void setIdExtintor(int idExtintor) {
        this.idExtintor = idExtintor;
    }

    @Override
    public String toString() {
        return "Extintor{" + "validade=" + validade + ", setor=" + setor + ", tipo=" + tipo + ", peso=" + peso + ", idExtintor=" + idExtintor + '}';
    }
    
}
