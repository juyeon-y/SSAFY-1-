-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema temp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema temp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `temp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `temp` ;

-- -----------------------------------------------------
-- Table `temp`.`security`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `temp`.`security` ;

CREATE TABLE IF NOT EXISTS `temp`.`security` (
  `id` VARCHAR(70) NOT NULL,
  `salt` VARCHAR(70) NULL DEFAULT NULL,
  `seckey` VARCHAR(120) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `temp`.`member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `temp`.`member` ;

CREATE TABLE IF NOT EXISTS `temp`.`member` (
  `id` VARCHAR(70) NOT NULL,
  `pw` VARCHAR(70) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `member_to_security_id`
    FOREIGN KEY (`id`)
    REFERENCES `temp`.`security` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
