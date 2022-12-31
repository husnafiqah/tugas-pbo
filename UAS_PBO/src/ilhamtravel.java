import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Class Program
public class ilhamtravel {
    // Mengkoneksikan Database
    static Connection conn;
    static String link = "jdbc:mysql://localhost:3306/ilhamtravel";
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("\n===========PT ILHAM TRAVEL===========");
        System.out.println("\n           WELCOME           ");
        String salamSapa = "Halo!";
        String sapa = salamSapa.replace("Halo!", "Keep Fighting!\n"); // method string
        System.out.println(sapa.toUpperCase());

        admin();

        menu();

        // date
        DateFormat formatTanggal = new SimpleDateFormat("dd MMMM yyyy");
        DateFormat formatJam = new SimpleDateFormat("HH:mm:ss");
        Date tanggal = new Date();

        // date
        System.out.println("====================================");
        System.out.println("=Dibuat pada     : " + formatTanggal.format(tanggal) + " =");
        System.out.println("=Diupdate pada   : " + formatJam.format(tanggal) + " WIB    =");
        System.out.println("====================================");
    }

    private static void admin() throws SQLException {
        // Membuat Objek HashMap Baru
        Map<String, String> Login = new HashMap<String, String>();

        // Membaca Data di database tabel login
        String inputUsername, inputPassword;
        String sql = "SELECT * FROM login";
        boolean relogin = true;
        conn = DriverManager.getConnection(link, "root", "");
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        // perulangan while
        while (result.next()) {
            // mengambil nilai di database dan menyimpannya ke dalam variable
            String username = result.getString("username");
            String password = result.getString("password");

            // input key dan value
            Login.put(username, password);
        }
        System.out.println("------------------------------------");

        // perulangan while
        while (relogin) {

            System.out.print("Username : ");
            inputUsername = input.nextLine();
            System.out.print("Password : ");
            inputPassword = input.nextLine();

            if (Login.get(inputUsername).equals(inputPassword) == true) {
                System.out.println("***Login Success***");
                relogin = false;
            }

            if (Login.get(inputUsername).equals(inputPassword) == false) {
                System.out.println("***Login Failed***");
                System.out.println("Input Username atau Password yang Benar!\n");
                relogin = true;
            }
        }
        statement.close();
    }

    private static void menu() throws SQLException {
        boolean MenuKembali = true;
        boolean TanyaBalik = true;
        Integer pilihan;
        String pertanyaan;

        // perulangan while
        while (MenuKembali) {
            System.out.println("====================================");
            System.out.println("              LIST MENU             ");
            System.out.println("====================================");
            System.out.println("1.Lihat Jadwal");
            System.out.println("2.Input Jadwal");
            System.out.println("3.Ubah Jadwal");
            System.out.println("4.Booking Tiket Travel");
            System.out.println("5.Batalkan Booking Tiket Travel");
            System.out.println("6.Keluar");
            System.out.print("Input Pilihan Anda (1/2/3/4/5/6): ");

            pilihan = input.nextInt();
            input.nextLine();
            JadwalTravel jadwal_travel = new JadwalTravel();
            PesanTiket pesan_tiket = new PesanTiket();

            // percabangan switch case
            switch (pilihan) {
                case 1:
                    jadwal_travel.view();
                    TanyaBalik = true;
                    break;

                case 2:
                    jadwal_travel.insert();
                    TanyaBalik = true;
                    break;

                case 3:
                    jadwal_travel.update();
                    TanyaBalik = true;
                    break;

                case 4:
                    pesan_tiket.save();
                    TanyaBalik = true;
                    break;

                case 5:
                    pesan_tiket.delete();
                    TanyaBalik = true;
                    break;

                case 6:
                    TanyaBalik = false;
                    MenuKembali = false;
                    break;

                default:
                    System.out.println("Input Angka  1/2/3/4/5/6!");
                    break;
            }

            // perulangan while
            while (TanyaBalik) {
                System.out.print("\nKe menu utama [yes/no]? ");
                pertanyaan = input.nextLine();
                // percabangan if else if
                if (pertanyaan.equalsIgnoreCase("no")) // method string
                {
                    MenuKembali = false;
                    TanyaBalik = false;
                } else if (pertanyaan.equalsIgnoreCase("yes")) // method string
                {
                    MenuKembali = true;
                    TanyaBalik = false;
                } else {
                    System.out.println("Input 'yes' atau 'no'");
                }
            }
        }
        System.out.println("\n\n\t\tSelesai\n");
    }
}