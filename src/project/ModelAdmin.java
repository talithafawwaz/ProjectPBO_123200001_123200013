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
public class ModelAdmin {
    Connector connector = new Connector(); 
    public int getBanyakData(){
        int jmlData=0;
        try{
            String query = "Select * from data_buku"; 
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
            String query = "Select * from `data_buku`"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);// result isinya tabel belum berupa string
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("judul"); // Harus sesuai database
                data[jmlData][1] = resultSet.getString("pengarang"); // Harus sesuai database
                data[jmlData][2] = resultSet.getString("penerbit"); // Harus sesuai database
                data[jmlData][3] = resultSet.getString("tahun_terbit");
                data[jmlData][4] = resultSet.getString("lokasi");
                jmlData++; //barisnya berpindah terus sampai habis        
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void tambahData(String judul,String pengarang,String penerbit,String tahun,String lokasi){
        
         try {
            
            String query = "INSERT INTO data_buku VALUES ('"+judul+"','"+pengarang+"','"+penerbit+"','"+tahun+"','"+lokasi+"')";  
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Insert Berhasil !!");
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,"Data Sudah Ada !!");
        }
    }
    
    public void updateData(String nama,String judul,String pengarang,String penerbit,String tahun,String lokasi){
            
        try {
            String query = "update data_buku set judul=?, "
                    + "pengarang=?, penerbit=?, tahun_terbit=?, lokasi=? where judul=?";
            PreparedStatement preparedStmt = connector.koneksi.prepareStatement(query);
            preparedStmt.setString(1, judul);
            preparedStmt.setString(2, pengarang);
            preparedStmt.setString(3, penerbit);
            preparedStmt.setString(4, tahun);
            preparedStmt.setString(5, lokasi);
            preparedStmt.setString(6, nama);
            preparedStmt.execute();
            
           if(nama.compareTo(judul)==0)
            JOptionPane.showMessageDialog(null,"Update Berhasil !!");
            else
                JOptionPane.showMessageDialog(null,"Data Tidak Ada!!");
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void deleteData(String judul){
        try{
            String query = "DELETE from data_buku WHERE judul = '"+judul+"'";
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
}
