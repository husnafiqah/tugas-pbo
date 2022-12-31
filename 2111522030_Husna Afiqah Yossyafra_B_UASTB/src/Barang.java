//Import Library
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.Scanner;


//Membuat kelas barang dengan menggunakan interface CRUD
public class Barang implements CRUD{

      //Membuat objek 
      static Connection conn;
      static Statement stm;
      static ResultSet rs;
      static Scanner input = new Scanner(System.in);
      Transaksi transaksi;

      // Membuat properti
      private int harga;
      private int jumlah;
      private int subtotal;
      private int diskon;
      
    //tes koneksi
    public Connection getKoneksi() {
        
        //Deklarasi variabel
        String url = "jdbc:mysql://localhost:3306/buah";
        String user = "root";
        String pass = "";
        
        //Exception
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn  = DriverManager.getConnection(url, user, pass);
            System.out.print("koneksi berhasil");
        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }

    //Polymorphisme Overridding
    @Override
    public  void tampilData(){
        
        String sql =  "SELECT * FROM penjualan";

        //Exception
        try {
            // inisisalisasi objek
            stm = conn.createStatement();
            rs =  stm.executeQuery(sql);
            
            // String method
            String judul = "daftar pesanan";
           
            System.out.printf("\t\t\t    %s\n",judul.toUpperCase());
           
           
            //Menampilka tabel dari database
            System.out.println("| No pesan |       Nama        | Harga   | Jumlah |  Diskon  | Subtotal |");
            while(rs.next()){
                int no_pesanan =  rs.getInt("no_pesanan");
                String nama_buah =  rs.getString("nama_buah");
                int harga =  rs.getInt("harga");
                int jumlah=  rs.getInt("jumlah");
                int diskon=  rs.getInt("diskon");
                int subtotal = rs.getInt("subtotal");
                System.out.println(String.format("    %-6d   %-16s    %-7d     %-5d   %-7d    %-7d  ", no_pesanan,nama_buah,harga,jumlah,diskon,subtotal));
                
            }
            //String method
            char[] str = {'T','e','r','i','m','a',' ','K','a','s','i','h'};
            String str2 = "";

            str2 = String.copyValueOf(str);
            str2 = str2.toUpperCase();
            System.out.printf("\n\t\t\t    %s \n\n",str2);
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    //Polymorphisme Overriding 
    @Override
    public void pesan(){
        //Exception handling
        try {
            //menginput data
            System.out.print("\nMasukkan no pesan : ");
            int  no_pesanan = input.nextInt();
        
            input.nextLine();
            System.out.print("\nMasukkan nama     : ");
            String nama_buah = input.nextLine();

            System.out.print("\n harga    : ");
            int harga = input.nextInt();

            System.out.print("\nMasukkan jumlah   : ");
            jumlah = input.nextInt();
            
            //percabangan if
            if(harga < 0 || jumlah < 0 || no_pesanan < 0){
                throw new IllegalArgumentException("angka tidak boleh negatif");
            }
            //instansiasi objek
            transaksi = new Transaksi(harga, diskon);
            this.harga = harga * jumlah;
            subtotal = transaksi.harga(this.harga);
            diskon =  transaksi.Discount(this.harga);
            
            //query tampil data 
            String sql =  "SELECT * FROM penjualan";
            stm = conn.createStatement();
            rs =  stm.executeQuery(sql);
           
            while(rs.next()){
                if(no_pesanan == rs.getInt("no_pesanan")){
                    System.out.println("\nno pesan telah ada");
                    throw new SQLException();
                }   
               
            }

            //query insert data
            String sql2 =  "INSERT INTO penjualan (no_pesanan,nama_buah,harga,jumlah,diskon,subtotal) VALUE('"+no_pesanan+"','"+nama_buah+"','"+harga+"','"+jumlah+"','"+diskon+"','"+subtotal+"')";
            stm.executeUpdate(sql2);
            System.out.println("Barang dimasukkan ke pesanan");

        } catch (IllegalArgumentException  | SQLException e) {
            System.err.println(e);
        }
    
    }

    //Polymorphisme overriding
    @Override
    public void updatePesan(){
        //Exception handling
        try {
            //memanggil method tampil data
            tampilData();

            //input data
            System.out.println();
            System.out.print("Masukkan no pesan: ");
            int no_pesanan =  input.nextInt();

            input.nextLine();
            System.out.print("Masukkan nama     : ");
            String nama_buah = input.nextLine();

            System.out.print("Masukkan harga    : ");
            int harga = input.nextInt();

            System.out.print("Masukkan jumlah   : ");
            int jumlah = input.nextInt();

            if(harga < 0 || jumlah < 0 || no_pesanan < 0){
                throw new IllegalArgumentException("angka tidak boleh negatif");
            }
            
            //instansiasi objek
            transaksi = new Transaksi(harga, diskon);
            this.harga = harga * jumlah;
            subtotal = transaksi.harga(this.harga);
            diskon =  transaksi.Discount(this.harga);
            boolean isFound = false;
          
            //query tampil data
            String sql =  "SELECT * FROM penjualan";
            stm = conn.createStatement();
            rs =  stm.executeQuery(sql);
           
            while(rs.next()){
                if(no_pesanan == rs.getInt("no_pesanan")){
                    isFound = true;
                }   
            }

            //pengecekan data di database
            if(!isFound){
                throw new SQLException("data tidak ditemukan");
            }else{
                //Query update data
                String sql2 = "UPDATE penjualan SET no_pesanan='"+no_pesanan+",nama_buah='"+nama_buah+"',harga='"+harga+"',jumlah='"+jumlah+"' WHERE no_pesanan= '"+no_pesanan+"'";
                stm.executeUpdate(sql2);
                System.out.println("Barang pesanan berhasil diupdate");
            }
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println(e);
        }
       
    }

    //Polymorhpisme overriding
    @Override
    public void batalPesan(){
        //Exception handling
        try {
            //Memanggil method
            tampilData();
            System.out.println();
            System.out.print("Masukkan no pesan : ");
            int no_pesanan = input.nextInt();

            if(no_pesanan < 0){
                throw new IllegalArgumentException("angka tidak boleh negatif");
            }

            boolean isFound = false;
            //query tampil data
            String sql =  "SELECT * FROM penjualan";
            stm = conn.createStatement();
            rs =  stm.executeQuery(sql);
           
            while(rs.next()){
                if(no_pesanan == rs.getInt("no_pesanan")){
                    isFound = true;
                }   
            }
            //pengecekan data
            if(!isFound){
                throw new SQLException("data tidak ditemukan");
            }else{
                //query hapus data
                String sql2 = "DELETE FROM  penjualan WHERE no_pesanan= " +no_pesanan;
                stm.executeUpdate(sql2);
                System.out.println("Barang batal di pesan");
            }
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println(e);
        }

       
    }

    //polymorphisme overriding
    @Override
    public void cariData(){
        //Exception handling
        try {
            //input keyword pencarian
            System.out.print("masukkan keyword (nama barang/no pesan) : ");
            String keyword = input.next();
            
            //query cari data
            String sql = "SELECT * FROM penjualan WHERE no_pesanan LIKE '%"+keyword+"%' OR  nama_buah LIKE '%"+keyword+"%";

            //inisialisasi objek
            stm = conn.createStatement();
            rs =  stm.executeQuery(sql);

            //Menampilkan data yang dicari
            System.out.println("| No pesan          Nama           Harga     Jumlah    Diskon    Subtotal |");
            System.out.println("------------------------------------------------------------------------------------");
            while(rs.next()){
                    int no_pesanan =  rs.getInt("no_pesanan");
                    String nama_buah = rs.getString("nama_buah");
                    int jumlah =  rs.getInt("jumlah");
                    int harga=  rs.getInt("harga");
                    int diskon=  rs.getInt("diskon");
                    int subtotal = rs.getInt("subtotal");
                    
                    System.out.println(String.format("|   %-6d | %-8s | %-11s  | %-8d |   %-5d|  %-7d |  %-7d |", no_pesanan,nama_buah,harga,jumlah,diskon,subtotal));
            }
            
        } catch (Exception e) {
            System.err.println(e);
        }
        
					
    }
}