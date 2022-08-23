import bd
from sqlalchemy import Column, Integer, String
#Para poder realizar este ejercicio debemos modificar nuestra clase Alumno y lo primero de todo
#Como vemos arriba hemos importado la bd para poder crear la Base de datos mediante los datos de nuestra clase
#Y luego hemos importado el sqlalchemy con Column, Integer, String
class Alumno(bd.Base):
    #Vamos a llamar a la tabla Alumno
    __tablename__ = 'Alumno'
    #Aqui pondremos lo que tendra nuestras tabla que son la id,nombre,curso y profesor
    #Y si van a ser de tipo String y cual sera la Primary Key
    id = Column(Integer, primary_key=True)
    nombre =Column(String, nullable=False)
    curso=Column(String, nullable=False)
    profesor= Column(String, nullable=False)
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
