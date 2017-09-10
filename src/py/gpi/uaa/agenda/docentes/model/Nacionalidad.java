package py.gpi.uaa.agenda.docentes.model;

public class Nacionalidad {
	
	private String idNacionalidad;
	private String descripcionNacionalidad;
	
	public Nacionalidad(String idNacionalidad, String descripcionNacionalidad) {
		super();
		this.idNacionalidad = idNacionalidad;
		this.descripcionNacionalidad = descripcionNacionalidad;
	}
	
	public Nacionalidad(){
		
	}

	public String getIdNacionalidad() {
		return idNacionalidad;
	}

	public void setIdNacionalidad(String idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public String getDescripcionNacionalidad() {
		return descripcionNacionalidad;
	}

	public void setDescripcionNacionalidad(String descripcionNacionalidad) {
		this.descripcionNacionalidad = descripcionNacionalidad;
	}

	@Override
	public String toString() {
		return "Nacionalidad [idNacionalidad=" + idNacionalidad + ", descripcionNacionalidad=" + descripcionNacionalidad
				+ "]";
	}
}
