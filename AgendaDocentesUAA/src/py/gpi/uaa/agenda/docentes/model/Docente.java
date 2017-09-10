package py.gpi.uaa.agenda.docentes.model;

public class Docente {

	private int idDocente;
	private String numeroCedula;
	private String nombreDocente;
	private String apellidoDocente;
	private Nacionalidad nacionalidad;
	private String numeroCelular;
	private String correoElectronico;

	public Docente(int idDocente, String numeroCedula, String nombreDocente, String apellidoDocente,
			Nacionalidad nacionalidad, String numeroCelular, String correoElectronico) {
		super();
		this.idDocente = idDocente;
		this.numeroCedula = numeroCedula;
		this.nombreDocente = nombreDocente;
		this.apellidoDocente = apellidoDocente;
		this.nacionalidad = nacionalidad;
		this.numeroCelular = numeroCelular;
		this.correoElectronico = correoElectronico;
	}
	
	public Docente (){
		
	}

	public int getIdDocente() {
		return idDocente;
	}



	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public String getNumeroCedula() {
		return numeroCedula;
	}

	public void setNumeroCedula(String numeroCedula) {
		this.numeroCedula = numeroCedula;
	}

	public String getNombreDocente() {
		return nombreDocente;
	}

	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}

	public String getApellidoDocente() {
		return apellidoDocente;
	}

	public void setApellidoDocente(String apellidoDocente) {
		this.apellidoDocente = apellidoDocente;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	@Override
	public String toString() {
		return "Docente [idDocente=" + idDocente + ", numeroCedula=" + numeroCedula + ", nombreDocente=" + nombreDocente
				+ ", apellidoDocente=" + apellidoDocente + ", nacionalidad=" + nacionalidad + ", numeroCelular="
				+ numeroCelular + ", correoElectronico=" + correoElectronico + "]";
	}

}
