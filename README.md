## Online Concert Ticketing Project
This small project aims to practice LinkedList and PriorityQueue data structure and understand how to use them.

### Summary

We read ticket and customer details from a txt file and process the data according to ticket type. 

### Users

<p>GOLD Customer - Customer which will take gold ticket. We put them behind the Gold Customer and pass other low priority customers (Silver, Bronze and Free) in the queue. </p>
<p>SILVER Customer - Customer which will take silver ticket. We put them behind the Silver or if does not exist Gold customers and pass bronze or free customers that are frontier than silver customer. </p>
<p>BRONZE Customer - Customer which will take bronze ticket. We put them behind the Bronze or if does not exist Silver customers and pass free customers that are frontier than bronze customer. </p>
<p>FREE Customer - Customer which will take free ticket. They do not have any priority they will wait untill all GOLD, SILVER and BRONZE customer's turn and then they will be served. </p>

### Details

<p>System shows Total and Average waiting time for all ticket types and the recent state of concert avenue.</p>
<br>
<p>U - Unsold </p>
<p>S - Sold </p>
<img width="288" alt="DAY1" src="https://user-images.githubusercontent.com/53305383/185746030-4f9344d2-3485-4c92-be2b-7e26a1ad0a57.png">
<img width="281" alt="DAY2" src="https://user-images.githubusercontent.com/53305383/185746130-6568872a-4461-43a7-8750-3a1f5cb75f5f.png">
