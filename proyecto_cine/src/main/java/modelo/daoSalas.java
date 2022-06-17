/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsSalas;
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
public class daoSalas {

    private static final String SQL_SELECT = "SELECT SELECT id_sala, id_cine, descipcion, formato, puntos, precio_sala FROM tbl_salas";
    private static final String SQL_INSERT = "INSERT INTO tbl_salas(id_cine, descipcion, formato, puntos, precio_sala) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_salas SET id_cine=?, descipcion=?, formato=?, puntos=? AND precio_sala=? WHERE id_sala= ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_salas WHERE id_sala=?";
    private static final String SQL_QUERY = "SELECT id_sala, id_cine, descipcion, formato, puntos, precio_sala FROM tbl_salas WHERE id_sala= ?";


    public List<clsSalas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsSalas sala = null;
        List<clsSalas> salas = new ArrayList<clsSalas>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_sala = rs.getInt("id_sala");
                int iId_cine = rs.getInt("id_cine");
                String sDescripcion = rs.getString("descipcion");
                String sFormato = rs.getString("formato");
                int iPuntos = rs.getInt("puntos");
                double dPrecio_sala = rs.getDouble("precio_sala");


                sala = new clsSalas();
                sala.setiId_sala(iId_sala);
                sala.setiId_cine(iId_cine);
                sala.setsDescripcion(sDescripcion);
                sala.setsFormato(sFormato);
                sala.setiPuntos(iPuntos);
                sala.setdPrecio_sala(dPrecio_sala);
                
                salas.add(sala);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return salas;
    }

    public int insert(clsSalas sala) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, sala.getiId_cine());
            stmt.setString(2, sala.getsDescripcion());
            stmt.setString(3, sala.getsFormato());
            stmt.setInt(4, sala.getiPuntos());
            stmt.setDouble(5, sala.getdPrecio_sala());
            


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

    public int update(clsSalas sala) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, sala.getiId_sala());
            stmt.setInt(2, sala.getiId_cine());
            stmt.setString(3, sala.getsDescripcion());
            stmt.setString(4, sala.getsFormato());
            stmt.setInt(5, sala.getiPuntos());
            stmt.setDouble(6, sala.getdPrecio_sala());

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

    public int delete(clsSalas sala) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, sala.getiId_sala());
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
    public clsSalas query(clsSalas sala) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsSalas> salas = new ArrayList<clsSalas>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, sala.getiId_sala());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_sala = rs.getInt("id_sala");
                int iId_cine = rs.getInt("id_cine");
                String sDescripcion = rs.getString("descipcion");
                String sFormato = rs.getString("formato");
                int iPuntos = rs.getInt("puntos");
                double dPrecio_sala = rs.getDouble("precio_sala");


                sala = new clsSalas();
                sala.setiId_sala(iId_sala);
                sala.setiId_cine(iId_cine);
                sala.setsDescripcion(sDescripcion);
                sala.setsFormato(sFormato);
                sala.setiPuntos(iPuntos);
                sala.setdPrecio_sala(dPrecio_sala);
                
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
        return sala;
    }

   
}
