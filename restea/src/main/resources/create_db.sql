-- MySQL Script generated by MySQL Workbench
-- Sun Oct 30 19:32:25 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ResTea
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ResTea` ;

-- -----------------------------------------------------
-- Schema ResTea
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ResTea` DEFAULT CHARACTER SET utf8 ;
USE `ResTea` ;

CREATE SCHEMA IF NOT EXISTS `ResTea` DEFAULT CHARACTER SET utf8 ;
USE `ResTea` ;

-- -----------------------------------------------------
-- Table `ResTea`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ResTea`.`user` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
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
-- Table `ResTea`.`Type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ResTea`.`Type` ;

CREATE TABLE IF NOT EXISTS `ResTea`.`Type` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `name` VARCHAR(20) NOT NULL,
                                               PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ResTea`.`Origin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ResTea`.`Origin` ;

CREATE TABLE IF NOT EXISTS `ResTea`.`Origin` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `name` VARCHAR(45) NOT NULL,
                                                 PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ResTea`.`Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ResTea`.`Product` ;

CREATE TABLE IF NOT EXISTS `ResTea`.`Product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `description` VARCHAR(400) NOT NULL,
  `image` BLOB DEFAULT NULL,
  `price` INT NOT NULL,
  `Type_id` INT NOT NULL,
  `Origin_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Type_id`, `Origin_id`),
  INDEX `fk_Product_Type1_idx` (`Type_id` ASC) VISIBLE,
  INDEX `fk_Product_Origin1_idx` (`Origin_id` ASC) VISIBLE,
  CONSTRAINT `fk_Product_Type1`
      FOREIGN KEY (`Type_id`)
          REFERENCES `ResTea`.`Type` (`id`)
          ON DELETE NO ACTION
          ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_Origin1`
      FOREIGN KEY (`Origin_id`)
          REFERENCES `ResTea`.`Origin` (`id`)
          ON DELETE NO ACTION
          ON UPDATE NO ACTION)
    ENGINE = InnoDB;
#                                                   `id` INT NOT NULL AUTO_INCREMENT,
#                                                   `name` VARCHAR(20) NOT NULL,
#                                                   `description` VARCHAR(400) NOT NULL,
#                                                   `image` BLOB DEFAULT NULL,
#                                                   `price` INT NOT NULL,
#                                                   `type_id` INT NOT NULL,
#                                                   `origin_id` INT NOT NULL,
#                                                   PRIMARY KEY (`id`, `type_id`, `origin_id`),
#                                                   FOREIGN KEY(`type_id`) REFERENCES type(`id`),
#                                                   FOREIGN KEY(`origin_id`) REFERENCES origin(`id`))

#                                                   PRIMARY KEY (`id`, `type_id`, `origin_id`),
#                                                   INDEX `fk_Product_Type1_idx` (`type_id` ASC) VISIBLE,
#                                                   INDEX `fk_Product_Origin1_idx` (`origin_id` ASC) VISIBLE,
#                                                   CONSTRAINT `fk_Product_Type1`
#                                                       FOREIGN KEY (`type_id`)
#                                                           REFERENCES `ResTea`.`Type` (`id`)
#                                                           ON DELETE NO ACTION
#                                                           ON UPDATE NO ACTION,
#                                                   CONSTRAINT `fk_Product_Origin1`
#                                                       FOREIGN KEY (`origin_id`)
#                                                           REFERENCES `ResTea`.`Origin` (`id`)
#                                                           ON DELETE NO ACTION
#                                                           ON UPDATE NO ACTION)
#      ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `ResTea`.`Cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shop`.`Cart` ;

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
-- Table `ResTea`.`Order_Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ResTea`.`Order_Product` ;

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


-- -----------------------------------------------------
-- Table `ResTea`.`flavor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ResTea`.`flavor` ;

CREATE TABLE IF NOT EXISTS `ResTea`.`flavor` (
                                                 `flavor_id` INT NOT NULL AUTO_INCREMENT,
                                                 `name` VARCHAR(45) NOT NULL,
                                                 PRIMARY KEY (`flavor_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ResTea`.`Product_Flavor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ResTea`.`Product_Flavor` ;

CREATE TABLE IF NOT EXISTS `ResTea`.`Product_Flavor` (
                                                         `product_id` INT NOT NULL,
                                                         `flavor_id` INT NOT NULL,
                                                         PRIMARY KEY (`product_id`, `flavor_id`),
                                                         INDEX `fk_Product_has_flavor_flavor1_idx` (`flavor_id` ASC) VISIBLE,
                                                         INDEX `fk_Product_has_flavor_Product1_idx` (`product_id` ASC) VISIBLE,
                                                         CONSTRAINT `fk_Product_has_flavor_Product1`
                                                             FOREIGN KEY (`product_id`)
                                                                 REFERENCES `ResTea`.`Product` (`id`)
                                                                 ON DELETE NO ACTION
                                                                 ON UPDATE NO ACTION,
                                                         CONSTRAINT `fk_Product_has_flavor_flavor1`
                                                             FOREIGN KEY (`flavor_id`)
                                                                 REFERENCES `ResTea`.`flavor` (`flavor_id`)
                                                                 ON DELETE NO ACTION
                                                                 ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`Properties`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ResTea`.`Properties` ;

CREATE TABLE IF NOT EXISTS `ResTea`.`Properties` (
                                                     `properties_id` INT NOT NULL AUTO_INCREMENT,
                                                     `name` VARCHAR(45) NOT NULL,
                                                     PRIMARY KEY (`properties_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`Product_Properties`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ResTea`.`Product_Properties` ;

CREATE TABLE IF NOT EXISTS `ResTea`.`Product_Properties` (
                                             `product_id` INT NOT NULL,
                                             `properties_id` INT NOT NULL,
                                             PRIMARY KEY (`product_id`, `properties_id`),
                                             INDEX `fk_Product_has_Properties_Properties1_idx` (`properties_id` ASC) VISIBLE,
                                             INDEX `fk_Product_has_Properties_Product1_idx` (`product_id` ASC) VISIBLE,
                                             CONSTRAINT `fk_Product_has_Properties_Product1`
                                                 FOREIGN KEY (`product_id`)
                                                     REFERENCES `ResTea`.`Product` (`id`)
                                                     ON DELETE NO ACTION
                                                     ON UPDATE NO ACTION,
                                             CONSTRAINT `fk_Product_has_Properties_Properties1`
                                                 FOREIGN KEY (`properties_id`)
                                                     REFERENCES `ResTea`.`Properties` (`properties_id`)
                                                     ON DELETE NO ACTION
                                                     ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;