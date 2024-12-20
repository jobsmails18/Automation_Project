Feature: Espncricinfo HomePage Validation

	Scenario: verify search field functionality
		Given I navigate to the Espncricinfo url "https://www.espncricinfo.com/"
		When I enter "Hello" in search field
		Then I should see the search result "Hello"
		And  Url is "https://search.espncricinfo.com/ci/content/site/search.html?search=Hello"
