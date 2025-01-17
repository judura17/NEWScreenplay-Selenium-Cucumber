@Recruitment
Feature: Reclutar candidato

    Scenario: Contratar candidato
    Given Este logueado en la aplicacion
    When Se ingrese al portal de reclutamiento
    And Se postule el candidato
    And Se agende entrevista al candidato
    Then Se contrata el candidato
