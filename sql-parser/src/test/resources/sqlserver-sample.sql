CREATE TABLE Employee (
	id INT NOT NULL,
	firstname VARCHAR(128) NULL,
	lastname VARCHAR(128) NULL,
	DateOfBirth DateTime NULL
)
GO

ALTER TABLE Employee ADD Comments VARCHAR(4000) NULL
GO