#Tenemos la clase Escuela donde tendremos su nombre, la localidad, el responsable y una lista de alumnos y de profesores
class Escola:
    nombre=""
    localidad=""
    responsable=""
    alumnos= []
    profesor= []

    #Creamos el constructor de la escuela
    def __init__(self,nombre,localidad,responsable):
        self.nombre= nombre
        self.localidad = localidad
        self.responsable = responsable

    #Meter Alumnos y Profesores en un instituto, si alguno de ellos se repite no lo mete   
    def insertarAlumno(self,alumno):
        #Si el alumno no esta en ningun instituto lo mete y si lo esta nos sale el mensaje
        if(alumno.instituto == False):
            self.alumnos.append(alumno)
            alumno.instituto=True
        else:
            print( "¡¡¡El alumno " + alumno.nombre+" no puede entrar en el instituto "  +self.nombre +" por que esta en otro instituto!!!")
    #Hacemos lo mismo que con el metodo anterior pero con los profesores
    def insertarProfesor(self,profesor):
        if(profesor.instituto == False):
            self.profesor.append(profesor)
            profesor.instituto=True

        else:
            print( "¡¡¡El profesor " + profesor.nombre+" no puede entrar en el instituto "  +self.nombre +" por que esta en otro instituto!!!")
  
    #Metodos para modificar Nombre, Localidad y responsable
    def modificarNombre(self,nombre):
         self.nombre=nombre
         
    def modificarLocalidad(self,localidad):
         self.localidad=localidad

    def modificarResponsable(self,responsable):
         self.responsable=responsable


    #Metodo para imprimir    
    def __str__(self):

        #Para poder imprimir todos los alumnos y profesores lo que tendremos que hacer es hacer un for para recorrer toda la lista y meterlo en una varible de tipo String para poder imprimirlo y que no salga como un Objeto
        alumnos=""
        for i in self.alumnos:
            alumnos += str(i) + "\n"

        profesores=""
        for i in self.profesor:
            profesores += str(i) + "\n"

        #Metemos el texto en una varible y eso lo que devolvemos de nuestro metodo
        texto = "Nombre de la escuela "+self.nombre+" localidad "+self.localidad+" el responsable es "+self.responsable +" los alumnos son: \n"+alumnos+" y los profesores son: \n"+ profesores
        return texto