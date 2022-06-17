/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Pablo
 */
public class clsAsiento {
    int iId_asiento;
    int iId_sala;
    int iFila;
    int iColumna;

    public clsAsiento() {
    }

    public clsAsiento(int iId_asiento, int iId_sala, int iFila, int iColumna) {
        this.iId_asiento = iId_asiento;
        this.iId_sala = iId_sala;
        this.iFila = iFila;
        this.iColumna = iColumna;
    }

    public int getiId_asiento() {
        return iId_asiento;
    }

    public void setiId_asiento(int iId_asiento) {
        this.iId_asiento = iId_asiento;
    }

    public int getiId_sala() {
        return iId_sala;
    }

    public void setiId_sala(int iId_sala) {
        this.iId_sala = iId_sala;
    }

    public int getiFila() {
        return iFila;
    }

    public void setiFila(int iFila) {
        this.iFila = iFila;
    }

    public int getiColumna() {
        return iColumna;
    }

    public void setiColumna(int iColumna) {
        this.iColumna = iColumna;
    }

@Override
    public String toString() {
        return "tbl_asientos{" + "id_asiento  =" + iId_asiento + ", id_sala=" + iId_sala + ", fila=" + iFila +", columna=" + iColumna + '}';
    }


}
