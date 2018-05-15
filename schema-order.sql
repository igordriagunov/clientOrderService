CREATE TABLE IF NOT EXISTS orders (
id INTEGER PRIMARY KEY AUTOINCREMENT,
orderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL  ,
orderSum INTEGER NOT NULL ,
status TEXT NOT NULL,
total INTEGER CHECK (total >=0) DEFAULT 0
);