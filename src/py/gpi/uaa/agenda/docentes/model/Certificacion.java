package py.gpi.uaa.agenda.docentes.model;

public class Certificacion {

	private String idCertificacion;
	private Docente docente;
	private Materia materia;

	public Certificacion() {
	}

	public String getIdCertificacion() {
		return idCertificacion;
	}

	public void setIdCertificacion(String idCertificacion) {
		this.idCertificacion = idCertificacion;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "Certificacion [idCertificacion=" + idCertificacion + ", docente=" + docente + ", materia=" + materia
				+ "]";
	}

}
