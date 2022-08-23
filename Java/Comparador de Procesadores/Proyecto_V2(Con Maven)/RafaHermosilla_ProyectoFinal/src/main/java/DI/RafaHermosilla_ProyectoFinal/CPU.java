package DI.RafaHermosilla_ProyectoFinal;

public class CPU {
	private String nombre;
	private String marca;
	private double frecuenciaReloj;
	private double frecuenciaRelojMax;
	private int numNucleos;
	private int memoriaCache;
	private String enlace;
	private int numHilos;
	
	public CPU(String nombre, String marca, double frecuenciaReloj, double frecuenciaRelojMax, int numNucleos,
			int memoriaCache, String enlace, int numHilos) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.frecuenciaReloj = frecuenciaReloj;
		this.frecuenciaRelojMax = frecuenciaRelojMax;
		this.numNucleos = numNucleos;
		this.memoriaCache = memoriaCache;
		this.enlace = enlace;
		this.numHilos = numHilos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getFrecuenciaReloj() {
		return frecuenciaReloj;
	}

	public void setFrecuenciaReloj(double frecuenciaReloj) {
		this.frecuenciaReloj = frecuenciaReloj;
	}

	public double getFrecuenciaRelojMax() {
		return frecuenciaRelojMax;
	}

	public void setFrecuenciaRelojMax(double frecuenciaRelojMax) {
		this.frecuenciaRelojMax = frecuenciaRelojMax;
	}

	public int getNumNucleos() {
		return numNucleos;
	}

	public void setNumNucleos(int numNucleos) {
		this.numNucleos = numNucleos;
	}

	public int getMemoriaCache() {
		return memoriaCache;
	}

	public void setMemoriaCache(int memoriaCache) {
		this.memoriaCache = memoriaCache;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public int getNumHilos() {
		return numHilos;
	}

	public void setNumHilos(int numHilos) {
		this.numHilos = numHilos;
	}

	@Override
	public String toString() {
		return "CPU [nombre=" + nombre + ", marca=" + marca + ", frecuenciaReloj=" + frecuenciaReloj
				+ ", frecuenciaRelojMax=" + frecuenciaRelojMax + ", numNucleos=" + numNucleos + ", memoriaCache="
				+ memoriaCache + ", enlace=" + enlace + ", numHilos=" + numHilos + "]";
	}
	

	
}
