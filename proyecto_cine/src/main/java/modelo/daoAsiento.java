/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsAsiento;
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
public class daoAsiento {

    private static final String SQL_SELECT = "SELECT id_asiento, id_sala, fila, columna FROM tbl_asientos";
    private static final String SQL_INSERT = "INSERT INTO tbl_asientos(id_sala, fila, columna) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_asientos SET id_sala=?, fila=? AND columna=? WHERE id_asiento = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_asientos WHERE id_asiento=?";
    private static final String SQL_QUERY = "SELECT id_asiento, id_sala, fila, columna WHERE id_asiento = ?";


    public List<clsAsiento> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsAsiento asiento = null;
        List<clsAsiento> asientos = new ArrayList<clsAsiento>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_asiento = rs.getInt("id_asiento");
                int iId_sala = rs.getInt("id_sala");
                int iFila = rs.getInt("fila");
                int iColumna = rs.getInt("columna");


                asiento = new clsAsiento();
                asiento.setiId_asiento(iId_asiento);
                asiento.setiId_sala(iId_sala);
                asiento.setiFila(iFila);
                asiento.setiColumna(iColumna);
                
                asientos.add(asiento);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return asientos;
    }

    public int insert(clsAsiento asiento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, asiento.getiId_sala());
            stmt.setInt(2, asiento.getiFila());
            stmt.setInt(3, asiento.getiColumna());

            


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

    public int update(clsAsiento asiento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, asiento.getiId_asiento());
            stmt.setInt(2, asiento.getiId_sala());
            stmt.setInt(3, asiento.getiFila());
            stmt.setInt(4, asiento.getiColumna());

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

    public int delete(clsAsiento asiento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, asiento.getiId_asiento());
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
    public clsAsiento query(clsAsiento asiento) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsAsiento> asientos = new ArrayList<clsAsiento>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, asiento.getiId_asiento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_asiento = rs.getInt("id_asiento");
                int iId_sala = rs.getInt("id_sala");
                int iFila = rs.getInt("fila");
                int iColumna = rs.getInt("columna");


                asiento = new clsAsiento();
                asiento.setiId_asiento(iId_asiento);
                asiento.setiId_sala(iId_sala);
                asiento.setiFila(iFila);
                asiento.setiColumna(iColumna);
                
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
        return asiento;
    }

   
}
