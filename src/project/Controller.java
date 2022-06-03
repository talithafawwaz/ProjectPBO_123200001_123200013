/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author HP
 */
public class Controller {
    ModelAdmin modelAdmin;
    ViewAdmin viewAdmin ;
    ModelTamu modelTamu;
    ViewTamu viewTamu;
    ModelPinjam modelPinjam;
    ViewPinjam viewPinjam;

    Controller(ViewAdmin viewAdmin, ModelAdmin modelAdmin) {
    this.modelAdmin = modelAdmin;
    this.viewAdmin = viewAdmin;
    
    //mengecek data yang ada dari database dan memasukkan ke dalam tabel
    if(modelAdmin.getBanyakData() != 0){
            String data[][] = modelAdmin.readData();
            viewAdmin.tabel.setModel((new JTable(data, viewAdmin.namaKolom)).getModel());
        } else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
    
    //aksi ketika menekan tombol tambah
    viewAdmin.btnTambah.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String judul = viewAdmin.getFjudul().getText();
        String pengarang = viewAdmin.getFpengarang().getText();
        String penerbit = viewAdmin.getFpenerbit().getText();
        String tahun = viewAdmin.getFtahun().getText();
        String lokasi = viewAdmin.getFlokasi().getText();
        if (judul.equals("") || pengarang.equals("")||penerbit.equals("")||tahun.equals("")||lokasi.equals("")) {
            JOptionPane.showMessageDialog(viewAdmin, "Isi Kolom Kosong Terlebih Dahulu !");
        }else {
            modelAdmin.tambahData(judul,pengarang,penerbit,tahun,lokasi);
            viewAdmin.dispose();
            MVC mvc = new MVC();
            mvc.Admin();
        }
        }
    });
    
    //aksi ketika menekan tombol update
    viewAdmin.btnUpdate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String nama = viewAdmin.nama;
        String judul = viewAdmin.getFjudul().getText();
        String pengarang = viewAdmin.getFpengarang().getText();
        String penerbit = viewAdmin.getFpenerbit().getText();
        String tahun = viewAdmin.getFtahun().getText();
        String lokasi = viewAdmin.getFlokasi().getText();
        if (judul.equals("") || pengarang.equals("")||penerbit.equals("")||tahun.equals("")||lokasi.equals("")) {
            JOptionPane.showMessageDialog(viewAdmin, "Isi Kolom Kosong Terlebih Dahulu !");
        }else {
            modelAdmin.updateData(nama,judul,pengarang,penerbit,tahun,lokasi);
            viewAdmin.dispose();
            MVC mvc = new MVC();
            mvc.Admin();
        }
        }
    });
    
    //aksi ketika menekan tombol delete
    viewAdmin.btnDelete.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String judul = viewAdmin.getFjudul().getText();

        if (judul.equals("")) {
            JOptionPane.showMessageDialog(viewAdmin, "Isi Judul Buku Yang Akan Dihapus");
        }else {
            modelAdmin.deleteData(judul);
            viewAdmin.dispose();
            MVC mvc = new MVC();
            mvc.Admin();
        }
        }
    });
    
    //aksi ketika menekan tombol clear
     viewAdmin.btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAdmin.fjudul.setText("");
                viewAdmin.fpengarang.setText("");
                viewAdmin.fpenerbit.setText("");
                viewAdmin.ftahun.setText("");
                viewAdmin.flokasi.setText("");
            }
        });
     
     //aksi ketika menekan tombol Menu Utama
     viewAdmin.btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAdmin.dispose();
                Home home = new Home();
            }
        });
     //aksi ketika menekan tombol Kembali
     viewAdmin.btnKembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAdmin.dispose();
                Data data = new Data();
            }
        });
    
    }
    
    Controller(ViewPinjam viewPinjam, ModelPinjam modelPinjam) {
    this.modelPinjam = modelPinjam;
    this.viewPinjam = viewPinjam;
    
    //mengecek data yang ada dari database dan memasukkan ke dalam tabel
    if(modelPinjam.getBanyakData() != 0){
            String data[][] = modelPinjam.readData();
            viewPinjam.tabel.setModel((new JTable(data, viewPinjam.namaKolom)).getModel());
        } else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
    
    //aksi ketika menekan tombol tambah
    viewPinjam.btnTambahpjm.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String nama = viewPinjam.getFnama().getText();
        String judul_buku = viewPinjam.getFjudul_buku().getText();
        String tgl_pinjam = viewPinjam.getFtgl_pinjam().getText();
        String tgl_kembali = viewPinjam.getFtgl_kembali().getText();
        String no_hp = viewPinjam.getFno_hp().getText();
        if (nama.equals("") || judul_buku.equals("")||tgl_pinjam.equals("")||tgl_kembali.equals("")||no_hp.equals("")) {
            JOptionPane.showMessageDialog(viewPinjam, "Isi Kolom Kosong Terlebih Dahulu !");
        }else {
            modelPinjam.tambahData(nama, judul_buku, tgl_pinjam, tgl_kembali, no_hp);
            viewPinjam.dispose();
            MVC mvc = new MVC();
            mvc.Pinjam();
        }
        }
    });
    
    //aksi ketika menekan tombol update
    viewPinjam.btnUpdatepjm.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String nam = viewPinjam.nam;
        String nama = viewPinjam.getFnama().getText();
        String judul_buku = viewPinjam.getFjudul_buku().getText();
        String tgl_pinjam = viewPinjam.getFtgl_pinjam().getText();
        String tgl_kembali = viewPinjam.getFtgl_kembali().getText();
        String no_hp = viewPinjam.getFno_hp().getText();
        if (nama.equals("") || judul_buku.equals("")||tgl_pinjam.equals("")||tgl_kembali.equals("")||no_hp.equals("")) {
            JOptionPane.showMessageDialog(viewPinjam, "Isi Kolom Kosong Terlebih Dahulu !");
        }else {
            modelPinjam.updateData(nam, nama, judul_buku, tgl_pinjam, tgl_kembali, no_hp);
            viewPinjam.dispose();
            MVC mvc = new MVC();
            mvc.Pinjam();
        }
        }
    });
    
    //aksi ketika menekan tombol delete
    viewPinjam.btnDeletepjm.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String nama = viewPinjam.getFnama().getText();

        if (nama.equals("")) {
            JOptionPane.showMessageDialog(viewPinjam, "Isi Nama Yang Akan Dihapus");
        }else {
            modelPinjam.deleteData(nama);
            viewPinjam.dispose();
            MVC mvc = new MVC();
            mvc.Pinjam();
        }
        }
    });
    
    //aksi ketika menekan tombol clear
     viewPinjam.btnClearpjm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPinjam.fnama.setText("");
                viewPinjam.fjudul_buku.setText("");
                viewPinjam.ftgl_pinjam.setText("");
                viewPinjam.ftgl_kembali.setText("");
                viewPinjam.fno_hp.setText("");
            }
        });
     
     //aksi ketika menekan tombol Menu Utama
     viewPinjam.btnBackpjm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPinjam.dispose();
                Home home = new Home();
            }
        });
     //aksi ketika menekan tombol Kembali
     viewPinjam.btnKembalipjm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPinjam.dispose();
                Data data = new Data();
            }
        });
    
    }
    
    Controller(ViewTamu viewTamu, ModelTamu modelTamu) {
    this.modelTamu = modelTamu;
    this.viewTamu = viewTamu;
    
    //mengecek data yang ada dari database dan memasukkan ke dalam tabel
    if(modelTamu.getBanyakData() != 0){
            String data[][] = modelTamu.readData();
            viewTamu.tabel.setModel((new JTable(data, viewTamu.namaKolom)).getModel());
        } else{
            JOptionPane.showMessageDialog(null, "Data Kosong!!\nMinta Admin Untuk Menginput Data!!");
        }
    
     //aksi ketika menekan tombol clear
     viewTamu.btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTamu.fnama.setText("");
                viewTamu.fjudul_buku.setText("");
                viewTamu.ftgl_pinjam.setText("");
                viewTamu.ftgl_kembali.setText("");
                viewTamu.fno_hp.setText("");
            }
        });
     
     //aksi ketika menekan tombol Menu Utama
     viewTamu.btnKembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTamu.dispose();
                HomePengunjung homePengunjung = new HomePengunjung();
            }
        });
     //aksi ketika menekan tombol tambah
    viewTamu.btnTambah.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String nama = viewTamu.getFnama().getText();
        String judul_buku = viewTamu.getFjudul_buku().getText();
        String tgl_pinjam = viewTamu.getFtgl_pinjam().getText();
        String tgl_kembali = viewTamu.getFtgl_kembali().getText();
        String no_hp = viewTamu.getFno_hp().getText();
        if (nama.equals("") || judul_buku.equals("")||tgl_pinjam.equals("")||tgl_kembali.equals("")||no_hp.equals("")) {
            JOptionPane.showMessageDialog(viewTamu, "Isi Kolom Kosong Terlebih Dahulu !");
        }else {
            modelTamu.tambahData(nama, judul_buku, tgl_pinjam, tgl_kembali, no_hp);
            JOptionPane.showMessageDialog(null,"Berhasil Meminjam!!");
            viewTamu.fnama.setText("");
            viewTamu.fjudul_buku.setText("");
            viewTamu.ftgl_pinjam.setText("");
            viewTamu.ftgl_kembali.setText("");
            viewTamu.fno_hp.setText("");
            viewTamu.dispose();
            MVC mvc = new MVC();
            mvc.Tamu();
        }
        }
    });
    viewTamu.btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTamu.dispose();
                Home home = new Home();
            }
        });
    }
}
