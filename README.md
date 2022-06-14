# PolandSalaryCalculator

The application has been created to calculate the salary net amount in pln and display all the taxation applied to the gross amount. The application will display the following fields:

* Pension Zus amount
* Disability zus amount
* Sickness zus amount
* Total zus amount
* Health amount
* Tax amount
* Yearly gross amount
* Yearly net amount
* Yearly net amount
* Net amount

The application will also ask if the user would like to participate in the statistics. If the user types "no", the application will terminate. Instead, if the user types "yes", it will be promted to choose one of the following job fields:

* It
* Finance
* Engineer
* Restaurant
* Airline

The input can be either lower case or uppercase. If the input does not match the list, it will be asked to try again. Else, the user has to provide one of the following job titles according to the job field chosen previously:

* It:
  * DevOps Engineer
  * Software Developer
  * Software Engineer
  * Cloud System Engineer
  * Cloud Architect
  * IT Analyst
  * Network Engineer
  * IT Support Specialist
  * Database Administrator
  * System Architect
  * Web Administrator
 
* Finance:
  * Fund Accountant
  * Depositary
  * Accountant
  * Tax Analyst
  * Auditor
  * Risk Analyst
  * Business Analyst
  * Billing Administrator
  * Financial Controller
 
* Engineer:
  * Mechanical Engineer 
  * Civil Engineer
  * Project Engineer
  * Project Engineer
  * Sales Engineer
  * R&D Engineer
  * Thermal Engineer 
  
* Restaurant
  * Executive Chef
  * Assistant Manager
  * General Manager
  * Sous Chef
  * Pastry Chef
  * Kitchen Manager
  * Line Cook
  * Bartender
  * Cashier
  * Dishwasher
  * Waitress
  
* Arline
  * Air Crew
  * Airline Captain
  * Airline Pilot
  * Airport Manager
  * Analyst
  * Chief Pilot
  * Traffic Manager
 

The application will display if the salary gross amount is above or below the gross salary average.

# Setup
* Required:
  * Docker
  * Postgres SQL
  * Java 11 or higher
* Optional
  * PgAdmin4

The application uses Postgres SQL Server, which runs in a Docker container. Please execute the following command to create the containers for Postgres SQL and PgAdmin4

* Docker container postgress:
  * docker pull postgres
  * docker run -p 5432:5432
-d \-e POSTGRES_PASSWORD=yourpassword-e POSTGRES_USER=youruser-e POSTGRES_DB=stripe-example-v pgdata:/var/lib/postgresql/datapostgres


* Docker container PgAdmin4: 
  * docker pull dpage/pgadmin4
  * docker run --name my-own-postgres -e POSTGRES_PASSWORD=postgresmaster -p 5432:5432 -d postgres

Create a table in PostgreSQL by executing the create table query.

CREATE TABLE IF NOT EXISTS public.salary_calculator ( id integer NOT NULL DEFAULT nextval('salary_calculator_id_seq'::regclass), pension_zus numeric, disability_zus numeric, sickness_zus numeric, total_zus numeric, health numeric, gross_yearly numeric, tax numeric, net_monthly numeric, net_yearly numeric, gross_monthly numeric, job_title character varying COLLATE pg_catalog."default", CONSTRAINT salary_calculator_pkey PRIMARY KEY (id) )

# How to run?

Clone the git repository, open the project with your favorite IDE, go to the DatabaseConfig class, and update the following fields according to your setup:

* HOST
* PASSWORD
* PORT
* USER

Once the database configuration is set, go to the SalaryCalculatorApplication class and run the main method.



