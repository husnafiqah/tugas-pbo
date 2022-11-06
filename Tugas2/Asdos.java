public class Asdos extends Mahasiswa{

    private int jamNgasdos;

   
    public Asdos(String nama, int sks, int jamNgasdos){
        super(nama, sks);
        jamSibuk = jamSibuk + jamNgasdos;
        
    }

    @Override
    // Menggunakan method dari kelas induk abstrak
    public int getjamSibuk(){
        return jamSibuk;
        
    }
    
    @Override
    // Menggunakan method dari kelas induk abstrak
    public void send(){
        System.out.println(this.nama+ " adalah seorang asdos dengan jam sibuk "+getjamSibuk());
    }

    public int jamNgasdos(){
        return jamNgasdos;
    }

    
}
