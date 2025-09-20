package entities;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livrosList = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livrosList.add(livro);
    }

    public void removerLivro(Livro livro) {
        livrosList.remove(livro);
    }

    public void listarLivros() {
        if (livrosList.isEmpty()) {
            System.out.println("Nenhum livro cadastrado...");
            return;
        }
        for (Livro l : livrosList) {
            System.out.println(l);
        }
    }

    public Livro buscarLivroPorAutor(String author) {
        for (Livro l : livrosList) {
            if (l.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                return l;
            }
        }
        return null;

    }

    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro l : livrosList) {
            if (l.getBook().toLowerCase().contains(titulo.toLowerCase())) {
                return l;
            }
        }
        return null;

    }

}
