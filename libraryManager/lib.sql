-- MySQL Script generated by MySQL Workbench
-- 09/24/15 00:19:25
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema library_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema library_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `library_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `library_db` ;

-- -----------------------------------------------------
-- Table `library_db`.`user_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`user_type` (
  `id_user_type` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `user_type` ENUM('USER', 'ADMIN') NOT NULL COMMENT '',
  UNIQUE INDEX `user_type_UNIQUE` (`user_type` ASC)  COMMENT '',
  PRIMARY KEY (`id_user_type`)  COMMENT '',
  UNIQUE INDEX `id_user_type_UNIQUE` (`id_user_type` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library_db`.`subscription`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`subscription` (
  `id_subscription` INT NOT NULL COMMENT '',
  `statment` ENUM('ON_HANDS', 'IN_READING_ROOM') NOT NULL COMMENT '',
  `was_taken` TIME(8) NOT NULL COMMENT '',
  `was_returned` TIME(8) NULL COMMENT '',
  `id_user_subscription` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id_subscription`)  COMMENT '',
  UNIQUE INDEX `id_user_subscription_UNIQUE` (`id_user_subscription` ASC)  COMMENT '',
  INDEX `statment` (`statment` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`user` (
  `id_user` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `login` VARCHAR(45) NOT NULL COMMENT '',
  `password` VARCHAR(45) NOT NULL COMMENT '',
  `id_user_type_fk` INT NOT NULL COMMENT '',
  `salt` VARCHAR(20) NOT NULL COMMENT '',
  `e-mail` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id_user`)  COMMENT '',
  UNIQUE INDEX `login_UNIQUE` (`login` ASC)  COMMENT '',
  INDEX `id_user_type_fk_idx` (`id_user_type_fk` ASC)  COMMENT '',
  UNIQUE INDEX `e-mail_UNIQUE` (`e-mail` ASC)  COMMENT '',
  CONSTRAINT `id_user_type_fk`
    FOREIGN KEY (`id_user_type_fk`)
    REFERENCES `library_db`.`user_type` (`id_user_type`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `id_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `library_db`.`subscription` (`id_user_subscription`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library_db`.`author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`author` (
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `thurname` VARCHAR(45) NOT NULL COMMENT '',
  `second_name` VARCHAR(45) NOT NULL COMMENT '',
  `id_author` INT NOT NULL AUTO_INCREMENT COMMENT '',
  UNIQUE INDEX `id_author_UNIQUE` (`id_author` ASC)  COMMENT '',
  PRIMARY KEY (`id_author`)  COMMENT '',
  INDEX `thurname` (`thurname` ASC)  COMMENT '',
  UNIQUE INDEX `thurname_UNIQUE` (`thurname` ASC)  COMMENT '',
  INDEX `name` (`name` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library_db`.`section`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`section` (
  `id_section` INT NOT NULL COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id_section`)  COMMENT '',
  UNIQUE INDEX `name_UNIQUE` (`name` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library_db`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`book` (
  `id_book` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `id_section_fk` INT NOT NULL COMMENT '',
  `publication_date` INT NOT NULL COMMENT '',
  `number_of_pages` INT NOT NULL COMMENT '',
  `id_author_fk` INT NOT NULL COMMENT '',
  `is_avalible` TINYINT(1) NOT NULL COMMENT '',
  UNIQUE INDEX `id_book_UNIQUE` (`id_book` ASC)  COMMENT '',
  PRIMARY KEY (`id_book`)  COMMENT '',
  INDEX `id_author_fk_idx` (`id_author_fk` ASC)  COMMENT '',
  INDEX `id_section_fk_idx` (`id_section_fk` ASC)  COMMENT '',
  INDEX `name` ()  COMMENT '',
  CONSTRAINT `id_author_fk`
    FOREIGN KEY (`id_author_fk`)
    REFERENCES `library_db`.`author` (`id_author`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `id_section_fk`
    FOREIGN KEY (`id_section_fk`)
    REFERENCES `library_db`.`section` (`id_section`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library_db`.`book_to_subscription`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`book_to_subscription` (
  `id_subscription_fk` INT NOT NULL COMMENT '',
  `id_book_to_subscription_fk` INT NOT NULL COMMENT '',
  INDEX `id_subscription_fk_idx` (`id_subscription_fk` ASC)  COMMENT '',
  INDEX `id_book_to_subscription_idx` (`id_book_to_subscription_fk` ASC)  COMMENT '',
  CONSTRAINT `id_subscription_fk`
    FOREIGN KEY (`id_subscription_fk`)
    REFERENCES `library_db`.`subscription` (`id_subscription`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `id_book_to_subscription`
    FOREIGN KEY (`id_book_to_subscription_fk`)
    REFERENCES `library_db`.`book` (`id_book`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library_db`.`order_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`order_table` (
  `id_order` INT NOT NULL COMMENT '',
  `id_user` INT NOT NULL COMMENT '',
  `id_book` INT NOT NULL COMMENT '',
  `statment` ENUM('ON_HANDS', 'IN_READING_ROOM') NOT NULL COMMENT '',
  PRIMARY KEY (`id_order`)  COMMENT '',
  INDEX `id_user_fk_idx` (`id_user` ASC)  COMMENT '',
  INDEX `id_book_idx` (`id_book` ASC)  COMMENT '',
  CONSTRAINT `id_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `library_db`.`user` (`id_user`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `id_book`
    FOREIGN KEY (`id_book`)
    REFERENCES `library_db`.`book` (`id_book`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;