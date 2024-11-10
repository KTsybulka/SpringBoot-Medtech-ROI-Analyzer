# Project Setup

## Database Setup
This project uses **Flyway** to handle database migrations. The migrations are organized by industry, allowing separate migrations for different sectors.

### Steps to Set Up the Database
1. **Ensure MySQL is Running**:
   - Database connection details are found in `src/main/resources/application.yml`.

2. **Industry-Specific Migrations**:
   - Flyway is configured to apply migrations from these folders:
     - `db/migration/healthcare` for Healthcare
     - `db/migration/retail` for Retail


   **Note**: If you need to apply migrations for only one industry, modify the `spring.flyway.locations` property in `application.yml` or use profiles as described below.

3. **Profiles for Industry-Specific Setup**:
   - The `application.yml` file supports profiles for each industry.
   - Run the application with a specific profile to load migrations for that industry only.

     ```bash
     # Run with Healthcare profile
     ./mvnw spring-boot:run -Dspring-boot.run.profiles=healthcare

     # Run with Retail profile
     ./mvnw spring-boot:run -Dspring-boot.run.profiles=retail
     ```

4. **Verify Migrations**:
   - Upon starting the application, Flyway will apply the migrations automatically if not already applied.
   - Check the logs or the `flyway_schema_history` table in the database to confirm the migrations were successful.
