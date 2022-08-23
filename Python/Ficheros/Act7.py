import sys
#La funcion esPrimo lo que hace es saber si nuestro numero es primo o no
def esPrimo(tmp):
    #Lo que hacemos es hacer un bucle desde el numero 2 hasta nuestro numero y ver si nuestra "n" puede dividir al nuestro y si lo hace no es primo
    for n in range(2,tmp):
        if tmp % n == 0:
            return False
    return True
#La funcion esPalindromo para saber si un numero es igual si le damos la vuelta
def esPalindromo(tmp:int):
    #Si el numero es de un digito es Palindromo
    if tmp >=0 and tmp <10:
        return True
    #Combertimos nuestro numero es String y si el numero es igual a el numero al reves es Palindromo
    if str(tmp) == str(tmp)[::-1]:
        return True
    return False
#Comprobar con doctest
if __name__ == "__main__":
    import doctest
    doctest.testmod()

listaNum:int = []

#Cogemos los nombres de los ficheros que tendremos que pasar por consola
ficheros = sys.argv
entrada = str(ficheros[1])
salida = str(ficheros[2])

#Abrimos el fichero y guardamos los numeros en una lista
f = open(entrada, "r")
numeros = f.read().split('\n')
listaNum = numeros
f.close()

#Imprimimos los numeros
for i in range(len(listaNum)):
    print(listaNum[i])

#Creamos contadores y listas para almacenar toda la informacion
contPalindromo = 0
contPrimos = 0
primos = []
palindromo = []


#Saber cuantos numeros son Palindromos
for i in range(len(listaNum)):
    if esPalindromo(int(listaNum[i])):
        contPalindromo += 1
        palindromo.append(listaNum[i])

#Saber cuantos numeros son Primos
for i in range(len(listaNum)):
    if esPrimo(int(listaNum[i])):
        contPrimos += 1
        primos.append(listaNum[i])



#Abrimos el archivo de salida para meter la informacion dentro
with open(salida, 'w') as f:
    f.write("Hay "+str(contPalindromo)+" numeros palindromos\n")
    f.write("Hay "+str(contPrimos)+" numeros primos\n")

    #Meter los numeros Palindromos y primos que son iguales
    for i in range(len(primos)):
        for j in range(len(palindromo)):
            if primos[i] == palindromo[j]:
                f.write(primos[i]+"\n")
f.close()