public class Dosen extends Elemen {

    private int jumlahHariKerja;
    int jamSibuk;

    public Dosen(String nama,int jumlahHariKerja){
        super(nama);
        jamSibuk = jumlahHariKerja *8;
        
    }

    
    @Override
    // Menggunakan method dari kelas induk abstrak
    public void send(){
        System.out.println(this.nama+ " adalah seorang dosen dengan jam sibuk "+getjamSibuk());
    }

    @Override
    // Menggunakan method dari kelas induk abstrak
    public int getjamSibuk(){
        return jamSibuk;
        
    }

    public int jumlahHariKerja(){
        return jumlahHariKerja;
    }
}
