/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Pablo
 */
public class clsSalas {
    int iId_sala;
    int iId_cine;
    String sDescripcion;
    String sFormato;
    int iPuntos;
    double dPrecio_sala;

    public clsSalas() {
    }

    public clsSalas(int iId_sala, int iId_cine, String sDescripcion, String sFormato, int iPuntos, double dPrecio_sala) {
        this.iId_sala = iId_sala;
        this.iId_cine = iId_cine;
        this.sDescripcion = sDescripcion;
        this.sFormato = sFormato;
        this.iPuntos = iPuntos;
        this.dPrecio_sala = dPrecio_sala;
    }

    public int getiId_sala() {
        return iId_sala;
    }

    public void setiId_sala(int iId_sala) {
        this.iId_sala = iId_sala;
    }

    public int getiId_cine() {
        return iId_cine;
    }

    public void setiId_cine(int iId_cine) {
        this.iId_cine = iId_cine;
    }

    public String getsDescripcion() {
        return sDescripcion;
    }

    public void setsDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }

    public String getsFormato() {
        return sFormato;
    }

    public void setsFormato(String sFormato) {
        this.sFormato = sFormato;
    }

    public int getiPuntos() {
        return iPuntos;
    }

    public void setiPuntos(int iPuntos) {
        this.iPuntos = iPuntos;
    }

    public double getdPrecio_sala() {
        return dPrecio_sala;
    }

    public void setdPrecio_sala(double dPrecio_sala) {
        this.dPrecio_sala = dPrecio_sala;
    }

    

    

@Override
    public String toString() {
        return "tbl_salas{" + "id_sala  =" + iId_sala + ", id_cine=" + iId_cine + ", descipcion=" + sDescripcion +", formato=" + sFormato +", puntos=" + iPuntos +", precio_sala=" + dPrecio_sala + '}';
    }


}
