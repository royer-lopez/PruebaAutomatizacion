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
Feature: validar Buscador
  como usuario quiero  buscar informacion en la pagina

  @tag1
  Scenario: Encontrar el buscador
    Given el usuario se encuentra en la apgina donde da clic en el icono
    When el usuario procede a llenar el campo y a precionar enter
    Then lee la informacion
    And sale del sistema
