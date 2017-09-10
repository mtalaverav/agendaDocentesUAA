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
import py.gpi.uaa.agenda.docentes.model.Facultad;
import py.gpi.uaa.agenda.docentes.model.Materia;

public class MateriaDao {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/agenda";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "uaa123";
	private FacultadDao facultadDao = new FacultadDao();

	public MateriaDao() {

	}

	public boolean insertarMateria(Materia materia) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "insert into materia (id_materia, descripcion, carga_horaria, cantidad_creditos, facultad) values (?, ?, ?, ?, ?)";
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			// campos

			preparedStatement.setString(1, materia.getIdMateria());
			preparedStatement.setString(2, materia.getDescripcionMateria());
			preparedStatement.setString(3, materia.getCargaHoraria());
			preparedStatement.setString(4, materia.getCantidadCreditos());

			if (materia.getFacultad() != null) {
				preparedStatement.setString(5, materia.getFacultad().getIdFacultad());
			} else {
				preparedStatement.setNull(5, Types.CHAR);
			}

			preparedStatement.executeUpdate();

			System.out.println("[MATERIA]: Ingresado correctamente.");
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

	// eliminar
	public boolean eliminarDMateria(Materia materia) {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE from materia WHERE id_materia = ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);

			preparedStatement.setString(1, materia.getIdMateria());

			// execute delete SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("[MATERIA]: Registro eliminado.");
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
	public boolean actualizarMateria(Materia materia) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String updateSql = "UPDATE materia set descripcion = ?, carga_horaria = ?, cantidad_creditos = ?, facultad = ? WHERE id_materia = ?";

		try {

			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(updateSql);

			preparedStatement.setString(1, materia.getIdMateria());
			preparedStatement.setString(2, materia.getDescripcionMateria());
			preparedStatement.setString(3, materia.getCargaHoraria());
			preparedStatement.setString(4, materia.getCantidadCreditos());

			if (materia.getFacultad() != null) {
				preparedStatement.setString(5, materia.getFacultad().getIdFacultad());
			} else {
				preparedStatement.setNull(5, Types.CHAR);
			}

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

	public List<Materia> recuperarMateria() {

		Connection dbConnection = null;
		Statement statement = null;

		String query = "SELECT * FROM materia";

		List<Materia> materias = new ArrayList<Materia>();

		try {

			dbConnection = getDBConnection();

			statement = dbConnection.createStatement();

			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {

				Materia materia = new Materia();

				materia.setIdMateria(rs.getString(1));
				materia.setDescripcionMateria(rs.getString(2));
				materia.setCargaHoraria(rs.getString(3));
				materia.setCantidadCreditos(rs.getString(4));

				String codigoFacultad = rs.getString(5);
				if (codigoFacultad != null) {
					Facultad facultad = this.facultadDao.recuperarFacultadPorCodigo(codigoFacultad);
					materia.setFacultad(facultad);
				}

				materias.add(materia);

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

		return materias;
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
