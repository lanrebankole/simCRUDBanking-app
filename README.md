# CRUD Spring Boot RESTful API

This project implements a CRUD (Create, Read, Update, Delete) Spring Boot RESTful API for managing bank accounts.

## API Endpoints

### 1. Create Account

        - **Endpoint:** `POST localhost:8080/account/create`
        - **Description:** Creates a new account.
        - **Request Body:**
          ```json
        
        *******REQUEST*******
          {
            "account_holder_name":"FIRST LAST NAME",
        	"account_balance": 0.0
        }
        
        - **RESPONSE:**
        {
            "account_number": 12,
            "account_holder_name": "FIRST LAST NAME",
            "account_balance": 0.0
        }

### 2. ACCOUNT INQUIRY

        - **Endpoint:** `GET localhost:8080/account/{id}`
        - **Description:** Inquires on input account.
        - **Request Body:**
       
        - **RESPONSE:**
          {
              "account_number":{id},
              "account_holder_name": "String",
              "account_balance": 0.0
          }

##### 3. Update Account (Cash Deposit and Withdrawal)
Endpoint: PUT /api/accounts/{id} localhost:8080/account/cashDeposit/{id}/{tranAmt} // Cash Deposit

Endpoint: PUT /api/accounts/{id} localhost:8080/account/cashDeposit/{id}/{tranAmt} // Cash Withdrawal

Description: Updates the balance of a specific account by ID. They both can cross-function if you use positive values for deposits and negative values for withdrawals.

 **Request Body:**
json
{
  "tranAmt": 100.0  // Positive for deposit, negative for withdrawal
}
**response**
{
    "account_number": {id},
    "account_holder_name": "String",
    "account_balance": {acctBalAfterTran}
}

##### 4. Close or Delete Account
Endpoint: DELETE localhost:8080/account/delete/{id}
Description: Closes account by ID.
**Request Body:**
json
{
  "accountNumber": {id} 
}
**response**
{
    "Account number:" + {id} + " is successfully closed"
}

### Docker Instructions
To run this application using Docker, use the following command:

docker run -p 8080:8080 <docker-image-name> 
To run the application locally without Docker, you can use Maven. Navigate to the project directory and run:
mvn spring-boot:run

The application will start on port 8080 by default.
