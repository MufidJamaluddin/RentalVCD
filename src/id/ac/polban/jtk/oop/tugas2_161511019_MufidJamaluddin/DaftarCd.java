/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.oop.tugas2_161511019_MufidJamaluddin;

import java.io.Serializable;

/**
 *
 * @author mufidjamaluddin
 */
public abstract class DaftarCd implements Serializable{
    /**
     * @serial 
     */
    private String judul;
    /**
     * @serial 
     */
    private String publisher;
    /**
     * @serial 
     */
    private int stok;
    /**
     * un
     */
    private static final long serialVersionUID = -1892561327013038124L;
    
    public DaftarCd()
    {

    }

    /**
     * @return the judul
     */
    public String getJudul() {
        return judul;
    }

    /**
     * @param judul the judul to set
     */
    public void setJudul(String judul) {
        this.judul = judul;
    }
    
    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public void setKategori(String kategoriStr)
    {
        
    }
    
    public void showKategori()
    {
        
    }

    /**
     * @return the stok
     */
    public int getStok() {
        return stok;
    }

    /**
     * @param stok the stok to set
     */
    public void setStok(int stok) {
        this.stok = stok;
    }
}
