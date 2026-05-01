📚 Library Seat Reservation System

(Java Swing + JDBC + MySQL)

1. Project Overview

The Library Seat Reservation System is a desktop-based application developed using Java Swing for the graphical user interface and JDBC for database connectivity with MySQL.

This system is designed to automate the process of managing library seats. It allows administrators to manage seat records and enables students to reserve, view, and cancel seat bookings through a user-friendly interface.

2. Objectives

The main objective of this project is to eliminate manual seat allocation and provide an efficient digital solution. It aims to simplify seat management, improve accessibility, and ensure that users can easily interact with the system through a graphical interface.

3. Technologies Used

The application is built using Java as the programming language. Java Swing is used to design the graphical user interface. MySQL is used as the database to store user, seat, and reservation data. JDBC is used to establish communication between the Java application and the database. The project can be developed using IDEs such as Eclipse or IntelliJ IDEA.

4. Database Description

The system uses a MySQL database named library_seat_db_gui. It contains three main tables.

The users table stores login credentials and roles of users. Each user has a unique ID, username, password, and role which can be either admin or student.

The seats table stores information about available seats in the library. Each seat has a unique ID, a seat number, and a status indicating whether it is available or booked.

The reservations table stores booking details. It connects users and seats using foreign keys and includes the reservation date and time slot.

5. System Architecture

The project follows a three-layer architecture.

The presentation layer consists of Swing-based GUI screens that interact with the user. The business logic layer controls the flow of the application and handles validations. The data access layer contains DAO classes that perform database operations such as inserting, updating, deleting, and retrieving records.

6. Modules Description

The login module is responsible for authenticating users. Based on the role, it redirects users to either the admin panel or the student panel.

The admin module allows administrators to add new seats, view all seats, and delete seats from the system.

The student module allows students to view available seats, reserve a seat by selecting a date and time slot, view their reservations, and cancel any existing reservations.

The reservation module manages booking operations. It checks seat availability before reserving, updates the seat status after booking, and restores availability when a reservation is canceled.

7. System Workflow

The admin logs into the system using valid credentials and can perform operations such as adding, viewing, or deleting seats before logging out.

The student logs into the system and can view available seats, make a reservation by entering required details, view their bookings, and cancel reservations if needed.

8. Key Classes

The DBConnection class is responsible for establishing a connection to the MySQL database.

The UserDAO class handles user authentication by verifying login credentials.

The SeatDAO class manages seat-related operations such as adding, viewing, and deleting seats.

The ReservationDAO class handles reservation-related operations including booking, viewing, and canceling reservations.

The Swing UI classes such as LoginFrame, AdminFrame, StudentFrame, and others provide the graphical interface for user interaction.

9. Features

The system provides a graphical user interface for ease of use. It supports role-based access control for admins and students. It maintains real-time seat status updates and allows users to manage reservations efficiently.

10. Limitations

The system currently stores passwords in plain text, which is not secure. It does not include a user registration feature. It also lacks advanced validation and does not handle concurrent booking conflicts. The user interface is basic due to the limitations of Swing.

11. Future Enhancements

The project can be improved by adding password encryption for better security. A user registration feature can be introduced. A calendar-based date picker can enhance usability. The system can be extended to manage seat availability based on time slots more effectively. The interface can be upgraded using modern frameworks like JavaFX, and the project can also be converted into a web-based application using technologies like Spring Boot.

12. Conclusion

The Library Seat Reservation System successfully demonstrates how Java Swing and JDBC can be used to build a functional desktop application integrated with a database. It simplifies the process of managing library seats and provides a strong foundation for developing more advanced reservation systems in the future.
