import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Login
            boolean loginSuccess = false;
            do {
                System.out.println("\n+-------------------------------------+");
                System.out.print("Username : ");
                String username = scanner.nextLine();
                System.out.print("Password : ");
                String password = scanner.nextLine();

                // Captcha generator
                Random rand = new Random();
                int captcha = rand.nextInt(9000) + 1000;
                System.out.println("Captcha : " + captcha);
                System.out.print("Masukkan Captcha: ");
                int inputCaptcha = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Validasi login
                if (username.equals("admin") && password.equals("1234") && inputCaptcha == captcha) {
                    loginSuccess = true;
                    System.out.println("Login berhasil!");
                } else {
                    System.out.println("Login gagal! Silakan coba lagi.");
                }
            } while (!loginSuccess);

            // Input transaksi
            System.out.println("\nSelamat Datang di Supermarket Zhahraa!");
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = scanner.nextDouble();
            if (hargaBarang <= 0) {
                throw new IllegalArgumentException("Harga barang harus lebih dari 0.");
            }

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = scanner.nextInt();
            if (jumlahBeli <= 0) {
                throw new IllegalArgumentException("Jumlah beli harus lebih dari 0.");
            }

            scanner.nextLine(); // Consume newline
            System.out.print("Nama Kasir: ");
            String namaKasir = scanner.nextLine();

            // Membuat objek Transaksi
            Transaksi transaksi = new Transaksi(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);

            // Menampilkan hasil
            System.out.println("\n===== Detail Transaksi =====");
            transaksi.tampilkanTransaksi();
            System.out.println("Kasir: " + namaKasir);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
