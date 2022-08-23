from Profesor import Profesor
#Creamos una clase Alumano en la que tendremos el nombre del alumno, su curso, el nombre de su profesor
#Y creamos un booleano para que solo este en un instituto
class Alumno:
    nombre =""
    curso=""
    profesor= Profesor()
    instituto=False
    #Constructor de la clase
    def __init__(self,nombre1,curso1,profesorResp):
        self.nombre = nombre1
        self.curso = curso1
        self.profesor = profesorResp

    #Metodo para imprimir
    def __str__(self):
        texto="El alumno es "+self.nombre+" y esta en el curso "+self.curso+" y tiene de tutor al profesor "+self.profesor.nombre
        return texto

    #Metodos para modificar
    def modificarNombre(self,nombre):
         self.nombre=nombre

    #modificar curso
    def modificarCurso(self,curso):
         self.curso=curso

    #modificar responsable del alumno
    def modificarProfesor(self,profesor):
         self.profesor=profesor
