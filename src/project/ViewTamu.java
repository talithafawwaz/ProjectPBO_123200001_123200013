/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class ViewTamu extends JFrame{
     //DEKLARASI KOMPONEN
    String nama;
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"JUDUL BUKU","PENGARANG","PENERBIT","TAHUN TERBIT","LOKASI BUKU"}; //membuat kolom dgn array tipe object;
    final JTextField fnama = new JTextField(50);
    final JTextField fjudul_buku = new JTextField(20);
    final JTextField ftgl_pinjam = new JTextField(20);
    final JTextField ftgl_kembali = new JTextField(10);
    final JTextField fno_hp = new JTextField(10);
    JLabel lnama= new JLabel("Nama");
    JLabel ljudul_buku = new JLabel("Judul Buku");
    JLabel ltgl_pinjam = new JLabel("Tanggal Pinjam");
    JLabel ltgl_kembali = new JLabel("Tanggal Kembali");
    JLabel lno_hp = new JLabel("No.HP");
    JButton btnTambah = new JButton("Tambah");
    JButton btnClear = new JButton("Clear");
    JButton btnKembali = new JButton("Kembali");
    JButton btnBack = new JButton("Menu Awal");
    
    public ViewTamu(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        setLayout(null);
        setSize(800,600);
        setVisible(true);
        setResizable(false);
        setTitle("Pengunjung");
        setDefaultCloseOperation(3);
  
        add(scrollPane);
        add(lnama);
        add(fnama);
        add(ljudul_buku);
        add(fjudul_buku);
        add(ltgl_pinjam);
        add(ftgl_pinjam);
        add(ltgl_kembali);
        add(ftgl_kembali);
        add(lno_hp);
        add(fno_hp);
        add(btnTambah);
        add(btnClear);
        add(btnKembali);
        add(btnBack);
        scrollPane.setBounds(20, 35, 500, 345);
        
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        lnama.setBounds(550, 35, 120, 20);
        fnama.setBounds(550, 60, 170, 20);
        ljudul_buku.setBounds(550, 90, 120, 20);
        fjudul_buku.setBounds(550, 115, 170, 20);
        ltgl_pinjam.setBounds(550, 145, 120, 20);
        ftgl_pinjam.setBounds(550, 170, 170, 20);
        ltgl_kembali.setBounds(550, 200, 120, 20);
        ftgl_kembali.setBounds(550, 225, 170, 20);
        lno_hp.setBounds(550, 255, 120, 20);
        fno_hp.setBounds(550, 280, 170, 20);
        btnTambah.setBounds(550, 315, 80, 20);
        btnClear.setBounds(650, 315, 80, 20);
        btnKembali.setBounds(600,400, 100, 20);
        btnBack.setBounds(20, 10, 100, 20);
        
        //mengambil data dari tabel yang di klik
        tabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                JTable target = (JTable)me.getSource();
                int baris = target.getSelectedRow(); // select a row
                nama =tabel.getValueAt(baris, 0).toString();
                fjudul_buku.setText(tabel.getValueAt(baris, 0).toString());
                
            }
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
    }
    public JTextField getFnama() {
        return fnama;
    }

    public JTextField getFjudul_buku() {
        return fjudul_buku;
    }

    public JTextField getFtgl_pinjam() {
        return ftgl_pinjam;
    }
    
    public JTextField getFtgl_kembali() {
        return ftgl_kembali;
    }
    
    public JTextField getFno_hp() {
        return fno_hp;
    }
}
