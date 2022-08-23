package DI.RafaHermosilla_ProyectoFinal;
//Creamos la clase contacto para poder hacer contactos en nuestra agenda
public class Tabla {
	    private String caracteristicas;
	    private String primeraCPU;
	    private String segundaCPU;
	    
	    public Tabla(String caracteristicas, String primeraCPU, String segundaCPU) {
	        this.caracteristicas = caracteristicas;
	        this.primeraCPU = primeraCPU;
	        this.segundaCPU = segundaCPU;
	    }

		public String getCaracteristicas() {
			return caracteristicas;
		}

		public void setCaracteristicas(String caracteristicas) {
			this.caracteristicas = caracteristicas;
		}

		public String getPrimeraCPU() {
			return primeraCPU;
		}

		public void setPrimeraCPU(String primeraCPU) {
			this.primeraCPU = primeraCPU;
		}

		public String getSegundaCPU() {
			return segundaCPU;
		}

		public void setSegundaCPU(String segundaCPU) {
			this.segundaCPU = segundaCPU;
		}
	    

}
