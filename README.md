# Spring Batch Customer Import

A Spring Batch application that reads customer data from a CSV file and loads it into a relational database. This project demonstrates how to use Spring Batch for batch processing, including reading from external CSV files, transforming the data, and writing it to a database.

## Features

- **CSV Parsing**: Reads customer data from a CSV file.
- **Batch Processing**: Uses Spring Batch to process the data in chunks.
- **Database Insertion**: Inserts customer data into a relational database (MySQL/PostgreSQL).
- **Job Execution**: Supports batch job execution for large datasets.
- **Spring Boot Integration**: Leverages Spring Boot for easy setup and management.

## Requirements

- Java 17 or higher
- Spring Boot 3.x
- A relational database (e.g., MySQL, PostgreSQL)
- Maven or Gradle
- CSV file containing customer data

## Setup

### Clone the Repository

```bash
git clone https://github.com/yourusername/spring-batch-customer-import.git
cd spring-batch-customer-import
