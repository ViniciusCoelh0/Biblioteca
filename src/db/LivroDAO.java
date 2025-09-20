package db;

import entities.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class LivroDAO {

    public void adicionarLivro(Livro livro) {
        String sql = "INSERT INTO livros (titulo, autor, ano) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseService.connect();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, livro.getBook());
            pstm.setString(2, livro.getAuthor());
            pstm.setInt(3, livro.getYear());
            pstm.executeUpdate();
            System.out.println("Livro adicionado com sucesso.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> listarLivros() {
        List<Livro> lista = new ArrayList<>();
        String sql = "SELECT * FROM livros";

        try (Connection conn = DatabaseService.connect();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                Livro livro = new Livro(
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano")
                );
                lista.add(livro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Livro buscarPorTitulo(String titulo) {
        String sql = "SELECT * FROM livros WHERE LOWER(titulo) LIKE ?";
        try (Connection conn = DatabaseService.connect();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, "%" + titulo.toLowerCase() + "%");
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new Livro(
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Livro buscarPorAutor(String autor) {
        String sql = "SELECT * FROM livros WHERE LOWER(autor) LIKE ?";
        try (Connection conn = DatabaseService.connect();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, "%" + autor.toLowerCase() + "%");
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new Livro(
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removerLivro(String titulo) {
        String sql = "DELETE FROM livro WHERE titulo = ?";
        try (Connection conn = DatabaseService.connect();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, titulo);
            int rows = pstm.executeUpdate();
            if (rows > 0) {
                System.out.println("Livro removido com sucesso");
            } else {
                System.out.println("Nenhum livro encontrado com esse título.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarLivro(String tituloAntigo, Livro novo) {
        String sql = "UPDATE livros SET titulo = ?, autor = ?,  ano = ? WHERE titulo = ?";
        try (Connection conn = DatabaseService.connect();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, novo.getBook());
            pstm.setString(2, novo.getAuthor());
            pstm.setInt(3, novo.getYear());
            pstm.setString(4, tituloAntigo);
            int rows = pstm.executeUpdate();
            if(rows > 0){
                System.out.println("Livro atualizado com sucesso!");
            }else{
                System.out.println("Nenhum livro encontrado para atualizar.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
