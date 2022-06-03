/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author HP
 */
public class MVC { 
    public void Admin(){
        ViewAdmin viewAdmin = new ViewAdmin();
        ModelAdmin modelAdmin = new ModelAdmin();
        Controller controller = new Controller(viewAdmin, modelAdmin);
    }
    public void Pinjam(){
        ViewPinjam viewPinjam = new ViewPinjam();
        ModelPinjam modelPinjam = new ModelPinjam();
        Controller controller = new Controller(viewPinjam, modelPinjam);
    }
    public void Tamu(){
        ViewTamu viewTamu = new ViewTamu();
        ModelTamu modelTamu = new ModelTamu();
        Controller controller = new Controller(viewTamu, modelTamu);
    }
}
