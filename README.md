# Bank Account Kata
Version java : java 11


This project includes tests for the deposit and withdrawal operations of an account service.
The following tests validate the behavior of deposit and withdrawal methods to ensure correct 
handling of edge cases and valid operations.

**# Tests Overview : AccountServiceImplTest**
**1. `testDeposit_AmountLessThanOrEqualToZero_ShouldThrowException`**
- **Description**: This test ensures that if a user attempts to deposit an amount less than or equal
to zero, an `IllegalArgumentException` is thrown.
- **Reason for Test**: Depositing a non-positive amount is invalid. This test verifies that the
system correctly rejects such input by throwing the appropriate exception.
- **Expected Outcome**: The method should throw an `IllegalArgumentException` with the message
"Deposit amount must be greater than zero."

**2. `testDeposit_ValidAmount_ShouldSucceed`**
- **Description**: This test checks if a valid deposit operation (amount greater than zero) 
successfully updates the account balance.
- **Reason for Test**: To confirm that positive deposit amounts are correctly processed and
the account balance is updated as expected.
- **Expected Outcome**: The deposit should succeed, and the account balance should increase by the
specified amount.

 ****3. `testWithdraw_AmountLessThanOrEqualToZero_ShouldThrowException`****
- **Description**: This test validates that when a user tries to withdraw an amount less than or 
equal to zero, an `IllegalArgumentException` is thrown.
- **Reason for Test**: Withdrawing a non-positive amount is an invalid operation, and this test 
ensures the system enforces this rule correctly.
- **Expected Outcome**: The method should throw an `IllegalArgumentException` with the message 
"Withdrawal amount must be greater than zero."

 **4. `testWithdraw_AmountGreaterThanBalance_ShouldThrowException`**
- **Description**: This test ensures that if the withdrawal amount exceeds the current account
balance, an `IllegalArgumentException` is thrown.
- **Reason for Test**: A withdrawal greater than the available balance should not be allowed. 
This test ensures the system correctly checks the balance before processing the withdrawal.
- **Expected Outcome**: The method should throw an `IllegalArgumentException` with the message 
"The balance is insufficient to withdraw."

**5. `testWithdraw_ValidAmount_ShouldSucceed`**
- **Description**: This test checks if a valid withdrawal operation (amount less than or equal 
to the account balance) is successfully processed.
- **Reason for Test**: To confirm that valid withdrawals are properly handled, the account balance 
should be reduced by the withdrawal amount.
- **Expected Outcome**: The withdrawal should succeed, and the account balance should decrease by
the specified amount.

**# Tests Overview : StatementPrinterImplTest**
**1. `shouldPrintStatement`**
- **Description**:
This test ensures that the statement print functionality formats the operations in the correct way.
It verifies that the output statement correctly prints a list of operations in a structured and 
human-readable format, which includes the date, operation type, amount, and balance.
**2. `shouldRecordOperationsInHistory`**
- **Description**:
This test ensures that every operation (such as deposits and withdrawals) is properly recorded in the transaction
history. It verifies that when an operation is performed on an account, the details of the operation
(such as the date, type of operation, amount, and balance) are saved and can be accessed later.


**# Testing Framework**
These tests are written using **JUnit 5** .

**## How to Run the Tests**

1. Clone this repository:
  
   **git clone <repository_url>**

2.  Navigate to the project directory
 **cd repository_url** 


3. Run the tests using Maven:

    **mvn test**

