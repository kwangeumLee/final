DROP DATABASE IF EXISTS pal_member;
DROP DATABASE IF EXISTS pal_member_test;

CREATE DATABASE pal_member;
CREATE DATABASE pal_member_test;

CREATE USER IF NOT EXISTS 'member'@'localhost'
  IDENTIFIED BY '';
GRANT ALL PRIVILEGES ON pal_member.* TO 'member' @'localhost';
GRANT ALL PRIVILEGES ON pal_member_test.* TO 'member' @'localhost';