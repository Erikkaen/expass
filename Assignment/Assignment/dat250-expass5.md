DAT250: Software Technology Experiment Assignment 5

1. First step I did was downloading Redis, I did this through docker. It worked fairly quickly when following the steps.
2. After testing around with commands like GET, EXPIRE and SET with redis, I started at Case 1. 
3. I went to the redis command overview page and typed in SET to see what commands it contained. I immediately see
the "SADD" function that adds one or more people to a set, and other functions like SMEMBERS which returns all members
of a set. I called the set "LoggedIn". I used SMEMBERS to see how many members there were, SADD to add members and
SREM to remove members.
4. I started case 2, and went to look for the commands for the HASH datatype. I saw there were many different Gets and 
Sets there as well, also HINCRBY which increments the integer value of a field in a hash by a number. This can be used to
increment the vote count of an option without having to replace the whole object, by using the structure: HINCRBY key field increment.
5. I made this structure as in the JSON with HSET, and used HINCRBY to increment the vote, and used HGETALL to look at the
structure.
6. I went to change my KTS file and add the needed implement. I printed the main method into my main method from the
assignment text, and I got out a "PONG" when running gradlew. 
7. I started looking at the "nosql" lectureexample to see the use of redis and redisconfig. I then made the 
"repository" package, and added a "config" package as well and added the classes/interfaces needed like the example.
I struggled back and forth with having the correct implementations and imports, but I finally got rid of all the red lines. 
I also noticed I had to change my ID's in "Poll" to long instead of string. I then used commands and connected to redis
to test:

C:\Users\erioa>docker exec -it redis redis-cli
127.0.0.1:6379> HSET poll:1:results option1 5 option2 3 option3 9
(integer) 3
127.0.0.1:6379> HGETALL poll:1:results
1) "option1"
2) "5"
3) "option2"
4) "3"
5) "option3"
6) "9"

127.0.0.1:6379> HINCRBY poll:1:results option2 1
(integer) 4

127.0.0.1:6379> EXPIRE poll:1:results 6
(integer) 1
127.0.0.1:6379> TTL poll:1:results
(integer) -2
127.0.0.1:6379> HGETALL poll:1:results
(empty array)
127.0.0.1:6379> DEL poll:1:results
(integer) 0
127.0.0.1:6379>


