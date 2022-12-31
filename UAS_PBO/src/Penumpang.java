//class Penumpang
public class Penumpang
{
    String id_penumpang;
    String nama_penumpang;

    //constructor
    public Penumpang()
    {

    }

    //constructor
    public Penumpang (String id_penumpang, String nama_penumpang)
    {
        this.id_penumpang = id_penumpang;
        this.nama_penumpang = nama_penumpang;
        System.out.println("\n");
        System.out.println(this.id_penumpang+ "Tercatat sebagai member baru!");
        System.out.println("Dengan Atas Nama Mr./Mrs. " +this.nama_penumpang);
    }

    public void method()
    {

    }
}