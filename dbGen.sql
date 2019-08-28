CREATE TABLE pal_members (
  id         BIGINT(20) NOT NULL AUTO_INCREMENT,
  name 	     CHAR(20),
  gender     BIGINT(20),
  desc       CHAR(20),
  PRIMARY KEY (id)
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8;
