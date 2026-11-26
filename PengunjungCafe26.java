public class PengunjungCafe26 {
    public static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
        System.out.println("Nomor meja: " + nomorMeja);
        System.out.println("Daftar nama Pengunjung: ");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    public static int hitungTotalBelanja(int... harga) {
        int total = 0; 
        for (int i = 0; i < harga.length; i++) {
            total += harga[i];
        }
        System.out.println(total);

        return total;
    }
    public static void main(String[] args) {
        // String[] tamu = {"Ali", "Budi", "Citra"};
        // daftarPengunjung(5, tamu);

        hitungTotalBelanja(20000);
        hitungTotalBelanja(30000, 80000, 50000);
        hitungTotalBelanja(65000,43000,10000);
    }
}