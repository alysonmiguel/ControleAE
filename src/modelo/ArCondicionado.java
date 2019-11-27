/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author Alyson
 */
public class ArCondicionado {
    
    private String modelo, setor,fabricante;
    private int despesas, idArCondicionado;
    private Date datafabricacao;

    public ArCondicionado() {
       
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public ArCondicionado(String modelo, String setor, int despesas, Date datafabricacao) {
        this.modelo = modelo;
        this.setor = setor;
        this.despesas = despesas;
        this.datafabricacao = datafabricacao;
    }

    public ArCondicionado(String modelo, String setor, int despesas,String fabricante, Date datafabricacao) {
        this.modelo = modelo;
        this.setor = setor;
        this.despesas = despesas;
        this.datafabricacao = datafabricacao;
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getDespesas() {
        return despesas;
    }

    public void setDespesas(int despesas) {
        this.despesas = despesas;
    }

    public int getIdArCondicionado() {
        return idArCondicionado;
    }

    public void setIdArCondicionado(int idArCondicionado) {
        this.idArCondicionado = idArCondicionado;
    }

    public Date getDatafabricacao() {
        return datafabricacao;
    }

    public void setDatafabricacao(Date datafabricacao) {
        this.datafabricacao = datafabricacao;
    }
    
    
    
    
    
}
