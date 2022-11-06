
public class Mahasiswa extends Elemen {
   private int sks;
   int jamSibuk;


   public Mahasiswa(String nama, int sks) {
        super(nama);
        jamSibuk = sks*3;
        
    }
 
    @Override
    // Menggunakan method dari parent class(Elemen) abstrak
   public void send(){
      System.out.println(this.nama+" adalah seorang mahasiswa dengan jam sibuk "+getjamSibuk());
    }

    @Override
    // Menggunakan method dari kelas induk abstrak
     public int getjamSibuk(){
        return jamSibuk;
     }

     public int sks(){
      return sks;
     }
   
    
}
