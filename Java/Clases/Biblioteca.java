import java.util.Date;
import java.util.Calendar;
public class Biblioteca{


	//EJEMPLAR
	public class Ejemplar{
		
	private String editorial;
	private int ISBN;
	private int anyo;
	private Socio prestadoA;
	private Obra obra;
	
		//Constructor
		public Ejemplar(String editorial, String ISBN, Obra obra){
	
		this.editorial = editorial;	
		this.ISBN = ISBN;
		this.obra = obra;
		}
		
		//toString()
		@Override
		public String toString(){}
	
		
		//Getters
		
		public String getEditorial() {
		return this.editorial;
		
		}
			
		public long getISBN() {
		return this.ISBN;
		
		}
	
	
		public int getAnyo() {
		return this.anyo;
			
		}
	
		public Socio getPrestadoA() {
		return this.prestadoA;
		
		}
		
		
		//Setters
		public void setAnyo(int any){
			this.anyo = any;
		}
	
		public setPrestadoA(Socio socio){
			this.prestadoA = socio;
		}	
		
		public void setEditorial(String editorial) {
			this.editorial = editorial;
		}
	
		public void setISBN(String ISBN){
			this.ISBN = ISBN;
		}
		
		
	}

	//OBRA
	public abstract class Obra{

	private String titulo;


		//Constructor
		public Obra(String titulo){
		this.titulo = titulo;
	
		}
		
		//Getters
		public String getTitulo(){
			return this.titulo;
		}
		
		//Setters
		public void String setTitulo(String titulo){
			this.titulo =titulo;
		}
		
		//Abstract
	
		@Override
		public abstract String toString();

		public abstract int getNumPrestramos();

	}

	
	//LIBRO
	public class Libro extends Obra{

	private String autor;
	private int numPrestamos;

		//Constructor
		public Libro(String titulo, String autor){
			super(titulo);
			this.autor = autor;
			this.numPrestamos =0;
		}
		
		//Getters
		
		public String getAutor(){
			return this.autor;
		}
		public int GetNumPrestamos(){
			return this.numPrestamos;
		}
		
		//Setters
		public void setAutor(String autor){
			this autor = autor;
		}
		public void setNumPrestamos(){
			this.numPrestamos++;
		}


	}

	//REVISTA

	public class Revista extends Obra{
	
		private int mes;
	
			//Constructor
			public Revista(String titulo, int mes){
			super(titulo);
			this.mes = mes;
		
			}
			
			//Getters
			public int getMes(){
				return this.mes;
			}
			
			//Setters
			public void setMes(int mes){
				this.mes =mes;
			}
	
	}
	
	
	//PRESTAMO
	public class Prestamo{

	private Date desde;
	private Date hasta;
	private Date devuelto;
	private Ejemplar ejempla;
	private Socio soci;
		
		public Prestamo(Ejemplar ej Socio socio){
		this.ejempla = ej;
		this.soci = socio;	
		}
		
		//Getters
	
		public Date getDesde() {
		return this.desde;
		}
	
		public Date getHasta() {
		return this.hasta;
		}
	
		public Date getDevuelto() {
		return this.devuelto;
		}
		
		//Fechas 
	
		public void setDesde(){
		this.desde = new Date();
		}	


		public void setHasta(){
		
		this.hasta = this.getDesde();
		Calendar c = Calendar.getInstance();
		c.setTime(this.hasta);
        c.add(Calendar.DATE, 15);
        this.hasta = c.getTime();
		
		}
	
		public void setDevuelto(){
		this.devuelto = new Date();
		this.ejempla.setPrestadoA(null);
		
		}
	
	}
	
	
	//SOCIO
	public class Socio implements Prestable{

	private int carnet;
	private String nombre;
	private boolean bloqueado;

		//Constructor
		public Socio(){}

		//Getters
		public int getCarnet(){
			return this.carnet;
		}

		public String getNombre(){
			return this.nombre;
		}

		public boolean getBloqueado(){
			return this.bloqueado;
		}
		
		//Setters
		
		public void setCarnet(int carnet){
		this.carnet = carnet;
		}
		
		public void setNombre(String nombre){
		this.nombre=nombre;	
		}
		
		public void setBloqueado(boolean bloqueado){
		this.bloqueado = bloqueado;	
		}
		
		

	}


	//PRESTABLE
	
	public interface Prestable{

		//Metodos
		public Prestamo solicitaPrestamo(Ejemplar e);
	
		public void devolverPrestamo(Prestamo p);
	
		public void pagaSancion(int importe);
	
	}


public static void main(String [] args){
	
	//Libros
	Libro libro1 = new Libro("Ejemplo de Libro1","Ej1");
	Libro libro2 = new Libro("Ejemplo de Libro2","Ej2");
	
	
	//Revista
	Revista revista1 = new Revista("Ejemplo de Revista",03)
	
	//Ejemplar
	Ejemplar ejemplar1 = new Ejemplar("Editorial1","ISBN1",libro1);
	Ejemplar ejemplar2 = new Ejemplar("Editorial2","ISBN2",libro2);
	Ejemplar ejemplar3 = new Ejemplar("Editorial3","ISBN3",revista1);
	
	//Socio
	Socio socio1 = new Socio();
	socio1.setCarnet(1);
	socio1.setNombre("Rafa");
	socio1.setBloqueado(false);
	
}


}