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
When User Take the first "<NumberProducts>" products
Then Their prices are printed in console
And Also print the list by product name ascendant
And Also print the list by product price descendant
When Assert the order taking the first "<Records>" results


Examples:
|ItemToSearch	|BrandSelected	|StatusSelected		|OrderTypeSelected					|NumberProducts |Records|
|Shoes			|PUMA			|Nuevo				|Precio + Envío: más bajo primero	|5				|5		|
