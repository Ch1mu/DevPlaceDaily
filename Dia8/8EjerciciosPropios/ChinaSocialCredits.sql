CREATE TABLE person(
    personid int AUTO_INCREMENT,
    name varchar(25) NOT NULL,
    lname varchar(50) NOT NULL,
    idnumber varchar(25) UNIQUE NOT NULL,
    adress varchar(25) NOT NULL,
    createdat datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedat datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(personid)
) ENGINE = INNODB;

CREATE TABLE goodact(
    goodactid int AUTO_INCREMENT,
    action varchar(300) NOT NULL,
    idnumber varchar(25) NOT NULL,
    PRIMARY KEY(goodactid),
    CONSTRAINT FK_personid 
    FOREIGN KEY(idnumber) REFERENCES person(idnumber)
) ENGINE = INNODB;

CREATE TABLE badact(
    badactid int AUTO_INCREMENT,
    action varchar(300) NOT NULL,
    idnumber varchar(25) NOT NULL,
    PRIMARY KEY(badactid),
    CONSTRAINT FK_personid2
    FOREIGN KEY(idnumber) REFERENCES person(idnumber)
) ENGINE = INNODB;

CREATE TABLE scpoints( 
    scpointsid int AUTO_INCREMENT, 
    idnumber varchar(25) NOT NULL, 
    socialcredits int NOT NULL, 
    PRIMARY KEY(scpointsid), 
    CONSTRAINT FK_SCPersonid 
    FOREIGN KEY(idnumber) REFERENCES person(idnumber) 
)ENGINE = INNODB

DELIMITER $$
CREATE TRIGGER TriggerdeleteSC
BEFORE INSERT ON badact FOR EACH ROW
BEGIN
    UPDATE scpoints sc SET socialcredits = socialcredits-1 where idnumber = NEW.idnumber;
END; $$

DELIMITER ;

DELIMITER $$

CREATE TRIGGER TriggerAddSC
AFTER INSERT ON goodact FOR EACH ROW
BEGIN
	UPDATE scpoints SET socialcredits = socialcredits + 1 WHERE idnumber = NEW.idnumber;
END;
$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER TriggerAddSC
AFTER INSERT ON person FOR EACH ROW
BEGIN
    UPDATE scpoints sc SET socialcredits = socialcredits+1 where idnumber = NEW.idnumber;
END;
$$
DELIMITER ;


