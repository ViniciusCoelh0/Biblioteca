package entities;

public class Livro {

    private String book;
    private String author;
    private int year;

    public Livro() {
    }

    public Livro(String book, String author, int year) {
        this.book = book;
        this.author = author;
        this.year = year;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Livros{" +
                "book: '" + book + '\'' +
                ", author: '" + author + '\'' +
                ", year: " + year +
                '}';
    }
}
