# 🏦 Bank Account Management System

This is a **Java-based Bank Account Management System** built to demonstrate Object-Oriented Programming (OOP) concepts such as **Inheritance**, **Polymorphism**, **Encapsulation**, and **Abstraction**. The project allows users to create bank accounts, deposit and withdraw funds, and view account details.

---

## 🚀 Features
✔️ Create Savings and Current Accounts  
✔️ Deposit and Withdraw Money  
✔️ View Account Balance  
✔️ Transaction History  
✔️ Error Handling for Invalid Inputs and Insufficient Balance  

---

## 🏗️ OOP Concepts Applied
### 1. **Abstraction**  
- `BankAccount` is an abstract class that defines common properties and methods for different account types.
- It hides implementation details and exposes only the necessary functionalities.

### 2. **Inheritance**  
- `SavingsAccount` and `CurrentAccount` classes inherit from the `BankAccount` class.
- Common behaviors are defined in `BankAccount` and customized in the child classes.

### 3. **Polymorphism**  
- Method Overriding: `withdraw()` method is implemented differently in `SavingsAccount` and `CurrentAccount`.
- This allows dynamic behavior at runtime.

### 4. **Encapsulation**  
- Account details like `balance`, `accountNumber`, and `holderName` are private.
- Access is controlled through public getters and setters.

---
