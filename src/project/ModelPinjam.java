/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author HP
 */
public class ModelPinjam {
    Connector connector = new Connector(); 
    public int getBanyakData(){
        int jmlData=0;
        try{
            String query = "Select * from data_peminjaman"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); //result isinya tabel belum berupa string
            while(resultSet.next()){ //menghitung banyak baris yang ada di database
                jmlData++; 
            }
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        return jmlData;
    }
    
    public String[][] readData(){ //dua dimensi baris-kolom
        try{
            int jmlData = 0; //menampung jumlah data sebanyak jumlah data yang ada, defaultnya
            String data[][] = new String[getBanyakData()][5]; // nemampung array. barisnya isinya di getBanyakData,kolomnya itu atribut
            String query = "Select * from `data_peminjaman`"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);// result isinya tabel belum berupa string
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("nama"); // Harus sesuai database
                data[jmlData][1] = resultSet.getString("judul_buku"); // Harus sesuai database
                data[jmlData][2] = resultSet.getString("tgl_pinjam"); // Harus sesuai database
                data[jmlData][3] = resultSet.getString("tgl_kembali");
                data[jmlData][4] = resultSet.getString("no_hp");
                jmlData++; //barisnya berpindah terus sampai habis        
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void tambahData(String nama,String judul_buku,String tgl_pinjam,String tgl_kembali,String no_hp){
        
         try {
            
            String query = "INSERT INTO data_peminjaman VALUES ('"+ nama +"','"+judul_buku+"','"+tgl_pinjam+"','"+tgl_kembali+"','"+no_hp+"')";  
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Insert Berhasil !!");
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,"Data Sudah Ada !!");
        }
    }
    
    public void updateData(String nama, String nam ,String judul_buku,String tgl_pinjam,String tgl_kembali,String no_hp){
            
        try {
            String query = "update data_peminjaman set nama=?, "
                    + "judul_buku=?, tgl_pinjam=?, tgl_kembali=?, no_hp=? where nama=?";
            PreparedStatement preparedStmt = connector.koneksi.prepareStatement(query);
            preparedStmt.setString(1, nama);
            preparedStmt.setString(2, judul_buku);
            preparedStmt.setString(3, tgl_pinjam);
            preparedStmt.setString(4, tgl_kembali);
            preparedStmt.setString(5, no_hp);
            preparedStmt.setString(6, nam);
            preparedStmt.execute();
            
           if(nam.compareTo(nama)==0)
            JOptionPane.showMessageDialog(null,"Update Berhasil !!");
            else
                JOptionPane.showMessageDialog(null,"Data Tidak Ada!!");
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void deleteData(String nama){
        try{
            String query = "DELETE from data_peminjaman WHERE nama = '"+nama+"'";
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
}
