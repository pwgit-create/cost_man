CREATE TABLE Prio_Queue(
id SERIAL PRIMARY KEY,
type INTEGER REFERENCES Prio_Queue_Type(id) NOT NULL,
name TEXT NOT NULL,
created TIMESTAMP);
