/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.oop.tugas2_161511019_MufidJamaluddin;

import java.io.Serializable;

interface DataFilm
{
    //-----------=-- JUDUL -------------------//
    /**
     * Mendapatkan Judul CdFilm
     * @return 
     */
    public String getJudul();
    
    /**
     * Memasukkan Judul CdFilm
     * @param judul 
     */
    public void setJudul(String judul);
    
    //------------- PEMAIN ----------------//
    /**
     * Mendapatkan Nama Pemain
     * @return 
     */
    public String getPemain();
    
    /**
     * Memasukkan Nama Pemain
     * @param penyanyi 
     */
    public void setPemain(String pemain);
    
    //-------------- SUTRADARA --------------//
    /**
     * Mendapatkan Nama Sutradara
     * @return 
     */
    public String getSutradara();
    
    /**
     * Memasukkan Nama Sutradara
     * @param produser 
     */
    public void setSutradara(String produser);
    
    //------------- PUBLISHER --------------//
    /**
     * Publisher
     */
    public String getPublisher();
    /**
     * 
     * @param publisher 
     */
    public void setPublisher(String publisher);
    
    //------------- KATEGORI ---------------//
    /**
     * Kategori Musik
     */
    public enum Kategori{
        
    }
    
    /**
     * Menampilkan Kategori
     */
    public void showKategori();
    
    //---------------- STOK --------------//
    /**
     * Mendapatkan Jml Stok
     * @return 
     */
    public int getStok();
    
    /**
     * Memasukkan Jml Stok
     * @param stok 
     */
    public void setStok(int stok);
    
    //-------------------------------------//
}

/**
 *
 * @author mufidjamaluddin
 */
public class CdFilm extends DaftarCd implements DataFilm, Serializable
{    
    /**
     * @serial 
     */
    private String pemain;
    /**
     * @serial 
     */
    private String sutradara;
    /**
     * @serial 
     */
    private kategori kategoriFilm;
    
    private static final long serialVersionUID = -1892561327013038124L;
    /**
     *  Kategori Film
     *
     */
    public enum kategori
    {
        SU("Semua Umur"), 
        D("Dewasa"), 
        R("Remaja"), 
        A("Anak anak");
        
        private final String deskipsi;
        
        /**
         * Konstruktor enum kategori
         * @param deskripsi
         * @param alias 
         */
        private kategori(String deskripsi)
        {
            this.deskipsi = deskripsi;
        }
        
        /**
         * Method enum untuk mendapatkan deskipsi
         * @return 
         */
        protected String getDeskripsi()
        {
            return this.deskipsi;
        }
        /**
         * Method enum untuk menampilkan deskripsi
         */
        public void showDeskripsi()
        {
            System.out.println(String.format("%s : %s", this, this.getDeskripsi() ));
        }
        
    }
    
    /**
     * Konstruktor
     */
    public CdFilm()
    {
    
    }
    /**
     * Konstruktor
     * @param judul to set
     * @param stok to set
     */
    public CdFilm(String judul, int stok)
    {
        super.setJudul(judul);
        super.setStok(stok);
    }

    /**
     * @return the pemain
     */
    @Override
    public String getPemain() {
        return pemain;
    }

    /**
     * @param pemain the pemain to set
     */
    @Override
    public void setPemain(String pemain) {
        this.pemain = pemain;
    }

    /**
     * @return the sutradara
     */
    @Override
    public String getSutradara() {
        return sutradara;
    }

    /**
     * @param sutradara the sutradara to set
     */
    @Override
    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }

    /**
     *
     * @param kategoriStr
     */
    @Override
    public void setKategori(String kategoriStr)
    {
        this.kategoriFilm = kategori.valueOf(kategoriStr);
    }
    /**
     * Mendapatkan alias kategori
     * @return 
     */
    public kategori getAliasKategori()
    {
        return this.kategoriFilm;
    }
    /**
     * Mendapatkan deskripsi kategori
     * @return 
     */
    public String getDesKategori()
    {
        return this.kategoriFilm.getDeskripsi();
    }
    
}