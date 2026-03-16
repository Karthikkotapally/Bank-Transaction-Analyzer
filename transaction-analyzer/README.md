# Transaction Analyzer

A web application for analyzing bank transactions, built with Spring Boot backend and vanilla JavaScript frontend.

## Project Structure

```
transaction-analyzer/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/blank/transaction_analyzer/
│   │   │       ├── TransactionAnalyzerApplication.java  # Main Spring Boot application
│   │   │       ├── controller/
│   │   │       │   └── TransactionController.java       # REST API endpoints
│   │   │       ├── dto/
│   │   │       │   └── MonthlySummaryDTO.java           # Data transfer object for summaries
│   │   │       ├── model/
│   │   │       │   ├── Transaction.java                 # JPA entity for transactions
│   │   │       │   └── TransactionType.java             # Enum for transaction types
│   │   │       ├── repository/
│   │   │       │   └── TransactionRepository.java       # JPA repository interface
│   │   │       └── service/
│   │   │           └── TransactionService.java          # Business logic service
│   │   └── resources/
│   │       ├── application.properties                   # Configuration
│   │       └── static/                                  # Frontend files
│   │           ├── index.html                           # Main HTML page
│   │           ├── script.js                            # Frontend JavaScript
│   │           └── style.css                            # CSS styles
│   └── test/
│       └── java/
│           └── com/blank/transaction_analyzer/
│               └── TransactionAnalyzerApplicationTests.java  # Unit tests
├── target/                                              # Build output
├── pom.xml                                              # Maven configuration
├── mvnw & mvnw.cmd                                      # Maven wrapper
├── test.http                                            # HTTP test file
└── README.md                                            # This file
```

## Backend

The backend is built with Spring Boot 3.x, using:

- **Spring Web**: For REST API endpoints
- **Spring Data JPA**: For database operations
- **SQLite**: As the database (file-based)
- **Lombok**: For reducing boilerplate code

### Key Components

- **TransactionController**: Handles HTTP requests for transactions
  - `POST /transactions`: Add a new transaction
  - `GET /transactions`: Get all transactions
  - `GET /transactions/summary?year=&month=`: Get monthly summary
  - `GET /transactions/overall-summary`: Get overall summary
  - `GET /transactions/type/{type}`: Get transactions by type

- **TransactionService**: Contains business logic for transaction operations

- **TransactionRepository**: JPA repository for database access

- **Transaction Entity**: Represents a transaction with fields: id, description, amount, type, date

### Configuration

- Database: SQLite file `transactions.db`
- Port: 8082 (configurable in `application.properties`)
- JPA: Auto-create tables with `ddl-auto=update`

## Frontend

The frontend is a single-page application using vanilla JavaScript, HTML, and CSS.

### Features

- **Dashboard**: Shows overall total debit, credit, and balance
- **Add Transaction**: Form to add new transactions
- **Transaction History**: Table displaying all transactions
- **Monthly Summary**: Filter and view summary by year and month

### Technologies

- **HTML5**: Structure
- **CSS3**: Styling with modern design
- **JavaScript (ES6+)**: Interactivity and API calls
- **Lucide Icons**: For UI icons

### Key Files

- `index.html`: Main page with sections for different views
- `script.js`: Handles UI logic, API calls, and data display
- `style.css`: Responsive styling

## Getting Started

1. **Prerequisites**:
   - Java 21+
   - Maven (or use mvnw wrapper)

2. **Run the Application**:
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Access the Application**:
   - Open http://localhost:8082 in your browser
   - The frontend will load, and you can start adding/viewing transactions

4. **API Testing**:
   - Use the `test.http` file with an HTTP client like VS Code REST Client
   - Or use tools like Postman to test endpoints

## Database

- Uses SQLite for simplicity (no external DB required)
- Database file: `transactions.db` (created automatically)
- Tables created via JPA auto-configuration

## Development

- Backend: Java 21, Spring Boot 3.x
- Frontend: Modern web standards, no build tools required
- Testing: JUnit for backend tests

## Notes

- CORS is enabled for all origins in the controller
- Static files are served from `/src/main/resources/static/`
- The application runs on port 8082 by default</content>
<parameter name="filePath">c:\Users\madhu\Random\transaction-analyzer\README.md