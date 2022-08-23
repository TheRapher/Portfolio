from functools import reduce

#Ejemplo de funcion lambda
doble =lambda num: num*2
print(doble(2))


#Funcion para saber si nuestra lista es numerica
def esnumero(lista):
    for i in range(len(lista)):
        if lista[i].isdigit() == False:
            print("La cadena solo pueden ser numeros")
            return exit()
        else:
            return lista
#Funcion para eliminar los numeros menores a 10
def menores(lista):
        f:int = int(lista)
        if f < 10:
            return False
        else:
            return True
#Pedir una cadena de numeros
print("Dame una cadena de numeros: ")
cadena = input()

#Creamos la lista y agregamos la cadena
per1 =[]
per1 = cadena.split()

#Llamamos a la funcion esnumero para saber si es un numero 
# y si no lo es acaba el programa y no sigue
listaNumeros = list(map(esnumero,per1))

#Pasamos la lista a una lista de enteros
for i in range(len(listaNumeros)):
    listaNumeros[i] = int(listaNumeros[i])

#Llamamos a la funcion listaNumeros para saber si es un numero > 10 
# y lo los que no los elimina
ListaNumerosMayores = list(filter(menores,listaNumeros))

#Hacemos la multiplicacion
print(reduce(lambda x, y: x*y,ListaNumerosMayores))