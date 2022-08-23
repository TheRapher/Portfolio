"""La diferencia entre Shallow copy y Deep copy.
Basicamente la Shallow copy construye un objeto de coleccion y 
luego lo prueba con las referencias a los objetos secundarios que estan en el origin y la 
Deep copy hace que el proceso de la copia sea recursiva.
"""

"""Crear una lista"""    
lista = []
    
#Meter un elemento a la lista
lista.append(1)

#Sacar un elemento de la lista
lista.pop()

"""Crear una lista con los 4 ultimos elementos de otra lista y
en la lista metemos 5 numeros"""
for i in range(5):
    lista.append(i)

#Creamos la nueva lista y metemos sus ultimos 4 numeros y la imprimimos
lista2 = []

lista2 = lista[1:]

print(lista2[:])

#Clonar una lista

listaClonada = []
listaClonada = lista2[:]
print(listaClonada[:])

#Convertir una cadena en una lista

cadena ="H O L A M U N D O"
listaClonada = cadena.split()
print(listaClonada[:])

