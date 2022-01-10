# FInanceManagementApp

## Finance Management Microservice written in Java Spring

### Basic Features 
1.  _Import transactions from csv file_ <br/>
- Enable import of bank transactions based on the format of bank_transactions.csv file. <br/>
- Expose POST /transactions/import API endpoint for this purpose.<br/>
- Create relational DB schema to support import of transactions with id as primary key.<br/>
- -Validate input according to OAS3 spec.<br/>
- Persist transaction into database.<br/>

2.   _List transactions with filters and pagination_ <br/>
- Enable paginated listing of transactions based on supplied filter conditions.<br/>
- Expose GET /transactions API endpoints for this purpose.<br/>
- Implement period filter (start-date and end-date).<br/>
- Implement transaction kinds filter as a list of acceptable transaction kinds.<br/>

3.  _Import categories from csv file_ <br/>
- Enable import of spending categories based on the format of categories.csv file.<br/>
- Expose POST /categories/import API endpoint for this purpose.<br/>
- Create relational DB schema to support import of categories with code as primary key and foreign key from transactions to categories on catcode matching code field.<br/>
- Validate input according to OAS3 spec.<br/>
- Persist categories into database.<br/>
<br/>
##### Note :  <br/>
- when code already exists its name should be updated<br/>
- parent-code already exists it should be updated<br/> 
<br/>

4.  _Categorize single transaction_ <br/>
- Enable categorization of a single transaction.<br/>
- Expose POST /transactions/{id}/categorize endpoint for this purpose.<br/>
- Validate that both category and transaction exists in database.<br/>
- Persist newly set category in database.<br/>

5. _Split transaction_ <br/>
- Enable split of transaction into multiple spending categories or subcategories.<br/>
- Expose POST /transactions/{id}/split endpoint for this purpose.<br/>
- If transaction is already split, deleta existing splits and replace them with new ones.<br/>
- Validate that the transaction and categories exist.<br/>
- Create relational DB schema that can persist splits for a transaction.<br/>
- Extend transaction list endpoint to return splits for each transaction.<br/>
- Persist splits into database with amount and catcode.

