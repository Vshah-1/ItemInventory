README file for Item Inventory project

Why are we doing this?:


We have been tasked with creating a fully functioning API that is CRUD functional, can handle HTTP requests, and can store data in a database. The scope of this project covers many key modules we covered in the DfE Software Pathway. Specifically, the project allows us to implement key modules we covered in Software Specialism such as Java, Spring boot, and also from Core learning such as Agile Fundamentals, Jira, Git, etc. 


How i expected the challenge to go:

This is an example of how you may give instructions on setting up your project locally. To get a local copy up and running follow these simple example steps.

I was not very familiar and up to date with some of the modules we had covered earlier in the course, and even some of the recent ones admittedly. As a result, I expected the project to be very challenging, but also very engaging. 

How to run this project:

Project prerequisites: 

+ IDE that can run Java

+ MySQL Database, that can persists data

+ Spring API Development Platform

+ .Jar build of file 

(MySQL Schema) 
![image](https://user-images.githubusercontent.com/94983341/152708779-8c9cd39e-29f3-45e6-96e6-76ab666551d4.png)


To run this project, download a copy of my git repository, and clone it to your local computer. From there you can run the -jar command of the .jar file. After this you can run the application, and use the My SQL Schema above to persist the item to your SQL server. 

What went well?:


The project was very well defined, I felt clear in my understanding of what it was asking me to do. I found planning the project, especially through the use of the Jira board to be very helpful in prioritising my workload, and effectively leveraging the best use of my time.

As I became more familiar with git, I found the use of the feature branch model to feel quite natural, and I can see how effective it can be when working on a large project. I also found the quality of the teaching from the lecturers to be instrumental in ensuring we were adequately prepared for this project, and their support when we needed it. 


What didn't go as planned?:


I was unfamiliar with a few topics, such as Git, which then we were given a refresher on and support which was very helpful. I was also unfamiliar with the more technical parts of some topics such as how to best utilise the Jira Board interface, and how to create a proper risk matrix. 

I also struggled with certain parts of Spring Boot Testing, and implementing a database, as I was not up to date with the learning for that module. These areas I had to catch my learning up first, and implement as I went along, which slowed down my progress. 


Possible improvements for future revisions of the project:


I created an item inventory project, with the main goal of ultimately referencing item effects, from a database which holds commonly recurring items in a dungeon crawler type game. 

In the future, I would like to make it so that users have access to create their own custom inventory, which would display information regarding the items they have acquired. This inventory would have the ability to add items directly from the database, and delete items from the inventory as they are dropped in the game. 

I would also like to expand on the details of the items, and create custom queries that could better search for items of a similar type, nature, effect, and so on. 


The following are the screenshots showing my postman requests and the output from the API:

Get All Items--

This is the code in my ItemController class, it utilises the getAll method in my ItemService class, and stores the reults in an array list, and can be used to get all the items currently held within the database. The path variable for this code is set too /items/getAllItems.

![image](https://user-images.githubusercontent.com/94983341/152696772-89d1b3a7-1cb3-4aa6-bfc2-997eb14eef55.png)

The getAll method leverages the use of the findAll method, and finds all the items located within the repository.

![image](https://user-images.githubusercontent.com/94983341/152697144-16a45852-36e6-4487-9586-cf9cc2b8dd20.png)

As you can see, the /items/getAllItems pathway can be used within postman to return all enteries within the repository.

![image](https://user-images.githubusercontent.com/94983341/152697273-58389cbf-3cf9-4396-abe7-896cfc4b1871.png)

Get By ID-- 

This is the code in my ItemController class for the Get By Id functionality, which allows for the ability to get items by their id value, which is unique to each item.

![image](https://user-images.githubusercontent.com/94983341/152698271-2aee9de0-0596-4f12-a81f-4c1a6d7edfe7.png)

This code relies on the getByID method in my service class, which uses the the .findById method to search for items in the repository, and return items specific to the id given.

![image](https://user-images.githubusercontent.com/94983341/152698333-249f1bf2-9f27-4025-9173-f89fee0a43ab.png)

The path variable to access items by their id is /Item/getItem/{id} where {id} is a value given, and will return the item with that id value as you can see from the following screenshot.

![image](https://user-images.githubusercontent.com/94983341/152698403-f637ead4-99a4-4bd9-b69c-ed1c571c97e0.png)


Add Item--

This is the code in my item controller class, that allows for the functionality to add/create an item.

![image](https://user-images.githubusercontent.com/94983341/152698748-82d9e2b2-386a-46aa-a82c-8d7884da2134.png)

It levarages the create method in the service class, and then saves the item within the repository using the .save method. The saved item can then be called by its id, or by the get all items method. 

![image](https://user-images.githubusercontent.com/94983341/152698802-27d7cdd7-f8f5-4e1c-977d-e7f3fac3d8cc.png)

The path variable to add a new item is /Items/addItems, from here we can enter the name and description in a JSON format, and send the request, which should then add the item. 

![image](https://user-images.githubusercontent.com/94983341/152698861-632d1ff5-3107-4d34-a8d3-b82261fccc68.png)

Now when we call the get all items function, you can see the item we created has been added to the list of items.

![image](https://user-images.githubusercontent.com/94983341/152698895-a581274b-4511-4c93-b3d8-6838b92f7a4a.png)

Update Items--

This is the code in my controller class, that allows for the ability to update items already within the list. it uses the Id of an item, checks if an item with that id exists, and then uses the method in my service class to update the id. The HttpHeaders passes additional information about the item, specifically the id of the item to be updated, which is located within the path variable /Items/updateItem/{id} where {id} is the id of the item that we wish to update. 

![image](https://user-images.githubusercontent.com/94983341/152699001-792f06cf-1795-42a4-8cad-f214b41f67c9.png)

The code within our service class checks to see if the item we wish to update exists. It does this by checking if an id exists by the value we have given it. It then uses the getters and setters method located within our item class to update the name and description variable of our items. If an item does not exists from the id value we have given, an EntityNotFound exception is given back. 

![image](https://user-images.githubusercontent.com/94983341/152699205-84c48d5c-e84d-45ca-a073-92fcb5cdf181.png)
 
Here we are calling the item assigned to the id of value 3, and passed through the information with which we want to update it by. 

![image](https://user-images.githubusercontent.com/94983341/152699370-9594fad6-5b31-4c1a-aca7-b70bdcb4bf45.png)

As you can see, item with the value of id 3, has been updated as per the information we provided it with. 

![image](https://user-images.githubusercontent.com/94983341/152699402-8c11a75c-4e42-4de5-9020-ffc808a4b6bf.png)


Delete Items-- 

Finally we have the ability to delete items. The functionality for this is provided by the delete method within our service class, which we can call upon and delete items. To do this, we follow the path variable /Items/deleteItem/{id} where id is the id of the item we wish to delete. 

![image](https://user-images.githubusercontent.com/94983341/152699617-60c0f706-bafb-4334-ba90-8ae66a1a3015.png)

The method within our service class firsts checks to see if an item exists, with the id of the value we have given it. If an item with that id exists, we use the .deleteById method and delete that item from the repository. If an item with that id does not exist, we can throw an EntityNotFoundException.

![image](https://user-images.githubusercontent.com/94983341/152699709-69f93a06-e2c1-4cca-90d0-c3cdbdbae68f.png)

We can send a delete request by following the path specified above /Items/deleteItem/{id}, and here was have passed the value 3.

![image](https://user-images.githubusercontent.com/94983341/152699751-4ea9b874-0b73-45f6-900c-2102db39b919.png)

When we send this request, you can see that we have deleted item by id value 3, and therefore that item no longer exists within our database. 

![image](https://user-images.githubusercontent.com/94983341/152699780-b546f3ca-37e0-47c6-b2b9-dff4e2a50779.png)


Screenshots of your database to prove that data is being persisted 

The database I am using to persist the data is MySQL. 

![image](https://user-images.githubusercontent.com/94983341/152700773-7d4de412-fec3-4a4a-b204-e9340ead58bb.png)

I have set the databsae to run on port 8080, and also have set it to auto update, and so whenever a request is made via postman, it will be sent the database.

Create Item Database-- 

When using the create Item functionality, I can send a create item request via postman.

![image](https://user-images.githubusercontent.com/94983341/152701677-792c81b1-1842-4ba8-b0e2-59212e73cf49.png)

Here I will recieve all the items, including item with id 2 which i have just created.

![image](https://user-images.githubusercontent.com/94983341/152701693-97ebfd17-e283-44e2-b488-ed3e4e9b8769.png)

Here you can see the item that I have created has persisted into my databse.

![image](https://user-images.githubusercontent.com/94983341/152712767-a6ee0983-cdaf-4d92-a65c-4f294615d622.png)

I can also update items within the database. I can update an Item using the put method in postman. 

![image](https://user-images.githubusercontent.com/94983341/152701753-07f9655d-384f-4794-ad04-9eb088e515ee.png)

Here I have updated item with id 2, and as you can see it has also been updated in my database. 

![image](https://user-images.githubusercontent.com/94983341/152712889-7f94ad2b-4a39-41da-be2c-44fd572c5ec9.png)

Finally I can also delete items contained with the database. Again we can do this via postman, and the delete method. 

![image](https://user-images.githubusercontent.com/94983341/152701923-f6839617-db30-421e-a185-f5eed6a10c77.png)

Here i have sent a request to delete the item associated with the id value of 2. Now we can take a look at the databse, and see that the item with id value 2 has been deleted. 

![image](https://user-images.githubusercontent.com/94983341/152701958-f4f665ed-3f56-4abc-be28-9e4d1830c140.png)

Screenshots of your test results, including coverage report 

This is the testing suite I designed for Unit Testing off the controller class. It uses the WebvcTest to configure the tests, and also the @BeforeEach annotation, to supply the tests with mock data that it can use to test the functionality of my methods. 

![image](https://user-images.githubusercontent.com/94983341/152704002-01c63fea-46c7-492d-b3c5-4f7cb1f60b3e.png)

Here you can see I have tests designed for the get all items method, create items method, and update items method.

Get all: 

The test for this method asserts that when the service method .getAll is called, verify that the array list of Items are returned. 

Create item:

The test for this method assers that when a new item is created using the service method .create, verify that that item that has been created is returned.

Update item:

The test for this method is a bit different. It passes data associated with an item, and then passes the data that that item should be updated with. It then verifies that when the item is called using the .update method, it returns the item with the updated information. 

![image](https://user-images.githubusercontent.com/94983341/152704549-f7686a30-b825-4915-b78e-60cb3b1216ba.png)

Here are the test designed for the getById method, and delete method: 

Get by Id: 

The test for this method asserts that its expects to see that when we call the getById function, with the value of the id we pass through, then we should expect to receive the item assigned to that value. The test then asserts that what we actually should be receiving is the item that gets called forth from our .getById method. It then verifies that we expect to recieve, and what we actually receive, are in line with each other. 


Delete method:

The test for this method is a little bit different. As when you delete an item, you cannot explicitly expect a value for the return, as what you would be receving is a null value as you have deleted that item. Therefore this test has to be written slightly different than the tests above. For this test we asserted that what we expect then is a status response that our request for delete has been accepted. That way we dont have to assert that we expect an explicit return, rather that the server accepted our request.

![image](https://user-images.githubusercontent.com/94983341/152712998-443472ba-b10d-4c8c-917b-8bee4c45b4a4.png)


This is the testing suite I designed for system integration of the controller class. As you can see it has a BeforeEach annotation where in I pass through dummy data before the tests for which to run the tests with. I also have an AfterEach tear down method, which resets the database after each tests, giving the tests a clean slate with which to run with.

![image](https://user-images.githubusercontent.com/94983341/152706062-ba2fdc12-c5eb-4b33-aef6-856a806c9b8d.png)

In this class I only managed to cover two tests. The Get Items, and create Items test.

![image](https://user-images.githubusercontent.com/94983341/152706090-f00a1aa5-e683-4010-b753-36855b058b09.png)

The following are the results from running all my tests. As you can see there are three that have been ignored. There were tests that I had not completed, and will come back to in a later version. 


![image](https://user-images.githubusercontent.com/94983341/152715439-52e1883a-39c1-48ac-a1e3-4dc3004d3b0b.png)


The coverage report shows that I have achieved a test coverage of around 72%.

![image](https://user-images.githubusercontent.com/94983341/152708067-d0020d55-6013-4ffb-a0c5-d6e55bad4b75.png)

Further breakdown of the test coverage. 

![image](https://user-images.githubusercontent.com/94983341/152708046-daa56ebf-aaf1-4710-8241-82375ecfa8b2.png)



Link to Jira Board 
