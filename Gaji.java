public class Gaji extends Pegawai {

    private double salary;

    public Gaji(String name, String address, int number, double salary) {
        super(name, address, number);
        setSalary(salary);
    }

    public void mailCheck() {
        System.out.println("Memeriksa Kelas Gaji dalam Surat ");
        System.out.println("Surat Tertuju Untuk " + getName() + "dengan gaji " + salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        if (newSalary >= 0.0) {
            salary = newSalary;
        }
    }

    public double computerPay() {
        System.out.println("Menghitung Pembayaran Gaji Untuk " + getName());
        return salary / 52;
    }

}
