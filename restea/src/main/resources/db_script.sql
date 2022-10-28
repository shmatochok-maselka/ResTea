-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ResTea
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ResTea
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ResTea` DEFAULT CHARACTER SET utf8 ;
USE `ResTea` ;

-- -----------------------------------------------------
-- Table `ResTea`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ResTea`.`user` (
  `id` INT NOT NULL,
  `name` VARCHAR(15) NOT NULL,
  `surname` VARCHAR(15) NOT NULL,
  `birthday` DATE NOT NULL,
  `bonus` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ResTea`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ResTea`.`role` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ResTea`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ResTea`.`user_role` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `role_id_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `ResTea`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `ResTea`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ResTea`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ResTea`.`order` (
  `id` INT NOT NULL,
  `phone` VARCHAR(12) NOT NULL,
  `address` VARCHAR(50) NOT NULL,
  `date` DATETIME NOT NULL,
  `price` DOUBLE NOT NULL,
  `used_bonus` INT NOT NULL,
  `receiver_name` VARCHAR(15) NOT NULL,
  `receiver_surname` VARCHAR(15) NOT NULL,
  `order_user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`order_user_id` ASC) VISIBLE,
  CONSTRAINT `order_user_id`
    FOREIGN KEY (`order_user_id`)
    REFERENCES `ResTea`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ResTea`.`type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ResTea`.`type` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ResTea`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ResTea`.`product` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `description` VARCHAR(400) NOT NULL,
  `image` BLOB NOT NULL,
  `price` DOUBLE NOT NULL,
  `type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `type_id_idx` (`type_id` ASC) VISIBLE,
  CONSTRAINT `type_id`
    FOREIGN KEY (`type_id`)
    REFERENCES `ResTea`.`type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ResTea`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ResTea`.`cart` (
  `cart_user_id` INT NOT NULL,
  `cart_product_id` INT NOT NULL,
  PRIMARY KEY (`cart_user_id`, `cart_product_id`),
  INDEX `product_id_idx` (`cart_product_id` ASC) VISIBLE,
  CONSTRAINT `cart_user_id`
    FOREIGN KEY (`cart_user_id`)
    REFERENCES `ResTea`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cart_product_id`
    FOREIGN KEY (`cart_product_id`)
    REFERENCES `ResTea`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ResTea`.`order_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ResTea`.`order_product` (
  `order_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `count` INT NOT NULL,
  PRIMARY KEY (`order_id`, `product_id`),
  INDEX `product_id_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `order_id`
    FOREIGN KEY (`order_id`)
    REFERENCES `ResTea`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `ResTea`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
