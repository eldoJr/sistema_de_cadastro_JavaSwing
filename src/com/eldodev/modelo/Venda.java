/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eldodev.modelo;

/**
 *
 * @author Teck Trakker
 */

public class Venda {

    private int id;
    private String cliente;
    private String veiculo;
    private String modelo;
    private String cor;
    private double preco;
    private Double ano_fabrico;

    // Construtores
    public Venda() {
    }

    public Venda(String cliente, String veiculo, String modelo, String cor, double preco, Double ano_fabrico) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.modelo = modelo;
        this.cor = cor;
        this.preco = preco;
        this.ano_fabrico = ano_fabrico;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Double getAnoFabrico() {
        return ano_fabrico;
    }

    public void setAnoFabrico(Double ano_fabrico) {
        this.ano_fabrico = ano_fabrico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void receberDadosCadastro(String cliente, String veiculo, String modelo, String cor, double preco, String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void cadastrarVenda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
