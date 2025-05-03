CREATE TABLE IF NOT EXISTS wait_time (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    minutes INT
);

CREATE TABLE IF NOT EXISTS table_status (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    table_number INT,
    is_available BOOLEAN
);
