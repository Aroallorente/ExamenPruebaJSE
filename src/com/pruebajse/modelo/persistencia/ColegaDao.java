package com.pruebajse.modelo.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import com.pruebajse.modelo.entidades.Colega;

public interface ColegaDao {

	
	public void alta(Colega colega) throws SQLException;

	public void baja(int id) throws SQLException;
	
	void modificar(Colega colega) throws SQLException ;
	
	public Colega consultaID(int id) throws SQLException;

	public Collection<Colega> consultaTodos() throws SQLException;
}
