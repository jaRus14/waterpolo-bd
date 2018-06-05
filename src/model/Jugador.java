package model;

import java.util.*;
import java.sql.*;

/**
 *
 * @author FJRUS
 */

public class Jugador {

    private int id;
    private String nombre;
    private String apellidos;
    private int edad;
    private int idEquipo;

    public Jugador() {
        
    }
    
    public Jugador(int id) {
        this.id = id;
    }

    public Jugador(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Jugador(int id, String nombre, String apellidos, int edad) {
        this(nombre, apellidos, edad);
        this.id = id;
    }

    public Jugador(String nombre, String apellidos, int edad, int idEquipo) {
        this(nombre, apellidos, edad);
        this.idEquipo = idEquipo;
    }

    public Jugador(int id, String nombre, String apellidos, int edad, int idEquipo) {
        this(id, nombre, apellidos, edad);
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // --------- OPERACIONES BD ----------------------------------------
    // ---------- CRUD BÁSICO
    public boolean create() {
        
        boolean todoOk = true;
        try (Connection conn = ConexionBd.obtener())
        {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO jugador (nombre, apellidos, edad, idequipo) VALUES (?,?,?,?)");
            stmt.setString(1, getNombre());
            stmt.setString(2, getApellidos());
            stmt.setInt(3, getEdad());
            stmt.setInt(4, getIdEquipo());

            stmt.executeUpdate();
            
        } catch(SQLException ex) {
            todoOk = false;
        }
        return todoOk;
    }

    public boolean retrieve() {
        boolean todoOk = true;
        try (Connection conn = ConexionBd.obtener())
        {
            PreparedStatement stmt = conn.prepareStatement("SELECT nombre ,apellidos, edad ,idequipo FROM jugador where id = ?");
            stmt.setInt(1, getId());
            
            try(ResultSet rs = stmt.executeQuery()){
                rs.next();
                setNombre(rs.getString(1));
                setApellidos(rs.getString(2));
                setEdad(rs.getInt(3));
                setIdEquipo(rs.getInt(4));
            }
            
        } catch(SQLException ex) {
            todoOk = false;
        }
        return todoOk;
    }

    public boolean update() {
        
        boolean todoOk = true;
        try(Connection conn = ConexionBd.obtener())
        {
            try(PreparedStatement stmt = conn.prepareStatement("UPDATE jugador SET nombre = ?, "
                    + "apellidos = ?, edad = ?, idequipo = ? where id = ?"))
            {
                stmt.setString(1,getNombre());
                stmt.setString(2,getApellidos());
                stmt.setInt(3,getEdad());
                stmt.setInt(4,getIdEquipo());
                stmt.setInt(5,getId());
                stmt.executeUpdate();
            }
        }catch(SQLException ex){
            todoOk = false;
        }
        return todoOk;
    }

    public boolean delete() {
        
        boolean todoOk = true;
        try(Connection conn = ConexionBd.obtener())
        {
            try(PreparedStatement stmt = conn.prepareStatement("DELETE FROM jugador WHERE id = ?"))
            {
                stmt.setInt(1, getId());
                stmt.executeUpdate();
            }
        }catch(SQLException ex){
            todoOk = false;
        }
        return todoOk;
    }

    // ----------- Otras, de clase, no relacionadas con ÉSTE (this) objeto
    public static List<Jugador> obtenerJugadores(String busqueda, boolean esJunior, boolean esClass, boolean esMaster) {
        /* Junior:  14 años o más y menos de 18.
        Class: 18 o más y menos de 26.
        Master: 26 años o más. */

        String sql = "";
        
        if(!busqueda.equals("") && esJunior){
            sql = "SELECT id, nombre ,apellidos ,edad, idequipo FROM jugador WHERE edad < 18 AND nombre LIKE lower(?) OR apellidos LIKE lower(?)";
        }else if(!busqueda.equals("") && esClass){
            sql = "SELECT id, nombre ,apellidos ,edad, idequipo FROM jugador WHERE edad >= 18 AND edad < 26 AND nombre LIKE lower(?) OR apellidos LIKE lower(?)";
        }else if(!busqueda.equals("") && esMaster){
            sql = "SELECT id, nombre ,apellidos ,edad, idequipo FROM jugador WHERE edad >= 26 AND nombre LIKE lower(?) OR apellidos LIKE lower(?)";
        }else if(busqueda.equals("") && esJunior){
            sql = "SELECT id, nombre ,apellidos ,edad, idequipo FROM jugador WHERE edad < 18";
        }else if(busqueda.equals("") && esClass){
            sql = "SELECT id, nombre ,apellidos ,edad, idequipo FROM jugador WHERE edad >= 18 AND edad < 26";
        }else if(busqueda.equals("") && esMaster){
            sql = "SELECT id, nombre ,apellidos ,edad, idequipo FROM jugador WHERE edad >= 26";
        }else if(!busqueda.equals("")){
            sql = "SELECT id, nombre ,apellidos ,edad, idequipo FROM jugador WHERE nombre LIKE lower(?) OR apellidos LIKE lower(?)";
        }else if(busqueda.equals("")){
            sql = "SELECT id, nombre ,apellidos ,edad, idequipo FROM jugador";
        }
        
        List<Jugador> resultado = new ArrayList<>();
        
         try (Connection conn = ConexionBd.obtener())
         {
            PreparedStatement stmt = conn.prepareStatement(sql);
            if(!busqueda.equals("")){
                stmt.setString(1, '%' + busqueda + '%');
                stmt.setString(2, '%' + busqueda + '%');
            }
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next()){
                    resultado.add(new Jugador(rs.getInt(1), rs.getString(2),
                            rs.getString(3),rs.getInt(4),rs.getInt(5)));
                }
            }  
        } catch(SQLException ex) {
            ex.printStackTrace();
        } 
        return resultado;
    }
}