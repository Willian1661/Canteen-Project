-- CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, pedido TEXT);

-- INSERT INTO users VALUES(1,"Willian","willian@gmail.com","misto quente",1);
-- INSERT INTO users VALUES(2,"Lucas","lucas@gmail.com","misto quente + cafe");
-- INSERT into users VALUES(3,"Maria","mar@hotmail.com","cafe com leite");

-- ALTER TABLE users RENAME COLUMN contact TO user_contact;
-- ALTER TABLE users ADD COLUMN order_id INTEGER;
-- UPDATE users SET order_id = 1;

-- CREATE TABLE orders(order_id INTEGER PRIMARY KEY AUTOINCREMENT, user_id INTEGER, order_name TEXT);
-- ALTER TABLE orders RENAME studant_id to user_id;
-- INSERT INTO orders (user_id) SELECT user_id FROM users;
-- UPDATE orders SET order_time = "04/04/23";
-- SELECT * FROM users;
-- SELECT * FROM orders;

-- ////////////////////////////////


/* CREATE TABLE users2 (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    contact TEXT,
    order_id TEXT
);

CREATE TABLE orders2 (
    order_id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER,
    name TEXT,
    date TEXT,
    stock TEXT,
    receipt_type TEXT,
    FOREIGN KEY (user_id) REFERENCES users2(id)
); */

-- INSERT INTO users2 (name, contact, order_id) VALUES("willian","willian@gmail.com",1);
-- SELECT orders2.order_id, users2.name,orders2.name
-- FROM orders2
-- INNER JOIN users2 ON orders2.user_id = users2.id;

-- INSERT INTO orders2(name,date,stock,receipt_type) VALUES ("misto quente","05/045/23","999","money");

-- SELECT * FROM orders2;
-- SELECT * FROM users2;