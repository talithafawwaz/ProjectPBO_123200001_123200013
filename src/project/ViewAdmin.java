/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class ViewAdmin extends JFrame{
    //DEKLARASI KOMPONEN
    String nama;
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"JUDUL BUKU","PENGARANG","PENERBIT","TAHUN TERBIT","LOKASI BUKU"}; //membuat kolom dgn array tipe object;
    final JTextField fjudul = new JTextField(50);
    final JTextField fpengarang = new JTextField(20);
    final JTextField fpenerbit = new JTextField(20);
    final JTextField ftahun = new JTextField(10);
    final JTextField flokasi = new JTextField(10);
    JLabel ljudul= new JLabel("Judul");
    JLabel lpengarang = new JLabel("Pengarang");
    JLabel lpenerbit = new JLabel("Penerbit");
    JLabel ltahun = new JLabel("Tahun Terbit");
    JLabel llokasi = new JLabel("Lokasi Buku");
    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Clear");
    JButton btnBack = new JButton("Menu Awal");
    JButton btnKembali = new JButton("Kembali");
    
    public ViewAdmin(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        setLayout(null);
        setSize(800,600);
        setVisible(true);
        setResizable(false);
        setTitle("Admin");
        setDefaultCloseOperation(3);
  
        add(scrollPane);
        add(ljudul);
        add(fjudul);
        add(lpengarang);
        add(fpengarang);
        add(lpenerbit);
        add(fpenerbit);
        add(ltahun);
        add(ftahun);
        add(llokasi);
        add(flokasi);
        add(btnTambah);
        add(btnUpdate);
        add(btnDelete);
        add(btnClear);
        add(btnBack);
        add(btnKembali);

        scrollPane.setBounds(20, 35, 500, 345);
        
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        ljudul.setBounds(550, 35, 120, 20);
        fjudul.setBounds(550, 60, 170, 20);
        lpengarang.setBounds(550, 90, 120, 20);
        fpengarang.setBounds(550, 115, 170, 20);
        lpenerbit.setBounds(550, 145, 120, 20);
        fpenerbit.setBounds(550, 170, 170, 20);
        ltahun.setBounds(550, 200, 120, 20);
        ftahun.setBounds(550, 225, 170, 20);
        llokasi.setBounds(550, 255, 120, 20);
        flokasi.setBounds(550, 280, 170, 20);
        btnTambah.setBounds(550, 315, 80, 20);
        btnUpdate.setBounds(550, 345, 80, 20);
        btnDelete.setBounds(650, 315, 80, 20);
        btnClear.setBounds(650, 345, 80, 20);
        btnKembali.setBounds(630,400, 100, 20);
        btnBack.setBounds(20, 10, 100, 20);
        
        //mengambil data dari tabel yang di klik
        tabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                JTable target = (JTable)me.getSource();
                int baris = target.getSelectedRow(); // select a row
                nama =tabel.getValueAt(baris, 0).toString();
                fjudul.setText(tabel.getValueAt(baris, 0).toString());
                fpengarang.setText(tabel.getValueAt(baris, 1).toString());
                fpenerbit.setText( tabel.getValueAt(baris, 2).toString());
                ftahun.setText(tabel.getValueAt(baris, 3).toString());
                flokasi.setText(tabel.getValueAt(baris, 4).toString());         
            }
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
    }
    
    public JTextField getFjudul() {
        return fjudul;
    }

    public JTextField getFpengarang() {
        return fpengarang;
    }

    public JTextField getFpenerbit() {
        return fpenerbit;
    }
    
    public JTextField getFtahun() {
        return ftahun;
    }
    
    public JTextField getFlokasi() {
        return flokasi;
    }
}
