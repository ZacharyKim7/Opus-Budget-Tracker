# Opus Budget Tracker Backend

A Spring Boot backend service for the Opus Finance personal finance tracker application with MongoDB Atlas integration.

## Goals
- Create a simple backend using Java + Spring Boot to handle integrations, calculations, and data storage
- Implement MongoDB for data storage

## Features

- RESTful API for user and account management
- MongoDB Atlas cloud database integration
- Spring Boot 3.2.0 with Java 17
- CORS configuration for frontend integration
- Lombok for reducing boilerplate code
- Input validation with Spring Validation

## Tech Stack

- **Framework**: Spring Boot 3.2.0
- **Language**: Java 17
- **Database**: MongoDB Atlas
- **Build Tool**: Maven
- **Key Dependencies**:
  - Spring Web
  - Spring Data MongoDB
  - Spring Validation
  - Lombok
  - Spring DevTools

## Project Structure

```
opus-backend/
├── src/
│   ├── main/
│   │   ├── java/com/opus/budget/
│   │   │   ├── config/          # Configuration classes
│   │   │   ├── controller/      # REST controllers
│   │   │   ├── exception/       # Custom exceptions
│   │   │   ├── model/           # Domain models/entities
│   │   │   ├── repository/      # MongoDB repositories
│   │   │   ├── service/         # Business logic layer
│   │   │   └── OpusBudgetTrackerApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-dev.properties
│   └── test/                    # Test files
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- MongoDB Atlas account with connection string

### Environment Setup

1. Set the MongoDB connection string as an environment variable:
   ```bash
   export MongoDB_Connection_String="your-mongodb-atlas-connection-string"
   ```

2. Or create a `.env` file (use `.env.example` as template):
   ```
   MongoDB_Connection_String=mongodb+srv://username:<password>@cluster.mongodb.net/?appName=OpusCluster
   ```

### Running the Application

1. Build the project:
   ```bash
   mvn clean install
   ```

2. Run the application:
   ```bash
   mvn spring-boot:run
   ```

3. The API will be available at `http://localhost:8080`

### Running with Development Profile

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## API Endpoints

### Health Check
- `GET /api/health` - Check API status

### Users
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `GET /api/users/username/{username}` - Get user by username
- `GET /api/users/email/{email}` - Get user by email
- `POST /api/users` - Create new user
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

### Accounts
- `GET /api/accounts` - Get all accounts
- `GET /api/accounts/{id}` - Get account by ID
- `GET /api/accounts/user/{userId}` - Get all accounts for a user
- `GET /api/accounts/user/{userId}/active` - Get active accounts for a user
- `GET /api/accounts/user/{userId}/type/{type}` - Get accounts by type for a user
- `POST /api/accounts` - Create new account
- `PUT /api/accounts/{id}` - Update account
- `DELETE /api/accounts/{id}` - Delete account

## Models

### User
- `id` - Unique identifier
- `username` - Unique username
- `email` - Unique email address
- `password` - User password (should be hashed in production)
- `firstName` - User's first name
- `lastName` - User's last name
- `createdAt` - Account creation timestamp
- `updatedAt` - Last update timestamp
- `active` - Account status

### Account
- `id` - Unique identifier
- `userId` - Reference to user
- `name` - Account name
- `type` - Account type (CHECKING, SAVINGS, CREDIT_CARD, INVESTMENT)
- `institutionName` - Financial institution name
- `plaidAccountId` - Plaid account identifier
- `plaidAccessToken` - Plaid access token
- `balance` - Current account balance
- `currency` - Currency code (default: USD)
- `createdAt` - Creation timestamp
- `updatedAt` - Last update timestamp
- `active` - Account status
- `synced` - Sync status with Plaid

## Configuration

### MongoDB
The application uses MongoDB Atlas for data persistence. Configure the connection string in `application.properties` or via environment variable.

### CORS
CORS is configured to allow requests from:
- `http://localhost:3000` (Create React App default)
- `http://localhost:5173` (Vite default)

Modify `CorsConfig.java` to add additional origins as needed.

## Development

### Code Structure
- **Controllers**: Handle HTTP requests and responses
- **Services**: Business logic and data processing
- **Repositories**: Data access layer using Spring Data MongoDB
- **Models**: Domain entities with MongoDB mappings
- **Config**: Application configuration classes

### Best Practices
- Use Lombok annotations to reduce boilerplate
- Validate input using Jakarta Validation annotations
- Use constructor injection for dependencies
- Follow RESTful API design principles

## Acceptance Criteria
- ✅ Setup of Java + Spring Boot boilerplate code
- ✅ Connection to MongoDB Atlas

## Future Enhancements

- [ ] Add authentication and authorization (Spring Security + JWT)
- [ ] Implement Plaid integration for account syncing
- [ ] Add transaction tracking
- [ ] Implement budget management endpoints
- [ ] Add comprehensive error handling
- [ ] Add API documentation (Swagger/OpenAPI)
- [ ] Add unit and integration tests
- [ ] Implement DTOs for request/response separation

## License

This project is part of the Opus Finance application.
