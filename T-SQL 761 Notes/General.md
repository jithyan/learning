# Introduction

* Databases typically have one of two structures:

   1. OLTP (Online Transaction Processing) - A structure that makes data inserts, updates and deletes very efficient. E.g. Normalizing. Reads become less efficient over time.
   2. OLAP (Online Analytical Processing) - aka Data Warehouse. Its structure makes reading data very efficient, but inserts/updates and deletes are inefficient.

* Most databases begin as OLTP.

## Terms

* **Transaction** - A set of logically related db modifications that form a single unit. Either they all succeed or if one fails, then all of them fail.
* **ACID**:
   - Atomicity: A transaction should be done or undone completely.
   - Consistency: A transaction transform a system from one consistent state to another.
   - Isolation: Each transaction should happen independently of other transaction occurring at the same time.
   - Durablity: Commited transaction should remain even during system failure.
* **Result Set** - The rows returned or affected by an T-SQL query.
* **Normalization** - organizing data ot minimize redundancy and remove ambiguity.
* **Commit** - A SQL command that marks a transaction as successful, which then applies the modifications to the database.
* **Rollback** - A SQL command that marks a transaction as unsuccessful, undos any database modifications (does not commit).

[DDL]

[DML]

## Features

* **Concatenation** : You can either use `+` or `CONCAT`. The advantage of the CONCAT function is that it converts your data types to VARCHAR for you!
