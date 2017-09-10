package py.gpi.uaa.agenda.docentes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import py.gpi.uaa.agenda.docentes.model.Certificacion;
import py.gpi.uaa.agenda.docentes.model.Docente;

public class CertificacionDao {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/agenda";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "uaa123";

	public CertificacionDao() {
	}

	public boolean insertarCertificacion(Certificacion certificacion) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "insert into certificacion (id_certificacion, id_docente, id_materia) values (?,?,?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			// campos

			preparedStatement.setString(1, certificacion.getIdCertificacion());

			// docente
			if (certificacion.getDocente() != null) {
				preparedStatement.setString(2, certificacion.getDocente().getNombreDocente());
			} else {
				preparedStatement.setNull(2, Types.CHAR);
			}

			// materia
			if (certificacion.getMateria() != null) {
				preparedStatement.setString(3, certificacion.getMateria().getIdMateria());
			} else {
				preparedStatement.setNull(3, Types.CHAR);
			}

			preparedStatement.executeUpdate();

			System.out.println("[CERTIFICACION]: Ingresado correctamente.");
			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}

	public boolean eliminarCertificacion(Certificacion certificacion) {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = " delete from certificacion where id_certificacion = ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);

			preparedStatement.setString(1, certificacion.getIdCertificacion());

			preparedStatement.executeUpdate();

			System.out.println("[CERTIFIACION]: Registro eliminado.");
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
