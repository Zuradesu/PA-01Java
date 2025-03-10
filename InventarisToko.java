import java.util.Scanner;

class Barang {
    String nama;
    int jumlahStok;
    double harga;

    // Constructor
    public Barang(String nama, int jumlahStok, double harga) {
        this.nama = nama;
        this.jumlahStok = jumlahStok;
        this.harga = harga;
    }

    // Method untuk menampilkan informasi barang
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama + ", Jumlah Stok: " + jumlahStok + ", Harga: " + harga);
    }
}

public class InventarisToko {
    static Barang[] inventaris = new Barang[10];

    // Method untuk menampilkan inventaris
    public static void tampilkanInventaris() {
        System.out.println("\nInventaris Toko:");
        for (int i = 0; i < inventaris.length; i++) {
            if (inventaris[i] != null) {
                System.out.print((i + 1) + ". ");
                inventaris[i].tampilkanInfo();
            }
        }
    }

    // Method untuk mengupdate stok barang berdasarkan nama
    public static void updateStok(String nama, int jumlahBaru) {
        for (Barang barang : inventaris) {
            if (barang != null && barang.nama.equalsIgnoreCase(nama)) {
                barang.jumlahStok = jumlahBaru;
                System.out.println("Stok berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan!");
    }

    // Method untuk mencari barang berdasarkan nama
    public static void cariBarang(String nama) {
        for (Barang barang : inventaris) {
            if (barang != null && barang.nama.equalsIgnoreCase(nama)) {
                System.out.println("\nHasil pencarian:");
                barang.tampilkanInfo();
                return;
            }
        }
        System.out.println("Barang tidak ditemukan!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Menambahkan barang ke dalam array
        inventaris[0] = new Barang("Pensil", 50, 200.0);
        inventaris[1] = new Barang("Buku", 30, 15000.0);
        inventaris[2] = new Barang("Penghapus", 20, 500.0);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan Inventaris");
            System.out.println("2. Cari Barang");
            System.out.println("3. Tambah Barang");
            System.out.println("4. Update Stok Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    tampilkanInventaris();
                    break;
                case 2:
                    System.out.print("Masukkan nama barang yang dicari: ");
                    String namaCari = scanner.nextLine();
                    cariBarang(namaCari);
                    break;
                case 3:
                    System.out.print("Masukkan nama barang baru: ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan jumlah stok: ");
                    int stokBaru = scanner.nextInt();
                    System.out.print("Masukkan harga: ");
                    double hargaBaru = scanner.nextDouble();
                    scanner.nextLine(); // Konsumsi newline
                    for (int i = 0; i < inventaris.length; i++) {
                        if (inventaris[i] == null) {
                            inventaris[i] = new Barang(namaBaru, stokBaru, hargaBaru);
                            System.out.println("Barang berhasil ditambahkan!");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Masukkan nama barang yang ingin diupdate: ");
                    String namaUpdate = scanner.nextLine();
                    System.out.print("Masukkan jumlah stok baru: ");
                    int jumlahUpdate = scanner.nextInt();
                    scanner.nextLine(); // Konsumsi newline
                    updateStok(namaUpdate, jumlahUpdate);
                    break;
                case 5:
                    System.out.println("Program ditutup.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
