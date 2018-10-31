module ChatStepHelper #modulo para exemplo(poderia ser uma classe)!

  def chat(message)
    @responseMessage = message
    @received= FALSE
    @sent= TRUE
    responseMessage
  end
end
World ChatStepHelper

#Given("today is Sunday") do
#  @today = 'Sunday'
#end

#Given("today is Friday") do
#  @today = 'Friday'
#end



#When("I ask whether it's Friday yet") do
#  @actual_answer = is_it_friday(@today)
#end

#Then("I should be told {string}") do |expected_answer|
#  expect(@actual_answer).to eq(expected_answer)
#end


#Given("a mensagem é oi") do
#  @message= "oi"
#end

#When("Quando eu pergunto a mensagem enviada pelo chat") do
#  @actual_answer = "oi"#chat(message)
#end

#Then(" should be told {string}") do |expected_answer|
#  expect(@actual_answer).to eq(expected_answer)
#end

Given("a message is {string}") do |given_message|
  @message= given_message
end

When("I ask chat sent message") do
  @actual_answer = chat(@message)
end

Then("I should be told {string}") do |expected_answer|
  expect(@actual_answer).to eq(expected_answer)
end
