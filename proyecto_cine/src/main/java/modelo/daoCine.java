/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsCines;
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
public class daoCine {

    private static final String SQL_SELECT = "SELECT  id_cine, nombre, direccion FROM tbl_cine";
    private static final String SQL_INSERT = "INSERT INTO tbl_cine(nombre, direccion) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_cine SET nombre=? AND direccion=? WHERE id_cine = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cine WHERE id_cine=?";
    private static final String SQL_QUERY = "SELECT id_cine, nombre, direccion FROM tbl_cine WHERE id_cine = ?";


    public List<clsCines> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCines cine = null;
        List<clsCines> cines = new ArrayList<clsCines>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_cliente = rs.getInt("id_cine");
                String sNombre = rs.getString("nombre");
                String sDireccion = rs.getString("direccion");

                cine = new clsCines();
                cine.setiId_cine(iId_cliente);
                cine.setsNombre(sNombre);
                cine.setsDireccion(sDireccion);
                
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

    public int insert(clsCines cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cine.getsNombre());
            stmt.setString(2, cine.getsDireccion());

            


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

    public int update(clsCines cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, cine.getiId_cine());
            stmt.setString(2, cine.getsNombre());
            stmt.setString(3, cine.getsDireccion());

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

    public int delete(clsCines cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cine.getiId_cine());
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
    public clsCines query(clsCines cine) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsCines> cines = new ArrayList<clsCines>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, cine.getiId_cine());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_cliente = rs.getInt("id_cine");
                String sNombre = rs.getString("nombre");
                String sDireccion = rs.getString("direccion");

                cine = new clsCines();
                cine.setiId_cine(iId_cliente);
                cine.setsNombre(sNombre);
                cine.setsDireccion(sDireccion);
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
