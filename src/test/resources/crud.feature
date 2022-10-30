Feature: Verify CRUD requests
  As user
  I want to test CRUD functionality
  so that I can be sure that it works correctly

  Scenario Outline: Check Create call
    Given User create Sweatband
    Then User checks response '<message>'


    Examples:
      | message              |
      | Product was created. |


  Scenario Outline: Check Update call
    Given User update Sweatband
    Then User checks response update call '<message>'

    Examples:
      | message         |
      | Product updated |


  Scenario Outline: Check Get call
    Given User get Sweatband
    Then User checks response id <id>


    Examples:
      | id   |
      | 1010 |


  Scenario Outline: Check Delete call
    Given User delete Sweatband
    Then User checks response delete call '<message>'


    Examples:
      | message              |
      | Product was deleted. |


  Scenario Outline: Check Multivitamins Get call
    Given User get Multivitamins id <id>
    Then User checks response get Multivitamins id


    Examples:
      | id |
      | 18 |