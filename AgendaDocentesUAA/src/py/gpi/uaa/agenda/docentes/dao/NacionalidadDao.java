package py.gpi.uaa.agenda.docentes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.gpi.uaa.agenda.docentes.model.Nacionalidad;

public class NacionalidadDao {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/agenda";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "uaa123";

	public Nacionalidad recuperarNacionalidadPorCodigo(String codigo) {
		Connection dbConnection = null;

		PreparedStatement statement = null;

		String queryRecup = "SELECT * FROM nacionalidad where codigo = ?";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.prepareStatement(queryRecup);

			statement.setString(1, codigo);
			ResultSet rs = statement.executeQuery(queryRecup);

			if (rs.next()) {
				Nacionalidad nacionalidad = new Nacionalidad();

				nacionalidad.setIdNacionalidad(rs.getString(1));
				nacionalidad.setDescripcionNacionalidad(rs.getString(2));

				return nacionalidad;
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}

		return null;
	}

	// recuperar nacionalidades

	public List<Nacionalidad> recuperarNacionalidades() {
		Connection dbConnection = null;
		Statement statement = null;

		String query = "SELECT * FROM nacionalidad";
		List<Nacionalidad> nacionalidades = new ArrayList<Nacionalidad>();

		try {
			dbConnection = getDBConnection();
			ResultSet rs = dbConnection.createStatement().executeQuery(query);
			
			while (rs.next()) {
				Nacionalidad nacionalidad = new Nacionalidad();

				nacionalidad.setIdNacionalidad(rs.getString(1));
				nacionalidad.setDescripcionNacionalidad(rs.getString(2));

				nacionalidades.add(nacionalidad);
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if (statement != null) {
					statement.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}

		return nacionalidades;

	}

	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

}
