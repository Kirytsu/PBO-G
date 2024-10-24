public class Book
{
    private String judul;
    private String penulis;
    private int tahun_terbit;
    private String penerbit;
    private String kategori;

    // Constructor
    public Book(String judul, String penulis, int tahun_terbit,
        String penerbit, String kategori)
    {
        this.judul = judul;
        this.penulis = penulis;
        this.tahun_terbit = tahun_terbit;
        this.penerbit = penerbit;
        this.kategori = kategori;
    }

    public void printDetails()
    {
        System.out.println("Nama buku : " + this.judul);
        System.out.println("Penulis : " + this.penulis);
        System.out.println("Kategori : " + this.kategori);
        System.out.println("Penerbit : " + this.penerbit);
        System.out.println("Tahun terbit : " + this.tahun_terbit);
    }
}
