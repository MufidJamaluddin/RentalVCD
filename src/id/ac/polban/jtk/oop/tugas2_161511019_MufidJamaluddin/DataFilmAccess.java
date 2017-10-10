/**
 *  Class DataFilmAccess memiliki tujuan untuk
 *  akses data input dan output daftar film
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
public class DataFilmAccess extends DataCdAccess implements DataAccess
{

    private List<CdFilm> dataFilm;
    /**
     *  Konstruktor
     *  Instansiasi ArrayList CdFilm
     *  Dipakai jika DataMusikAccess ke objek ArrayList baru
     */
    public DataFilmAccess()
    {
        super();
        this.dataFilm = new ArrayList();
        super.setFilePath("D://filetugas/DataFilmFile.ser");
    }
    
    /**
     *  Konstruktor
     *  Dipakai untuk akses ke ArrayList yg telah ditentukan
     *  @param daftarFilm
     */
    public DataFilmAccess(List<CdFilm> daftarFilm)
    {
        super();
        this.dataFilm = daftarFilm;
        super.setFilePath("D://filetugas/DataFilmFile.ser");
    }
    
    
    /**
     * @return the dataFilm
     */
    protected List<CdFilm> getDataFilm() {
        return dataFilm;
    }

    /**
     * @param dataFilm the dataFilm to set
     */
    protected void setDataFilm(List<CdFilm> dataFilm) {
        this.dataFilm = dataFilm;
    }
    
    /**
     * Method untuk Entry Data CdFilm :
     * Judul, Pemain, Sutradara, Publisher, Kategori dan Jumlah Stok
     * Mengembalikan Boolean Sukses Tidaknya Entry Data
     * 
     * @return 
     */
    @Override
    public boolean entryDataCD()
    {
        /**
         * Objek CdFilm yang Akan Diisi Datanya
         */
        CdFilm objFilm;
        /**
         * Logika Tentang Keberhasilan Entry Data ke List
         */
        boolean isEntry;
        /**
         * Penampung Nilai String dan Integer
         */ 
        String tempStr;
        int tempInt;
        /**
         * Instansiasi
         */
        objFilm = new CdFilm();
        super.instansiasiInput();
        
        /**
         * Inpt Judul Film
         */
        System.out.print("\nJudul\t\t: ");
        tempStr = super.input.nextLine();
        objFilm.setJudul(tempStr);
        
        /**
         * Input Pemain Film
         */
        System.out.print("Pemain\t\t: ");
        tempStr = super.input.nextLine();
        objFilm.setPemain(tempStr);
        
        /**
         * Input Sutradara
         */
        System.out.print("Sutradara\t: ");
        tempStr = super.input.nextLine();
        objFilm.setSutradara(tempStr);
        
        /**
         * Input Publisher
         */
        System.out.print("Publisher\t: ");
        tempStr = super.input.nextLine();
        objFilm.setPublisher(tempStr);
        
        /**
         *  Menampilkan List Kategori
         */
        objFilm.showKategori();
        
        /**
         * Input Inisial Kategori
         * Wajib huruf besar
         */
        System.out.println("Kategori (SU, D, R, A) (Wajib huruf besar) : ");
        tempStr = super.input.next();
        objFilm.setKategori(tempStr);
        
        /**
         * Input Jml Stok
         */
        System.out.print("Stok\t\t: ");
        tempInt = super.input.nextInt();
        objFilm.setStok(tempInt);
        
        /**
         * Menambahkan Data yg Diinputkan
         * ke ArrayList DataFilm
         */
        isEntry = this.getDataFilm().add(objFilm);
        
        /**
         * Mengembalikan boolean
         * sukses tidaknya entry data ke list
         */
        return isEntry;
    }
    
    /**
     * Method untuk menampilkan isi ArrayList dataFilm 
     */
    @Override
    public void showData()
    {
        
        /**
         * Menampilkan Semua Data
         * dalam ArrayList
         */
        this.getDataFilm().forEach((CdFilm objFilm) -> {
            System.out.println(String.format("Judul\t\t: %s\nPemain\t\t: %s\nSutradara\t: %s\nPublisher\t: %s\nKategori\t: %s : %s\nStok\t\t: %s\n",objFilm.getJudul(),objFilm.getPemain(),objFilm.getSutradara(),objFilm.getPublisher(),objFilm.getAliasKategori(),objFilm.getDesKategori(),objFilm.getStok() ));
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
            List<CdFilm> daftarFilm;
            /**
             * Mengambil ArrayList dari File
             */
            daftarFilm = (List<CdFilm>) ois.readObject();
            this.setDataFilm(daftarFilm);    
        } 
        catch (IOException | ClassNotFoundException ex) 
        {
            /**
             * Jika masalah di IO dan ClassNotFound
             * tampilkan pesan
             */
            System.out.println(String.format("Masalah File IO dan ClassNotFound\nPesan : %s",ex.getMessage()));
        }
    }
    
    /**
     *
     * @param oos
     */
    @Override
    public void writeFile(ObjectOutputStream oos)
    {
        try 
        {
            /**
             * Menyimpan Objek ArrayList ke File
             */
            oos.writeObject(this.getDataFilm());
        } 
        catch (IOException ex) 
        {
            /**
             * Jika masalah di IO
             * tampilkan pesan
             */
            System.out.println(String.format("Masalah IO File\nPesan : %s",ex.getMessage()));
        }
    }

}