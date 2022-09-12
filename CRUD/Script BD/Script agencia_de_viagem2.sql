-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema agencia_de_viagem
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema agencia_de_viagem
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `agencia_de_viagem` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `agencia_de_viagem` ;

-- -----------------------------------------------------
-- Table `agencia_de_viagem`.`destino`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agencia_de_viagem`.`destino` ;

CREATE TABLE IF NOT EXISTS `agencia_de_viagem`.`destino` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `lugares` VARCHAR(30) NULL DEFAULT NULL,
  `ida` VARCHAR(30) NULL DEFAULT NULL,
  `volta` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `agencia_de_viagem`.`promocao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agencia_de_viagem`.`promocao` ;

CREATE TABLE IF NOT EXISTS `agencia_de_viagem`.`promocao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `promocao_relampago` VARCHAR(30) NULL DEFAULT NULL,
  `passagens` VARCHAR(30) NULL DEFAULT NULL,
  `pacotes` VARCHAR(30) NULL DEFAULT NULL,
  `hospedagem` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
