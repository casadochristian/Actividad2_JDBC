package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	
private Properties properties;
	
	public void init() {
		//Cargamos el fichero properties que está dentro de nuestro classpath
		try (InputStream ficheroPropiedades = Config.class.getClassLoader()
				.getResourceAsStream("config.properties");){
			properties = new Properties();
			//Cargamos en el objeto properties todos los valores del fichero
			properties.load(ficheroPropiedades);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que devuelve un valor de una propiedad a partir de la clave
	 * @param key la clave de la propiedad
	 * @return valor de la propiedad. Null en caso de que no exista.
	 */
	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}
