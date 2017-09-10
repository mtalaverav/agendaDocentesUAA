package py.gpi.uaa.agenda.docentes.model;

public class Turno {

	private String idTurno;
	private String turnoDescripcion;

	public Turno(String idTurno, String turnoDescripcion) {
		super();
		this.idTurno = idTurno;
		this.turnoDescripcion = turnoDescripcion;
	}

	public String getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(String idTurno) {
		this.idTurno = idTurno;
	}

	public String getTurnoDescripcion() {
		return turnoDescripcion;
	}

	public void setTurnoDescripcion(String turnoDescripcion) {
		this.turnoDescripcion = turnoDescripcion;
	}

	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno + ", turnoDescripcion=" + turnoDescripcion + "]";
	}
}
