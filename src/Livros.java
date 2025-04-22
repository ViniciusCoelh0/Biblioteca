
public class Livros {
	String titulo;
	String autor;
	int anoPublicacao;
	int numeroPaginas;
	String descricao;
	
	public void Livro(String titulo, String autor, int anoPublicacao, int numeroPaginas, String descricao) {
		this.titulo = titulo;
		this.autor = autor;
		this.anoPublicacao = anoPublicacao;
		this.numeroPaginas = numeroPaginas;
		
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public String toString() {
		return "Titulo: " + titulo + "\n" 
		+ " Autor: " + autor + "\n"
		+ " Ano de publicação: " + anoPublicacao + "\n" 
		+ " Numero de paginas: " + numeroPaginas;
		
	}
	
}
