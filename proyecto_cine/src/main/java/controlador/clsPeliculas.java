/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Pablo
 */
public class clsPeliculas {
    int iId_pelicula;
    String sNombre;
    String sClasificacion;
    String sGenero;
    String sSubtitulado;
    String sIdioma;
    double sPrecio;

    public clsPeliculas() {
    }

    public clsPeliculas(int iId_pelicula, String sNombre, String sClasificacion, String sGenero, String sSubtitulado, String sIdioma, double sPrecio) {
        this.iId_pelicula = iId_pelicula;
        this.sNombre = sNombre;
        this.sClasificacion = sClasificacion;
        this.sGenero = sGenero;
        this.sSubtitulado = sSubtitulado;
        this.sIdioma = sIdioma;
        this.sPrecio = sPrecio;
    }

    public int getiId_pelicula() {
        return iId_pelicula;
    }

    public void setiId_pelicula(int iId_pelicula) {
        this.iId_pelicula = iId_pelicula;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsClasificacion() {
        return sClasificacion;
    }

    public void setsClasificacion(String sClasificacion) {
        this.sClasificacion = sClasificacion;
    }

    public String getsGenero() {
        return sGenero;
    }

    public void setsGenero(String sGenero) {
        this.sGenero = sGenero;
    }

    public String getsSubtitulado() {
        return sSubtitulado;
    }

    public void setsSubtitulado(String sSubtitulado) {
        this.sSubtitulado = sSubtitulado;
    }

    public String getsIdioma() {
        return sIdioma;
    }

    public void setsIdioma(String sIdioma) {
        this.sIdioma = sIdioma;
    }

    public double getsPrecio() {
        return sPrecio;
    }

    public void setsPrecio(double sPrecio) {
        this.sPrecio = sPrecio;
    }

@Override
    public String toString() {
        return "tbl_peliculas{" + "id_pelicula =" + iId_pelicula + ", nombre=" + sNombre + ", clasificacion=" + sClasificacion +", genero=" + sGenero +", subtitulado=" + sSubtitulado +", idioma=" + sIdioma +", precio=" + sPrecio + '}';
    }


}
