Feature: Upload Profile Picture

  Background:
    When user enters username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option.
    And user clicks on add employee option.

  @ValidPicture @all
  Scenario: Successfully upload a valid profile picture
    When the user uploads a picture "ValidProfilePic.JPG" with maximum size of "1000KB" and dimensions "200x200"
    And  the user enters "Cat" and "Puppy"
    And  the user clicks save button
    Then the profile picture should be updated successfully

  @InvalidFiles @all
  Scenario Outline: Upload profile picture with invalid files
    When the user enters "<firstname>" and "<lastname>"
    And the user uploads "<filename>"
    And the user clicks save button
    Then an alert with message "<errorMessage>" should be displayed

    Examples:
      | firstname| lastname | filename                  | errorMessage                             |
      | catttt   | leooo    | invalid_file.txt          | Failed to Save: File Type Not Allowed    |
      | leooo    | catttt   | largeDimensions_image.JPG | Failed to Save: File Size Exceeded       |
      | leocatt  | cattleoo | largesize_Image.jpg       |  Failed to Save: File Size Exceeded      |