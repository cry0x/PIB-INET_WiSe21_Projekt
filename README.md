# pib-inet

## Setup Database
### PostgreSQL
```sql
CREATE TABLE users(
  id SERIAL PRIMARY KEY NOT NULL,
  lastname varchar(75) NOT NULL,
  firstname varchar(75) NOT NULL,
  email varchar(75) UNIQUE NOT NULL,
  street varchar(75),
  house_number int,
  postal_code int,
  town varchar(75)
);
```