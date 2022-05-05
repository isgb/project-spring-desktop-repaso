/**
 * 
 */
package com.devpredator.projectspringdesktop.test;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.devpredator.projectspringdesktop.dao.DisqueraDAO;
import com.devpredator.projectspringdesktop.dao.impl.DisqueraDAOImpl;

/**
 * @author isgb
 * Clase de pruebas unitarias que permite hacer pruebas con Spring
 */
public class SpringDesktopTest {

	@Test
	public void testContext() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		assertNotNull(context); // verificar que el contexto esté cargado
		
		DisqueraDAO disqueraDAO = (DisqueraDAO) context.getBean("disqueraDAO");
		assertNotNull(disqueraDAO);
		
		DisqueraDAO disqueraDAONuevo = (DisqueraDAO) context.getBean("disqueraDAO");
		
		DisqueraDAO disqueraDAOSinSpring = new DisqueraDAOImpl();
		DisqueraDAO disqueraDAOSinSpringNuevo = new DisqueraDAOImpl();
		
		System.out.println("Contexto cargado exitosamente");
		System.out.println(disqueraDAO);
		
		System.out.println(disqueraDAONuevo);
		System.out.println(disqueraDAOSinSpring);
		System.out.println(disqueraDAOSinSpringNuevo);
		
		/*::::::Properties:::::*/
		Properties properties = (Properties) context.getBean("properties");
		System.out.println(properties.get("spring-username"));
	}

}
