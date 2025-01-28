# Hospital Management System

## Overview

The **Hospital Management System** is a desktop application developed using **Java (Swing and AWT)** for the user interface and **pgAdmin (PostgreSQL)** for the database management. This system provides a seamless way to manage hospital operations, including patient details, doctor assignments and appointment schedulingil.

---

## Features

1. **Patient Management**

   - Add, update, and delete patient details.
   - View patient history and medical records.

2. **Doctor Management**

   - Manage doctor profiles and specializations.
   - Assign doctors to patients.

3. **Appointment Scheduling**

   - Book, update, and cancel appointments.
   - View schedules by date and doctor.

4. **Database Integration**

   - PostgreSQL is used for secure and efficient data management.

---

## Tech Stack

- **Frontend**: Java Swing, AWT
- **Backend**: Java
- **Database**: PostgreSQL (pgAdmin)
- **IDE**: IntelliJ IDEA / Eclipse / NetBeans (any Java IDE of your choice)

---

## Prerequisites

1. **Java Development Kit (JDK)** 8 or higher
2. **PostgreSQL** (with pgAdmin)
3. A Java IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans)

---

## Setup Instructions

### 1. Clone the Repository

```bash
$ git clone https://github.com/DeepankSingh/Hospital-Management-System.git
$ cd Hospital-Management-System
```

### 2. Set Up the Database

1. Open **pgAdmin** and create a new database (e.g., `hospital_management`).
2. Run the SQL scripts provided in the `database` folder to create the necessary tables and insert initial data.

### 3. Configure the Application

1. Locate the `dbConfig.java` file in the project.
2. Update the database connection details:
   ```java
   private static final String URL = "jdbc:postgresql://localhost:5432/hospital_management";
   private static final String USER = "your_username";
   private static final String PASSWORD = "your_password";
   ```

### 4. Run the Application

1. Open the project in your preferred IDE.
2. Compile and run the `Main.java` file to start the application.

---

## Screenshots

(Add screenshots of the application here, such as the login screen, patient management screen, etc.)

---

## Future Enhancements

- Add role-based authentication for admin, doctors, and staff.
- Implement a notification system for upcoming appointments.
- Create a reporting module for data analytics.
- Enhance the UI with modern design principles.

---

## License

This project is licensed under the [MIT License](LICENSE).

---

## Contribution

Contributions are welcome! If you'd like to contribute:

1. Fork the repository.
2. Create a feature branch: `git checkout -b feature-name`.
3. Commit your changes: `git commit -m 'Add some feature'`.
4. Push to the branch: `git push origin feature-name`.
5. Open a pull request.

---

## Contact

If you have any questions or need further assistance, feel free to contact me:

- **Email**: [singhdeepank9@gmail.com](mailto\:singhdeepank9@gmail.com)
- **LinkedIn**: [Deepank Singh](https://www.linkedin.com/in/deepank-singh/)

