public class Simulator {
    public static void main(String[] args) {
        Elemen a = new Asdos ("Fairuzikum" ,24, 1); //Downcasting
        Asdos h = (Asdos) a;

        Dosen b = new Dosen("Raja OP Damanik",5); //polymorphism

        Elemen c = new Asdos ("Angel-chan",21, 1); //upcasting

        Mahasiswa d = new Mahasiswa ("Firman", 20); //polymorphism
        
        Elemen e = new Mahasiswa ("Nid to pass this sem", 23); //Downcasting
        Mahasiswa g = (Mahasiswa) e;

        Elemen f = (Elemen) new Dosen("Nivotko",3); //upcasting
        
        
        h.send();
        b.send();
        c.send();
        d.send();
        g.send();
        f.send();

        int total = h.jamSibuk+b.getjamSibuk()+c.getjamSibuk()+d.getjamSibuk()+((Mahasiswa) e).getjamSibuk()+((Dosen) f).getjamSibuk();
        System.out.println("Total jam sibuk elemen Fasilkom adalah "+total);
}
}
