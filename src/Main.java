import db.DatabaseSetup;
import db.LivroDAO;
import entities.Livro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Para biblioteca sem DB
        //Biblioteca livros = new Biblioteca();

        //DB
        LivroDAO dao = new LivroDAO();

        // Cria a tabela se não existir
        DatabaseSetup.criarTabela();

        System.out.println("Biblioteca online...");

        while (true) {

            System.out.println("\n=== MENU ===");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Buscar livro");
            System.out.println("4 - Atualizar livro");
            System.out.println("8 - Remover livro");
            System.out.println("0 - Sair");


            int option = sc.nextInt();


            switch (option) {

                case 1 -> adicionarLivro(sc, dao);
                case 2 -> {
                    var livros = dao.listarLivros();
                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        livros.forEach(System.out::println);
                    }
                }
                case 3 -> buscarLivroPorAutor(sc, dao);
                case 5 -> atualizarLivro(sc, dao);
                case 8 -> removerLivroPorNome(sc, dao);
                case 0 -> {
                    System.out.println("Adeus, espero te ver de novo em breve.");
                    System.exit(0);
                }
            }
        }
    }

    public static void adicionarLivro(Scanner sc, LivroDAO dao) {
        sc.nextLine();
        System.out.println("Vamos adicionar um livro: \n");

        System.out.print("Nome do Livro: ");
        String book = sc.nextLine().toLowerCase();

        System.out.println();

        System.out.print("Nome do Autor: ");
        String author = sc.nextLine().toLowerCase();

        System.out.println();

        System.out.print("Ano de publicação: ");
        int year = sc.nextInt();

        dao.adicionarLivro(new Livro(book, author, year));

//        Livro livroAdd = new Livro(book, author, year);
//        livros.adicionarLivro(livroAdd);
    }

    private static void buscarLivroPorAutor(Scanner sc, LivroDAO dao) {
        System.out.println("Iniciando busca... \n");
        sc.nextLine();
        System.out.println("Digite o nome do livro ou do autor: ");
        String buscador = sc.nextLine().toLowerCase();

        Livro encontrado = (dao.buscarPorAutor(buscador) != null)
                ? dao.buscarPorAutor(buscador)
                : dao.buscarPorTitulo(buscador);

        System.out.println(
                (encontrado != null)
                        ? "Livro encontrado: " + encontrado
                        : "Nenhum livro encontrado para: " + buscador
        );

//        Livro encontrado = (livros.buscarLivroPorAutor(buscador) != null)
//                ? livros.buscarLivroPorTitulo(buscador)
//                : livros.buscarLivroPorAutor(buscador);
//
//        System.out.println(
//                (encontrado != null)
//                        ? "Livro encontrado: " + encontrado
//                        : "Nenhum livro encontrado para: " + buscador
//        );
    }

    private static void removerLivroPorNome(Scanner sc, LivroDAO dao) {
        System.out.println("Removendo livro...");
        System.out.println("Digite o nome do livro para ser removido: ");
        sc.nextLine();
        String titulo = sc.nextLine();
        dao.removerLivro(titulo);

//        Livro encontrado = livros.buscarLivroPorTitulo(book);
//        if (encontrado != null) {
//            System.out.println("Livro " + encontrado.getBook() + " do autor " + encontrado.getAuthor() + "removido com sucesso.");
//            livros.removerLivro(encontrado);
//        } else {
//            System.out.println("Livro não encontrado.");
//        }


    }

    private static void atualizarLivro(Scanner sc, LivroDAO dao) {
        sc.nextLine();
        System.out.println("Digite o título do livro a ser atualizado: ");
        String antigo = sc.nextLine();

        System.out.print("Novo título: ");
        String titulo = sc.nextLine();
        System.out.print("Novo autor: ");
        String autor = sc.nextLine();
        System.out.print("Novo ano: ");
        int ano = sc.nextInt();

        dao.atualizarLivro(antigo, new Livro(titulo, autor, ano));
    }

//    public static void atualizarLivro(Scanner sc, Biblioteca livros) {
//        System.out.println("Removendo livro...");
//        System.out.println("Digite o nome do livro para ser atualizado: ");
//        sc.nextLine();
//        String book = sc.nextLine();
//
//        Livro encontrado = livros.buscarLivroPorTitulo(book);
//        if (encontrado != null) {
//            System.out.println("Livro encontrado.\n");
//            System.out.println("O que gostaria de atualizar: ");
//            System.out.println("1 - Nome do autor");
//            System.out.println("2 - Titulo do livro");
//            System.out.println("3 - Ano de publicação");
//            System.out.println("4 - Atualizar o livro inteiro");
//            int atualizar = sc.nextInt();
//            sc.nextLine();
//
//            switch (atualizar) {
//                case 1 -> {
//                    System.out.print("Digite o nome do autor do livro: ");
//                    String autor = sc.nextLine();
//                    encontrado.setAuthor(autor);
//                    System.out.println("Autor atualizado.");
//                }
//                case 2 -> {
//                    System.out.print("Digite o nome do livro: ");
//                    String titulo = sc.nextLine();
//                    encontrado.setBook(titulo);
//                    System.out.println("Titulo atualizado.");
//                }
//                case 3 -> {
//                    System.out.print("Digite o ano da publicação do livro: ");
//                    int ano = sc.nextInt();
//                    encontrado.setYear(ano);
//                    System.out.println("Ano do livro atualizado.");
//                }
//
//                case 4 -> {
//                    System.out.print("Digite o nome do livro: ");
//                    String titulo = sc.nextLine();
//                    System.out.print("Digite o nome do autor do livro: ");
//                    String autor = sc.nextLine();
//                    System.out.print("Digite o ano da publicação do livro: ");
//                    int ano = sc.nextInt();
//
//                    encontrado.setBook(titulo);
//                    encontrado.setAuthor(autor);
//                    encontrado.setYear(ano);
//
//                    System.out.print("Livro atualizado com sucesso.");
//
//                }
//
//                default -> System.out.println("Opção invalida");
//            }
//
//        } else {
//            System.out.println("Livro não encontrado.");
//        }
//    }

}