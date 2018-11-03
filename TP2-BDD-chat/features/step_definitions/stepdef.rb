module ChatStepHelper #modulo para exemplo(poderia ser uma classe)!

  def chat(message)
    @responseMessage = message
    @received= false
    @sent= true
    @responseMessage
  end
end
World ChatStepHelper

Given("a message is {string}") do |given_message|
  @messageTest= given_message
end

When("I ask chat sent message") do
  @actual_answer = chat(@messageTest)
end

Then("I should be told {string}") do |expected_answer|
  expect(@actual_answer).to eq(expected_answer)
end
