import sys
import os
import pyperclip

listaPalabras = []
#Guardamos el nombre del archivo
archivo = sys.argv
#Metemos donde estamos ahora mismo que sera donde esta nuestro proyecto
ruta = os.getcwd()
#Agreamos el archivo de texto
ruta += "/"+archivo[1]
#Abrimos el fichero y guardamos las palabras en una lista
f = open(ruta, "r")
numeros = f.read().split('\n')
listaPalabras = numeros
f.close()
#Cremos el portapapeles y guardamos dentro de una variable la frase
pyperclip.copy("Hola Sergi viva Python")
pru = pyperclip.waitForPaste()
#Metemos en una lista cada palabra de la frase
lista = []
lista = pru.split(" ")
#Recorremos la lista de las palabras y la de la lista con cada palabra de la frase
for i in range(len(listaPalabras)):
    for j in range(len(lista)):
        #Vemos si la palabra prohibida esta en la frase si es asi entra en el if y ponemos el upper por si escribimos la palabra con mayus o sin ella
        if listaPalabras[i].upper() == lista[j].upper():
            #Guardamos la longitud de la palabra
            p = len(lista[j])
            #Guardamos cuantos * tiene la palabra
            f = p*"*"
            #Cambiamos la palabra por los *
            lista[j] =lista[j].replace(lista[j],f)
        
#Ahora vamos a meter en una variable la frase entera ya con los *
frase =""
for i in range(len(lista)):
    frase +=lista[i]+" "
#Lo cambiamos por la otra frase y la imprimimos
pyperclip.copy(frase)
print(pyperclip.paste())