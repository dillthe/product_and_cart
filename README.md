# Product and Cart

Product and Cart is a web application that manages products and shopping carts at E-commerce website. This application allows users to view products, add them to a shopping cart, and manage the items in their cart. This project was developed as a team project, and I was responsible for the cart and product pages.

## Features

- **Product Management**: View a list of available products.
- **Cart Management**: Add, update, and remove items in the shopping cart.
- **User Authentication**: Users can register, login, and manage their profiles.

## Tech Stack

### Backend
- **Java**: A robust and widely-used programming language suitable for building scalable backend services.
- **Spring Boot**: A Java-based framework that simplifies the development of RESTful web services and microservices.
- **MySQL**: A reliable and efficient relational database management system for storing application data.

## Installation and Running

### Prerequisites

- Java Development Kit (JDK) installed
- MySQL installed and running
  
## Usage

1. **Register and Login**: Create a new account or login with an existing account.
2. **View Products**: Browse the list of available products.
3. **Manage Cart**: Add products to the cart, update quantities, and remove items from the cart.

## Project Structure

  - `src/main/java/`: Java source files
    - `com/brandistory/`: Main package
      - `web/`: REST controllers
      - `service/`: Business logic
      - `repository/`: Database access, Entity definitions
  - `src/main/resources/`: Application configuration files

## Why These Technologies?

- **Java**: Chosen for its robustness and scalability, making it ideal for backend services.
- **Spring Boot**: Selected for its ability to simplify the development of RESTful web services and microservices, providing a robust and scalable backend.
- **MySQL**: Used for its reliability and efficiency in managing relational data, making it suitable for handling the application’s data storage needs.

## Challenges Faced

1. **Loading Image Files with Product Information**: Setting up the application to load image files along with product details was challenging. Additionally, making these image files accessible as indexed options on the homepage required careful implementation.
2. **Managing Cart Numbers and Orders**: Each product added to the cart was assigned a unique cart number, but orders needed to be grouped by cart numbers (e.g., cart numbers 1, 2, 3, 4). Implementing partial orders and linking them with user IDs to manage all items was a complex task.
3. **Implementing Login Token for User ID Retrieval**: Initially implemented by manually entering user IDs, the system was upgraded to retrieve IDs through login tokens. This was challenging at first, but quickly adapted to enable usage across all APIs.
