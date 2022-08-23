#Importamos nuestras clases
from Escola import Escola
from Profesor import Profesor
from Alumno import Alumno

#Creamos dos colegios diferentes
colegio1 = Escola("Serra","Torrent","Sergi")
colegio2 =Escola("Bonavista","Alaquas","Paco")

#Creamos dos profes diferentes
profe1=Profesor("Sergi","Ciencias")
profe2=Profesor("Jose","Ciencias")

#Creamos dos alumnos diferentes
alumno1=Alumno("Rafa","2DAM",profe1)
alumno2=Alumno("Pepe","2DAM",profe2)

#Insertamos los profesores en el primer colegio
colegio1.insertarProfesor(profe1)
colegio1.insertarProfesor(profe2)

#Insertamos los alumnos en el primer colegio
colegio1.insertarAlumno(alumno1)
colegio1.insertarAlumno(alumno2)

#Y ahora insertamos un alumno y un profesor en el otro colegio pero este nos saldra el mensaje de que no se puede ya que el alumno y profesor ya estan dentro de otro colegio
colegio2.insertarAlumno(alumno1)
colegio2.insertarProfesor(profe1)

#Imprimimos el colegio
print(colegio1)
