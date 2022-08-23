from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

#Lo primero que vamos a hacer en comunicarnos con sqlite y se creara la BD de alumnos.sqlite
engine = create_engine('sqlite:///alumnos.sqlite')
#Ahora vamos a crear una Sesion que basicamente registra los objetos creados, modificados o eliminados
Session = sessionmaker(bind=engine)
sesion = Session()
#Por ultimo para poder interactuar con el ORM nos queda el Base que sirve para mapear de forma automatica de una clase a una tabla
Base = declarative_base()