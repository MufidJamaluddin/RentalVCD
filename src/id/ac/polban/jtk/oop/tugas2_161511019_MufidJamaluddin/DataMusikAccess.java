/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.oop.tugas2_161511019_MufidJamaluddin;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mufidjamaluddin
 */
public class DataMusikAccess extends DataCdAccess implements DataAccess
{

    private List<CdMusik> dataMusik;
    /**
     *  Konstruktor
     *  Instansiasi ArrayList CdFilm
     *  Dipakai jika DataMusikAccess ke objek ArrayList baru
     */
    public DataMusikAccess()
    {
        super();
        super.setFilePath("D://filetugas/DataMusikFile.ser");
        this.getDataFromFile();
    }
    
    /**
     *  Konstruktor
     *  dipakai untuk akses ke ArrayList yang telah ditentukan
     *  @param daftarMusik
     */
    public DataMusikAccess(List<CdMusik> daftarMusik)
    {
        super();
        this.dataMusik = daftarMusik;
        super.setFilePath("D://filetugas/DataMusikFile.ser");
    }
    
    /**
     * @return the dataMusik
     */
    protected List<CdMusik> getDataMusik() {
        return dataMusik;
    }

    /**
     * @param dataMusik the dataMusik to set
     */
    protected void setDataMusik(List<CdMusik> dataMusik) {
        this.dataMusik = dataMusik;
    }
    
    
    /**
     * Method untuk Entry Data CdFilm :
     * Judul, Penyanyi, Produser, Publisher, Top Hits, Kategori, Stok
     * Mengembalikan Boolean Sukses Tidaknya Entry Data
     * 
     * @return 
     */
    @Override
    public boolean entryDataCD()
    {   
        /**
         *  Deklarasi
         */
        CdMusik objMusik;
        boolean isEntry;
        /**
         * Penampung String dan Integer
         */
        String tempStr;
        int tempInt;
        /**
         * Instansiasi
         */
        objMusik = new CdMusik(); 
        super.instansiasiInput();
        /**
         * Input Judul Musik
         */
        System.out.print("\nJudul\t\t: ");
        tempStr = super.input.nextLine();
        objMusik.setJudul(tempStr);
        /**
         * Input Penyanyi Musik
         */
        System.out.print("Penyanyi\t: ");
        tempStr = super.input.nextLine();
        objMusik.setPenyanyi(tempStr);
        /**
         * Input Produser
         */
        System.out.print("Produser\t: ");
        tempStr = super.input.nextLine();
        objMusik.setProduser(tempStr);
        /**
         * Input Publisher
         */
        System.out.print("Publisher\t: ");
        tempStr = super.input.nextLine();
        objMusik.setPublisher(tempStr);
        /**
         * Input Top Hits
         */
        System.out.print("Top Hits\t: ");
        tempStr = super.input.nextLine();
        objMusik.setTopHits(tempStr);
        /**
         * Tampilkan List Kategori
         */
        objMusik.showKategori();
        /**
         * Input Kategori berdasarkan Kategori yg ada
         * wajib huruf besar
         */
        System.out.print("Kategori (");
        objMusik.showLKategori();
        System.out.print(" ) (Wajib huruf besar) : ");
        tempStr = super.input.next();
        objMusik.setKategori(tempStr);
        /**
         * Input Stok
         */
        System.out.print("Stok\t\t: ");
        tempInt = super.input.nextInt();
        objMusik.setStok(tempInt);
        /**
         * Masukkan data yang telah diinputkan
         * ke dalam List
         * 
         * Mengembalikan boolean sukses tidaknya input
         */
        isEntry = this.getDataMusik().add(objMusik);
        /**
         * Kembalikan boolean sukses tidaknya input
         */
        return isEntry;    
    }
    
    /**
     * 
     */
    @Override
    public void showData()
    {
        /**
         * Menampilkan Semua isi ArrayList
         */
        this.getDataMusik().forEach((daftarMusik) -> {
            System.out.println(String.format("Judul\t\t: %s\nPenyanyi\t: %s\nProduser\t: %s\nPublisher\t: %s\nTop Hits\t: %s\nKategori\t: %s : %s\nStok\t\t: %d\n", daftarMusik.getJudul(), daftarMusik.getPenyanyi(), daftarMusik.getProduser(), daftarMusik.getPublisher(), daftarMusik.getTopHits(), daftarMusik.getAliasKategori(), daftarMusik.getDesKategori(), daftarMusik.getStok() ));
        });
        
    }
    
    /**
     * 
     * @param ois 
     */
    @Override
    public void readFile(ObjectInputStream ois)
    {
        try 
        {
            /**
             * Deklarasi
             */
            List<CdMusik> daftarMusik;
            /**
             * Mengambil ArrayList dari File
             */
            daftarMusik = (List<CdMusik>) ois.readObject();
            this.setDataMusik(daftarMusik);
            
            System.out.println(String.format("Sukses Mendapatkan Data dari File %s ",this.getFilePath()));
        } 
        catch (IOException | ClassNotFoundException ex) 
        {
            /**
             * Jika masalah di IO dan ClassNotFound
             * tampilkan pesan
             */
            System.out.println(String.format("Masalah IO dan ClassNotFound\nPesan : %s",ex.getMessage()));
        }
    }
    
    /**
     *
     * @param oos
     */
    @Override
    public void writeFile(ObjectOutputStream oos)
    {
        try {
            /**
             * Menyimpan Objek ArrayList ke File
             */
            oos.writeObject(this.getDataMusik());
            
            System.out.println(String.format("Data berhasil disimpan ke File %s ",this.getFilePath()));
        } 
        catch (IOException ex) 
        {
            /**
             * Jika masalah di IO
             * tampilkan pesan
             */
            System.out.println(String.format("Masalah IO\nPesan : %s",ex.getMessage()));
        }
    }

}