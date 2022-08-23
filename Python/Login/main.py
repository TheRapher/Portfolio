from kivy.app import App
from kivy.properties import StringProperty
from kivy.uix.screenmanager import ScreenManager, Screen, SlideTransition
import os
import csv
import hashlib

#Cogemos la  ruta donde esta el fichero de los usuarios
fichero = "/home/rafa/Escritorio/login/user1.csv"
user = []
passw = []
#Lo leemos y metemos los usuarios en la lista que hemos creado para los usuarios
#Y metemos las contraseñas en la lista de las contraseñas
with open(fichero) as File:
    reader = csv.reader(File, delimiter=':', quotechar=':',quoting=csv.QUOTE_MINIMAL)
    for row in reader:
        user.append(row[0])
        passw.append(row[1])

class Login(Screen):
    def do_login(self, usuarioTexto, contraseñaTexto):
        app = App.get_running_app()
        #Cuando le damos al boton creamos un for para recorrer todos lo usuarios y ver si encaja con lo que pone en el login 
        # y lo metemos en dos variables el usuario y la contraseña
        for i in range(len(user)):
            usuarioCSV = str(user[i])
            contraCSV = str(passw[i])
         
            #Convertimos la contraseña que nos da el usuario en sha1 para comparar
            contrasha1 = hashlib.sha1()
            password =contraseñaTexto.encode('utf-8')
            contrasha1.update(password)
            contraUsu = contrasha1.hexdigest()
                #Si el usuario y contraseña de nuestro .csv es igual al que ponemos entra y se guarda el usuario y contraseña 
                # y ponemos en un Label que todo correcto y cerramos el for 
            if (usuarioCSV == str(usuarioTexto) and str(contraCSV)==contraUsu):
                app.usuario = usuarioTexto
                app.contraseña = contraseñaTexto
                self.ids['lbl'].text = "Usuario y contraseña CORRECTOS"
                break
            #Si no es correcto borramos el usuario y contraseña del Editor de texto y ponemos en el Label que es incorrecto
            else:
                self.ids['usuario'].text = ""
                self.ids['contraseña'].text = ""
                self.ids['lbl'].text ="Usuario o Contraseña INCORRECTOS"
        app.config.read(app.get_application_config())
        app.config.write()

class LoginApp(App):
    usuario = StringProperty(None)
    contraseña = StringProperty(None)
    #Crea la aplicacion y agrega lo que le pusimos en la clase Login
    def build(self):
        manager = ScreenManager()

        manager.add_widget(Login(name='login'))
        return manager
    #Confirma si la configuracion esta bien
    def get_application_config(self):
        if(not self.usuario):
            return super(LoginApp, self).get_application_config()

        conf_directory = self.user_data_dir + '/' + self.usuario

        if(not os.path.exists(conf_directory)):
            os.makedirs(conf_directory)

        return super(LoginApp, self).get_application_config(
            '%s/config.cfg' % (conf_directory)
        )
#Hacemos que se ejecute nuestra aplicacion
if __name__ == '__main__':
    LoginApp().run()