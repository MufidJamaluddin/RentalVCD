/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.oop.tugas2_161511019_MufidJamaluddin;

import java.io.Serializable;

interface DataMusik
{
    //-----------=-- JUDUL -------------------//
    /**
     * Mendapatkan Judul CdMusik
     * @return 
     */
    public String getJudul();
    
    /**
     * Memasukkan Judul CdMusik
     * @param judul 
     */
    public void setJudul(String judul);
    
    //------------- PENYANYI ----------------//
    /**
     * Mendapatkan Nama Penyanyi
     * @return 
     */
    public String getPenyanyi();
    
    /**
     * Memasukkan Nama Penyanyi
     * @param penyanyi 
     */
    public void setPenyanyi(String penyanyi);
    
    //-------------- PRODUSER --------------//
    /**
     * Mendapatkan Nama Produser
     * @return 
     */
    public String getProduser();
    
    /**
     * Memasukkan Nama Produser
     * @param produser 
     */
    public void setProduser(String produser);
    
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
    
    //------------ TOP HITS ----------------//
    /**
     * Mendapatkan Top Hits Lagu
     * @return 
     */
    public String getTopHits();
    
    /**
     * Memasukkan Top Hits Lagu
     * @param topHits 
     */
    public void setTopHits(String topHits);
    
    //------------- KATEGORI ---------------//
    /**
     * Kategori CdMusik
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
public class CdMusik extends DaftarCd implements DataMusik, Serializable
{
    /**
     *  Atribut CdMusik
     *  yg tidak ada di SuperClass DaftarCd
     */
    /**
     * @serial 
     */
    private String penyanyi;
    /**
     * @serial 
     */
    private String produser;
    /**
     * @serial
     */
    private String topHits;
    /**
     * @serial
     */
    private Kategori kategoriMusik;
    /**
     *  untuk serialisasi dan deserialisasi
     */
    private static final long serialVersionUID = -1892561327013038124L;
    /**
     *  Kategori Musik
     *  
     */
    public enum Kategori
    {
        C("Classic"), 
        J("Jazz"), 
        P("Pop"), 
        R("Rock"),
        O("Other");
        
        private final String deskipsi;
        
        /**
         * Konstruktor enum kategori
         * @param deskripsi
         * @param alias 
         */
        private Kategori(String deskripsi)
        {
            this.deskipsi = deskripsi;
        }
        /**
         * Mengembalikan deskripsi enum
         * @return 
         */
        protected String getDeskripsi()
        {
            return this.deskipsi;
        }
        /**
         * Menampilkan deskripsi enum
         */
        public void showDeskripsi()
        {
            System.out.println(String.format("%s : %s", this, this.getDeskripsi() ));
        }
        
    }
    
    /**
     * Konstruktor Kosong
     * Class CDMusik
     */
    public CdMusik()
    {
        
    }
    
    /**
     * Konstruktor CDMusik
     * @param judul
     * @param stok 
     */
    public CdMusik(String judul, int stok)
    {
        super.setJudul(judul);
        super.setStok(stok);
    }

    /**
     * @return the topHits
     */
    @Override
    public String getTopHits() {
        return topHits;
    }

    /**
     * @param topHits the topHits to set
     */
    @Override
    public void setTopHits(String topHits) {
        this.topHits = topHits;
    }

    /**
     * @return the penyanyi
     */
    @Override
    public String getPenyanyi() {
        return penyanyi;
    }

    /**
     * @param penyanyi the penyanyi to set
     */
    @Override
    public void setPenyanyi(String penyanyi) {
        this.penyanyi = penyanyi;
    }

    /**
     * @return the produser
     */
    @Override
    public String getProduser() {
        return produser;
    }

    /**
     * @param produser the produser to set
     */
    @Override
    public void setProduser(String produser) {
        this.produser = produser;
    }
    
    /**
     *
     * @param kategoriStr
     */
    @Override
    public void setKategori(String kategoriStr)
    {
        this.kategoriMusik = Kategori.valueOf(kategoriStr);
    }
    
    /**
     *  Menampilkan Seluruh Isi enum Kategori
     */
    @Override
    public void showKategori()
    {
        System.out.println("Daftar Kategori :");
        for(Kategori kat : Kategori.values() )
            kat.showDeskripsi();
    }
    
    /**
     * Menampilkan Seluruh isi enum Kategori
     */
    public void showLKategori()
    {
        for(Kategori kat : Kategori.values() )
            System.out.print(String.format(" %s", kat));
    }
    
    /**
     *  Mendapatkan isi enum kategori
     *  @return 
     */
    public Kategori getAliasKategori()
    {
        return this.kategoriMusik;
    }
    
    /**
     * Mendapatkan deskripsi kategori
     * @return 
     */
    public String getDesKategori()
    {
        return this.kategoriMusik.getDeskripsi();
    }
}