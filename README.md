# BookMe - Sistema de Reservas para Salones de Belleza
## Descripción del Proyecto

BookMe es un sistema de gestión de reservas diseñado para optimizar la administración de citas y servicios en salones de belleza. El sistema permite a los administradores y clientes gestionar horarios, servicios, clientes y generar reportes en formato PDF, mejorando la eficiencia y la experiencia del usuario.

Este proyecto fue desarrollado utilizando Programación Orientada a Objetos (POO) y sigue buenas prácticas de desarrollo de software. Incluye una interfaz gráfica intuitiva y una base de datos para la persistencia de datos.

# Objetivo General

Diseñar y desarrollar un sistema basado en Programación Orientada a Objetos (POO) que cumpla con los requerimientos definidos para la gestión de reservas en salones de belleza, aplicando buenas prácticas de desarrollo de software.

# Requerimientos Funcionales

## Login

El sistema permite el acceso a través de dos roles diferenciados:
- Administrador: Gestiona servicios, horarios, clientes y reportes.
- Empleado: Gestiona reservas, visuliza horarios y servicios ofrecidos por BookMe.
- Cliente: Realiza reservas, consulta horarios y        servicios disponibles.
## Gestión de Información

Registro, actualización y consulta de datos:
- Servicios ofrecidos por el salón (cortes de cabello, manicura, pedicura, etc.).
- Horarios disponibles para cada servicio.
- Información de clientes (nombre, correo, teléfono, etc.).
- Reservas realizadas por los clientes.
## Operaciones Principales

Funcionalidades clave:
- Realizar reservas de servicios.
- Gestionar horarios y disponibilidad.
- Registrar y actualizar información de clientes.
- Generar reportes en formato PDF (facturas de los pagos del cliente).
## Reportes

Generación de documentos en formato PDF:
- Facturas de servicios contratados.

## Persistencia de Datos

El sistema utiliza una base de datos MySQL para almacenar y gestionar la información de manera persistente.Las tablas principales incluyen:
- clientes: Información de los clientes.
- servicios: Catálogo de servicios ofrecidos.
- reservas: Registro de reservas realizadas.
- horarios: Disponibilidad de horarios para cada servicio.
## Tecnologías Utilizadas

- Lenguaje de Programación: Java.
- Base de Datos: MySQL.
- Generación de PDF: iTextPDF.
- Interfaz Gráfica: Swing (Java).
- Control de Versiones: Git y GitHub.
## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes y componentes:

## Login

- Implementación de un sistema de autenticación con al menos dos roles: Administrador y Cliente.

## Gestión de Información

Clases para el registro, actualización y consulta de:
- Servicios (Servicio).
- Horarios (Horario).
- Clientes (Cliente).
- Reservas (Reserva).
## Operaciones Principales

Lógica de negocio para:
- Realizar reservas.
- Gestionar horarios.
- Generar reportes.
## Generación de PDF

- Uso de la librería iTextPDF para crear facturas e informes en formato PDF.
## Persistencia de Datos

- Conexión a una base de datos MySQL mediante JDBC.
- Consultas SQL para gestionar la información.
- Instalación y Uso

## Requisitos Previos

- Java Development Kit (JDK) 8 o superior.
- MySQL Server.
- Librerías adicionales:
- iTextPDF (para generación de PDF).
- MySQL Connector/J (para conexión a la base de datos).
## Pasos para Ejecutar el Proyecto

- Clona el repositorio:
- Configura la base de datos:
- Importa el archivo bookme.sql en MySQL para crear la base de datos y las tablas necesarias.
- Configura las credenciales de la base de datos en el archivo conexion/Conexion.java.
- Compila y ejecuta el proyecto

## Capturas de pantalla

- login 

- Registro

- Panel de gestión del Administrador

- Panel de gestión del Empleado

- Panel de gestión del Cliente

- PDF
