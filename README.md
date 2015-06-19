// https://spring.io/guides/gs/consuming-rest-jquery/

1) Take a look at what the various spring boot (starter) libs give you, eg - web, test, data-rest, data-jpa

2) Tutorial not finished yet
https://spring.io/guides/gs/accessing-data-rest/

3) Easy enough to change to a war, just change the packaging from jar to war and mark the container libs as 'provided'

4) Take a look at 
http://kotlinlang.org/docs/tutorials/spring-boot-restful.html
http://spring.io/guides/tutorials/bookmarks/

5) Spring boot reference at http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle

Rest api exposed

1) GET greeting

2) customer stuff in progress..

Testing using curl

$ curl -i -X POST -H "Content-Type:application/json" -d '{  "firstName" : "Frodo",  "lastName" : "Baggins" }' http://localhost:8080/people

-i: include response headers
-d: data


Changes

* Added h2 database to classpath
* Spring xxx for hot debugging of the spring boot app
