import bd
from Alumno import Alumno
#Por ultimo vamos a crear ya todo como la tabla y su informacion
def run():
    #Aqui pondremos la informacion de la tabla
    rafa = Alumno('Rafa','2DAM','Sergi')
    
    #Y lo añadimos a la sesion 
    bd.sesion.add(rafa)
    print(rafa.id)
    paco = Alumno('Paco','2DAM','Paco')
    bd.sesion.add(paco)

    #Por ultimo, deberemos hacer un commit() de la sesion para confirmar los cambios de la base de datos
    bd.sesion.commit()
    print(paco.id)
if __name__ == '__main__':
    #Esto creara la tabla y metera la informacion en la tabla
    bd.Base.metadata.create_all(bd.engine)
    run()