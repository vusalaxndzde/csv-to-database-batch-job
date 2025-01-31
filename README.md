# Spring Batch Customer Import

A Spring Batch application that reads customer data from a CSV file and loads it into a relational database. This project demonstrates how to use Spring Batch for batch processing, including reading from external CSV files, transforming the data, and writing it to a database.

<p align="center">
     <a alt="Java">
        <img src="https://img.shields.io/badge/Java-v17-blue.svg" />
    </a>
    <a alt="Spring Boot">
        <img src="https://img.shields.io/badge/Spring%20Boot-v3.4.2-brightgreen.svg" />
    </a>
    <a alt="Maven">
        <img src="https://img.shields.io/badge/Maven-v4.0.0-orange.svg" />
    </a>
</p>

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
git clone https://github.com/vusalaxndzde/spring-batch-customer-import.git
cd csv-to-database-batch-job
