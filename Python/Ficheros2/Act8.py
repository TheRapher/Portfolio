import shutil
import os

extensiones = ['png','mp4','doc','txt']
#Ubicacion Actual
ubicacion = os.getcwd()
print(ubicacion)
#lista con todos los ficheros 
archivos = os.listdir(ubicacion)
#Creamos dos bucles, uno que es la longitud de las extensiones y otro de los archivos y basicamente lo que hace es coger la extension de un archivo y ver si es igual al de la lista de extensiones
#Si no es asi cambia a otro archivo y asi con todos y una vez terminar de recorrer todos los archivos pasa a la siguiente extension y asi hasta que terminan los for
for i in range(len(extensiones)):   
    for j in range(len(archivos)):
        #Cogemos la extension del archivo
        ruta,extension = os.path.splitext(ubicacion+"/"+archivos[j])
        #Le quitamos el . para hacer la comparacion con la lista
        extension1 = extension.split(".")
        #Sacamos el primer elemento ya que ese elemento es vacio y asi nos quedamos solo con la extension
        extension1.pop(0)
        #Aqui lo que hacemos es ver si esta vacio ya puede ser que se encuentre con una carpeta y eso no tiene extension y eso lo que hace es tener una lista vacia
        if(len(extension1) ==1):
            #Comparamos si son iguales y si lo son se mueve a la carpeta
            if(extension1[0] == extensiones[i]):
                shutil.move(ubicacion+"/"+archivos[j], ubicacion+"/"+extensiones[i]+"/"+archivos[j])
                print("Elemento movido")