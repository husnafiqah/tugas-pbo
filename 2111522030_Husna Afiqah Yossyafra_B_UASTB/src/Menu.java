import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Date;

public class Menu {

    static Scanner input = new Scanner(System.in);
    static Date date =  new Date();
    static Calendar calendar = Calendar.getInstance();

    String buah;
    int harga;

    public Menu(String buah, int harga){
        this.buah = buah;
        this.harga = harga;
    }
    
    //method tampil menu
    public static int menuPenjualan(){

        // Menampikan Tanggal/Date 
       String namaHari[] = {
        "Minggu","Senin","Selasa","Rabu","Kamis","Jumat","Sabtu"
       };
       String hari = namaHari[calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)];
       String tanggal =  String.format("%tF", date);
       String waktu =  String.format("%tT", date);
       String zona =  String.format("%tZ", date);
       System.out.println();
       
        
        //Memebuat objek
        LinkedHashSet<Menu> buah=new LinkedHashSet<Menu>();  
    
        
        //inisialisasi objek
        Menu b1 = new Menu("Mangga",20000);  
        Menu b2 = new Menu("Jeruk",24000);  
        Menu b3 = new Menu("Apel", 28000);
        Menu b4 = new Menu("Pir", 40000);
        Menu b5 = new Menu("Melon", 25000);
        

        //Menambah elemen ke linkHashset
        buah.add(b1);  
        buah.add(b2);   
        buah.add(b3);   
        buah.add(b4);   
        buah.add(b5); 
        
       //Membuat tampilan menu
        System.out.println("==============================================");
        System.out.println("            TOKO BUAH INDONESIA");
        System.out.println("     "+hari +","+tanggal+ " || "+waktu+" "+zona);
        System.out.println("----------------------------------------------");
        
        
        System.out.println("\n                DAFTAR MENU"); 
        System.out.println("----------------------------------------------");

        //Menampilkan daftar menu
        for(Menu b:buah){  
            System.out.printf("  %-21s    %-9d\n",b.buah,b.harga);  
        } 
        System.out.println("");  
        System.out.println("""
        \n
        1. lihat pesanan buah
        2. Masukkan pesanan buah
        3. ubah pesanan buah
        4. batalkan pesanan buah
        """);
        System.out.print("\nMasukkan pilihan Anda : ");
        int pilihan =  input.nextInt();
        return pilihan;
   
    }   


    public static void pembayaran(){
        //Memebuat objek
        ArrayList<String> list=new ArrayList<String>();//Creating arraylist  
        
        //Menambah elemen ke linkHashSet
        list.add("Tunai");
        list.add("Debit");
     

        //Menampilkan isi list
        Iterator itr=list.iterator();  
        int i = 1;
        while(itr.hasNext()){
            System.out.print(i+". "); 
            System.out.println(itr.next());
            i++;
        }  
        System.out.print("Masukkan pilihan : ");
        input.nextInt();
        System.out.println("Pembayaran anda berhasil");
       

    }  
    
}
