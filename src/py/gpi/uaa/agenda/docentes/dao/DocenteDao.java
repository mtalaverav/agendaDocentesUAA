package py.gpi.uaa.agenda.docentes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import py.gpi.uaa.agenda.docentes.model.Docente;
import py.gpi.uaa.agenda.docentes.model.Nacionalidad;

public class DocenteDao {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/agenda";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "uaa123";
	private NacionalidadDao nacionalidadDao = new NacionalidadDao();

	public DocenteDao() {
	}

	// insertar registros
	public boolean insertarDocente(Docente docente) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO docente"
				+ "(id_docente, nro_cedula, nombre, apellido, id_nacionalidad, nro_celular, email) VALUES"
				+ "(?,?,?,?,?,?,?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setInt(1, docente.getIdDocente());
			preparedStatement.setString(2, docente.getNumeroCedula());
			preparedStatement.setString(3, docente.getNombreDocente());
			preparedStatement.setString(4, docente.getApellidoDocente());

			if (docente.getNacionalidad() != null) {
				preparedStatement.setString(5, docente.getNacionalidad().getIdNacionalidad());
			} else {
				preparedStatement.setNull(5, Types.CHAR);
			}

			preparedStatement.setString(6, docente.getNumeroCelular());
			preparedStatement.setString(7, docente.getCorreoElectronico());

			preparedStatement.executeUpdate();

			System.out.println("[DOCENTE]: Ingresado correctamente.");
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

	// eliminar registros
	public boolean eliminarDocente(Docente docente) {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		// los parametros del where son en base a la necesidad de la logica de
		// negocio.
		String deleteSQL = "DELETE from docente WHERE nro_cedula = ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);

			preparedStatement.setString(1, docente.getNumeroCedula());

			// execute delete SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("[DOCENTE]: Registro eliminado.");
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

	// actualizar registros
	public boolean actualizarDocente(Docente docente) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String updateSql = "UPDATE docente set nombre = ?, apellido = ?, id_nacionalidad = ?, nro_celular = ?, email = ? WHERE nro_cedula = ?";

		try {

			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(updateSql);

			preparedStatement.setString(1, docente.getNombreDocente());
			preparedStatement.setString(2, docente.getApellidoDocente());

			if (docente.getNacionalidad() != null) {
				preparedStatement.setString(3, docente.getNacionalidad().getIdNacionalidad());
			} else {
				preparedStatement.setNull(3, Types.CHAR);
			}

			preparedStatement.setString(4, docente.getNumeroCelular());
			preparedStatement.setString(5, docente.getCorreoElectronico());
			preparedStatement.setString(6, docente.getNumeroCedula());

			preparedStatement.executeUpdate();

			System.out.println("[DOCENTE: Actualizado correctamente.]");
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

	// recuperar docentes
	public List<Docente> recuperarDocente() {

		Connection dbConnection = null;
		Statement statement = null;

		String query = "SELECT * FROM docente";

		List<Docente> docentes = new ArrayList<Docente>();

		try {

			dbConnection = getDBConnection();

			statement = dbConnection.createStatement();

			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {

				Docente docente = new Docente();

				docente.setIdDocente(rs.getInt(1));
				docente.setNumeroCedula(rs.getString(2));
				docente.setNombreDocente(rs.getString(3));
				docente.setApellidoDocente(rs.getString(4));

				String codigoNacionalidad = rs.getString(5);
				if (codigoNacionalidad != null) {
					Nacionalidad nacionalidad = this.nacionalidadDao.recuperarNacionalidadPorCodigo(codigoNacionalidad);
					docente.setNacionalidad(nacionalidad);
				}

				docente.setNumeroCelular(rs.getString(6));
				docente.setCorreoElectronico(rs.getString(7));

				docentes.add(docente);

			}
		}catch (Exception e) {
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

		return docentes;
	}

	public Docente recuperarDocentePorId(Docente paramDoc) {
		Connection dbConnection = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;

		String query = "select * from docente where id_docente like ?";
		Docente docente = null;

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, "'%" + paramDoc.getIdDocente() + "%'");

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
			
				docente = new Docente();
				docente.setIdDocente(rs.getInt(1));
				docente.setNumeroCedula(rs.getString(2));
				docente.setNombreDocente(rs.getString(3));
				docente.setApellidoDocente(rs.getString(4));

				if (docente.getNacionalidad() != null) {
					preparedStatement.setString(5, docente.getNacionalidad().getIdNacionalidad());
				} else {
					preparedStatement.setNull(5, Types.CHAR);
				}

				docente.setNumeroCelular(rs.getString(6));
				docente.setCorreoElectronico(rs.getString(7));

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

		return docente;
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
