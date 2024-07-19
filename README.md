## Spring Boot Application: JSON String Manipulation

### Overview
This document provides a detailed explanation of the approach, code implementation, and testing strategy for the Spring Boot application that involves string manipulation within a JSON model and calling an API to replace and return the modified JSON model.

### Project Structure
The project is structured into the following layers:
1. Controller Layer: Handles HTTP requests.
2. Service Layer: Contains business logic for JSON manipulation.
3. Repository Layer: Interacts with the database.
4. Entity Layer: Represents the database entity.

### JSON Model
The predefined JSON model used in this application:

{
    "menu": {
        "id": "file",
        "value": "File",
        "popup": {
            "menuitem": [
                {"value": "New", "onclick": "CreateDoc()"},
                {"value": "Open", "onclick": "OpenDoc()"},
                {"value": "Save", "onclick": "SaveDoc()"}
            ]
        }
    }
}


### Approach
1. **Define the JSON Model**: The JSON model is predefined as a constant string in the service layer.
2. **Implement JSON Manipulation**: The service layer method `manipulateJson` takes input parameters, splits them into key-value pairs, and replaces the keys in the JSON model with the corresponding values.
3. **Save Modified JSON to Database**: The modified JSON model is saved in a database table with columns `id` and `jsonModel`.
4. **Expose API Endpoint**: A REST API endpoint is created to handle POST requests for JSON manipulation and return the modified JSON.

### Setup Instructions

#### Prerequisites
- Java Development Kit (JDK) 8
- Apache Maven
- MySQL Database

#### Steps
1. **Clone the Repository**
  
    git clone <repository-url>
    cd SpringbootAssessment

2. **Configure MySQL Database**
    - Create a database named `springboot_assessment`.
    - Update `application.properties` with your MySQL database credentials.
   
    spring.datasource.url=jdbc:mysql://localhost:3306/springboot_assessment
    spring.datasource.username=
    spring.datasource.password=
    spring.jpa.hibernate.ddl-auto=update
 

3. **Build the Project**
    
    ./mvnw clean install
   
4. **Run the Application**
    
    ./mvnw spring-boot:run
    

5. **Access the API**
    - **Endpoint**: `/api/manipulate`
    - **Method**: POST
    - **Parameter**: `inputs` (Comma-separated string manipulation inputs)


### Postman Test Steps
1. **Open Postman**.
2. **Create a new POST request**.
3. **Set the request URL** to `http://localhost:8080/api/manipulate`.
4. **In the Body tab**,
5. **Add a key named `inputs`** and set its value to the test case input (e.g., `New:::NewDocument`).
6. **Send the request** and verify the response.

7. 
### Testing Strategy
To verify that the string manipulation and API endpoint work correctly, the following test cases should be performed using Postman:
  ![image](https://github.com/user-attachments/assets/95ab5aca-0bb9-4c7e-809f-d2d4467ae1dc)
1. **Basic Replacement**:
    - **Input**: `New:::NewDocument`
    - **Expected Output**: JSON with "New" replaced by "NewDocument".
![image](https://github.com/user-attachments/assets/613b0d1a-214d-42d0-bdc3-d4dcd0f90064)

2. **Multiple Replacements**:
    - **Input**: `New:::NewDocument,Open:::OpenFile,Save:::SaveAs`
    - **Expected Output**: JSON with all specified replacements.
![image](https://github.com/user-attachments/assets/0f9fb5af-8bb4-43cc-aac3-cc9637c7baa9)

3. **Single Replacement with Extra Spaces**:
    - **Input**: `New   :::   NewDocument`
    - **Expected Output**: JSON with "New" replaced by "NewDocument".
![image](https://github.com/user-attachments/assets/2ef88342-0d82-41b1-8e8b-bd0f65100a92)

4. **Invalid Input Format**:
    - **Input**: `New:::NewDocument,InvalidInput`
    - **Expected Output**: Error message indicating invalid input format.
![image](https://github.com/user-attachments/assets/971f8bb0-1ac1-4ce5-acda-018965bef741)



5. **Partial Replacement**:
    - **Input**: `Open:::OpenDocument`
    - **Expected Output**: JSON with "Open" replaced by "OpenDocument".
![image](https://github.com/user-attachments/assets/65b42f95-b36a-46c0-82a5-b74949354309)

6. **Replacing Key That Does Not Exist**:
    - **Input**: `NonexistentKey:::NewValue`
    - **Expected Output**: Original JSON without any changes for non-existent keys.
![image](https://github.com/user-attachments/assets/d0754ed3-e7e6-46d0-aa7a-ed1807641748)

7. **Complex Replacement with Multiple Key-Value Pairs**:
    - **Input**: `New:::NewDocument,Save:::SaveAs,Open:::OpenFile`
    - **Expected Output**: JSON with all specified replacements.
![image](https://github.com/user-attachments/assets/4a68b511-ba42-48a3-9f36-c1e7689cfd9b)

Mysql database view:
![image](https://github.com/user-attachments/assets/0b91daed-ab5c-4a75-8063-b6f3f977b29a)


### Conclusion
The Spring Boot application fulfills all the requirements outlined in the assessment. It correctly manipulates the JSON model based on dynamic inputs, saves the modified JSON in the database, and provides a REST API endpoint for testing and verification. The code is structured following best practices, with proper error handling, logging, and documentation.

### Additional Information
1. **Dependencies**
    - Spring Boot Starter Web
    - Spring Boot Starter Data JPA
    - MySQL Connector
    - Spring Boot Starter Test

2. **Contact**
    - For any questions or support, please contact on pawarajay2207@gmail.com or 9172970812.

