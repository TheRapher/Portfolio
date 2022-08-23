# Añadir las imagenes
from PIL import Image
# Convertir las imagenes en texto
import pytesseract

# Guardamos nuestra imagen en la variable
img = Image.open("D:/foto_ejemplo.jpg")

# La convertimos en texto
result = pytesseract.image_to_string(img)
#Abrimos el archivo y almacenamos la informacion de la imagen dentro
with open("D:/texto.txt", mode ="w") as file:
    file.write(result)
    print("Hecho")