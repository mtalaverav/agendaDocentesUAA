package py.gpi.uaa.agenda.docentes.model;

public class Facultad {

	private String idFacultad;
	private String descripcion;

	public Facultad() {

	}

	public String getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Facultad [idFacultad=" + idFacultad + ", descripcion=" + descripcion + "]";
	}

}
