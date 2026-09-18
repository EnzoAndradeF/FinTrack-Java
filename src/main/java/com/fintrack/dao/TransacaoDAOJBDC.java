package com.fintrack.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.management.RuntimeErrorException;
import com.fintrack.factory.ConnectionFactory;
import com.fintrack.model.Entrada;
import com.fintrack.model.Saida;
import com.fintrack.model.Transacao;

public class TransacaoDAOJBDC implements TransacaoDAO {

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM transacoes WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar transação", e);
        }
    }

    @Override
    public List<Transacao> listarTodas() {
        String sql = "SELECT id, descricao, valor, tipo, data_transacao FROM transacoes";
        List<Transacao> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                double valor = rs.getDouble("valor");
                String tipo = rs.getString("tipo");
                LocalDate data = rs.getDate("data_transacao").toLocalDate();

                Transacao t =
                        "ENTRADA".equalsIgnoreCase(tipo) ? new Entrada(id, descricao, valor, data)
                                : new Saida(id, descricao, valor, data);

                lista.add(t);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar transações", e);
        }

        return lista;
    }

    @Override
    public void salvar(Transacao transacao) {
        String sql =
                "INSERT INTO transacoes (descricao, valor, tipo, data_transacao) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, transacao.getDescricao());
            stmt.setDouble(2, transacao.getValor());
            stmt.setString(3, transacao instanceof Entrada ? "ENTRADA" : "SAIDA");
            stmt.setDate(4, Date.valueOf(transacao.getDataTransacao()));

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    transacao.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar transação no MySQL", e);
        }
    }

}
