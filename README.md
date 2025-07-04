# Car Dealership Console Application

This is a Java console application for managing a simple car dealership system. It allows users to add and view users and cars, and simulate car purchases, all backed by a PostgreSQL database. The project uses Maven for build management.

## Features
- Add new users with name, surname, and wealth.
- Add new cars with brand, model, price, equipment, and available count.
- List all users and cars.
- Simulate a user purchasing a car (with wealth and car count checks).
- Data persistence via PostgreSQL.

## Project Structure
```
project-master/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── org/
                └── example/
                    ├── Application.java         # Main application logic and menu
                    ├── Main.java               # Entry point
                    ├── User.java               # User entity
                    ├── Cars.java               # Car entity
                    ├── User_Repository.java    # User repository (PostgreSQL)
                    ├── Cars_Repository.java    # Car repository (PostgreSQL)
                    ├── UserRepository.java     # User repository interface
                    ├── CarsRepotisory.java     # Car repository interface
                    ├── DB.java                 # Database interface
                    ├── Conncetion_Db.java      # Database connection implementation
```

## Requirements
- Java 11 or higher
- Maven
- PostgreSQL (running on `localhost:5432` with database `postgres`, user `postgres`, password `tryu1234` by default)

## Setup
1. **Clone the repository**
   ```sh
   git clone <repo-url>
   cd project-master
   ```
2. **Configure the Database**
   - Ensure PostgreSQL is running and accessible at the default connection string.
   - Create the required tables:
     ```sql
     CREATE TABLE users (
         id SERIAL PRIMARY KEY,
         name VARCHAR(100),
         surname VARCHAR(100),
         wealth INT
     );
     CREATE TABLE cars (
         id SERIAL PRIMARY KEY,
         brand VARCHAR(100),
         model VARCHAR(100),
         price INT,
         equipment VARCHAR(100),
         carscount INT
     );
     ```
   - (Optional) Update connection details in `Application.java` and `Conncetion_Db.java` if needed.

3. **Build the Project**
   ```sh
   mvn clean package
   ```

4. **Run the Application**
   ```sh
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```

## Usage
- Follow the on-screen menu to add users, add cars, list users/cars, or simulate a purchase.
- The application will prompt for required information.
- To exit, choose the exit option or type 'no' when prompted to continue.

## Notes
- The application uses simple console input/output for interaction.
- All data is stored in the PostgreSQL database.
- Default database credentials are hardcoded; change them in the code for production use.

## License
This project is for educational/demo purposes. 
