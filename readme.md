# Proyecto Integral 

El presente documento, es el **Proyecto Integrador** de ***Argentina Program 4.0***. Esta es una pequeña solución informática que sirve para realizarle consultas a y gestionar un sistema de reportes.
La misma implementa buenas prácticas de programación.

#### Especificaciones
- Autor: Bernardo Royo
- contacto : Royo2193@gmail.com
- Versión: 1.0.1

#### Requerimientos
- Java version 17
- JDK version 17
- Spring Boot  version 3.2.0
- Maven version 4.0.0
- Hibernate version 3.5.4-Final
- Hibernate-core version 5.5.7.Final
- slf4j-simple version 1.7.5
- mysql-connector-java version 8.0.23
- lombok
- spring-boot-starter-test
- jaxb-api version 2.3.1
- jaxb-impl version 2.3.1
- joda-time version 2.12.5
- IDE - Intellij Idea
- MYSQL Workbench 8.0 CE
- Documentado en Markdown



#### Estructura de directorios
``` tree


    SistemaDeReportes
    ├────  .mvn
    │       └── wrapper
    │           └── maven-wrapper.jar
    │           └── maven-wrapper.properties
    ├────  src
    │      └── main
    │      │  └──java
    │      │  │  └──com.JavaIntermedioUTN
    │      │  │     └──Controladores
    │      │  │     │  └──ControladorDeCliente.java
    │      │  │     │  └──ControladorDeTecnicos.java
    │      │  │     └──DTOs
    │      │  │     │  └──ClienteDTO.java
    │      │  │     └──Modelos
    │      │  │     │  └──Caso.java
    │      │  │     │  └──Cliente.java
    │      │  │     │  └──Especialidad.java
    │      │  │     │  └──Problema.java
    │      │  │     │  └──Reporte.java
    │      │  │     │  └──Servicio.java
    │      │  │     │  Tecnico.java
    │      │  │     └──Servicios
    │      │  │     │  └──ServicioDeClientes.java
    │      │  │     └──SistemaDeReportes
    │      │  │     │  └──ConectorMySQL.java
    │      │  │     │  └──ServicioDeReportes.java
    │      │  │     └──SistemaDeReportesApplication.java
    │      │  │       
    │      │  └──resources
    │      │      └──application.properties
    │      │      └──hibernate.cfg.xml
    │      └──test
    │         └──SistemaDeReportesApplicationTests
    │   
    │
    ├──.gitignore
    ├──CREARBASEDEDATOSYCARGARDATOS.sql
    ├──DER base de datps.mwb
    ├──DER base de datos.mwb.bak
    ├── mvnw
    ├── mvnw.cmd
    ├── poom.xml
    └── readme.md
```

---
### CONFIGURACION DE ENTORNO
- #### VARIABLES DE ENTORNO
- Debera completar sus credenciales en el archibo hibernate.cfg.xml en la carpeta resources para poder acceder a la BD
  ``` js
    PORT=3306
    HOST="Ingrese un Host"
    DATABASE= incidentes
    <property name="hibernate.connection.username">INGRESESUUSUARIO</property>
    <property name="hibernate.connection.password">INGRESESUCONTRASEÑA</property>
  
  ```





## CORRER API
Se debe correr el archivo "CREARBASEDEDATOSYCARGARDATOS.sql" ,el mismo generara la base de datos local para poder utilizar la api correctamente.


### CORRER EL SERVIDOR HTTP
   El mismo corre en el puerto 9290 y se levantara una vez que se de run a la aplicacion dede el archivo main SistemaDeReportesApplication.



## Métodos HTTP
#### En este proyecto todos los metodos solicitados son de consulta , las URL son las siguientes:

| Tipo   | URI                                                | Descripción                   |
|--------|----------------------------------------------------|-------------------------------|
| GET    | http://localhost:9290/clientes/                     | Servirá información de todas las categorías existentes |
| POST   | http://localhost:9290/clientes/                     | Crea una nueva entidad        |
| DELETE | http://localhost:9290/clientes/       | Elimina un Cliente            |
| GET    | http://localhost:9290/tecnicos/masIncidentesResueltos | Filtra Tecnicos que resolvieron mas incidentes en "x" cantidad de dias |
| GET    | http://localhost:9290/tecnicos/masIncidentesPorEspecialidad | Filtra por dias y expecilidad |
| GET    |http://localhost:9290/tecnicos/masRapidoIncidentesResueltos | Filtra por Velocidad de un tecnico  para resolver problemas|






### Observaciones :
Para utilizar el metodo POST es necesario pasarle un numero de cuit de tipo String , una razon social de tipo String y un emailCliente de tipo String.
Para utilizar el metodo DELETE es necesario pasarle un cuit valido dentro de la BD

-

 