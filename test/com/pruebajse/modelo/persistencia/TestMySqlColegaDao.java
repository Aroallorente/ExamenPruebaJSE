package com.pruebajse.modelo.persistencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import com.pruebajse.modelo.entidades.Colega;

public class TestMySqlColegaDao {

	@Test
	public void test() {
		Colega colega = new Colega(1, "Aroa", "Lille", new Date());
		
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/examencolega");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		
		MySqlColegaDao sut = new MySqlColegaDao(ds);
		
		
		try {
			sut.alta(colega);
			
			Colega colegaObtenido = sut.consultaID(colega.getId());
			
			
			assertEquals(colega, colegaObtenido);
		}catch (SQLException e){
			e.printStackTrace();
			fail("Se produce un SQLException y no debería: " + e.getMessage());
		}
	}
}
		


