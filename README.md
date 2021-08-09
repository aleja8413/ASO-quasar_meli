# ASO-quasar_meli
Challenge Meli 

## Información del proyecto
- Lenguaje: Java
- Compilador: 11
- Base de datos: h2 (En el archivo de propiedades se encuentra la cadena de conexión y se agregar archivo init.sql en la carpeta de resources)
- Swagger
- Maven

## Ejecución del proyecto
- Descargar el repositorio (git clone https://github.com/aleja8413/ASO-quasar_meli.git)
- Abrir el proyecto con IDE de desarrollo o ejecutar mvn package en la raiz del proyecto (Se pone por defecto el puerto 8080)
- En caso de ejecutar el comando package, dirigirse a la carpeta target y ejecutar java -jar ASO-quasar_meli-0.0.1-SNAPSHOT.jar
- Abrir un navegador y copiar la siguiente dirección http://localhost:8080/swagger-ui/ (Allí encontrá los endpoints creados)

## Despliegue
Aplicación desplegada en Heroku: https://aso-fuego-quasar.herokuapp.com/swagger-ui/

## Pruebas
- Se adicionan collections de postman para pruebas locales o desde heroku



