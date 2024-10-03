# Prueba Técnica 

### Autor: Luis Gabriel Salgado Santamaría 👨‍💻🌐

## Descripción

Esta prueba técnica consiste en el desarrollo de una solución de microservicios utilizando Java Spring Boot y PostgreSQL. La solución se divide en dos microservicios principales:

1. **Microservicio Cliente y Persona**: Maneja las entidades `Cliente` y `Persona`.
2. **Microservicio Cuenta y Movimiento**: Maneja las entidades `Cuenta` y `Movimiento`.

## Tecnologías y Herramientas

- **Java**: Spring Boot
- **Base de Datos**: PostgreSQL
- **IDE**: IntelliJ IDEA 
- **Validación de API**: Postman v9.13.2 
- **Docker**: Para el despliegue de la solución

## Requerimientos

1. **Microservicios**:
   - Separar en dos microservicios: `Cliente` y `Persona`, `Cuenta` y `Movimientos`.
   - Comunicación asincrónica entre los microservicios.

2. **Funcionalidades**:
   - **F1**: CRUD para las entidades `Cliente`, `Cuenta` y `Movimientos` con endpoints `/clientes`, `/cuentas` y `/movimientos`. ✅ 
   - **F2**: Registro de movimientos y actualización de saldo disponible.✅ 
   - **F3**: Manejo de errores de saldo no disponible.✅ 
   - **F4**: Generación de reportes de estado de cuenta con un rango de fechas y cliente.✅ 
   - **F5**: Implementación de una prueba unitaria para la entidad `Cliente`.✅ 
   - **F6**: Implementación de una prueba de integración.✅ 
   - **F7**: Despliegue en contenedores Docker.✅ 

## Funcionalidades de API's que se realizaron (banco.postman_collection.json)

### CRUD

- **Crear Usuario**
  - **URL**: `/clientes`
  - **Método**: POST
  - **Descripción**: Crea un nuevo cliente en el sistema.

- **Obtener Usuario por ID**
  - **URL**: `/clientes/{id}`
  - **Método**: GET
  - **Descripción**: Obtiene los detalles de un cliente específico.

- **Actualizar Usuario**
  - **URL**: `/clientes/{id}`
  - **Método**: PUT
  - **Descripción**: Actualiza los detalles de un cliente específico.

- **Eliminar Usuario**
  - **URL**: `/clientes/{id}`
  - **Método**: DELETE
  - **Descripción**: Elimina un cliente específico del sistema.

- **Crear Cuenta**
  - **URL**: `/cuentas`
  - **Método**: POST
  - **Descripción**: Crea una nueva cuenta bancaria.

- **Obtener Cuenta por ID**
  - **URL**: `/cuentas/{id}`
  - **Método**: GET
  - **Descripción**: Obtiene los detalles de una cuenta específica.

- **Actualizar Cuenta**
  - **URL**: `/cuentas/{id}`
  - **Método**: PUT
  - **Descripción**: Actualiza los detalles de una cuenta existente.

- **Eliminar Cuenta**
  - **URL**: `/cuentas/{id}`
  - **Método**: DELETE
  - **Descripción**: Elimina una cuenta específica del sistema.

- **Crear Movimiento**
  - **URL**: `/movimientos`
  - **Método**: POST
  - **Descripción**: Registra un nuevo movimiento en una cuenta bancaria.

- **Obtener Movimiento por ID**
  - **URL**: `/movimientos/{id}`
  - **Método**: GET
  - **Descripción**: Obtiene los detalles de un movimiento específico.

### Registro de Movimientos

- **URL**: `/movimientos`
- **Método**: POST
- **Descripción**: Actualiza el saldo disponible y registra las transacciones realizadas.

### Manejo de Errores

- **Mensaje**: Mensaje para saldo no disponible.

### Reportes

- **URL**: `/reportes`
- **Método**: GET
- **Descripción**: Obtiene un reporte de estado de cuenta con un rango de fechas y cliente en formato JSON.
- **Parámetros**:
  - `fecha`: Rango de fechas para el reporte.
  - `cliente`: Identificador del cliente para el reporte.

## Casos de Uso

1. **Creación de Usuarios**:
   - Ejemplos de datos para crear clientes.✅ 

2. **Creación de Cuentas de Usuario**:
   - Ejemplos de datos para crear cuentas.✅ 

3. **Realización de Movimientos**:
   - Ejemplos de movimientos.✅ 

4. **Listado de Movimientos por Fechas**:
   - Ejemplo de JSON para listado de movimientos.✅ 

## Pruebas

- **Pruebas Unitarias**:
  - `ClienteTest`: Prueba unitaria para la entidad `Cliente`.
  - `MovimientoServiceImplTest`: Prueba unitaria para el servicio `MovimientoServiceImpl`.

- **Prueba de Integración**:
  - `ClienteRepositoryIntegrationTest`: Prueba de integración para el repositorio `ClienteRepository`.

## Despliegue

- La solución está desplegada en Docker utilizando el archivo `docker-compose.yml`.✅ 

---

