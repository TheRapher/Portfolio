package DI.RafaHermosilla_ProyectoFinal;


public class Usuario {

	private String nombre;
	private String contraseña;
	private String correo;
	private String tipo;
	private String verificacion;
	public Usuario(String nombre, String contraseña, String correo,String tipo,String verificacion) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.correo = correo;
		this.tipo = tipo;
		this.verificacion = verificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getVerificacion() {
		return verificacion;
	}
	public void setVerificacion(String verificacion) {
		this.verificacion = verificacion;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contraseña=" + contraseña + ", correo=" + correo + ", tipo=" + tipo
				+ ", verificacion=" + verificacion + "]";
	}
	

	
}
