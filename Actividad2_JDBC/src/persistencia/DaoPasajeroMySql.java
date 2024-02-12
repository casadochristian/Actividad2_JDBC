package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Config;
import entidad.Coche;
import entidad.Pasajero;
import persistencia.interfaz.DaoPasajero;

public class DaoPasajeroMySql implements DaoPasajero {
	
private Connection connection;
	
	public boolean openConn(){
		Config config = new Config();
		config.init();
		
		String url = config.getProperty("url");
		String user = config.getProperty("user");
		String password = config.getProperty("password");
		try {
			connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean closeConn(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean addPasajero(Pasajero p) {
		if(!openConn()){
			return false;
		}
		boolean add = true;
		
		String query = "insert into pasajeros (NOMBRE,EDAD,PESO) "
				+ " values(?,?,?)";
		try {
			//preparamos la query con valores parametrizables(?)
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, p.getNombre());
			ps.setInt(2, p.getEdad());
			ps.setDouble(3, p.getPeso());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				add = false;
		} catch (SQLException e) {
			System.out.println("ADD -> Error al insertar: " + p);
			add = false;
			e.printStackTrace();
		} finally{
			closeConn();
		}
		
		return add;
	}

	@Override
	public boolean deletePasajeroById(int id) {
		if(!openConn()){
			return false;
		}
		
		boolean delete = true;
		String query = "delete from pasajeros where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				delete = false;
		} catch (SQLException e) {
			System.out.println("DELETE -> No se ha podido borrar el pasajero con id " + id);
			e.printStackTrace();
		} finally {
			closeConn();
		}
		return delete; 
	}

	@Override
	public Pasajero getPasajeroById(int id) {
		if(!openConn()){
			return null;
		}		
		Pasajero p = null;
		
		String query = "select ID,NOMBRE,EDAD,PESO from PASAJEROS where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				p = new Pasajero();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setEdad(rs.getInt(3));
				p.setPeso(rs.getDouble(4));		
			}
		} catch (SQLException e) {
			System.out.println("GET -> error al obtener el coche con id " + id);
			e.printStackTrace();
		} finally {
			closeConn();
		}				
		return p;
	}

	@Override
	public List<Pasajero> listPasajeros() {
		if(!openConn()){
			return null;
		}		
		List<Pasajero> listPasajeros = new ArrayList<>();
		
		String query = "select ID,NOMBRE,EDAD,PESO from pasajeros";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Pasajero p = new Pasajero();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setEdad(rs.getInt(3));
				p.setPeso(rs.getDouble(4));
				
				listPasajeros.add(p);
			}
		} catch (SQLException e) {
			System.out.println("LIST -> error al obtener los pasajeros");
			e.printStackTrace();
		} finally {
			closeConn();
		}
		return listPasajeros;
	}

	@Override
	public boolean addPasajeroToCoche(Pasajero p) {
		if(!openConn()){
			return false;
		}
		boolean update = true;
		String query = "update pasajeros set IDCOCHE=? WHERE ID=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, p.getCoche().getId());
			ps.setInt(2, p.getId());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				update = false;
			else
				update = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("UPDATE -> error al modificar el pasajero" + p);
			update = false;
			e.printStackTrace();
		} finally{
			closeConn();
		}
		
		return update;
	}

	@Override
	public boolean deletePasajeroFromCoche(int idPasajero, int idCoche) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean listPasajerosByCarId(int idCoche) {
		// TODO Auto-generated method stub
		return false;
	}

}
