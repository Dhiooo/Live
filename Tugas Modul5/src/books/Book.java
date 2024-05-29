package books;

public class Book {
    private String idBuku;
    private String judul;
    private int stok;
    private String author;
    private String category;

    public Book(String idBuku, String judul, int stok, String category , String author) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.stok = stok;
        this.category = category;
        this.author = author;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public int getStok() {
        return stok;
    }

    public String getCategory() {
        return category;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getAuthor() {
        return author;
    }
}
