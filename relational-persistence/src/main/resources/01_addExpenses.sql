create table expense(
    id INT,
    expended DATE default NULL,
    amount VARCHAR(20),
    reason VARCHAR(40),
    PRIMARY KEY (id)
);