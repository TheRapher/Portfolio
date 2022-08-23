import random
def realitzaTirada(pPie,pPap,pTij):
    partida:int = random.randint(0, 2)
    if partida ==0:
        pPie = 0
        return pPie
    if partida ==1:
        pPap = 1
        return pPap
    if partida ==2:
        pTij = 2
        return pTij
def jugaNPartides(n):
    jugador1 = 0
    jugador2 = 0
    empates = 0
    tmp1=0
    tmp2=0
    pPie,pPap,pTij=0,0,0
    for i in range(n):
        tmp1 =realitzaTirada(pPie,pPap,pTij)
        tmp2 =realitzaTirada(pPie,pPap,pTij)
        if tmp1 == 0 and tmp2 == 2:
            jugador1 +=1
        elif tmp1 ==1 and tmp2==0:
            jugador1 +=1
        elif tmp1==2 and tmp2==1:
            jugador1 +=1
        elif tmp1 == 2 and tmp2 == 2:
            empates +=1
        elif tmp1 == 1 and tmp2 == 1:
            empates +=1
        elif tmp1 == 0 and tmp2 == 0:
            empates +=1
        else:
            jugador2 +=1
    texto = "Jugador 1: "+str(jugador1)+" Jugador 2: "+str(jugador2)+" Empates: "+str(empates)
    print(comprobarProbabilitat(pPie,pPap,pTij,n))
    return texto
def comprobarProbabilitat(pPie,pPap,pTij,n):
    for i in range(n):

        if realitzaTirada(pPie,pPap,pTij) ==0:
            pPie +=1
        elif realitzaTirada(pPie,pPap,pTij) ==1:
            pPap +=1
        elif realitzaTirada(pPie,pPap,pTij) ==2:
            pTij +=2
    
    pPie = pPie/n*100
    pPap = pPap/n*100
    pTij = pTij/n*100
    texto = "La piedra tiene la posibilidad de "+str(pPie)+"%, el papel tiene un "+str(pPap)+"% y el la tijera un "+str(pTij)+"%"
    return texto
print(jugaNPartides(9))