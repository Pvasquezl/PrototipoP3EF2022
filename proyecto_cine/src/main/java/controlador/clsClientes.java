/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Pablo
 */
public class clsClientes {
    int iId_cliente;
    String sNombre;
    String sNit;

    public clsClientes() {
    }

    public clsClientes(int iId_cliente, String sNombre, String sNit) {
        this.iId_cliente = iId_cliente;
        this.sNombre = sNombre;
        this.sNit = sNit;
    }

    public int getiId_cliente() {
        return iId_cliente;
    }

    public void setiId_cliente(int iId_cliente) {
        this.iId_cliente = iId_cliente;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsNit() {
        return sNit;
    }

    public void setsNit(String sNit) {
        this.sNit = sNit;
    }

@Override
    public String toString() {
        return "tbl_clientes{" + "id_cliente  =" + iId_cliente + ", nombre=" + sNombre + ", nit=" + sNit + '}';
    }


}
