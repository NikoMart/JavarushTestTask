CREATE TABLE `test`.`user`(
	id int(8) NOT NULL AUTO_INCREMENT,
	name varchar(25),
	age int,
	isAdmin bit NOT NULL DEFAULT FALSE,
	createDate timestamp DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
);

INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user1', '11');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user2', '22');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user3', '33');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user4', '44');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user5', '55');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user6', '66');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user7', '11');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user8', '22');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user9', '33');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user10', '44');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user11', '55');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user12', '66');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user13', '11');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user14', '22');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user15', '33');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user16', '44');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user17', '55');
INSERT INTO `test`.`user` (`name`, `age`) VALUES ('user18', '66');
