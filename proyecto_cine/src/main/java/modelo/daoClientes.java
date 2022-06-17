/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsClientes;
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
public class daoClientes {

    private static final String SQL_SELECT = "SELECT  id_cliente, nombre, nit FROM tbl_clientes";
    private static final String SQL_INSERT = "INSERT INTO tbl_clientes(nombre, nit) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_clientes SET nombre=? AND nit=? WHERE id_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_clientes WHERE id_cliente=?";
    private static final String SQL_QUERY = "SELECT id_cliente, nombre, nit FROM tbl_clientes WHERE id_cliente = ?";


    public List<clsClientes> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsClientes cliente = null;
        List<clsClientes> clientes = new ArrayList<clsClientes>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_cliente = rs.getInt("id_cliente");
                String sNombre = rs.getString("nombre");
                String iNit = rs.getString("nit");

                cliente = new clsClientes();
                cliente.setiId_cliente(iId_cliente);
                cliente.setsNombre(sNombre);
                cliente.setsNit(iNit);
                
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return clientes;
    }

    public int insert(clsClientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getsNombre());
            stmt.setString(2, cliente.getsNit());

            


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

    public int update(clsClientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, cliente.getiId_cliente());
            stmt.setString(2, cliente.getsNombre());
            stmt.setString(3, cliente.getsNit());

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

    public int delete(clsClientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getiId_cliente());
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
    public clsClientes query(clsClientes cliente) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsClientes> clientes = new ArrayList<clsClientes>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, cliente.getiId_cliente());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_cliente = rs.getInt("id_cliente");
                String sNombre = rs.getString("nombre");
                String iNit = rs.getString("nit");

                cliente = new clsClientes();
                cliente.setiId_cliente(iId_cliente);
                cliente.setsNombre(sNombre);
                cliente.setsNit(iNit);
                
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
        return cliente;
    }

   
}
