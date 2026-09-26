
# Event Booking System

A backend REST API for managing event bookings, built using Java and Spring Boot.

## Overview

This project is a learning-focused Event Booking System developed to understand and implement backend development concepts using Spring Boot.

The application provides REST APIs for creating, retrieving, updating, and deleting bookings, along with JPA entity relationships, DTOs, validation, exception handling, and appropriate HTTP status codes.

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman

## Features

- Create, retrieve, update, and delete bookings
- JPA entity relationships between bookings and events
- Request and Response DTOs
- Jakarta Bean Validation
- Centralized exception handling
- Custom exceptions for booking and event not found cases
- Appropriate HTTP response status codes
- MySQL database persistence

## Entity Relationship

The application contains two main entities:

- `Event`
- `Booking`

Relationship:

```text
Event
  │
  │ 1
  │
  │ *
Booking
````

An `Event` can have multiple `Booking` records, while each `Booking` belongs to one `Event`.

## API Endpoints

### Booking APIs

| Method | Endpoint         | Description          | Response       |
| ------ | ---------------- | -------------------- | -------------- |
| POST   | `/bookings`      | Create a new booking | 201 Created    |
| GET    | `/bookings`      | Get all bookings     | 200 OK         |
| GET    | `/bookings/{id}` | Get booking by ID    | 200 OK         |
| PUT    | `/bookings/{id}` | Update a booking     | 204 No Content |
| DELETE | `/bookings/{id}` | Delete a booking     | 204 No Content |

## Validation & Error Handling

The application uses Jakarta Bean Validation to validate incoming booking data.

Examples include:

* Required field validation
* Email format validation
* Minimum price validation
* Event existence validation
* Booking existence validation

A centralized exception handler is used to return consistent error responses for:

* Booking not found
* Event not found
* Invalid request data
* Unexpected server errors

## How to Run

### Prerequisites

Make sure the following are installed:

* Java 17
* MySQL
* Maven

### Steps

1. Clone the repository.
2. Create a MySQL database named `event_booking`.
3. Configure the database connection in `application.properties`.
4. Run the Spring Boot application.
5. Use Postman or another API client to test the endpoints.

## Future Improvements

* Pagination and sorting
* Improved SQL/database practices
* Automated testing
* Spring Security
* JWT-based authentication

````
