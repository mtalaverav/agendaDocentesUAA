package py.gpi.uaa.agenda.docentes.model;

public class Materia {

	private String idMateria;
	private String descripcionMateria;
	private String cargaHoraria;
	private String cantidadCreditos;
	private Facultad facultad;
	
	public Materia() {
	
	}

	public String getCantidadCreditos() {
		return cantidadCreditos;
	}

	public void setCantidadCreditos(String cantidadCreditos) {
		this.cantidadCreditos = cantidadCreditos;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public String getIdMateria() {
		return idMateria;
	}


	public void setIdMateria(String string) {
		this.idMateria = string;
	}

	public String getDescripcionMateria() {
		return descripcionMateria;
	}

	public void setDescripcionMateria(String descripcionMateria) {
		this.descripcionMateria = descripcionMateria;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getCreditos() {
		return cantidadCreditos;
	}

	public void setCreditos(String creditos) {
		this.cantidadCreditos = creditos;
	}

	@Override
	public String toString() {
		return "Materia [idMateria=" + idMateria + ", descripcionMateria=" + descripcionMateria + ", cargaHoraria="
				+ cargaHoraria + ", cantidadCreditos=" + cantidadCreditos + ", facultad=" + facultad + "]";
	}

}
