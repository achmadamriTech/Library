package com.example.library.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SEWA")
public class SewaDetail {
    @Id
    @SequenceGenerator(name = "SEWA_SEQ", allocationSize = 1 )
    @GeneratedValue(generator = "SEWA_SEQ", strategy = GenerationType.SEQUENCE)
    private Long ID;

    @Column(nullable = false)
    private Date TGLSEWA;

    @Column(nullable = false)
    private int LAMASEWA;

    @Column(nullable = true)
    private String KETERANGAN;

    @Column(nullable = false)
    private String ISBN;

    @Column(nullable = false)
    private String JUDUL;

    @Column(nullable = false)
    private String PENGARANG;

    @Column(nullable = false)
    private String PELANGGANID;

    @Column(nullable = false)
    private String KODEPEL;

    @Column(nullable = false)
    private String NAMA;

    @Column(nullable = true)
    private String TELP;

    @Column(nullable = false)
    private String EMAIL;


    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Date getTGLSEWA() {
        return this.TGLSEWA;
    }

    public void setTGLSEWA(Date TGLSEWA) {
        this.TGLSEWA = TGLSEWA;
    }

    public int getLAMASEWA() {
        return this.LAMASEWA;
    }

    public void setLAMASEWA(int LAMASEWA) {
        this.LAMASEWA = LAMASEWA;
    }

    public String getKETERANGAN() {
        return this.KETERANGAN;
    }

    public void setKETERANGAN(String KETERANGAN) {
        this.KETERANGAN = KETERANGAN;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getJUDUL() {
        return this.JUDUL;
    }

    public void setJUDUL(String JUDUL) {
        this.JUDUL = JUDUL;
    }

    public String getPENGARANG() {
        return this.PENGARANG;
    }

    public void setPENGARANG(String PENGARANG) {
        this.PENGARANG = PENGARANG;
    }

    public String getPELANGGANID() {
        return this.PELANGGANID;
    }

    public void setPELANGGANID(String PELANGGANID) {
        this.PELANGGANID = PELANGGANID;
    }

    public String getKODEPEL() {
        return this.KODEPEL;
    }

    public void setKODEPEL(String KODEPEL) {
        this.KODEPEL = KODEPEL;
    }

    public String getNAMA() {
        return this.NAMA;
    }

    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }

    public String getTELP() {
        return this.TELP;
    }

    public void setTELP(String TELP) {
        this.TELP = TELP;
    }

    public String getEMAIL() {
        return this.EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

}
