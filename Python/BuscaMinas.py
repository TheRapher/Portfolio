#Lo primero de todo para crear el buscaminas es crear el tablero con las minas
#Preguntaremos por cuantos numeros quiere en la fila y cuantas columnas quiere
try:
    print("Dime la longitud de la fila: ")
    fila:int=  input()
    print("Dime longtitud de la columna: ")
    columna:int=input()
except:
    print("Debes introducir un numero")
tablero= []
#Para crear un tablero crearemos una lista bidimensional asi que vamos a hacer un for con el numero de columas y dentro de el meteremos en la lista tablero otra lista donde iran las filas
#Despues otro for con el numero total de cada fila y lo vamos a ir a agregando a la lista y cuando termine el for ira a la siguiente columna y asi sucesivamente hasta que termine
for i in range(int(columna)):
    tablero.append([])
    for j in range(int(fila)):
        print("Columna: "+str(j))
        print("Fila: "+str(i))
        print ("Pon el numero 0 si no hay minas y -1 si es minas(SOLO UN NUMERO): ")
        filas = input()
        #Si no es 0 o -1 se termina el programa y si es pues agregamos el numero a la lista
        if (filas == '0' or filas == '-1'):
            tablero[i].append(int(filas))
        else:
            print("Debe introducir el numero 0 o -1")
            exit() 


def contandoMinas(lista):
    buscaMinas =[]
    #En este for lo que hacemos es ver si en cada fila hay una bomba(-1) Y si la hay ponemos +1 o +2
    for fila in lista:
        for i in range(len(fila)):
            if fila[i] == -1:
                if fila[i-1] == 0:
                    fila[i-1] = 1
            #Saber posicion del ultimo 1 o 0 para poder avanzar
            if i != len(fila)-1:
                if fila[i+1] == 0:
                    fila[i+1] = 1
                if fila[i] == 1 and fila[i-1] == -1 and fila[i+1] == -1:
                    fila[i]+=1
        print(fila)
        buscaMinas.append(fila)


contandoMinas(tablero)

