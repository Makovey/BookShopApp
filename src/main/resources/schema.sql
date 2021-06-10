DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

CREATE TABLE books
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    title    VARCHAR(250) NOT NULL,
    priceOld VARCHAR(250) DEFAULT NULL,
    price    VARCHAR(250) DEFAULT NULL
);

CREATE TABLE authors
(
    id     INT AUTO_INCREMENT PRIMARY KEY,
    bookId INT references books (id),
    firstName VARCHAR(250) NOT NULL,
    lastName VARCHAR(250) NOT NULL
);