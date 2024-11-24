

Feature: Create, Verify and Comment on Discussion Post

  @Sanity @Critical @ki
  Scenario Outline: Create a post, verify it, comment on it, and verify the comment
    Given user logs in with email "test.apr221@digite.com" and password "welcome@1"

    Examples:
      | Title             | Titles             |
      | Hiast               | His                |
