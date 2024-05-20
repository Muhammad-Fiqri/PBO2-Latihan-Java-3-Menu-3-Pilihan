/*
Author: Muhammad Fiqri
Kelas: 2IA10
Github: https://github.com/Muhammad-Fiqri
 */
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;

public class MenuProgram {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.tampilkanMenu();
    }
}

class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void tampilkanMenu() {
        int pilihan = -1;

        while (pilihan != 0) {
            System.out.println("=== MENU ===");
            System.out.println("1. Simpan Text File");
            System.out.println("2. Hapus Text File");
            System.out.println("3. Baca Text File");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan karakter baru (\n) setelah membaca nomor

            prosesPilihanMenu(pilihan);
        }

        System.out.println("Terima kasih telah menggunakan program ini!");
    }

    private void prosesPilihanMenu(int pilihan) {
        switch (pilihan) {
            case 1:
                System.out.println("Anda Memilih Pilihan Simpan Text File");

                System.out.println("Masukkan Nama Text File (Dengan Extension .txt): ");
                String fileName1 = scanner.nextLine();
                System.out.println("Masukkan Isi Text Yang Ingin Di Simpan: ");
                String text = scanner.nextLine();
                try {
                    FileWriter writer = new FileWriter(fileName1);
                    writer.write(text);
                    writer.close();
                    System.out.println("Text Berhasil Tersimpan Di " + fileName1);
                  } catch (IOException e) {
                    System.err.println("Menyimpan File Error: " + e.getMessage());
                  }
                break;
            case 2:
                System.out.println("Anda memilih pilihan Hapus Text File");

                System.out.println("Masukkan Nama Text File (Dengan Extension .txt) Yang Ingin Di Hapus: ");
                String fileName2 = scanner.nextLine();

                File file = new File(fileName2);

                if (file.exists()) {
                    if (file.delete()) {
                        System.out.println("File Berhasil Di Hapus.");
                    } else {
                        System.err.println("Error Menghapus File.");
                    }
                } else {
                    System.err.println("File Tidak Di Temukan.");
                }
                break;
            case 3:
                System.out.println("Anda memilih pilihan Edit Text File");

                System.out.println("Masukkan Nama Text File (Dengan Extension .txt) Yang Ingin Di Tampilkan: ");
                String fileName3 = scanner.nextLine();
            
                try (BufferedReader reader = new BufferedReader(new FileReader(fileName3))) {
                  String line;
                  while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                  }
                  System.out.println("Akhir Dari File.");
                } catch (IOException e) {
                  System.err.println("Error Membaca File: " + e.getMessage());
                }
                break;
            case 0:
                System.out.println("Keluar dari program...");
                break;
            default:
                System.out.println("Pilihan tidak valid");
        }
    }
}
