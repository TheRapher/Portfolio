#Metodo para ver cuantas veces sale un patron, basicamente lo hice con temporales y con varios if
def numPatrones(text):
    #Metemos el texto en una lista, lo que hace es meter cada letra en un espacio de la lista
    lista = list(text.upper())
    #Definimos todas las variables
    tmp0 = 0
    tmp1 = 0
    tmp2 = 0
    tmp3 = 0
    tmp4 = 0
    tmp5 =0
    patron00= 0
    patron101 = 0
    patronABC = 0
    patronHO = 0
    #Recorremos toda la lista
    for i in range(len(lista)):

        #Comprobar patron 00

        #Basicamente si es 0 el primero entra y le sumamos +1 al tmp1 y cuando termina y vuelve a haber otro 0 se suma otro +1
        if(lista[i] == '0'):
          tmp1=tmp1+1
        #Si hay otro 0(000) entra y ponemos el tmp0 a 0 pero el tmp1 a 2, eso significa que entra al if de abajo otra vez
        if(lista[i] == '0' and tmp0 == 1):
           tmp1=2
           tmp0 = 0
        #Cuando el temporal sea 2(00) suma +1 a la varible y ponemos el tmp1 a 0 pero en otro tmp0 lo ponemos a 1
        if(tmp1 == 2):
            patron00 +=1
            tmp1 = 0
            tmp0 = 1
        #Si es diferente de 0 los ponemos a 0 los dos tmps    
        if(lista[i] != '0'):
            tmp0 = 0
            tmp1=0
    

        #Comprobar patron 101
        #Si es 1 entra y en el tmp2 le ponemos 1
        if(lista[i] =='1'):
            tmp2 = 1
        #Si el siguiente numero es 0 y el tmp2 es 1 y el numero anterior de la lista es 1 entra y le ponemos al tmp3 un 1
        if(lista[i] == '0' and tmp2 ==1 and lista[i-1] == '1'):
            tmp3 = 1
        #Si la lista es 1 otra vez pero tmp3 es 1 y el numero anterior es 0 entra y tmp2 a 1 por si acaso hay luego otro 01, el tmp3 a 0 y le ponemos +1 a la veriable
        if(lista[i] =='1' and tmp3 == 1 and lista[i-1] == '0'):
            tmp2 = 1
            tmp3 = 0
            patron101 +=1


        #Comprobar patron ABC
        #Si es una A entra y el tmp4 es 1
        if(lista[i] =='A'):
            tmp4 = 1
        #Si es una B y el tmp4 es 1 y la letra anterior es una A entra y el tmp4 se convierte en 2
        if(lista[i] == 'B' and tmp4 ==1 and lista[i-1] == 'A'):
            tmp4 = 2
        #Si es C y tmp4 es un 2 y la letra anterior es una B entra y ponemos el tmp4 a 0 y le ponemos +1 a la variable
        if(lista[i] =='C' and tmp4 == 2 and lista[i-1] == 'B'):
            tmp4 = 0
            patronABC = patronABC+1


        #Comprobar patron HO
        #Si es una H entra y ponemos 1 al tmp5
        if(lista[i] =='H'):
            tmp5 = 1
        #Si es una O y tmp5 es un 1 y la letra anterior es una H entra y le ponemos +1 a la variable
        if(lista[i] == 'O' and tmp5 ==1 and lista[i-1] == 'H'):
            patronHO += 1
    #Imprimimos
    print("Patron 00 salio:{} veces".format(patron00))
    print("Patron 101 salio:{}veces".format(patron101))
    print("Patron ABC salio:{}veces".format(patronABC))
    print("Patron HO salio:{}veces".format(patronHO))

#Pedimos una cadena de texto y se lo pasamos al metodo
print("Dame una cadena: ")
cadena = input()
numPatrones(cadena)