import random

class Car:
    matricula:int   
    color =""      
    puerta =""
    combustibles =""
    #Constructor
    def __init__(self,matri:int,col="",puert:int=0,combustible=""):
        self.matricula = matri
        self.color = col
        self.puerta = puert
        self.combustibles = combustible
    #Metodo imprimir
    def imprimir(self):
      print("La matricula es: "+str(self.matricula) +" y "+self.color)

    #Metodo combustible
    def combustible(self):
        if(self.combustibles=="Diesel"):
            print("Tienes el mejor combustible")
        elif(self.combustibles=="Gasolina"):
            print("Tienes el peor combustible ")
        elif(self.combustibles=="Electrico"):
            print("Eres ecologico :)")
        else:
            print("Elige Gasolina(1)/Diesel(2)/Electrico(3)")

    #Metodo puertas
    def puertas(self):
        if self.puerta==3:
            print("Tienes un coche con 3 puertas")
        elif self.puerta==5:
            print("Tienes un coche con 5 puertas")
        else:
            print("Error")

#Lista de colores y los tipos de combustibles
tmp=["Red","White","Black","Pink","Blue"]

#Elegir el numero de veces que queremos que salga un coche 3

print("Dime un numero: ")
per1 = int(input())
entero:int = per1

#Blucle para imprimir todos los coches
for i in range(entero):
    if i < 10:
        #Numeros random para elegir numeros aleatorios para el color
        numero:int = random.randint(0, 4)
        #Ponemos el color en una variable
        color = tmp[numero]
        print("")
        #Creamos el coche
        car1=Car(1,color,5,"Gasolina")
        car1.imprimir()
        car1.combustible()
        car1.puertas()