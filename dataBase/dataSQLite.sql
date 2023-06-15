------------------------------- Tables Section ---------------------------

-- CREATE TABLE users(
-- ID INTEGER PRIMARY KEY AUTOINCREMENT,
-- Name TEXT NOT NULL,
-- Contact TEXT,
-- Registration TEXT NOT NULL UNIQUE,
-- PassWord TEXT NOT NULL
-- );

-- CREATE TABLE user_order(
-- ID INTEGER PRIMARY KEY AUTOINCREMENT,
-- Canteen_ID INTEGER NOT NULL,
-- Users_ID INTEGER NOT NULL,
-- OrdersMenu_ID INTEGER NOT NULL,
-- Paymenthods INTEGER NOT NULL,
-- Date TEXT,
-- FOREIGN KEY (Canteen_ID) REFERENCES canteens(ID),
-- FOREIGN KEY (Users_ID) REFERENCES users(ID),
-- FOREIGN KEY (OrdersMenu_ID) REFERENCES ordersMenu_canteens(ID)
-- );

-- CREATE TABLE canteens(
-- ID INTEGER PRIMARY KEY AUTOINCREMENT,
-- Name TEXT NOT NULL,
-- Registration TEXT NOT NULL UNIQUE,
-- PassWord TEXT NOT NULL,
-- Block TEXT NOT NULL
-- );

-- CREATE TABLE payMethods (
-- ID INTEGER PRIMARY KEY AUTOINCREMENT,
-- Canteen_ID INTEGER NOT NULL,
-- Type INTEGER NOT NULL,
-- FOREIGN KEY (Canteen_ID) REFERENCES canteens(ID)
-- );

-- CREATE TABLE ordersMenu_canteens(
-- ID INTEGER PRIMARY KEY AUTOINCREMENT,
-- Canteen_ID INTEGER NOT NULL,
-- Name TEXT NOT NULL,
-- Value INTEGER,
-- FOREIGN KEY (Canteen_ID) REFERENCES canteens(ID)
-- );

------------------------------- Values Section ---------------------------

-- INSERT INTO users (ID,Name,Contact,Registration,PassWord) 
-- VALUES (1,'William','Willian@gmail.com','11554463200','1234560');

-- INSERT INTO canteens (ID,Name,Registration,PassWord,Block) 
-- VALUES (1,'UTI do lanche','person@canteen.estacio.br','canteen','E');

-- INSERT INTO user_order (ID,Canteen_ID,Users_ID,OrdersMenu_ID,Paymenthods,Date) 
-- VALUES (1,1,1,1,1,'05/05/23');

-- INSERT INTO payMethods (ID,Canteen_ID,Type) 
-- VALUES (1,1,1);

-- INSERT INTO menu_canteens (ID,Canteen_ID,Name,Value) VALUES 
-- (1,1,'misto quente',350),
-- (2,1,'cafe',200),
-- (3,1,'tapioca amanteigada',350);

-- INSERT INTO menu_canteens (Canteen_ID,Name,Value) VALUES 
-- (1,'torta de frango',700),
-- (1,'torta de carne do sol',950),
-- (1,'macarronada',900),
-- (1,'torresminho',350),
-- (1,'cappuccino',450),
-- (1,'suco natural',250);

-- .tables users
SELECT * FROM users;
-- .tables canteens
SELECT * FROM canteens;
-- .tables user_order
SELECT * from user_order;

-- .tables payMethods
SELECT * from payMethods;

-- .tables menu_canteens
SELECT * from menu_canteens;
-- SELECT count(ID) FROM menu_canteens;
-- SELECT 
--     name
-- FROM 
--     sqlite_schema
-- WHERE 
--     type ='table' AND 
--     name NOT LIKE 'sqlite_%';

-- PRAGMA table_info(users);