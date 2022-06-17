/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsPeliculas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.clsConexion;

/**
 *
 * @author visitante
 */
public class daoPeliculas {

    private static final String SQL_SELECT = "SELECT id_pelicula, nombre, clasificacion, genero, subtitulado, idioma, precio FROM tbl_peliculas";
    private static final String SQL_INSERT = "INSERT INTO tbl_peliculas(nombre, clasificacion, genero, subtitulado, idioma, precio) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_peliculas SET nombre=?, clasificacion=?, genero=?, subtitulado=?, idioma=? AND precio=? WHERE id_pelicula= ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_peliculas WHERE id_pelicula=?";
    private static final String SQL_QUERY = "SELECT id_pelicula, nombre, clasificacion, genero, subtitulado, idioma, precio FROM tbl_peliculas WHERE id_pelicula = ?";


    public List<clsPeliculas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPeliculas cine = null;
        List<clsPeliculas> cines = new ArrayList<clsPeliculas>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_pelicula = rs.getInt("id_pelicula");
                String sNombre = rs.getString("nombre");
                String sClasificacion = rs.getString("clasificacion");
                String sGenero = rs.getString("genero");
                String sSubtitulado = rs.getString("subtitulado");
                String sIdioma = rs.getString("idioma");
                double dPrecio = rs.getDouble("precio");


                cine = new clsPeliculas();
                cine.setiId_pelicula(iId_pelicula);
                cine.setsNombre(sNombre);
                cine.setsClasificacion(sClasificacion);
                cine.setsGenero(sGenero);
                cine.setsSubtitulado(sSubtitulado);
                cine.setsIdioma(sIdioma);
                cine.setsPrecio(dPrecio);
                
                cines.add(cine);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return cines;
    }

    public int insert(clsPeliculas cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cine.getsNombre());
            stmt.setString(2, cine.getsClasificacion());
            stmt.setString(3, cine.getsGenero());
            stmt.setString(4, cine.getsSubtitulado());
            stmt.setString(5, cine.getsIdioma());
            stmt.setDouble(6, cine.getsPrecio());

            


            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsPeliculas cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, cine.getiId_pelicula());
            stmt.setString(2, cine.getsNombre());
            stmt.setString(3, cine.getsClasificacion());
            stmt.setString(4, cine.getsGenero());
            stmt.setString(5, cine.getsSubtitulado());
            stmt.setString(6, cine.getsIdioma());
            stmt.setDouble(7, cine.getsPrecio());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsPeliculas cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cine.getiId_pelicula());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public clsPeliculas query(clsPeliculas cine) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsPeliculas> cines = new ArrayList<clsPeliculas>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, cine.getiId_pelicula());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_pelicula = rs.getInt("id_pelicula");
                String sNombre = rs.getString("nombre");
                String sClasificacion = rs.getString("clasificacion");
                String sGenero = rs.getString("genero");
                String sSubtitulado = rs.getString("subtitulado");
                String sIdioma = rs.getString("idioma");
                double dPrecio = rs.getDouble("precio");


                cine = new clsPeliculas();
                cine.setiId_pelicula(iId_pelicula);
                cine.setsNombre(sNombre);
                cine.setsClasificacion(sClasificacion);
                cine.setsGenero(sGenero);
                cine.setsSubtitulado(sSubtitulado);
                cine.setsIdioma(sIdioma);
                cine.setsPrecio(dPrecio);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return cine;
    }

   
}
