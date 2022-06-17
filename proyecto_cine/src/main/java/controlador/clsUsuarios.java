/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Pablo
 */
public class clsUsuarios {
    int Iid_usuario;
    String sNombre;
    String sCorreo;
    String sContraseña;
    String sCargo;

    public clsUsuarios() {
    }

    public clsUsuarios(int Iid_usuario, String sNombre, String sCorreo, String sContraseña, String sCargo) {
        this.Iid_usuario = Iid_usuario;
        this.sNombre = sNombre;
        this.sCorreo = sCorreo;
        this.sContraseña = sContraseña;
        this.sCargo = sCargo;
    }

    public int getIid_usuario() {
        return Iid_usuario;
    }

    public void setIid_usuario(int Iid_usuario) {
        this.Iid_usuario = Iid_usuario;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsCorreo() {
        return sCorreo;
    }

    public void setsCorreo(String sCorreo) {
        this.sCorreo = sCorreo;
    }

    public String getsContraseña() {
        return sContraseña;
    }

    public void setsContraseña(String sContraseña) {
        this.sContraseña = sContraseña;
    }

    public String getsCargo() {
        return sCargo;
    }

    public void setsCargo(String sTipo) {
        this.sCargo = sTipo;
    }

 @Override
    public String toString() {
        return "tbl_usuarios{" + "id_usuario =" + Iid_usuario + ", nombre=" + sNombre + ", correo=" + sCorreo +", contraseña=" + sContraseña +", cargo=" + sCargo + '}';
    }

}
