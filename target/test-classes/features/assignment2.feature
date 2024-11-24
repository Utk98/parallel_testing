Feature: Comment on cards
  @kim
  Scenario Outline: Click and comment on different cards
    Given user logs in with email "test1@digite.com" and password "welcome@1"


    Examples:
      | Card  |
      | sz |
      | ismine |
