class Notes:
    dicc_Notes = {}
    def __init__(self,dicc_Notes ={}):
        self.dicc_Notes = dicc_Notes

    def mitjana(self):
        media=0
        for i in range(len(list(self.dicc_Notes.values()))):
            media += int(list(self.dicc_Notes.values())[i])
        media = media/len(list(self.dicc_Notes.values()))
        print("La media es "+str(media))

    def mitjanaSenseNoms(self,lista):
        lista = list(self.dicc_Notes.values())
        media =0
        for i in range(len(lista)):
            media += int(lista[i])
        media = media/len(lista)
        print ("La media sin nombres es: "+str(media))
        return lista

    def longitudDicc(self):
        print("Nuestro diccionario tiene "+str(len(self.dicc_Notes.items()))+" elementos")


dicc_Tmp ={"Pepito":"8","Juanito":"10"}
lista = []
ejemplo = Notes(dicc_Tmp)
ejemplo.mitjana()
ejemplo.mitjanaSenseNoms(lista)
ejemplo.longitudDicc()