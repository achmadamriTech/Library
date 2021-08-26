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

    @Column(nullable = false)
    private String TELP;

    @Column(nullable = false)
    private String EMAIL;


}
