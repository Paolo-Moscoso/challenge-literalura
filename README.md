# 📚 LiterAlura - Catálogo de Libros

Aplicación de consola desarrollada en **Java con Spring Boot** que permite buscar libros desde la API de **Gutendex**, guardarlos en una base de datos **PostgreSQL** y consultarlos mediante un **menú interactivo**.

Este proyecto fue desarrollado como parte del **challenge LiterAlura** del programa de formación de **Alura**.

---

# 🚀 Tecnologías utilizadas

- ☕ Java 17  
- 🌱 Spring Boot  
- 🗄 Spring Data JPA  
- 🐘 PostgreSQL  
- 🔗 API Gutendex  
- 📦 Maven  
- 📄 Jackson (manejo de JSON)

---

# 📂 Arquitectura del proyecto

El proyecto sigue una **estructura organizada por capas**:

```
src/main/java/com/literalura/challange/
├── ChallangeApplication.java
├── application/
│   └── service/
│       └── LibroService.java
├── domain/
│   ├── model/
│   │   ├── Autor.java
│   │   └── Libro.java
│   └── repository/
│       ├── AutorRepository.java
│       └── LibroRepository.java
├── infrastructure/
│   ├── api/
│   │   ├── ConsumoApi.java
│   │   └── ConvierteDatos.java
│   └── dto/
│       ├── AutorDTO.java
│       ├── LibroDTO.java
│       └── RespuestaGutendexDTO.java
└── presentation/
    └── console/
        └── MenuPrincipal.java
```


---

# ⚙️ Funcionalidades

La aplicación ofrece un **menú interactivo** con las siguientes opciones:

1 - Buscar libro por título
2 - Listar libros registrados
3 - Listar autores registrados
4 - Listar autores vivos en un determinado año
5 - Listar libros por idioma
0 - Salir

---

# 🔎 Funcionalidades detalladas

## 📚 Buscar libro por título

Consulta la **API de Gutendex** y guarda el libro en la base de datos si no existe.

Se almacenan los siguientes datos:

- Título  
- Autor  
- Idioma  
- Número de descargas  

---

## 📖 Listar libros registrados

Muestra **todos los libros almacenados en la base de datos**.

---

## ✍️ Listar autores registrados

Permite visualizar **todos los autores guardados**.

Incluye:

- Nombre  
- Año de nacimiento  
- Año de fallecimiento  

---

## 🧑‍🏫 Listar autores vivos en un año

Permite consultar **qué autores estaban vivos en un año determinado**.

---

## 🌍 Listar libros por idioma

Permite filtrar libros por idioma.

Ejemplos:

es - Español
en - Inglés
fr - Francés
pt - Portugués


---

# 🗄 Base de datos

El proyecto utiliza **PostgreSQL** con dos tablas principales:

## Tabla: autores

| Campo | Tipo |
|------|------|
| id | Long |
| nombre | String |
| nacimiento | Integer |
| fallecimiento | Integer |

## Tabla: libros

| Campo | Tipo |
|------|------|
| id | Long |
| titulo | String |
| idioma | String |
| descargas | Integer |
| autor_id | FK |

### Relación

---

# 🔗 Consumo de API

La aplicación obtiene datos desde:
https://gutendex.com/books/


Se utilizan las clases:

- `HttpClient`
- `HttpRequest`
- `HttpResponse`

para realizar las consultas HTTP.

---

# 🧠 Procesamiento de datos

El JSON obtenido desde la API es convertido a **objetos Java** usando:

- `ObjectMapper`
- `@JsonAlias`

Esto permite **mapear fácilmente los datos recibidos a clases DTO**.

---

# ▶️ Cómo ejecutar el proyecto

## 📋 Requisitos previos

- ☕ Java 17 o superior instalado
- 🐘 PostgreSQL instalado y ejecutándose
- 📦 Maven instalado

## 1️⃣ Clonar repositorio

```bash
git clone https://github.com/Paolo-Moscoso/challenge-literalura.git
```

## 2️⃣ Configurar base de datos

Crear base de datos en PostgreSQL:

```
literalura
```

Configurar en `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=postgres
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 3️⃣ Ejecutar aplicación

Desde el IDE o con Maven:

```bash
mvn spring-boot:run
```
📌 Ejemplo de uso
Ingrese una opción:

1 - Buscar libro por título
Escribe el nombre del libro:
Don Quijote
Libro encontrado:

Título: Don Quijote
Autor: Miguel de Cervantes
Idioma: es
Descargas: 12345
🎯 Objetivo del proyecto

Practicar:

Consumo de APIs REST

Manejo de JSON

Persistencia con JPA

Uso de PostgreSQL

Arquitectura en capas

Aplicaciones de consola con Spring Boot

👨‍💻 Autor

Vicente Paolo Moscoso Lizarazu

Proyecto desarrollado como parte del challenge LiterAlura de Alura.