/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author HP
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Home home = new Home();
    }
}
    //Halaman Utama
    class Home extends JFrame {
    Menu menu;
    
    JButton btnAdmin = new JButton("Login Admin");
    JButton btnTamu = new JButton("Login Pengunjung");
    
    Home(){
        setTitle("Perpustakaan");
	setSize(350,120);
	setLayout(null);
        
        add(btnAdmin);
        add(btnTamu);
        btnAdmin.setBounds(10,20,150,40);
        btnTamu.setBounds(170,20,150,40);
        
         btnAdmin.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  dispose();
                  Login login = new Login();        
              }
         });
         
         btnTamu.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  dispose();
                  HomePengunjung homePengunjung = new HomePengunjung();
              }
         });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
     
   }
}
    //Halaman Login Admin
   class Login extends JFrame {
   final JTextField funame = new JTextField(10);
   final JPasswordField fpass = new JPasswordField(10);
   
   JLabel lTitle = new JLabel(" LOGIN ADMIN ");
   JLabel luname = new JLabel(" Username ");
   JLabel lpass = new JLabel(" Password ");
   
   JButton btnLoginAdmin = new JButton(" LOGIN ");

    Login() {
	setTitle("LOGIN ADMIN");
	setSize(350,250);
	setLayout(null);
        
        add(lTitle);
	add(luname);
	add(funame);
        add(lpass);
	add(fpass);
	add(btnLoginAdmin);  
        
        setVisible(true);
        lTitle.setBounds(150,20,140,20);
	luname.setBounds(10,50,120,20);
	funame.setBounds(130,50,150,20);
	lpass.setBounds(10,80,120,20);
	fpass.setBounds(130,80,150,20);
	btnLoginAdmin.setBounds(100,120,120,20);
        
        btnLoginAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = funame.getText();
                String pass = fpass.getText();
                
                if(uname.equals("admin") && pass.equals("admin")){
                    dispose();
                    Data data = new Data();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Login Gagal!");
                }
            }
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
    }
}

class Data extends JFrame{
    JButton btnData_Buku = new JButton("Data Buku");
    JButton btnData_Pinjam = new JButton("Data Peminjaman");
    Data(){
        setTitle("Perpustakaan");
	setSize(350,120);
	setLayout(null);
        
        add(btnData_Buku);
        add(btnData_Pinjam);
        
        btnData_Buku.setBounds(10,20,150,40);
        btnData_Pinjam.setBounds(170,20,150,40);
        
         btnData_Buku.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  dispose();
                  MVC mvc = new MVC();
                  mvc.Admin();        
              }
         });
         
         btnData_Pinjam.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  dispose();
                  MVC mvc = new MVC();
                  mvc.Pinjam();
              }
         });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
    }
}

class HomePengunjung extends JFrame{
    JButton btnLogin_Peng = new JButton("Login");
    JButton btnDaftar_Peng = new JButton("Daftar");
    HomePengunjung(){
        setTitle("Halaman Pengunjung");
	setSize(350,120);
	setLayout(null);
        
        add(btnLogin_Peng);
        add(btnDaftar_Peng);
        
        btnLogin_Peng.setBounds(10,20,150,40);
        btnDaftar_Peng.setBounds(170,20,150,40);
        
         btnLogin_Peng.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  dispose();
                  LoginPengunjung loginPengunjung = new LoginPengunjung();        
              }
         });
         
         btnDaftar_Peng.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  dispose();
                  DaftarPengunjung daftarPengunjung = new DaftarPengunjung();
              }
         });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
    }
}
class LoginPengunjung extends JFrame{
   Connector connector = new Connector(); 
   Statement statement;
   ResultSet rs;
   JTextField funamepeng = new JTextField();
   JTextField fpasspeng = new JTextField();
   
   JLabel lTitlepeng = new JLabel(" LOGIN PENGUNJUNG ");
   JLabel lunamepeng = new JLabel(" Username ");
   JLabel lpasspeng = new JLabel(" Password ");
   
   JButton btnLoginPeng = new JButton(" LOGIN ");
   JButton btnBack = new JButton(" Kembali ");
    LoginPengunjung(){
        setTitle("LOGIN PENGUNJUNG");
	setSize(350,350);
	setLayout(null);
        
        add(lTitlepeng);
	add(lunamepeng);
	add(funamepeng);
        add(lpasspeng);
	add(fpasspeng);
	add(btnLoginPeng);
        add(btnBack);
        
        setVisible(true);
        lTitlepeng.setBounds(100,20,140,20);
	lunamepeng.setBounds(10,70,120,20);
	funamepeng.setBounds(130,70,150,20);
	lpasspeng.setBounds(10,110,120,20);
	fpasspeng.setBounds(130,110,150,20);
	btnLoginPeng.setBounds(40,170,100,20);
        btnBack.setBounds(170,170,100,20);
        
        
        btnLoginPeng.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String query = "SELECT * FROM `data_user` WHERE username = '" + getFunamepeng() +"'"; 
                    connector.statement = connector.koneksi.createStatement();
                    ResultSet rs = connector.statement.executeQuery(query);
                    if (rs.next()) 
                    {
                        if (getFunamepeng().equals(rs.getString("password")))
                        {
                            System.out.println("Berhasil Login");
                            JOptionPane.showMessageDialog(null, "Berhasil Login");
                            dispose();
                            MVC mvc = new MVC();
                            mvc.Tamu();
                        } else
                        {
                            JOptionPane.showMessageDialog(rootPane,"Password Salah");
                        }
                    } 
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane, "Username Tidak Ditemukan");
                    }
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());
                }

            }
        });
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                HomePengunjung homePengunjung = new HomePengunjung();
            }
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null); 
        
    }
    public String getFunamepeng() {
        return funamepeng.getText();
    }
    public String getFpasspeng() {
        return fpasspeng.getText();
    }
}

class DaftarPengunjung extends JFrame{
   Connector connector = new Connector(); 
   Statement statement;
   ResultSet rs;
   JTextField funamedaftar = new JTextField();
   JTextField fpassdaftar = new JTextField();
   JTextField fnamadaftar = new JTextField();
   
   JLabel lTitledaftar = new JLabel(" DAFTAR PENGUNJUNG ");
   JLabel lunamedaftar = new JLabel(" Username ");
   JLabel lpassdaftar = new JLabel(" Password ");
   JLabel lnamadaftar = new JLabel(" Nama ");
   
   JButton btnDaftarPeng = new JButton(" DAFTAR ");
   JButton btnBack = new JButton(" Kembali ");
    DaftarPengunjung(){
        setTitle("DAFTAR PENGUNJUNG");
	setSize(350,250);
	setLayout(null);
        
        add(lTitledaftar);
	add(lunamedaftar);
	add(funamedaftar);
        add(lpassdaftar);
	add(fpassdaftar);
        add(lnamadaftar);
	add(fnamadaftar);
	add(btnDaftarPeng);
        add(btnBack);
        
        setVisible(true);
        lTitledaftar.setBounds(100,20,170,20);
	lunamedaftar.setBounds(10,70,120,20);
	funamedaftar.setBounds(130,70,150,20);
	lpassdaftar.setBounds(10,100,120,20);
	fpassdaftar.setBounds(130,100,150,20);
        lnamadaftar.setBounds(10,130,120,20);
	fnamadaftar.setBounds(130,130,150,20);
	btnDaftarPeng.setBounds(40,170,100,20);
        btnBack.setBounds(170,170,100,20);
        
        btnDaftarPeng.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{   
                    Connector connector = new Connector();
                    String query =  "SELECT * FROM `data_user` WHERE username = '" + getFunamedaftar() +"'"; 
                    connector.statement = connector.koneksi.createStatement();
                    ResultSet rs = connector.statement.executeQuery(query);
                    if (rs.next()) 
                    {
                        JOptionPane.showMessageDialog(rootPane, "Username Sudah Digunakan");
                    } else 
                    {
                        String inputData = "INSERT INTO `data_user` VALUES ( '"+ getFunamedaftar() +"','"+getFpassdaftar()+"','"+getFnamadaftar()+"');";           
                        connector.statement = connector.koneksi.createStatement();
                        connector.statement.executeUpdate(inputData);
                        System.out.println("Berhasil Mendaftar User");
                        JOptionPane.showMessageDialog(null,"Berhasil Mendaftar User");
                        dispose();
                        LoginPengunjung loginPengunjung = new LoginPengunjung();
                    }     
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
        });
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                HomePengunjung homePengunjung = new HomePengunjung();
            }
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null); 
        
    }
    public String getFunamedaftar() {
        return funamedaftar.getText();
    }
    public String getFpassdaftar() {
        return fpassdaftar.getText();
    }
    public String getFnamadaftar() {
        return fnamadaftar.getText();
    }
}

