Feature: Validate emails 

Scenario Outline: Validate emails from the comments section for posts by specific User

Given Build userList Payload
When Hit the resource "usersAPI" with "Get" Http request
And Get userid for the user "<name>" if present
Then Build posts payload with userid
Then Hit the resource "postsAPI" with "Get" Http request
And Extract the postIds
And Build comments payload with postId
And Hit the resource "commentsAPI" with "Get" Http request
And Validate the email IDs in the comments

Examples:
|name			|
|Delphine	|