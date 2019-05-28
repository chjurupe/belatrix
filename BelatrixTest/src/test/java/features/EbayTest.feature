Feature: Automation Exam

Scenario Outline: Belatrix exam
Given User is on Ebay Page
When User search for "<ItemToSearch>"
Then Ebay Page displays the list
When User select Brand "<BrandSelected>"
Then Ebay Page displays the brand list
When User select Status "<StatusSelected>"
Then Ebay Page displays the list
And Number of results is printed
When User orber by "<OrderTypeSelected>"
Then Ebay Page displays the list
When User buy The first "<Records>" Records
#And The Price of First "<Records>" Records are printed

Examples:
|ItemToSearch	|BrandSelected	|StatusSelected		|OrderTypeSelected					|Records|
|Shoes			|PUMA			|Nuevo				|Precio + Envío: más bajo primero	|5		|
