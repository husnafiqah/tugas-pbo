import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

//class JadwalTravel
public class JadwalTravel implements Database //class JadwalTravel yang mengimplementasikan interface Database
{
    //koneksi database
    Connection conn;
    String link = "jdbc:mysql://localhost:3306/IlhamTravel";
    Scanner input = new Scanner(System.in);

    String id_travel;
    String lokasi_berangkat; 
    String lokasi_tujuan;
    String jadwal;
    Integer harga;

    public void method()
    {

    }

    //implementasi dari interface

    @Override
    public void insert() throws SQLException 
    {
        System.out.print("\n==========Tambah Jadwal Travel==========");
        System.out.print("\nID Travel       : ");
        this.id_travel = input.nextLine();
        System.out.print("Lokasi Berangkat  : ");
        this.lokasi_berangkat = input.nextLine();
        System.out.print("Lokasi Tujuan     : ");
        this.lokasi_tujuan = input.nextLine();
        System.out.print("Jadwal            : ");
        this.jadwal = input.nextLine();
        System.out.print("Harga             : ");
        this.harga = input.nextInt();
    
        String sql = "INSERT INTO jadwal_travel (id_travel, lokasi_berangkat, lokasi_tujuan,  jadwal, harga) VALUES ('"+id_travel+"','"+lokasi_berangkat+"','"+lokasi_tujuan+"','"+jadwal+"', '"+harga+"' )";
        conn = DriverManager.getConnection(link,"root","");
	    Statement statement = conn.createStatement();
	    statement.execute(sql);
	    System.out.println("Input Data Sukses!");
        
        statement.close();
    }

    @Override
    public void view() throws SQLException 
    {
        //mengakses data yang berada di database jadwal_travel
        String sql = "SELECT * FROM jadwal_travel";
        conn = DriverManager.getConnection(link,"root","");
        Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

        while (result.next())
        {
        System.out.print("\nID Travel         : ");
        System.out.println(result.getString("id_travel"));
        System.out.print("Lokasi Berangkat  : ");
        System.out.println(result.getString("lokasi_berangkat"));
        System.out.print("Lokasi Tujuan     : ");
        System.out.println(result.getString("lokasi_tujuan"));
        System.out.print("Jadwal            : ");
        System.out.println(result.getString("jadwal"));
        System.out.print("Harga             : ");
        System.out.println(result.getInt("harga"));
        }
        
        statement.close();
    }
    
    @Override
    public void update() throws SQLException 
    {
        //try
        try
        {
            view();
            Integer pil;
            System.out.print("\n----------Ubah Jadwal----------");
            System.out.print("\nID Travel : ");
            String ubah = input.nextLine();

            //mengakses data database jaya_travel tabel jadwal_travel
            String sql = "SELECT * FROM jadwal_travel WHERE id_travel ='"+ubah+"'";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            //percabangan  if
            if (result.next())
            {
                System.out.println("\nData yang akan diubah \n1.Jadwal Travel\n2.Harga Travel");
                System.out.print("Pilihan Anda [1/2] : ");
                pil = input.nextInt();
                input.nextLine();
        
                //percabangan switch case
                switch (pil)
                {
                    case 1:
                        System.out.print("\nJadwal Travel ["+result.getString("jadwal")+"]\t: ");
                        String ubah1 = input.nextLine();
                        //update data  database jaya_travel tabel jadwal_travel
                        sql = "UPDATE jadwal_travel SET jadwal = '"+ubah1+"' WHERE id_travel ='"+ubah+"'";
                        if(statement.executeUpdate(sql) > 0)
                        {
                            System.out.println("Berhasil Memperbarui Jadwal! (ID Travel "+ubah+")");
                        }
                    break;
        
                    case 2:
                        System.out.print("\nHarga Travel ["+result.getInt("harga")+"]\t: ");
                        Integer ubah2 = input.nextInt();
                        //update data  database jaya_travel tabel jadwal_travel
                        sql = "UPDATE jadwal_travel SET harga = "+ubah2+" WHERE id_travel ='"+ubah+"'";
                        input.nextLine();
                        if(statement.executeUpdate(sql) > 0)
                        {
                            System.out.println("Berhasil Memperbarui Harga! (ID Travel "+ubah+")");
                        }
                    break;

                    default :
                        System.out.println("\n\t***ERROR***");
                        System.out.println("Input Angka 1 atau 2 !");
                    break;
                }
            }

            else
            {
                System.out.println("**Error!**");
            }
        }

        //exeption SQL 
        catch (SQLException e)
        {
            System.err.println("Update Data Gagal");
        }

        //exception input tidak sesuai jenis data
        catch (InputMismatchException e)
        {
            System.err.println("Gagal! Masukkan Data yang Benar");
        }
    }
    public void save() throws SQLException 
    {
        
    }
    public void delete() throws SQLException 
    {
    }
}
