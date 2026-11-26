import java.util.Scanner;
public class Kafe26 {
    static Scanner sc = new Scanner(System.in);
    public static void Menu (String namaPelanggan, String isMember, int jamKunjung) {

        // if (isMember.equalsIgnoreCase("y")) {
        //     System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        // }
        if (jamKunjung == 14 || jamKunjung == 16) {
            System.out.println("Happy Hour! Diskon 20% untuk semua minuman");
        }

        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("==========================");
        System.out.println("Silahkan pilih menu yang Anda inginkan");
    }

    // public static void ubahNama(String nama) {
    //     nama = "Tamu";
    //     System.out.println("Di dalam fungsi: " + nama);
    // }
    // public static void main(String[] args) {
    //     String nama = "Andi";
    //     ubahNama(nama);
    //     System.out.println("Di main: " + nama);
    //     Menu ("Andi", "y", 15);
    // }

    public static int hitungTotalHarga26(int pilihanMenu, int banyakItem) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }

        public static int totalKeseluruhan(int pilihanMenu, int banyakItem) {
        int totalKeseluruhan = 0;

        while (true) {
            System.out.print("\nMasukkan nomor yang ingin Anda pesan (0 untuk selesai): ");
            pilihanMenu = sc.nextInt();

            if (pilihanMenu == 0) {
                break;
            }

            if (pilihanMenu < 1 || pilihanMenu > 6) {
                System.out.print("Menu tidak tersedia");
                continue;
            }

            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            banyakItem = sc.nextInt();

            int subtotal = hitungTotalHarga26(pilihanMenu, banyakItem);
            totalKeseluruhan += subtotal;
            System.out.print("Subtotal item ini: Rp" + subtotal);

        }

        System.out.println("Total keseluruhan pesanan Anda: Rp" + totalKeseluruhan);
        return totalKeseluruhan;
    }
    
    public static int hitungDiskon(int totalHarga, String kodePromo, boolean isMember) {
            int diskonPromo = 0;
            int diskonMember = 0;

            if (kodePromo.equalsIgnoreCase("DISKON50")) {
                diskonPromo = totalHarga * 50 / 100;
            } else if (kodePromo.equalsIgnoreCase("DISKON30")) {
                diskonPromo = totalHarga * 30 / 100;
            }

            if (isMember) {
                diskonMember = totalHarga * 10 / 100;
            } 

            return diskonPromo + diskonMember;

            }
    public static void main(String[] args) {
        Menu("Andi", "y", 15);

        int totalHarga = totalKeseluruhan(0, 0);
        
        sc.nextLine();
        System.out.print("\nMasukkan kode promo:" );
        String kodePromo = sc.nextLine();
        
        System.out.print("Apakah anda pelanggan member? (true/false): ");
        boolean isMember = sc.nextBoolean();

        if (kodePromo.equalsIgnoreCase("DISKON50")) {
            System.out.println("Selamat anda mendapatkan diskon 50%");
        } else if (kodePromo.equalsIgnoreCase("DISKON30")) {
            System.out.println("Selamat anda mendapatkan diskon 30%");
        } else {
            System.out.println("Kode promo invalid");
        }

        if (isMember) {
            System.out.println("Selamat anda mendapatkan tambahan diskon 10%");
        }

        int besarDiskon = hitungDiskon(totalHarga, kodePromo, isMember);
        double totalBayar = totalHarga - besarDiskon;

        besarDiskon = hitungDiskon(totalHarga, kodePromo, isMember);
        totalBayar = totalHarga - besarDiskon;

        System.out.println("Total harga: Rp" + totalHarga);
        System.out.println("Besar diskon: Rp" + besarDiskon);
        System.out.println("Total yang harus dibayar: Rp" + totalBayar);
    }
}
