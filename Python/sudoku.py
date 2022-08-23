sudokuBien = [
    [3,1,2],
    [4,6,8],
    [5,7,9]
]
sudokuMal = [
    [1,2,3],
    [1,2,3],
    [1,2,3]
]
def esSudokuCorrecto(lista):
    #En este for lo que hacemos es ver si en cada fila hay un numero igual y si lo hay devolvemos False, lo que significa que el sudoku esta mal
    for fila in lista:
        #Antes de entrar al if tenemos que entender lo que hace cada cosa, el sorted(list(set(fila)))) lo que hace es si hay algun numero repetido lo elimina y nos lo ordena con el sorted
        #Una vez sabiendo eso lo que hace nuestro if es si la lista es diferente a la lista con el set te dice que el sudoku esta mal ya que en la fila hay un numero repetido
        if sorted(list(set(fila))) != sorted(fila):
            print(set(fila))
            return False

    #Ahora vamos a ver si las columnas estan bien de nuestro sudoku
    columnas= []
    #Crearemos un for con el numero total de la lista y dentro de ese for creamos otro for para la fila de nuestro sudoku
    for columna in range(len(lista)):
        for fila in lista:
            #Aqui almacenamos las columnas entoces por ejemplo para empezar va almacenando de las filas la posicion 0 y cuando termina el for de la fila el for de la columna se pone en uno
            #entoces se vuelve a iniciar el for de la fila pero copia la columna de la posicion 1 y asi hasta que acaba el sodoku
            columnas += [fila[columna]]
            #Y aqui es lo mismo que el if de arriba y es si la lista con el sorted nos ordena los numeros y con elset(quita numeros repetidos) es diferente a la lista de las columnas te devulve False
            if sorted(list(set(columnas))) != sorted(columnas):
                return False
    #Si no entra a ningun if pues te devuelve True y eso significa que el sodoku esta bien
    return True

if esSudokuCorrecto(sudokuBien) == False:
    print("El sudoku esta mal")
else:
    print("El sudoku esta bien")