# TransferRouteApp

## Overview
This is a demo application for calculating the maximum cost of transfers within a given weight limit. The application provides a REST API to interact with the transfer service.

## Features
- Calculate the maximum cost of transfers within a given weight limit.
- REST API to interact with the transfer service.

## Setup

### Clone the repository
```sh
git clone https://github.com/ltura22/TransferRouteApp.git
cd TransferRouteApp
```

### Build the project
```sh
mvn clean package
```

### Run the application
```sh
java -jar target/TransferRouteApp-1.0.0.jar
```

## API Endpoints

### Calculate Maximum Cost
- **URL:** `/api/transfers/maximum-cost`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
    "maxWeight": 15,
    "availableTransfers": [
      {"weight": 5, "cost": 10},
      {"weight": 10, "cost": 20},
      {"weight": 3, "cost": 5},
      {"weight": 8, "cost": 15}
    ]
  }
  ```
- **Response:**
  ```json
  {
    "selectedTransfers": [
      {"weight": 5, "cost": 10},
      {"weight": 10, "cost": 20}
    ],
    "totalCost": 30,
    "totalWeight": 15
  }
  ```
  
### CURL Command
  ```sh
  curl -X POST http://localhost:8080/api/maximum-cost \
  -H "Content-Type: application/json" \
  -d '{
  "maxWeight": 15,
  "availableTransfers": [
  {"weight": 5, "cost": 10},
  {"weight": 10, "cost": 20},
  {"weight": 3, "cost": 5},
  {"weight": 8, "cost": 15}
  ]
  }'
  ```

## Running Tests

To run tests, ensure that the server is running and use the following command:
```sh
mvn test
```




