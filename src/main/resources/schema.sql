CREATE TABLE coin
(
    code       CHAR(3) PRIMARY KEY,
    name       VARCHAR(20) NOT NULL,
    created_at TIMESTAMP   NOT NULL DEFAULT current_timestamp,
    updated_at TIMESTAMP   NOT NULL DEFAULT current_timestamp
);
