#Funcion Suma
def suma(x,y):
    return x+y


#Funcion duplicar los valores de la lista
def lista(list=[]):
    numero:int
    for i in range(len(lista1)):
        numero = lista1[i]
        numero = numero*2
        lista1[i] = numero
    
#Funcion duplicar los valores de la lista sin modificar la original 
def listaSinModificar(list=[]):
    numero:int
    listaCopia = []
    for i in range(len(list)):
        listaCopia.append(list[i])

    for i in range(len(listaCopia)):
        numero = listaCopia[i]
        numero = numero*2
        listaCopia[i] = numero
        
    return listaCopia[:]

#Ver si funciona la funcion Suma
print(suma(2,2))
#Ver si funciona la funcion Lista
lista1 = [1,2,3]
lista(lista1)
print(lista1[:])

#Ver si funciona la funcion la Lista2
lista2 = [1,2,3]
print(listaSinModificar(lista2))
print(lista2[:])
