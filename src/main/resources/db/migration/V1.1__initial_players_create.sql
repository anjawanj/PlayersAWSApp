USE players;

CREATE TABLE players
(
    id               BIGINT(20) NOT NULL AUTO_INCREMENT,
    first_name       varchar(255) DEFAULT NULL,
    last_name        varchar(255) DEFAULT NULL,
    country          varchar(255) DEFAULT NULL,
    role             varchar(255) DEFAULT NULL,
    teams            varchar(2048) DEFAULT NULL,
    birth_date       datetime DEFAULT NULL,
    status           int(4) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
