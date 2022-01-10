# FInanceManagementApp

## Finance Management Microservice written in Java Spring

### Basic Features 
1.  Import transactions from csv file <br/>
-Enable import of bank transactions based on the format of bank_transactions.csv file.
-Expose POST /transactions/import API endpoint for this purpose.
-Create relational DB schema to support import of transactions with id as primary key.
-Validate input according to OAS3 spec.
-Persist transaction into database.

2.   List transactions with filters and pagination <br/>
*Enable paginated listing of transactions based on supplied filter conditions.
*Expose GET /transactions API endpoints for this purpose.
*Implement period filter (start-date and end-date).
*Implement transaction kinds filter as a list of acceptable transaction kinds.

3.  Import categories from csv file <br/>
*Enable import of spending categories based on the format of categories.csv file.
*Expose POST /categories/import API endpoint for this purpose.
*Create relational DB schema to support import of categories with code as primary key and foreign key from transactions to categories on catcode matching code field.
*Validate input according to OAS3 spec.
*Persist categories into database.
<br/>
*Note : * <br/>
*when code already exists its name should be updated
*parent-code already exists it should be updated

4.  Categorize single transaction <br/>
*Enable categorization of a single transaction.
*Expose POST /transactions/{id}/categorize endpoint for this purpose.
*Validate that both category and transaction exists in database.
*Persist newly set category in database.

5. Split transaction <br/>
[*Enable split of transaction into multiple spending categories or subcategories.
*Expose POST /transactions/{id}/split endpoint for this purpose.
*If transaction is already split, deleta existing splits and replace them with new ones.
*Validate that the transaction and categories exist.
*Create relational DB schema that can persist splits for a transaction.
*Extend transaction list endpoint to return splits for each transaction.
*Persist splits into database with amount and catcode.]

