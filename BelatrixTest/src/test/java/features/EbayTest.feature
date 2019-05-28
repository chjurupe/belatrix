Feature: Automation Exam

Scenario Outline: Belatrix exam
Given User is on Ebay Page
When User search for "<ItemToSearch>"
Then Ebay Page displays the list
When User select Brand "<BrandSelected>"
Then Ebay Page displays the brand list

Examples:
|ItemToSearch	|BrandSelected	|
|Shoes			|Puma			|
