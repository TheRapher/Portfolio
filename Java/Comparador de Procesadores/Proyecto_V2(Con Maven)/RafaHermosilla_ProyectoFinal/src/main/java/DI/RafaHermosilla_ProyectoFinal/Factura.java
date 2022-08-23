package DI.RafaHermosilla_ProyectoFinal;

public class Factura {
	private String nombre;
	private String correo;
	private int numero;
	public Factura(String nombreApellidos, String correo2, int numFactura) {
		super();
		nombre = nombreApellidos;
		correo = correo2;
		numero = numFactura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombreApellidos) {
		nombre = nombreApellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo2) {
		correo = correo2;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numFactura) {
		numero = numFactura;
	}
	
}
