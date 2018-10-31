Feature: Envio da mensagem é oi
  Verifica se enviou o conteudo da mensagem desejado

# Scenario: Sunday isn't Friday
#    Given today is Sunday
#    When I ask whether it's Friday yet
#    Then I should be told "Nope"

#  Scenario: Friday is Friday
#    Given today is Friday
#    When I ask whether it's Friday yet
#    Then I should be told "TGIF"

#  Scenario Outline: Today is or is not Friday
#    Given today is "<day>"
#    When I ask whether it's Friday yet
#    Then I should be told "<answer>"
#
#    Examples:
#    | day | answer |
#    | Friday | TGIF |
#    | Sunday | Nope |
#    | anything else! | Nope |

  Scenario: A mensagem e oi
    Given a message is "oi"
    When I ask chat sent message
    Then I should be told "oi"
