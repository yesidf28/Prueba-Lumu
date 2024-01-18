@Suite @Home
Feature: Caso1 - Validar acceso

  Background: Validar el acceso al sitio https://wordcounter.net/
    Given el usuario tiene acceso al sitio web

    @ValidPlaceHolder
    Scenario: 1 - validar que se visualiza el placeholder en el Textarea
      When El placeholder del textarea contiene el texto 'Start typing, or copy and paste your document here...'
      Then Se muestra el texto en el placeholder.

    @ValidNumPalabras
    Scenario: 2 - validar que el sitio muestre el numero de palabras correcto de un texto ingresado
      When Ingresar un texto en el text area que contenga 17 palabras
      Then Se muestra el numero correcto de palabras del texto ingresado en este caso 17

    @ValidNumCaracteres
    Scenario: 3 - validar que el sitio muestre el numero de caracteres correcto de un texto ingresado
      When Ingresar un texto en el text area que contenga 81 caracteres
      Then Se muestra el numero correcto de caracteres del texto ingresado en este caso 81

    @ValidKeywordDensity
    Scenario: 4 - validar que las Keyword Density se muestren correctamente
      When Ingresar un texto en el text area que contenga palabras repetidas
      Then Se muestran correctamente las Keyword density