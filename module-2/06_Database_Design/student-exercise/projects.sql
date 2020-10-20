        BEGIN TRANSACTION;
        
        
        DROP TABLE IF EXISTS department_employee;
        DROP TABLE IF EXISTS project_employee;
        DROP TABLE IF EXISTS project;
        DROP TABLE IF EXISTS employee;
        DROP TABLE IF EXISTS department;
     
         CREATE TABLE department
        (
                dep_Id SERIAL,
                dep_Name VARCHAR(160) NOT NULL,
                
                constraint pk_employee_identifier PRIMARY KEY (dep_Id)
                
        );  
        
          
        CREATE TABLE employee
        ( 
                employee_Id SERIAL,
                title VARCHAR(160) NOT NULL,
                last_Name VARCHAR(50) NOT NULL,
                first_Name VARCHAR(50) NOT NULL,
                gender VARCHAR(6) NOT NULL,
                date_of_Birth date NOT NULL,
                date_of_Hire date NOT NULL,
                
                constraint pk_employee_Id PRIMARY KEY (employee_Id)
                
                
        );
        
        CREATE TABLE department_employee
        (       
                dep_slot_id SERIAL NOT NULL,
                dep_Id int,
                employee_Id int,
                
                constraint pk_dep_slot_id PRIMARY KEY (dep_slot_id),
                constraint fk_employee_dep FOREIGN KEY (employee_Id) references employee (employee_Id),
                constraint fk_dep_identifier FOREIGN KEY (dep_Id) references department (dep_Id)
        );
        
      
        
         

        
      
         CREATE TABLE project
        (
                project_Id SERIAL,
                project_Name VARCHAR(160) NOT NULL,
                project_start_Date date NOT NULL,
                
                constraint pk_project_Id PRIMARY KEY (project_Id)
                
        ); 
        
        CREATE TABLE project_employee
        (
                slot_id SERIAL NOT NULL,
                employee_id int NOT NULL,
                project_id int NOT NULL,
                
                constraint pk_slot_identifier PRIMARY KEY (slot_id),
                constraint fk_employee_project FOREIGN KEY (employee_Id) references employee (employee_Id),
                constraint fk_project_identifier FOREIGN KEY (project_Id) references project (project_Id)
        );        

        
 
        COMMIT;