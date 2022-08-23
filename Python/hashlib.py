import hashlib
#Guardar un usuario o varios con su contraseña en una lista
#Se puede hacer de dos formas
#1.Una lista en la que ponemos un usuario y despues la contraseña (lista["usu1","pass1"])
#2.Crear dos listas en la que una se encarga de los usuarios y otra de las contraseñas

#Voy a crear la del primer punto
pass1 = hashlib.new("sha1", b"pass1")
pass2 = hashlib.new("sha1", b"pass2")
pass3 = hashlib.new("sha1", b"pass3")
pass4 = hashlib.new("sha1", b"pass4")
pass5 = hashlib.new("sha1", b"pass5")

listaUsuarios = ["Usu1",pass1,"Usu2",pass2,"Usu3",pass3,"Usu4",pass4,"Usu5",pass5]
print(listaUsuarios[:])

#Crear con un diccionario
dicc_Users = {"Usu1": pass1,"Usu2": pass2,"Usu3": pass3,"Usu4": pass4,"Usu5": pass5}

#Mostrar los usuarios
print(list(dicc_Users.keys()))
#Mostrar las contraseñas
print(list(dicc_Users.values()))
