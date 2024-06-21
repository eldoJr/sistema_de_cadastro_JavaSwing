package com.eldodev.gui.to;

import com.eldodev.modelo.Venda;
import javax.swing.table.AbstractTableModel;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class VendaTableModel extends AbstractTableModel {
    private final NumberFormat NFC = NumberFormat.getCurrencyInstance();
    private List<Venda> dados;
    private final String[] colunas = {"Cliente", "Veículo", "Modelo", "Cor", "Preço","Ano de Fabrico"};

    @Override
    public int getRowCount() {
        return (dados == null) ? 0 : dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int l, int c) {
        Venda venda = dados.get(l);
        switch (c) {
            case 0:
                return venda.getCliente();
            case 1:
                return venda.getVeiculo();
            case 2:
                return venda.getModelo();
            case 3:
                return venda.getCor();
            case 4:
                Double preco = venda.getPreco();
                return (preco != null && !preco.isNaN() && !preco.isInfinite()) ? NFC.format(preco) : "";

            case 5:
                return (venda.getAnoFabrico());
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente!");
        }
    }

    @Override
    public String getColumnName(int c) {
        return colunas[c];
    }

    @Override
    public boolean isCellEditable(int l, int c) {
        return false;
    }

    public void setDados(List<Venda> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Venda getRowValue(int l) {
        return dados.get(l);
    }

    public void adicionarVenda(Venda venda) {
        if (dados == null) {
            dados = new ArrayList<>();
        }
        dados.add(venda);
        fireTableRowsInserted(dados.size() - 1, dados.size() - 1);
    }
}
