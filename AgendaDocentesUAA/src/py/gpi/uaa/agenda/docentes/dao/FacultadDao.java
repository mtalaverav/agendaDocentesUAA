package py.gpi.uaa.agenda.docentes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.gpi.uaa.agenda.docentes.model.Docente;
import py.gpi.uaa.agenda.docentes.model.Facultad;

public class FacultadDao {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/agenda";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "uaa123";

	public FacultadDao() {
		// TODO Auto-generated constructor stub
	}

	public boolean insertarFacultad(Facultad facultad) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = " insert into facultad (id_facultad, descripcion) values (?, ?) ";

		try {

			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			// campos

			preparedStatement.setString(1, facultad.getIdFacultad());
			preparedStatement.setString(2, facultad.getDescripcion());

			preparedStatement.executeUpdate();

			System.out.println("[FACULTAD]: Ingresado correctamente.");
			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}

		return false;

	}

	public boolean eliminarFacultad(Facultad facultad) {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "delete from facultad where id_facultad = ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);

			preparedStatement.setString(1, facultad.getIdFacultad());
			// execute delete SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("[FACULTAD]: Registro eliminado.");
			return true;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}

		}
		return false;

	}

	public List<Facultad> recuperarFacultades() {
		Connection dbConnection = null;
		Statement statement = null;

		String query = "SELECT * FROM facultad";
		List<Facultad> facultades = new ArrayList<Facultad>();

		try {
			dbConnection = getDBConnection();
			ResultSet rs = dbConnection.createStatement().executeQuery(query);

			while (rs.next()) {
				Facultad facultad = new Facultad();

				facultad.setIdFacultad(rs.getString(1));
				facultad.setDescripcion(rs.getString(2));

				facultades.add(facultad);
			}
		} catch (Exception e) {
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

		return facultades;

	}

	public Facultad recuperarFacultadPorCodigo(String codigo) {
		Connection dbConnection = null;

		PreparedStatement statement = null;

		String queryRecup = "SELECT * FROM facultad where codigo = ?";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.prepareStatement(queryRecup);

			statement.setString(1, codigo);
			ResultSet rs = statement.executeQuery(queryRecup);

			if (rs.next()) {
				Facultad facultad = new Facultad();

				facultad.setIdFacultad(rs.getString(1));
				facultad.setDescripcion(rs.getString(2));

				return facultad;
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
