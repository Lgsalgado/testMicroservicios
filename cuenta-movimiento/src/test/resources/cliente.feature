Feature: Crear Cliente

  Background:
    * url 'http://localhost:8080'

  Scenario: Crear un nuevo cliente
    Given request {"nombre": "Juan Osorio","genero": "Masculino","edad": 35,"identificacion": "1706057450","direccion": "13 junio y Equinoccial","telefono": "097548965","contrasena": "1245","estado": true}
    When method post
    Then status 201
