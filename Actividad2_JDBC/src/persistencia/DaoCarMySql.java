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
import persistencia.interfaz.DaoCar;

public class DaoCarMySql implements DaoCar {
	
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
	public boolean addCar(Coche c) {
		if(!openConn()){
			return false;
		}
		boolean add = true;
		
		String query = "insert into coches (MARCA,MODELO,AÑO,KM) "
				+ " values(?,?,?,?)";
		try {
			//preparamos la query con valores parametrizables(?)
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, c.getBrand());
			ps.setString(2, c.getModel());
			ps.setInt(3, c.getYear());
			ps.setInt(4, c.getKm());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				add = false;
		} catch (SQLException e) {
			System.out.println("ADD -> Error al insertar: " + c);
			add = false;
			e.printStackTrace();
		} finally{
			closeConn();
		}
		
		return add;
	}

	@Override
	public boolean deleteCarById(int id) {
		if(!openConn()){
			return false;
		}
		
		boolean delete = true;
		String query = "delete from coches where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				delete = false;
		} catch (SQLException e) {
			System.out.println("DELETE -> No se ha podido dar de baja el coche con id " + id);
			e.printStackTrace();
		} finally {
			closeConn();
		}
		return delete; 
	}

	@Override
	public Coche getCarById(int id) {
		if(!openConn()){
			return null;
		}		
		Coche car = null;
		
		String query = "select ID,MARCA,MODELO,AÑO,KM from coches where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				car = new Coche();
				car.setId(rs.getInt(1));
				car.setBrand(rs.getString(2));
				car.setModel(rs.getString(3));
				car.setYear(rs.getInt(4));
				car.setKm(rs.getInt(5));				
			}
		} catch (SQLException e) {
			System.out.println("GET -> error al obtener el coche con id " + id);
			e.printStackTrace();
		} finally {
			closeConn();
		}				
		return car;
	}

	@Override
	public boolean updateCar(Coche c) {
		if(!openConn()){
			return false;
		}
		boolean update = true;
		String query = "update coches set MARCA=?, MODELO=?,AÑO=?,KM=? WHERE ID=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, c.getBrand());
			ps.setString(2, c.getModel());
			ps.setInt(3, c.getYear());
			ps.setInt(4, c.getKm());
			ps.setInt(5, c.getId());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				update = false;
			else
				update = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("UPDATE -> error al modificar el coche" + c);
			update = false;
			e.printStackTrace();
		} finally{
			closeConn();
		}
		
		return update;
	}

	@Override
	public List<Coche> listCars() {
		if(!openConn()){
			return null;
		}		
		List<Coche> carList = new ArrayList<>();
		
		String query = "select ID,MARCA,MODELO,AÑO,KM from coches";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Coche car = new Coche();
				car.setId(rs.getInt(1));
				car.setBrand(rs.getString(2));
				car.setModel(rs.getString(3));
				car.setYear(rs.getInt(4));
				car.setKm(rs.getInt(5));
				
				carList.add(car);
			}
		} catch (SQLException e) {
			System.out.println("LIST -> error al obtener los coches");
			e.printStackTrace();
		} finally {
			closeConn();
		}
		
		
		return carList;
	}

}
