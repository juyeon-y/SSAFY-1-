CREATE SCHEMA IF NOT EXISTS `happyhouse` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`dongcode` (
  `dongCode` VARCHAR(10) NOT NULL,
  `sidoName` VARCHAR(30) NULL DEFAULT NULL,
  `gugunName` VARCHAR(30) NULL DEFAULT NULL,
  `dongName` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`dongCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `happyhouse`.`user` (
  `email` VARCHAR(50) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `nickname` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `happyhouse`.`houseinfo` (
  `aptCode` BIGINT NOT NULL,
  `buildYear` INT NULL DEFAULT NULL,
  `roadName` VARCHAR(40) NULL DEFAULT NULL,
  `roadNameBonbun` VARCHAR(5) NULL DEFAULT NULL,
  `roadNameBubun` VARCHAR(5) NULL DEFAULT NULL,
  `roadNameSeq` VARCHAR(2) NULL DEFAULT NULL,
  `roadNameBasementCode` VARCHAR(1) NULL DEFAULT NULL,
  `roadNameCode` VARCHAR(7) NULL DEFAULT NULL,
  `dong` VARCHAR(40) NULL DEFAULT NULL,
  `bonbun` VARCHAR(4) NULL DEFAULT NULL,
  `bubun` VARCHAR(4) NULL DEFAULT NULL,
  `sigunguCode` VARCHAR(5) NULL DEFAULT NULL,
  `eubmyundongCode` VARCHAR(5) NULL DEFAULT NULL,
  `dongCode` VARCHAR(10) NULL DEFAULT NULL,
  `landCode` VARCHAR(1) NULL DEFAULT NULL,
  `apartmentName` VARCHAR(40) NULL DEFAULT NULL,
  `jibun` VARCHAR(10) NULL DEFAULT NULL,
  `lng` VARCHAR(30) NULL DEFAULT NULL,
  `lat` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`aptCode`),
  UNIQUE INDEX `UNIQUE` (`buildYear` ASC, `apartmentName` ASC, `jibun` ASC, `sigunguCode` ASC, `eubmyundongCode` ASC) INVISIBLE,
  INDEX `houseinfo_dongCode_dongcode_dongCode_fk_idx` (`dongCode` ASC) INVISIBLE,
  CONSTRAINT `houseinfo_dongCode_dongcode_dongCode_fk`
    FOREIGN KEY (`dongCode`)
    REFERENCES `happyhouse`.`dongcode` (`dongCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `happyhouse`.`interestplace` (
  `email` VARCHAR(50) NOT NULL,
  `dongCode` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`email`, `dongCode`),
  INDEX `dongcode_interestplace_fk_idx` (`dongCode` ASC) VISIBLE,
  CONSTRAINT `user_interestplace_fk`
    FOREIGN KEY (`email`)
    REFERENCES `happyhouse`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `dongcode_interestplace_fk`
    FOREIGN KEY (`dongCode`)
    REFERENCES `happyhouse`.`dongcode` (`dongCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `happyhouse`.`notice` (
  `idx` INT NOT NULL auto_increment,
  `title` VARCHAR(20) NOT NULL,
  `content` VARCHAR(16000) NOT NULL,
  `hits` INT NULL DEFAULT 0,
  `writer` VARCHAR(20) NOT NULL,
  `date` DATETIME NOT NULL DEFAULT current_timestamp,
  PRIMARY KEY (`idx`),
  INDEX `user_notice_fk_idx` (`writer` ASC) VISIBLE,
  CONSTRAINT `user_notice_fk`
    FOREIGN KEY (`writer`)
    REFERENCES `happyhouse`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `happyhouse`.`housedeal` (
  `no` BIGINT NOT NULL,
  `dealAmount` VARCHAR(20) NULL DEFAULT NULL,
  `dealYear` INT NULL DEFAULT NULL,
  `dealMonth` INT NULL DEFAULT NULL,
  `dealDay` INT NULL DEFAULT NULL,
  `area` VARCHAR(20) NULL DEFAULT NULL,
  `floor` VARCHAR(4) NULL DEFAULT NULL,
  `cancelDealType` VARCHAR(1) NULL DEFAULT NULL,
  `aptCode` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `housedeal_aptCode_houseinfo_aptCode_fk_idx` (`aptCode` ASC) VISIBLE,
  CONSTRAINT `housedeal_aptCode_houseinfo_aptCode_fk`
    FOREIGN KEY (`aptCode`)
    REFERENCES `happyhouse`.`houseinfo` (`aptCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `happyhouse`.`environment` (
  `idx` INT NOT NULL auto_increment,
  `WRKP_NM` VARCHAR(1000) NOT NULL,
  `UPCH_COB_CODE` VARCHAR(1000) NULL,
  `UPCH_COB_NM` VARCHAR(1000) NULL,
  `DRT_INSP_YMD` DATE NULL,
  `ORG_AND_TEAM_CODE` VARCHAR(1000) NULL,
  `SF_TEAM_NM` VARCHAR(1000) NULL,
  `DRT_INSP_SE_NM` VARCHAR(1000) NULL,
  `DISPO_TGT_YN` VARCHAR(1000) NULL,
  `DRT_INSP_ITEM` VARCHAR(1000) NULL,
  `DRT_INSP_RT_DTL` VARCHAR(1000) NULL,
  `dongcode` VARCHAR(10) NOT NULL,
  `address` VARCHAR(500) NULL,
  PRIMARY KEY (`idx`),
  INDEX `dong_env_fk_idx` (`dongcode` ASC) VISIBLE,
  CONSTRAINT `dong_env_fk`
    FOREIGN KEY (`dongcode`)
    REFERENCES `happyhouse`.`dongcode` (`dongCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `happyhouse`.`business` (
  `idx` INT NOT NULL AUTO_INCREMENT,
  `dongcode` VARCHAR(10) NOT NULL,
  `bizname` VARCHAR(1000) NOT NULL,
  `maincategory` VARCHAR(1000) NULL DEFAULT NULL,
  `middleclass` VARCHAR(1000) NULL DEFAULT NULL,
  `subcategory` VARCHAR(1000) NULL DEFAULT NULL,
  `category` VARCHAR(1000) NULL DEFAULT NULL,
  `address` VARCHAR(500) NULL DEFAULT NULL,
  `lng` DOUBLE NOT NULL,
  `lat` DOUBLE NOT NULL,
  PRIMARY KEY (`idx`),
  INDEX `dongcode_business_fk_idx` (`dongcode` ASC) VISIBLE,
  CONSTRAINT `dongcode_business_fk`
    FOREIGN KEY (`dongcode`)
    REFERENCES `happyhouse`.`dongcode` (`dongCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `happyhouse`.`clinic` (
  `idx` INT NOT NULL auto_increment,
  `sidoname` VARCHAR(100) NULL,
  `sigugunname` VARCHAR(100) NULL,
  `clinicname` VARCHAR(100) NULL,
  `address` VARCHAR(500) NULL,
  `daytime` VARCHAR(100) NULL,
  `saturdaytime` VARCHAR(100) NULL,
  `sundaytime` VARCHAR(100) NULL,
  `redtime` VARCHAR(100) NULL,
  `phone` VARCHAR(20) NULL,
  PRIMARY KEY (`idx`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `happyhouse`.`hospital` (
  `idx` INT NOT NULL auto_increment,
  `hospitalname` VARCHAR(100) NULL,
  `sidoname` VARCHAR(100) NULL,
  `sigugunname` VARCHAR(100) NULL,
  `address` VARCHAR(100) NULL,
  `applicationtype` CHAR(1) NULL check (`applicationtype` in ('A', 'B')),
  `phone` VARCHAR(15) NULL,
  PRIMARY KEY (`idx`))
ENGINE = InnoDB;