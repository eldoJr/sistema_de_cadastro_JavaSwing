package com.eldodev.dao;

import static com.eldodev.dao.ConexaoBD.conectar;
import com.eldodev.modelo.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Classe de acesso a dados da venda
 * 
 * @author Eldo
 */
public class VendaDAO implements IDAO<Venda> {

    private final Connection conexao;

    public VendaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(Venda venda) throws SQLException {
        String sql = "INSERT INTO vendas (Cliente, Veiculo, Modelo, Cor, Preco, ANOFABRICO) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, venda.getCliente());
            ps.setString(2, venda.getVeiculo());
            ps.setString(3, venda.getModelo());
            ps.setString(4, venda.getCor());
            ps.setDouble(5, venda.getPreco());
            ps.setDouble(6, venda.getAnoFabrico());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int idVenda = rs.getInt(1);
        }
    }

    @Override
    public void alterar(Venda venda) throws SQLException {
        String sql = "UPDATE vendas SET Cliente=?, Veiculo=?, Modelo=?, Cor=?, Preco=?, ANOFABRICO=? WHERE ID=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, venda.getCliente());
            ps.setString(2, venda.getVeiculo());
            ps.setString(3, venda.getModelo());
            ps.setString(4, venda.getCor());
            ps.setDouble(5, venda.getPreco());
            ps.setDouble(6, venda.getAnoFabrico());
            ps.setInt(7, venda.getId());
            ps.execute();
        }
    }

    @Override
    public void excluir(Venda venda) throws SQLException {
        String sql = "DELETE FROM vendas WHERE ID=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, venda.getId());
            ps.execute();
        }
    }

    @Override
    public ArrayList<Venda> listarTodos() throws SQLException {
        String sql = "SELECT * FROM vendas ORDER BY ANOFABRICO DESC";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            ArrayList<Venda> listaVendas = new ArrayList<>();
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getInt("ID"));
                venda.setCliente(rs.getString("Cliente"));
                venda.setVeiculo(rs.getString("Veiculo"));
                venda.setModelo(rs.getString("Modelo"));
                venda.setCor(rs.getString("Cor"));
                venda.setPreco(rs.getDouble("Preco"));
                venda.setAnoFabrico(rs.getDouble("ANOFABRICO"));
                listaVendas.add(venda);
            }
            return listaVendas;
        }
    }

    @Override
    public Venda recuperar(int id) throws SQLException {
        String sql = "SELECT * FROM vendas WHERE ID=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                Venda venda = new Venda();
                if (rs.next()) {
                    venda.setId(rs.getInt("ID"));
                    venda.setCliente(rs.getString("Cliente"));
                    venda.setVeiculo(rs.getString("Veiculo"));
                    venda.setModelo(rs.getString("Modelo"));
                    venda.setCor(rs.getString("Cor"));
                    venda.setPreco(rs.getDouble("Preco"));
                    venda.setAnoFabrico(rs.getDouble("ANOFABRICO"));
                }
                return venda;
            }
        }
    }

    public boolean salvarVenda(Venda venda) throws SQLException {
        String sql = "INSERT INTO venda (cliente, veiculo, modelo, cor, preco, AnoFabrico) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, venda.getCliente());
            stmt.setString(2, venda.getVeiculo());
            stmt.setString(3, venda.getModelo());
            stmt.setString(4, venda.getCor());
            stmt.setDouble(5, venda.getPreco());
            stmt.setDouble(6, venda.getAnoFabrico());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        }
    }

    public boolean atualizarVenda(Venda venda) throws SQLException {
        String sql = "UPDATE venda SET cliente=?, veiculo=?, modelo=?, cor=?, preco=?, AnoFabrico=? WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, venda.getCliente());
            stmt.setString(2, venda.getVeiculo());
            stmt.setString(3, venda.getModelo());
            stmt.setString(4, venda.getCor());
            stmt.setDouble(5, venda.getPreco());
            stmt.setDouble(6, venda.getAnoFabrico());
            stmt.setInt(7, venda.getId());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        }
    }
}
