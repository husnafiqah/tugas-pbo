import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

//class PesanTiket
public class PesanTiket extends JadwalTravel {
    // koneksi database
    Connection conn;
    String link = "jdbc:mysql://localhost:3306/ilhamtravel";

    Scanner input = new Scanner(System.in);
    String nama_admin, id_admin;
    String tanggal_booking, nama_penumpang, id_penumpang;
    Integer jmlhtiketMax = 15, tiket_tersedia, tiket_dipesan, total_harga;

    public void nama_admin() {
        System.out.print("\nNama Admin       : ");
        this.nama_admin = input.nextLine();
    }

    public void id_admin() {
        System.out.print("ID Admin         : ");
        this.id_admin = input.nextLine();
    }

    public void tanggal_booking() {
        System.out.print("Tanggal Booking  : ");
        this.tanggal_booking = input.nextLine();
    }

    public void id_penumpang() {
        System.out.print("ID Penumpang     : ");
        this.id_penumpang = input.nextLine();

    }

    public void nama_penumpang() {
        System.out.print("Nama Penumpang   : ");
        this.nama_penumpang = input.nextLine();
    }

    public void id_travel() {
        System.out.print("ID Travel        : ");
        this.id_travel = input.nextLine();
    }

    public void harga() {
        System.out.print("Harga            : ");
        this.harga = input.nextInt();
    }

    public void jumlah_tiket() {
        // Maximum penjualan tiket 15 lembar pada setiap jadwal travel
        System.out.print("Jumlah Tiket     : ");
        tiket_dipesan = input.nextInt();
        {
            try {
                if (tiket_dipesan <= 0 && tiket_dipesan > 15)
                    System.out.print("Tiket Tidak Tersedia");
            }

            catch (Exception nullpException) {
                System.out.println("\nERROR!\n");
            }
        }
    }

    public void total_harga() {
        // Total harga yang harus dibayar penumpang
        this.total_harga = this.harga * this.tiket_dipesan;
        System.out.print("\nTotal Harga       :  Rp" + this.total_harga + "");
    }

    public void penumpang() throws SQLException {
        Penumpang penumpang = new Penumpang(this.id_penumpang, this.nama_penumpang);
        penumpang.method();
    }

    @Override
    public void save() throws SQLException {
        try {
            view();
            System.out.print("\n==========Pesan Tiket==========");
            nama_admin();
            id_admin();
            tanggal_booking();
            id_penumpang();
            nama_penumpang();
            id_travel();
            harga();
            jumlah_tiket();
            total_harga();

            penumpang();

            conn = DriverManager.getConnection(link, "root", "");
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO pesan_tiket (tanggal_booking, id_penumpang, nama_penumpang, id_travel, jumlah_tiket, total_harga) VALUES ('"
                    + this.tanggal_booking + "', '" + this.id_penumpang + "', '" + this.nama_penumpang + "', '"
                    + this.id_travel + "', '" + this.tiket_dipesan + "', '" + this.total_harga + "')";
            statement.execute(sql);
            System.out.println("\nPesan Tiket Berhasil");

        }

        // exception SQL
        catch (SQLException e) {
            System.err.println("\nPesan Tiket Gagal");
        }

        // excception input tidak sesuai dengan tipe data
        catch (InputMismatchException e) {
            System.out.println("\nTipe Inputan Data Harus Benar");
        }
    }

    @Override
    public void delete() throws SQLException {
        try {
            System.out.println("=======Pembatalan Booking Tiket=======");
            System.out.println("ID Penumpang : ");
            this.id_penumpang = input.next();

            String sql = "DELETE FROM pesan_tiket WHERE id_penumpang = " + id_penumpang;
            conn = DriverManager.getConnection(link, "root", "");
            Statement statement = conn.createStatement();
            // ResultSet result = statement.executeQuery(sql);

            if (statement.executeUpdate(sql) > 0) {
                System.out.println("**Berhasil Menghapus Booking " + id_penumpang + "**");
            }
        }

        catch (SQLException e) {
            System.out.println("Terjadi Kesalahan Dalam Menghapus Data ");
        }

        catch (Exception e) {
            System.out.println("Masukan ID Penumpang Yang Benar");
        }

    }

}
