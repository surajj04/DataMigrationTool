# DataMigrationTool


<div style="display: flex; justify-content: center; align-items: center;">
    <img src="https://miro.medium.com/v2/resize:fit:1400/1*-SjJ12zamKV3ERm6LMatoA.png" width="450" style="margin-right: 20px;" />
    <img src="https://bgasparotto.com/wp-content/uploads/2015/05/mysql-logo.png" width="450" />
</div>


**DataMigrationTool** is a simple and efficient tool for migrating and processing CSV data into MySQL databases. Built using **Spring Batch**, it ensures seamless data migration with features like schema mapping, data cleaning, and fault tolerance.

---

## Key Features

- **CSV to MySQL Migration**: Reads data from CSV files and stores it in MySQL.
- **Schema Mapping**: Maps fields in CSV files to database table columns.
- **Data Cleaning**: Performs tasks like renaming fields and validating records.
- **Batch Processing**: Efficiently handles large files with fault tolerance and chunk-based processing.
- **Resume Support**: Automatically resumes from where it left off after interruptions.

---

## Prerequisites

- **Java**: JDK 21 or higher.
- **MySQL**: Database installed and running.
- **Maven**: For building and running the project.

---

## How to Use

1. **Clone the Repository**  
    <small>Clone the repository to your local machine:</small>
   
   ```bash
   git clone https://github.com/yourusername/DataMigrationTool.git
2. **Install Prerequisites**  
    <small>Ensure you have the following installed:</small>

    - **Java JDK 21**  or higher.
    - **MySQL Database.**

3. **Set Up the MySQL Database**  
    <small>Create a new database in MySQL:</small>
    ```
    CREATE DATABASE datamigrationtool;
4. **Configure Application Properties**  
    <small>Update the application.yml file located in src/main/resources with your MySQL database credentials:</small>
    ```
    spring:
        datasource:
            url: jdbc:mysql://localhost:3306/datamigrationtool
            username: your_mysql_username
            password: your_mysql_password
5. **Build the Project**  
    <small>Compile the application using Maven:</small>
    ```
    mvn clean install
6. **Run the Application**  
    <small>Start the migration tool by running the following command:</small>
    ```
    java -jar target/DataMigrationTool-1.0.0.jar

7. **Verify the Data**  
    <small>After the migration is complete, check the MySQL database to ensure the data has been migrated successfully:</small>
    ```
    SELECT * FROM your_table_name;