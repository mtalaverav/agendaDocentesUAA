package py.gpi.uaa.agenda.docentes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import py.gpi.uaa.agenda.docentes.model.Curso;
import py.gpi.uaa.agenda.docentes.model.Docente;

public class CursoDao {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/agenda";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "uaa123";

	public CursoDao() {
	}

	public boolean insertarCurso(Curso curso) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO curso (id_curso, id_materia, id_docente, id_turno, seccion, aula, semestre) VALUES (?,?,?,?,?,?,?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			
			preparedStatement.setInt(1, curso.getIdCurso());
			
			if (curso.getMateria() != null) {
				preparedStatement.setString(2, curso.getMateria().getIdMateria());
			} else {
				preparedStatement.setNull(2, Types.CHAR);
			}

			if (curso.getDocente() != null) {
				preparedStatement.setString(3, curso.getDocente().getNombreDocente());
			} else {
				preparedStatement.setNull(3, Types.CHAR);
			}
			
			preparedStatement.setString(4,  curso.getTurno());
			
			preparedStatement.setString(5, curso.getSeccion());
			preparedStatement.setString(6, curso.getAula());

			
			preparedStatement.setString(7,  curso.getSemestre());
			
			preparedStatement.executeUpdate();
			
			System.out.println("[CURSO]: Ingresado correctamente.");
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
	
	public boolean eliminarCursos(Curso curso) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "delete from curso where id_curso = ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, curso.getIdCurso());

			// execute delete SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("[CURSO]: Registro eliminado.");
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
