/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.oop.tugas2_161511019_MufidJamaluddin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

interface DataAccess
{
    /**
     * Method untuk entry data ke list
     * Dapat lebih dari satu CD
     */
    public void entryData();   
    
    /**
     * Method untuk entry data satu CD
     * Mengembalikan boolean nilai disimpan di ArrayList atau tidak
     * 
     * @return 
     */
    public boolean entryDataCD();
    
    /**
     * Method untuk menampilkan semua list data CD
     */
    public void showData();
    
    /**
     * Method untuk mengambil data dari file
     */
    public void getDataFromFile();
    
    /**
     * Methoduntuk menyimpan data ke file
     */
    public void writeDataToFile();
}

/**
 *
 * @author mufidjamaluddin
 */
public class DataCdAccess implements DataAccess
{    
    /**
     *  Atribut DataCdAccess
     * 
     *  Objek input hanya dapat diakses oleh objek ini dan turunannya (Protected)
     *  supaya objek yang bukan turunannya tidak bisa input
     * 
     *  Objek ArrayList CdFilm dan CdMusik hanya dapat diakses melalui getter
     *  dan setter
     */
    protected Scanner input;
    private String filePath;
    
    /**
     *  Konstruktor
     */
    public DataCdAccess()
    {
        this.input = null;
    }
    
    /**
     *  Method untuk instansiasi input
     */
    public void instansiasiInput()
    {
        this.input = new Scanner(System.in);
    }
    
    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    /**
     * Method untuk menentukan input lagi atau tidak
     * dengan string Y/N (Representasi Yes or No)
     * 
     * @param isEntrySuccess
     * @return 
     */
    public String entryLagi(boolean isEntrySuccess)
    {
        String entryLg;
        
        if(isEntrySuccess)
        {
            System.out.println("Input Lagi? (y/n)\t: ");
            entryLg = this.input.next();
        }
        else
        {
            System.out.println("Data Film Gagal Dientrykan ke List, Silakan Coba Lagi");
            entryLg = "y";
        }
        
        return entryLg;
    }
    
    /**
     * 
     *  Obj Data Access harus memiliki method untuk Entry Data banyak CD

     *  Method untuk entry data ke list
     */
    @Override
    public void entryData()
    {
        /**
         * pilihan entryLagi
         * dan logika apakah entri data sukses
         */
        String entryLg;
        boolean isEntrySuccess;
        
        /**
         * Loop
         * Jika user memilih entry lagi
         */
        do{
            /**
             * Entry data satu CD
             */
            isEntrySuccess = this.entryDataCD();
            /**
             * Jika entry sukses, maka user dapat memilih N
             */
            entryLg = this.entryLagi(isEntrySuccess);
            
        }
        while("Y".equals(entryLg) || "y".equals(entryLg));
        
    }
    
    /**
     * Obj Data Access harus memiliki method untuk Entry Data satu CD
     * @return 
     */
    @Override
    public boolean entryDataCD() 
    {
        // di override di subclass
        return false;
    }
    
    /**
     * Obj Data Access harus memiliki method untuk menampilkan data
     */
    @Override
    public void showData() 
    {
        // di override di subclass
    }
    
    /**
     * 
     * @param ois 
     */
    public void readFile(ObjectInputStream ois)
    {
        /**
         * Mengambil ArrayList dari File
         * 
         * di Override di Sub-Class
         */
    }
    
    /**
     * mengambil data dari file
     */
    @Override
    public void getDataFromFile()
    {   
        /**
         * Deklarasi
         */
        FileInputStream fis;
        ObjectInputStream ois;
        
        System.out.println("kk");
        /**
         * try-catch
         */
        try 
        {
            /**
             * Instansiasi
             * File dan Objek Input
             */
            fis = new FileInputStream(this.getFilePath());
            ois = new ObjectInputStream(fis);
            /**
             * Read File
             */
            this.readFile(ois);
            /**
             * Menutup Objek Input Stream
             */
            ois.close();
        } 
        catch (FileNotFoundException fileNotFound) 
        {
            /**
             * Jika file tidak ditemukan, tampilkan pesan
             */
            System.out.println(String.format("File %s Not Found\nPesan : %s", this.getFilePath(),fileNotFound.getMessage()));
        }
        catch (IOException ex) 
        {
            /**
             * Jika masalah di IO dan ClassNotFound
             * tampilkan pesan
             */
            System.out.println(String.format("Masalah File IO dan ClassNotFound\nPesan : %s",ex.getMessage()));
        }
            
    }
    
    public void writeFile(ObjectOutputStream oos)
    {
        /**
         * Menyimpan Objek ArrayList ke File
         * di Override di Sub-Class
         */
    }

    /**
     * menyimpan data ke file
     */
    @Override
    public void writeDataToFile()
    {
        /**
         * Deklarasi
         */
        FileOutputStream fos;
        ObjectOutputStream oos;
        
        try 
        {
            /**
             * Instansiasi
             * File dan Objek Input
             */
            fos = new FileOutputStream(this.getFilePath(),true);
            oos = new ObjectOutputStream(fos);
            /**
             * Menympan Objek ArrayList ke File
             */
            this.writeFile(oos);
            /**
             * Menutup objek output
             */
            oos.close();
        }    
        catch (FileNotFoundException fileNotFound) 
        {
            /**
             * Jika file tidak ditemukan, tampilkan pesan
             */
            System.out.println(String.format("File %s Not Found\nPesan : %s", this.getFilePath(),fileNotFound.getMessage()));
        }
        catch (IOException masalahIO) 
        {
            /**
             * Jika masalah di IO
             * tampilkan pesan
             */
            System.out.println(String.format("Masalah IO File\nPesan : %s",masalahIO.getMessage()));
        }
    }
    
    
    /**
     * Program utama
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        /**
         *  Deklarasi
         */
        Scanner input;
        int pilih;
        DataFilmAccess objFilmAccess;
        DataMusikAccess objMusikAccess;
        
        /**
         *  Instansiasi
         */
        objFilmAccess = new DataFilmAccess();
        objMusikAccess = new DataMusikAccess();
        input = new Scanner(System.in);
        
        /**
         *  Loop
         *  Loop berakhir jika user 
         *  input pilihan keluar
         */
        do
        {
            /**
             *  Memilih pilihan menu
             */
            System.out.print("\t------------ MENU ----------------\n\t- Pilih:\n\t- 1. Entry Data CD Film\n\t- 2. Entry Data CD Musik\n\t- 3. Tampilkan Data CD Film\n\t- 4. Tampilkan Data CD Musik\n\t- 5. Keluar\n\n\t- << Pilih (1, 2, 3, 4, atau 5) : ");
            pilih = input.nextInt();
            
            /**
             *  Menyajikan aksi dari menu yg dipilih
             */
            switch(pilih)
            {
                case 1:                    
                    System.out.println("----------- ENTRY DATA CD FILM ------------");
                    /**
                     *  Entry Data CD Film
                     *  Entry berakhir jika user memilih tidak entry lagi
                     */
                    objFilmAccess.entryData();
                    /**
                     *  Menyimpan Data Hasil Entry (ArrayList) ke File 
                     */
                    objFilmAccess.writeDataToFile();
                    break;
                case 2:
                    System.out.println("----------- ENTRY DATA CD MUSIK ------------");
                    /**
                     *  Entry Data CD Film
                     *  Entry berakhir jika user memilih tidak entry lagi
                     */
                    objMusikAccess.entryData();
                    /**
                     *  Menyimpan Data Hasil Entry (ArrayList) ke File 
                     */
                    objMusikAccess.writeDataToFile();
                    break;
                case 3:
                    System.out.println("----------- DAFTAR DATA CD FILM ------------");
                    /**
                     *  Mengambil Data dari File
                     */
                    objFilmAccess.getDataFromFile();
                    /**
                     *  Menampilkan Data List 
                     */
                    objFilmAccess.showData();
                    break;
                case 4:
                    System.out.println("----------- DAFTAR DATA CD MUSIK ------------");
                    /**
                     *  Mengambil Data dari File 
                     */
                            objMusikAccess.getDataFromFile();
                    /**
                     *  Menampilkan Data dari File 
                     */
                    objMusikAccess.showData();
                    break;
                case 5:
                    /**
                     *  Pilihan keluar
                     */
                    break;
                default:
                    /**
                     *  Jika user salah input
                     */
                    System.out.println("\tAnda salah input, silakan coba lagi!\n");
                    break;
            }
            
        } 
        while(pilih != 5);
        /**
         *  Keluar
         */
    }

    
}