Feature: Login Data Driven with Excel

  @sanity @regression
  Scenario Outline: Login Data Driven Excel scenario outline
    Given user on login page
    When the user shuld be redirected to MyAccount Page by passing email and password via excel row "<row_index>"

    Examples: 
				| row_index |
				|					1	|
				|					2	|
				|					3	|
				|					4	|
				|					5	|

