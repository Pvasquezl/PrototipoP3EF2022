/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Pablo
 */
public class clsCines {
    int iId_cine;
    String sNombre;
    String sDireccion;

    public clsCines() {
    }

    public clsCines(int iId_cine, String sNombre, String sDireccion) {
        this.iId_cine = iId_cine;
        this.sNombre = sNombre;
        this.sDireccion = sDireccion;
    }

    public int getiId_cine() {
        return iId_cine;
    }

    public void setiId_cine(int iId_cine) {
        this.iId_cine = iId_cine;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsDireccion() {
        return sDireccion;
    }

    public void setsDireccion(String sDireccion) {
        this.sDireccion = sDireccion;
    }

@Override
    public String toString() {
        return "tbl_cine{" + "id_cine  =" + iId_cine + ", nombre=" + sNombre + ", direccion=" + sDireccion + '}';
    }


}
