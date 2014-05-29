--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `mysql_e`.`cartitem` DROP PRIMARY KEY;

DROP TABLE `mysql_e`.`cartitem`;

CREATE TABLE `mysql_e`.`cartitem` (
	`CartItem_Id` INT NOT NULL,
	`Product_id` INT NOT NULL,
	`quantity_count` INT NOT NULL,
	`price` INT NOT NULL,
	`Shopping_cart_id` INT NOT NULL,
	PRIMARY KEY (`CartItem_Id`)
);

