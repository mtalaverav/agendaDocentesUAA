package py.gpi.uaa.agenda.docentes.model;

public class Semestre {

	private int idsemestre;
	private String descripcion;


	public Semestre(int idsemestre, String descripcion) {
		super();
		this.idsemestre = idsemestre;
		this.descripcion = descripcion;
	}

	public int getIdsemestre() {
		return idsemestre;
	}

	public void setIdsemestre(int idsemestre) {
		this.idsemestre = idsemestre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Semestre [idsemestre=" + idsemestre + ", descripcion=" + descripcion + "]";
	}

}
