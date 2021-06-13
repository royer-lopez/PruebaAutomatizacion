#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: validar titulo del logo
  quiero que al ingresar ala pagina de empleo el usuario pueda dar clic en el logo y me redirecione a la pagina principal de choucair

  @tag1
  Scenario: ir ala  pantalla principal de la pagina
    Given dado que el usuario esta  en la pagina de empleo
    And desea ir a la pagina principal de chhoucair cuando haga clic en el logo
    Then se debe direccionar ala pantalla principal donde finalmente  termina

 