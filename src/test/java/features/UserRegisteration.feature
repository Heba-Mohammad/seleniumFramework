Feature: User Registeration
  I want to check that the user can register in our e-commerce website
  
  Scenario Outline: User Registeration
  Given the user in the home page
  When I click on register link
  And I entered "<firstname>","<lastname>","<email>","<password>"
  Then The registeration page displayed successfully "<email>","<password>"
 
 Examples:
  | firstname | lastname | email | password |
  | ahmed | mohamed | ahmed47@test.com | 12345678 |
  | heba | moh | test37@test.com | 123456789 |
  
  Examples:
  | email | password |
  |ahmed47@test.com | 12345678 |
  | test37@test.com | 123456789 |

