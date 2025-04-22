import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner livroInfos = new Scanner(System.in);

		ArrayList<Livros> listaLivros = new ArrayList<>();
		
		while (true) {
			System.out.println("\nO que deseja fazer?");
			System.out.println("[1] Ver lista de livros");
			System.out.println("[2] Adicionar um livro");
			System.out.println("[3] Excluir livro");
			System.out.println("[4] Sair");
			System.out.print("Escolha: ");

			int escolha = livroInfos.nextInt();
			livroInfos.nextLine();
		
		
			switch (escolha) {
			case 1 -> {
				if (listaLivros.isEmpty()) {
					System.out.println("\nNenhum livro cadastrado.");
				} else {
						System.out.println("\nLista de livros:\n");
						int index = 0;
						for (Livros l : listaLivros) {
							System.out.println(index + ": " + l); // Mostra o índice junto com o livro
							System.out.println("----------------------");
							index++;
						}
				}
			}
			case 2 -> {
				Livros livros = new Livros();
				
				System.out.println("Vamos adicionar um livro? \n");
				System.out.println("Titulo:");
				livros.setTitulo(livroInfos.nextLine());
				
				System.out.println("Autor:");
				livros.setAutor(livroInfos.nextLine());
				
				System.out.println("Ano de publicação:");
				livros.setAnoPublicacao(livroInfos.nextInt());
				
				System.out.println("Numero de paginas:");
				livros.setNumeroPaginas(livroInfos.nextInt());
				
				
				listaLivros.add(livros);
				
				System.out.println("\nLivro adicionado com sucesso!\n");
				System.out.println(livros);
						
			}
			
			case 3 ->{
				System.out.println("Escolha o método de exclusão:");
				System.out.println("[1] Excluir por índice");
				System.out.println("[2] Excluir por título");
				int metodoExcluir = livroInfos.nextInt();
				
				
				switch (metodoExcluir) {
					case 1 -> {
						System.out.println("Digite o indice do livro que deseja excluir:");
						String limpa = livroInfos.nextLine();
						int indice = livroInfos.nextInt();
						
						if(indice >= 0 && indice < listaLivros.size()) {
							listaLivros.remove(indice);
							System.out.println("Livro excluido com sucesso");
							
						}else {
							System.out.println("Titulo não encontrado");
						}
					
					}
					
					
					
					case 2 ->{
						System.out.print("Digite o título do livro que deseja excluir: ");
						String limpa = livroInfos.nextLine();
						String titulo = livroInfos.nextLine();
						boolean encontrado = false;
						
						for(Livros l : listaLivros) {
							if(l.getTitulo().equalsIgnoreCase(titulo)) {
								listaLivros.remove(l);
								encontrado = true;
								System.out.println("Livro: \"" + titulo + "\" Excluido com sucesso" );
								break;
							}
						}
						if(!encontrado) {
							System.out.println("Livro não encontrado");
						}
						
					}
					
				}
				
			}
			case 4 ->{
				System.out.println("Saindo da biblioteca.");
				System.exit(escolha);
				return;
			}
			
			default -> throw new IllegalArgumentException("Valor invalido: " + escolha);
			}
			
			
	}
		
		
		
		livroInfos.close();
	}
}
