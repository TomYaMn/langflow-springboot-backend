-- liquibase formatted sql

-- changeset developer:1
CREATE TABLE intranet_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone_no VARCHAR(50),
    nric VARCHAR(50),
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);
-- rollback DROP TABLE intranet_user;

-- changeset developer:2
CREATE TABLE internet_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone_no VARCHAR(50),
    nric VARCHAR(50),
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);
-- rollback DROP TABLE internet_user;

-- changeset developer:3
CREATE TABLE application (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     application_no VARCHAR(100) NOT NULL,
     submitted_by_internet_user_id BIGINT NOT NULL,
     reviewed_by_intranet_user_id BIGINT,
     status INT NOT NULL,
     intranet_user_remark TEXT,
     created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     created_by VARCHAR(255),
     updated_by VARCHAR(255),
     CONSTRAINT fk_app_internet_user FOREIGN KEY (submitted_by_internet_user_id) REFERENCES internet_user(id),
     CONSTRAINT fk_app_intranet_user FOREIGN KEY (reviewed_by_intranet_user_id) REFERENCES intranet_user(id)
);
-- rollback DROP TABLE application;

-- changeset developer:4
CREATE TABLE intranet_user_log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    intranet_user_id BIGINT NOT NULL,
    remark TEXT,
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT fk_log_intranet_user FOREIGN KEY (intranet_user_id) REFERENCES intranet_user(id)
);
-- rollback DROP TABLE intranet_user_log;

-- changeset developer:5
CREATE TABLE internet_user_log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    internet_user_id BIGINT NOT NULL,
    remark TEXT,
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT fk_log_internet_user FOREIGN KEY (internet_user_id) REFERENCES internet_user(id)
);
-- rollback DROP TABLE internet_user_log;

-- changeset developer:6
CREATE TABLE listener_log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    response_body LONGTEXT,
    remark TEXT,
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);
-- rollback DROP TABLE listener_log;

-- changeset developer:7
CREATE TABLE publisher_log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    request_body LONGTEXT,
    remark TEXT,
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);
-- rollback DROP TABLE publisher_log;