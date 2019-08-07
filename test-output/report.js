$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:SingleInput.feature");
formatter.feature({
  "name": "Cucumber BDD Single Input Form Feature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Cucumber BDD Single Input Form Test",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User has navigated to single input form page",
  "keyword": "Given "
});
formatter.match({
  "location": "SingleInput.User_has_navigated_to_single_input_form_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user submits the form",
  "keyword": "When "
});
formatter.match({
  "location": "SingleInput.user_submits_the_form()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user validates the result",
  "keyword": "Then "
});
formatter.match({
  "location": "SingleInput.user_validates_the_result()"
});
formatter.result({
  "status": "passed"
});
});