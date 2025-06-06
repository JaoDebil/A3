package treinosDAO;

import treinos.treinos;
import conexao.MySQLConnection;
import alunosDAO.alunosDAO;

import java.sql.*;
import java.util.*;

public class treinosDAO {
    public void cadastrarTreino(treinos t) throws SQLException {
        alunosDAO alunoDao = new alunosDAO();
        if (!alunoDao.existeAluno(t.getAluno_id())) {
        System.out.println("Erro: Aluno com ID " + t.getAluno_id() + " não existe.");
        return;
    }
        String sql = "INSERT INTO treinos (aluno_id, tipo_treino, descricao, duracao_minutos, data_inicio) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = MySQLConnection.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, t.getAluno_id());
            stmt.setString(2, t.getTipo_treino());
            stmt.setString(3, t.getDescricao());
            stmt.setInt(4, t.getDuracao_minutos());
            stmt.setDate(5, t.getData_inicio());
            stmt.executeUpdate();
        }
    }

    public List<treinos> listarTreinosPorAluno(int alunoId) throws SQLException {
        List<treinos> lista = new ArrayList<>();
        String sql = "SELECT * FROM treinos WHERE aluno_id = ?";

        try (Connection conn = MySQLConnection.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, alunoId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    treinos t = new treinos();
                    t.setId(rs.getInt("id"));
                    t.setAluno_id(rs.getInt("aluno_id"));
                    t.setTipo_treino(rs.getString("tipo_treino"));
                    t.setDescricao(rs.getString("descricao"));
                    t.setDuracao_minutos(rs.getInt("duracao_minutos"));
                    t.setData_inicio(rs.getDate("data_inicio"));
                    lista.add(t);
                }
            }
        }

        return lista;
    }

    public void excluirTreino(int treinoId) throws SQLException {
        String sql = "DELETE FROM treinos WHERE id = ?";

        try (Connection conn = MySQLConnection.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, treinoId);
            stmt.executeUpdate();
        }
    }
}