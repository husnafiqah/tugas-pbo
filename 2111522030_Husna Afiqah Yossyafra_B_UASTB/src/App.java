
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
     
        try{
            //Membuat objek
            Scanner input = new Scanner(System.in);
            Barang connection = new Barang();

            //koneksi ke database
            connection.getKoneksi();
            boolean lanjut = true;

            System.out.println();
            // pilihan menu pemesanan
            while(lanjut){ 
                    switch(Menu.menuPenjualan()){
        
                        case 1:
                            connection.tampilData();
                            break;
        
                        case 2:
                            connection.pesan();
                            break;
                        case 3: 
                            connection.updatePesan();
                            break;
                        case 4:
                            connection.batalPesan();
                            break;
                        default:
                            System.out.println("pilihan tidak ada");

                        break;
        
                    }
                // lanjut program/tidak
                System.out.print("Apakah anda ingin pesan lagi ? (y/n)  ");
                String pilihan =  input.next();
                lanjut = pilihan.equalsIgnoreCase("y");
                if(!lanjut){
                    connection.tampilData();
                    connection.cariData();
                    System.out.println();
                    System.out.println("Pilih menu pembayaran");
                    Menu.pembayaran();
    
                    
                    System.out.println("TERIMA KASIH");
                }
             }
             input.close();
                  
        }catch (InputMismatchException e){
            e.printStackTrace();
        }
    
        
    }
       

}
       
        


