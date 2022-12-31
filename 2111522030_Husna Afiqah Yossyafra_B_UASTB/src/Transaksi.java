//Membuat class transaski dengan mewarisi kelas barang dan menggunakan interface diskon
public class Transaksi extends Barang implements Diskon {
	
    //Mmebuat properti
	public int harga;
    public int diskon;

    //Membuat constructor
    public Transaksi(Integer harga,Integer diskon){
        this.harga = harga;
        this.diskon = diskon;
    }

    //Polymorphisme overriding
    @Override
    public  int harga(Integer harga){
        //Menghitung harga dengan diskon
        this.harga = harga;
        if(harga > 100000 ){
            this.harga = (int)((double)(this.harga*0.80));
        }else if(harga > 50000){
            this.harga = (int)((double)(this.harga*0.85));
        }else if(harga > 25000){
            this.harga = (int)((double)(this.harga*0.90));
        }else{
            this.harga = (int)((double)(this.harga*0.95));
        }
        return this.harga;
    }

    @Override
    public  int Discount(Integer diskon){
        //Menghitung diskon
        this.harga = diskon;
        if(harga > 100000 ){
            this.harga = (int)((double)(this.harga*0.20));
        }else if(harga > 50000){
            this.harga = (int)((double)(this.harga*0.15));
        }else if(harga > 25000){
            this.harga = (int)((double)(this.harga*0.10));
        }else{
            this.harga = (int)((double)(this.harga*0.05));
        }
        return this.harga;
	}
	
}
