#Lista con dos valores y ordenarla(Primer valor es la altura y el segundo el peso)
lista1 = [
    (24,5),
    (50,6),
    (24,3),
    (40,4),
    (40,1),
]
#Muestra la lista ordenada de mayor a menor altura y si hay alguna igual a otra(Como vemos en el ejemplo con el 24 y el 40) la ordena de menor a mayor esas dos que son iguales y eso lo hace el (-) que le ponemos en la -listaDef[0].
print(sorted(lista1, key=lambda listaDef: (-listaDef[0], listaDef[1])))