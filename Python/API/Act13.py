import requests  #Importamos la librería requests

print("SOLICITANDO INFORMACION DE INTERNET")
print("espere....") 

#Vamos a coger el total de los personajes para sacarlos todos segun su especie y para ello tendremos que sacar el count
URL = 'https://rickandmortyapi.com/api/character/'
data = requests.get(URL)
data = data.json() 
#Guardaremos en una variable lo que hay en info
info = data['info']
#Buscamos el count y lo guardamos
totalPersonajes = int(info['count'])
totalPaginas = int(info['pages'])

#Preguntamos por la especie que quiere
print("Dime la especie: ")
especie = input()

print("Total del personajes: "+ str(totalPersonajes))
print("Total del paginas: "+ str(totalPaginas))

print ("Mostrando la lista de Personajes...")
print ("Guardandolo en la lista...")
#Creamos un For con todos los personajes que hay y ponemos el total de personajes
for pagina in range(totalPaginas):
    #Creamos la URL el personaje
    URL = 'https://rickandmortyapi.com/api/character?page='+str(pagina)
    #solicitamos la información y guardamos la respuesta en data.
    data = requests.get(URL)
    #Nos guarda la informacion como un JSON
    data = data.json()
    #Ahora deberemos recorrer los results y para ello deberemos hacer un for y ver si la especie es igual a la que pusimos y si no es asi no entra al if y no lo imprime
    for personajes in data["results"]:
        if personajes['species'] == especie:
            print(personajes['name'])