-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cinema
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cinema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cinema` DEFAULT CHARACTER SET utf8 ;
USE `cinema` ;

-- -----------------------------------------------------
-- Table `cinema`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinema`.`role` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinema`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinema`.`account` (
  `id` INT NOT NULL,
  `account_name` VARCHAR(45) NULL,
  `full_name` VARCHAR(45) NULL,
  `role_id` INT NOT NULL,
  `password` VARCHAR(45) NULL,
  `facebook_id` VARCHAR(45) NULL,
  `google_id` VARCHAR(45) NULL,
  `id_number` VARCHAR(45) NULL,
  `profile_picture` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `phone_number` VARCHAR(45) NULL,
  `gender` BIT(1) NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `member_code` VARCHAR(45) NULL,
  `point` VARCHAR(45) NULL,
  `is_deleted` BIT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_account_role_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_account_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `cinema`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinema`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinema`.`booking` (
  `id` INT NOT NULL,
  `account_id` INT NOT NULL,
  `print_status` BIT(1) NULL,
  `is_deleted` BIT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_booking_account1_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_booking_account1`
    FOREIGN KEY (`account_id`)
    REFERENCES `cinema`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinema`.`hall`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinema`.`hall` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `total_seat` INT NULL,
  `is_deleted` BIT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinema`.`time`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinema`.`time` (
  `id` INT NOT NULL,
  `time` TIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinema`.`movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinema`.`movie` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `start_date` DATE NULL,
  `actor` VARCHAR(45) NULL,
  `director` VARCHAR(45) NULL,
  `duration` INT NULL,
  `producer` VARCHAR(45) NULL,
  `trailer` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `poster` VARCHAR(45) NULL,
  `ticket_price` INT NULL,
  `is_deleted` BIT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinema`.`schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinema`.`schedule` (
  `id` INT NOT NULL,
  `date` DATE NULL,
  `hall_id` INT NOT NULL,
  `time_id` INT NOT NULL,
  `is_deleted` BIT(1) NULL DEFAULT 0,
  `movie_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_schedule_hall1_idx` (`hall_id` ASC) VISIBLE,
  INDEX `fk_schedule_time1_idx` (`time_id` ASC) VISIBLE,
  INDEX `fk_schedule_movie1_idx` (`movie_id` ASC) VISIBLE,
  CONSTRAINT `fk_schedule_hall1`
    FOREIGN KEY (`hall_id`)
    REFERENCES `cinema`.`hall` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_schedule_time1`
    FOREIGN KEY (`time_id`)
    REFERENCES `cinema`.`time` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_schedule_movie1`
    FOREIGN KEY (`movie_id`)
    REFERENCES `cinema`.`movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinema`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinema`.`ticket` (
  `id` INT NOT NULL,
  `seat_number` INT NULL,
  `booking_id` INT NOT NULL,
  `schedule_id` INT NOT NULL,
  `is_deleted` BIT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_ticket_booking1_idx` (`booking_id` ASC) VISIBLE,
  INDEX `fk_ticket_schedule1_idx` (`schedule_id` ASC) VISIBLE,
  CONSTRAINT `fk_ticket_booking1`
    FOREIGN KEY (`booking_id`)
    REFERENCES `cinema`.`booking` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_schedule1`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `cinema`.`schedule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinema`.`genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinema`.`genre` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `is_deleted` BIT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinema`.`movie_has_genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinema`.`movie_has_genre` (
  `movie_id` INT NOT NULL,
  `genre_id` INT NOT NULL,
  PRIMARY KEY (`movie_id`, `genre_id`),
  INDEX `fk_movie_has_genre_genre1_idx` (`genre_id` ASC) VISIBLE,
  INDEX `fk_movie_has_genre_movie1_idx` (`movie_id` ASC) VISIBLE,
  CONSTRAINT `fk_movie_has_genre_movie1`
    FOREIGN KEY (`movie_id`)
    REFERENCES `cinema`.`movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movie_has_genre_genre1`
    FOREIGN KEY (`genre_id`)
    REFERENCES `cinema`.`genre` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
