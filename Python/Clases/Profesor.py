#La clase profesor tiene los atributos nombre y tipo y instituto para que solo trabaje en un instituto
class Profesor:
    nombre=""
    tipo=""
    instituto=False
    def __init__(self,nombre="nulo",tipo="nulo"):
        self.nombre=nombre
        #Debemos comprobar si el profesor es de Ciencias o Letras o Mixto si no lo es pues lo ponemos en sin asignar 
        if(tipo == "Ciencias"):
            self.tipo = tipo
        elif(tipo == "Letras"):
              self.tipo = tipo
        elif(tipo == "Mixto"):
            self.tipo = tipo
        else:
            self.tipo = "Sin asignar"

    #Metodo para imprimir
    def __str__(self):
        texto ="El profesor es "+self.nombre+" y es de "+self.tipo
        return texto

    #Metodos para modificar
    def modificarNombre(self,nombre):
        self.nombre=nombre
    
    def modificarTipo(self,tipo):
        self.tipo=tipo
