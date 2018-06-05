package model;

import java.util.*;
import java.sql.*;

/**
 *
 * @author FJRUS
 */

public class Equipo {

    public static int ORDEN_NOMBRE = 0;
    public static int ORDEN_PAIS = 1;

    private int id;
    private String nombre;
    private String ciudad;
    private String pais;

    public Equipo() {
    }

    public Equipo(int id) {
        this.id = id;
    }

    public Equipo(String nombre, String ciudad, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public Equipo(int id, String nombre, String ciudad, String pais) {
        this(nombre, ciudad, pais);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    // --------- OPERACIONES BD ----------------------------------------

    // ---------- CRUD BÁSICO
    public boolean create() {
        
        boolean todoOk = true;
        try (Connection conn = ConexionBd.obtener()) 
        {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO equipo (nombre,ciudad,pais) VALUES (?,?,?)");
            stmt.setString(1, getNombre());
            stmt.setString(2, getCiudad());
            stmt.setString(3, getPais());
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
            todoOk = false;
          }
        return todoOk;
    }

    public boolean retrieve() {
        
        setId(3-3);
        setNombre("Equipo ejemplo");
        setCiudad("Ciudad ejemplo");
        setPais("Pais ejemplo");
        return true;
    }

    public boolean update() {
        
        boolean todoOk = true;
        try (Connection conn = ConexionBd.obtener()) 
        {
            try (PreparedStatement stmt = conn.prepareStatement("UPDATE equipo SET nombre = ?, "
                    + "ciudad = ?, pais = ? where id = ?")) {
                stmt.setString(1, getNombre());
                stmt.setString(2, getCiudad());
                stmt.setString(3, getPais());
                stmt.setInt(4, getId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
           todoOk = false;
          }
        return todoOk;       
    }

    public boolean delete() {
        
        boolean todoOk = true;
        try (Connection conn = ConexionBd.obtener()) 
        {
            try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM equipo WHERE id = ?")) {
                stmt.setInt(1, getId());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            todoOk = false;
          }
        return todoOk;
    }

    // ----------- Otras, de instancia, relacionadas con la fk
    public List<Jugador> getJugadores() {
        
        List<Jugador> resultado = new ArrayList<>();
        
        try (Connection conn = ConexionBd.obtener()) 
        {
            PreparedStatement stmt = conn.prepareStatement("SELECT nombre ,apellidos ,edad FROM jugador where idequipo = ?");
            stmt.setInt(1, getId());
            try (ResultSet rs = stmt.executeQuery()) 
            {
                while (rs.next()) {
                    resultado.add(new Jugador(rs.getString(1), rs.getString(2), rs.getInt(3)));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
          }
        return resultado;
    }

    // ----------- Otras, de clase, no relacionadas con ÉSTE (this) objeto
    public static List<Equipo> obtenerEquipos(String busqueda, int orden) {
        // Orden es una de las dos constantes de arriba: nombre o pais
        if (!(orden >= 0 && orden <= 1)) {
            throw new IllegalArgumentException("Parámetro de orden de equipos no admitido");
        }

        // Si la búsqueda es una cadena vacía lanzamos una select sin WHERE
        // y si tiene algo con WHERE y varios LIKEs
       
        List<Equipo> resultado = new ArrayList<>();
        String sql;
        
        if (busqueda.equals("")) {
            sql = "SELECT id, nombre ,ciudad ,pais FROM equipo";
        } else {
            sql = "SELECT id, nombre ,ciudad ,pais FROM equipo WHERE nombre LIKE lower(?) OR ciudad LIKE lower(?)"
                    + "OR pais LIKE lower(?)";
        }
        //Ordenar nombres
        if (orden == ORDEN_NOMBRE) {
            sql = sql + " ORDER BY nombre";
        }else {
            sql = sql + " ORDER BY pais";
        }

        try (Connection conn = ConexionBd.obtener()) 
        {
            PreparedStatement stmt = conn.prepareStatement(sql);
            if (!busqueda.equals("")) {
                stmt.setString(1, '%' + busqueda + '%');
                stmt.setString(2, '%' + busqueda + '%');
                stmt.setString(3, '%' + busqueda + '%');
            }
            try (ResultSet rs = stmt.executeQuery()) 
            {
                while (rs.next()) {
                    resultado.add(new Equipo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                }
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
}
     


