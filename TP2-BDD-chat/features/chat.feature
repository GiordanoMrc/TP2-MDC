Feature: Envio da mensagem é oi
  Verifica se enviou o conteudo da mensagem desejado

  Scenario Outline: A mensagem e oi
  Given a message is "oi"
  When I ask chat sent message
  Then I should be told "oi"


  Examples:
  | enviado | esperado |
  | oi | oi |
  | "" | erro |
