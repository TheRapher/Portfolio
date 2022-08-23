import csv
import sys   
from barcode.writer import ImageWriter
import barcode

#Ruta del fichero .csv
fichero = ""

#Creamos el EAN para que sea ean13 y creamos nuestras listas para guardar la informacion
EAN = barcode.get_barcode_class("ean13")
id =[]
nombre=[]

#Abrimos el fichero y lo recorremos, mientras lo recorremos 
# vamos a guardar la informacion en las listas para luego crear el codigo de barras
with open(fichero)  as File:
    reader = csv.reader(File, delimiter=',', quotechar=',',
                        quoting=csv.QUOTE_MINIMAL)
    for row in reader:
        id.append(row[1])
        nombre.append(row[0])

    #Creamos las imagenes con el nombre que tenemos puesto en .csv y el codigo de barras se crea con nuestra id
    for i in range(len(id)):
        ean = EAN(id[i], writer=ImageWriter())
        ean.save(nombre[i])
