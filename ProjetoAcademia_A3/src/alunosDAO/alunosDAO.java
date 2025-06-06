package alunosDAO;

import alunos.alunos;
import conexao.MySQLConnection;

import java.sql.*;
import java.util.*;

public class alunosDAO {

    public void cadastrarAluno(alunos a) throws SQLException {
        String sql = "INSERT INTO alunos (nome, cpf, data_nascimento, telefone, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = MySQLConnection.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getCpf());
            stmt.setDate(3, a.getData_nascimento());
            stmt.setString(4, a.getTelefone());
            stmt.setString(5, a.getEmail());
            stmt.executeUpdate();
        }
    }
    
    public boolean existeAluno(int id) throws SQLException {
    String sql = "SELECT 1 FROM alunos WHERE id = ?";
    try (Connection conn = MySQLConnection.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            return rs.next(); // retorna true se o aluno existir
        }
    }
}
    
    public List<alunos> listarAlunos() throws SQLException {
        List<alunos> lista = new ArrayList<>();
        String sql = "SELECT * FROM alunos";

        try (Connection conn = MySQLConnection.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                alunos a = new alunos();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setCpf(rs.getString("cpf"));
                a.setData_nascimento(rs.getDate("data_nascimento"));
                a.setTelefone(rs.getString("telefone"));
                a.setEmail(rs.getString("email"));
                lista.add(a);
            }
        }
        return lista;
    }

    public void editarAluno(alunos a) throws SQLException {
        String sql = "UPDATE alunos SET nome=?, cpf=?, data_nascimento=?, telefone=?, email=? WHERE id=?";

        try (Connection conn = MySQLConnection.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getCpf());
            stmt.setDate(3, a.getData_nascimento());
            stmt.setString(4, a.getTelefone());
            stmt.setString(5, a.getEmail());
            stmt.setInt(6, a.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirAluno(int id) throws SQLException {
        String sql = "DELETE FROM alunos WHERE id=?";

        try (Connection conn = MySQLConnection.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}