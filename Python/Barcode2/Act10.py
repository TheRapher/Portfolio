import os
from pyzbar.pyzbar import decode
import cv2

#Creamos la clase que lee las imagenes
def LeerCodigo(imagen=""):
    #Lee la imagen usando cv2
    img = cv2.imread(imagen)

    #Ver si es un codigo de barras
    detectar= decode(img)
    if not detectar:
        print("Codigo de barras no detectado")
    else:
        for barcode in detectar:
            #Localizar la posicion del codigo en la imagen
            (x,y,w,h) = barcode.rect
            # cv2 para resaltar el código de barras
            cv2.rectangle(img, (x-10, y-10),(x + w+10, y + h+10),(255, 0, 0), 2)
            #Si el codigo de barras no esta vacio pues entramos y ponemos toda la informacion
            if barcode.data!="":
               
                #Metemos dentro de una variable el contenido del codigo de barras como str para que sea textp
                f = str(barcode.data)
                #Si lo ponemos tal cual la variable f nos salen al principio y al final letras y numeros que no nos interesan, asi que la quitamos y nos quedamos con la id
                fi = f[2:-2]
                print("ID de usuario: "+fi) 
                #Y por ultimo cogamos la variable imagen que contiene el nombre del fichero con la extension y lo que hacemos es quitarle la extension y con eso ya tenemos el nombre de usuario
                p = imagen.split(".png")
                print("Nombre de usuario: "+p[0])

#Metemos la ruta donde tengamos los png
ruta = ''

#Metemos todos los nombres de los ficheros en una lista
contenido = os.listdir(ruta)
imagenes = []
#Recorremos la lista y ponemos dentro de otra lista los ficheros .png
for fichero in contenido:
    if os.path.isfile(os.path.join(ruta, fichero)) and fichero.endswith('.png'):
        imagenes.append(fichero)
tmp =""
#Recorremos toda la lista y la metemos a la funcion
for i in range(len(imagenes)):
    tmp = str(imagenes[i])
    LeerCodigo(tmp)