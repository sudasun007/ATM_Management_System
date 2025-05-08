# 🏦 ATM Management System

A desktop-based **ATM Management System** developed using **Java Swing** for the frontend and **MySQL** for the backend database. This project simulates basic ATM functionalities such as login, balance inquiry, deposit, withdrawal, and viewing mini-statements.

---

## 📋 Features

- User Registration (Multi-step forms)
- Account Creation with Card and PIN generation
- Login using Card Number and PIN
- Deposit and Withdraw Money
- Balance Inquiry
- Mini Statement (View past transactions)
- Secure database design with proper relations

---

## 🛠️ Technologies Used

- **Java** (JDK 8 or above)
- **Java Swing** (for GUI)
- **MySQL** (for database)
- **JDBC** (for connecting Java with MySQL)

---

## 🧱 Database Schema

Database name: `atmDB`

### Tables:

1. **signup**
   - Stores personal information collected during registration.

2. **signuptwo**
   - Stores additional details like religion, category, occupation, etc.

3. **signupthree**
   - Stores account type, card number, and PIN.

4. **login**
   - Stores card number and PIN for login validation.

5. **bank**
   - Stores transaction records including deposits and withdrawals.

---

## 📂 Project Structure

```text
atm-management-system/
│
├── src/
│   └── atm/management/system/
│       ├── Signup.java
│       ├── SignupTwo.java
│       ├── SignupThree.java
│       ├── Login.java
│       ├── Transactions.java
│       ├── Deposit.java
│       ├── Withdraw.java
│       ├── BalanceInquiry.java
│       ├── MiniStatement.java
│       └── Conn.java
│
├── icons/
│   └── atm.jpg                (ATM GUI background image)
│
├── atmDB.sql                 (SQL script to create all tables)
├── README.md
```

---

## 🚀 How to Run the Project

### 🔧 Requirements

- Java JDK 8 or above
- MySQL Server
- MySQL Workbench (optional)
- IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans)

### ⚙️ Setup Steps

1. **Clone the repository** or download the project folder.

2. **Create the database:**

   - Open MySQL Workbench or CLI.
   - Run the SQL script from `atmDB.sql` to create the database and all necessary tables.

3. **Update the database connection:**

   In `Conn.java`, update your database credentials:
   ```java
   String url = "jdbc:mysql://localhost:3306/atmDB";
   String user = "root"; // your username
   String password = "your_password";
   ```

4. **Compile and Run:**

   Open the project in your Java IDE.

   Compile and run `Login.java` or `Signup.java` to begin using the application.

---

## 🛡️ Security Notes

- The system uses a basic card number and PIN system for authentication.
- No password/PIN encryption is implemented (for educational use only).
- You can enhance the project by integrating hashing algorithms and validation mechanisms.
