DELIVERY API
============

A RESTful API built with Spring Boot for managing CUSTOMERS and PRODUCT registration. This project provides endpoints to PLACE-ORDERS, ORDERS, PRODUCT, and SPECIFI PRODUCT BY ID  records. It has been successfully tested in Postman.


 Features
 ========
•	Customer details  
•	View product details
•	Update custome information
•	delete product records
•	RESTful design with JSON responses

Technologies Used
=================
•	Java 17+
•	Spring Boot
•	Maven (dependency management & build tool)
•	Postman (API testing)

API Endpoints
=============
Method	       Endpoint	                      Description
post	        /api/oder/place-order	         Get all students
GET	          /api/oder/{id}	               Get student by ID
GET	       /api/oder//orders-name-productName 	  name of customer  and all  products 
DELETE	  /api/oder/delete/{id}	           Delete a records
