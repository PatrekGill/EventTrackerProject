-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mygamelistdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mygamelistdb` ;

-- -----------------------------------------------------
-- Schema mygamelistdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mygamelistdb` DEFAULT CHARACTER SET utf8 ;
USE `mygamelistdb` ;

-- -----------------------------------------------------
-- Table `game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game` ;

CREATE TABLE IF NOT EXISTS `game` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(150) NULL,
  `image_url` VARCHAR(300) NULL,
  `description` TEXT NULL,
  `created_date_time` DATETIME NULL,
  `updated_date_time` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `company` ;

CREATE TABLE IF NOT EXISTS `company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  `description` TEXT NULL,
  `image_url` VARCHAR(250) NULL,
  `created_date_time` DATETIME NULL,
  `updated_date_time` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game_company` ;

CREATE TABLE IF NOT EXISTS `game_company` (
  `game_id` INT NOT NULL,
  `company_id` INT NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  INDEX `fk_game_company_company1_idx` (`company_id` ASC),
  PRIMARY KEY (`game_id`, `company_id`),
  CONSTRAINT `fk_game_company_game`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_company_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Platform`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Platform` ;

CREATE TABLE IF NOT EXISTS `Platform` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `abbreviation` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_release`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game_release` ;

CREATE TABLE IF NOT EXISTS `game_release` (
  `game_id` INT NOT NULL,
  `platform_id` INT NOT NULL,
  `date` DATE NULL,
  INDEX `fk_game_platform_game1_idx` (`game_id` ASC),
  INDEX `fk_game_platform_Platform1_idx` (`platform_id` ASC),
  PRIMARY KEY (`game_id`, `platform_id`),
  CONSTRAINT `fk_game_platform_game1`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_platform_Platform1`
    FOREIGN KEY (`platform_id`)
    REFERENCES `Platform` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tag` ;

CREATE TABLE IF NOT EXISTS `tag` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game_tag` ;

CREATE TABLE IF NOT EXISTS `game_tag` (
  `game_id` INT NOT NULL,
  `tag_id` INT NOT NULL,
  INDEX `fk_game_genre_genre1_idx` (`tag_id` ASC),
  PRIMARY KEY (`game_id`, `tag_id`),
  CONSTRAINT `fk_game_genre_game1`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_genre_genre1`
    FOREIGN KEY (`tag_id`)
    REFERENCES `tag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `staff` ;

CREATE TABLE IF NOT EXISTS `staff` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(75) NOT NULL,
  `description` TEXT NULL,
  `image_url` VARCHAR(250) NULL,
  `created_date_time` DATETIME NULL,
  `updated_date_time` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game_staff` ;

CREATE TABLE IF NOT EXISTS `game_staff` (
  `game_id` INT NOT NULL,
  `staff_id` INT NOT NULL,
  `role` VARCHAR(75) NOT NULL,
  INDEX `fk_game_staff_staff1_idx` (`staff_id` ASC),
  PRIMARY KEY (`game_id`, `staff_id`),
  CONSTRAINT `fk_game_staff_game1`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_staff_staff1`
    FOREIGN KEY (`staff_id`)
    REFERENCES `staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `created_date_time` DATETIME NULL,
  `updated_date_time` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_list`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game_list` ;

CREATE TABLE IF NOT EXISTS `game_list` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `permanent` TINYINT(1) NOT NULL,
  `created_date_time` DATETIME NULL,
  `updated_date_time` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_list_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_list_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_to_list`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game_to_list` ;

CREATE TABLE IF NOT EXISTS `game_to_list` (
  `game_id` INT NOT NULL,
  `list_id` INT NOT NULL,
  INDEX `fk_game_list_list1_idx` (`list_id` ASC),
  PRIMARY KEY (`game_id`, `list_id`),
  CONSTRAINT `fk_game_list_game1`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_list_list1`
    FOREIGN KEY (`list_id`)
    REFERENCES `game_list` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `relationship`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `relationship` ;

CREATE TABLE IF NOT EXISTS `relationship` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_relation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game_relation` ;

CREATE TABLE IF NOT EXISTS `game_relation` (
  `primary_game_id` INT NOT NULL,
  `other_game_id` INT NOT NULL,
  `relationship_id` INT NOT NULL,
  INDEX `fk_game_relation_game1_idx` (`primary_game_id` ASC),
  INDEX `fk_game_relation_game2_idx` (`other_game_id` ASC),
  INDEX `fk_game_relation_relationship1_idx` (`relationship_id` ASC),
  PRIMARY KEY (`primary_game_id`, `other_game_id`),
  CONSTRAINT `fk_game_relation_game1`
    FOREIGN KEY (`primary_game_id`)
    REFERENCES `game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_relation_game2`
    FOREIGN KEY (`other_game_id`)
    REFERENCES `game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_relation_relationship1`
    FOREIGN KEY (`relationship_id`)
    REFERENCES `relationship` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game_comment` ;

CREATE TABLE IF NOT EXISTS `game_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `game_id` INT NOT NULL,
  `text` TEXT NOT NULL,
  `visible` TINYINT(1) NOT NULL DEFAULT 1,
  `created_date_time` DATETIME NULL,
  `updated_date_time` DATETIME NULL,
  `in_reply_to` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_user1_idx` (`user_id` ASC),
  INDEX `fk_game_comment_game1_idx` (`game_id` ASC),
  INDEX `fk_game_comment_game_comment1_idx` (`in_reply_to` ASC),
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_comment_game1`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_comment_game_comment1`
    FOREIGN KEY (`in_reply_to`)
    REFERENCES `game_comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `status` ;

CREATE TABLE IF NOT EXISTS `status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_game` ;

CREATE TABLE IF NOT EXISTS `user_game` (
  `user_id` INT NOT NULL,
  `game_id` INT NOT NULL,
  `status_id` INT NOT NULL DEFAULT 1,
  `notes` TEXT NULL,
  `hours_played` DECIMAL(7,2) NULL DEFAULT 0,
  `score` INT NULL,
  `start_date` DATE NULL,
  `finish_date` DATE NULL,
  INDEX `fk_game_usuer_game1_idx` (`game_id` ASC),
  INDEX `fk_game_usuer_status1_idx` (`status_id` ASC),
  PRIMARY KEY (`user_id`, `game_id`),
  CONSTRAINT `fk_game_usuer_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_usuer_game1`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_usuer_status1`
    FOREIGN KEY (`status_id`)
    REFERENCES `status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS gameuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'gameuser'@'localhost' IDENTIFIED BY 'gameuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'gameuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `game`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `game` (`id`, `title`, `image_url`, `description`, `created_date_time`, `updated_date_time`) VALUES (1, 'Mass Effect', 'https://upload.wikimedia.org/wikipedia/en/thumb/e/e8/MassEffect.jpg/220px-MassEffect.jpg', 'First Mass Effect', '2022-01-07 18:52:00', '2022-01-08 02:52:00');
INSERT INTO `game` (`id`, `title`, `image_url`, `description`, `created_date_time`, `updated_date_time`) VALUES (2, 'Mass Effect 2', 'https://upload.wikimedia.org/wikipedia/en/thumb/0/05/MassEffect2_cover.PNG/220px-MassEffect2_cover.PNG', 'Second Mass Effect', '2022-01-07 18:52:00', '2022-01-08 02:52:00');
INSERT INTO `game` (`id`, `title`, `image_url`, `description`, `created_date_time`, `updated_date_time`) VALUES (3, 'Mass Effect 3', 'https://upload.wikimedia.org/wikipedia/en/thumb/b/b0/Mass_Effect_3_Game_Cover.jpg/220px-Mass_Effect_3_Game_Cover.jpg', 'Third Mass Effect', '2022-01-07 18:52:00', '2022-01-08 02:52:00');
INSERT INTO `game` (`id`, `title`, `image_url`, `description`, `created_date_time`, `updated_date_time`) VALUES (4, 'Days Gone', NULL, 'A Zombie Game', '2022-01-07 18:52:00', '2022-01-08 02:52:00');
INSERT INTO `game` (`id`, `title`, `image_url`, `description`, `created_date_time`, `updated_date_time`) VALUES (5, 'Halo Infinite', NULL, '7th Halo Title', '2022-01-07 18:52:00', '2022-01-08 02:52:00');
INSERT INTO `game` (`id`, `title`, `image_url`, `description`, `created_date_time`, `updated_date_time`) VALUES (6, 'Call Of Duty 4: Modern Warfare', NULL, '4th Call Of Duty', '2022-01-07 18:52:00', '2022-01-08 02:52:00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `company`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `company` (`id`, `name`, `description`, `image_url`, `created_date_time`, `updated_date_time`) VALUES (1, 'Bioware', 'A primarily rpg studio', 'https://eaassets-a.akamaihd.net/www.bioware.com/wp-content/themes/bioware/assets/img/favicon.ico', '2022-01-07 18:52:00', '2022-01-08 02:52:00');
INSERT INTO `company` (`id`, `name`, `description`, `image_url`, `created_date_time`, `updated_date_time`) VALUES (2, 'Electronic Arts', 'A game publisher', 'https://upload.wikimedia.org/wikipedia/commons/e/e5/Electronic_Arts_Logo_2020.png', '2022-01-07 18:52:00', '2022-01-08 02:52:00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `game_company`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `game_company` (`game_id`, `company_id`, `role`) VALUES (1, 1, 'Developer');
INSERT INTO `game_company` (`game_id`, `company_id`, `role`) VALUES (1, 2, 'Publisher');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Platform`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `Platform` (`id`, `name`, `abbreviation`) VALUES (1, 'Windows', 'PC');
INSERT INTO `Platform` (`id`, `name`, `abbreviation`) VALUES (2, 'Playstation 4', 'PS4');
INSERT INTO `Platform` (`id`, `name`, `abbreviation`) VALUES (3, 'Xbox One', 'XBOX ONE');
INSERT INTO `Platform` (`id`, `name`, `abbreviation`) VALUES (4, 'Playstation 3', 'PS3');
INSERT INTO `Platform` (`id`, `name`, `abbreviation`) VALUES (5, 'Xbox 360', 'XBOX 360');

COMMIT;


-- -----------------------------------------------------
-- Data for table `game_release`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `game_release` (`game_id`, `platform_id`, `date`) VALUES (1, 1, '2008-05-28');
INSERT INTO `game_release` (`game_id`, `platform_id`, `date`) VALUES (2, 1, '2010-01-26');
INSERT INTO `game_release` (`game_id`, `platform_id`, `date`) VALUES (3, 1, '2012-03-06');

COMMIT;


-- -----------------------------------------------------
-- Data for table `tag`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `tag` (`id`, `name`) VALUES (1, 'RPG');
INSERT INTO `tag` (`id`, `name`) VALUES (2, 'Third Person Shooter');
INSERT INTO `tag` (`id`, `name`) VALUES (3, 'Singleplayer');

COMMIT;


-- -----------------------------------------------------
-- Data for table `game_tag`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `game_tag` (`game_id`, `tag_id`) VALUES (1, 1);
INSERT INTO `game_tag` (`game_id`, `tag_id`) VALUES (1, 2);
INSERT INTO `game_tag` (`game_id`, `tag_id`) VALUES (2, 1);
INSERT INTO `game_tag` (`game_id`, `tag_id`) VALUES (2, 2);
INSERT INTO `game_tag` (`game_id`, `tag_id`) VALUES (3, 1);
INSERT INTO `game_tag` (`game_id`, `tag_id`) VALUES (3, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `staff`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `staff` (`id`, `name`, `description`, `image_url`, `created_date_time`, `updated_date_time`) VALUES (1, 'Casey Hudson', 'Worked at Bioware for several years', 'https://eaassets-a.akamaihd.net/blog.bioware.com/wp-content/uploads/2018/04/Final2-3.jpg', '2022-01-07 18:52:01', '2022-01-08 02:52:01');

COMMIT;


-- -----------------------------------------------------
-- Data for table `game_staff`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `game_staff` (`game_id`, `staff_id`, `role`) VALUES (1, 1, 'Project Director');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `user` (`id`, `username`, `password`, `created_date_time`, `updated_date_time`) VALUES (1, 'admin', 'admin', '2022-01-07 18:52:00', '2022-01-08 02:52:00');
INSERT INTO `user` (`id`, `username`, `password`, `created_date_time`, `updated_date_time`) VALUES (2, 'Ansible2', 'Ansible2', '2022-01-07 18:52:00', '2022-01-08 02:52:00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `game_list`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `game_list` (`id`, `user_id`, `name`, `permanent`, `created_date_time`, `updated_date_time`) VALUES (1, 1, 'Playing', 1, '2022-01-07 18:52:00', '2022-01-08 02:52:01');
INSERT INTO `game_list` (`id`, `user_id`, `name`, `permanent`, `created_date_time`, `updated_date_time`) VALUES (2, 1, 'Completed', 1, '2022-01-07 18:52:00', '2022-01-08 02:52:01');
INSERT INTO `game_list` (`id`, `user_id`, `name`, `permanent`, `created_date_time`, `updated_date_time`) VALUES (3, 1, 'Paused', 1, '2022-01-07 18:52:00', '2022-01-08 02:52:01');
INSERT INTO `game_list` (`id`, `user_id`, `name`, `permanent`, `created_date_time`, `updated_date_time`) VALUES (4, 1, 'Replaying', 1, '2022-01-07 18:52:00', '2022-01-08 02:52:01');
INSERT INTO `game_list` (`id`, `user_id`, `name`, `permanent`, `created_date_time`, `updated_date_time`) VALUES (5, 1, 'Dropped', 1, '2022-01-07 18:52:00', '2022-01-08 02:52:01');
INSERT INTO `game_list` (`id`, `user_id`, `name`, `permanent`, `created_date_time`, `updated_date_time`) VALUES (6, 1, 'Plan To Play', 1, '2022-01-07 18:52:00', '2022-01-08 02:52:01');

COMMIT;


-- -----------------------------------------------------
-- Data for table `game_to_list`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `game_to_list` (`game_id`, `list_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `relationship`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `relationship` (`id`, `name`) VALUES (1, 'Sequel');
INSERT INTO `relationship` (`id`, `name`) VALUES (2, 'Prequel');
INSERT INTO `relationship` (`id`, `name`) VALUES (3, 'Other');

COMMIT;


-- -----------------------------------------------------
-- Data for table `game_relation`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `game_relation` (`primary_game_id`, `other_game_id`, `relationship_id`) VALUES (1, 2, 1);
INSERT INTO `game_relation` (`primary_game_id`, `other_game_id`, `relationship_id`) VALUES (2, 1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `game_comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `game_comment` (`id`, `user_id`, `game_id`, `text`, `visible`, `created_date_time`, `updated_date_time`, `in_reply_to`) VALUES (1, 1, 1, 'A Good Game', 1, '2022-01-7 18:52:00', '2022-01-08 02:52:01', NULL);
INSERT INTO `game_comment` (`id`, `user_id`, `game_id`, `text`, `visible`, `created_date_time`, `updated_date_time`, `in_reply_to`) VALUES (2, 2, 1, 'I agree', 1, '2022-01-7 18:52:01', '2022-01-08 02:52:00', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `status`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `status` (`id`, `name`) VALUES (1, 'Playing');
INSERT INTO `status` (`id`, `name`) VALUES (2, 'Completed');
INSERT INTO `status` (`id`, `name`) VALUES (3, 'Paused');
INSERT INTO `status` (`id`, `name`) VALUES (4, 'Replaying');
INSERT INTO `status` (`id`, `name`) VALUES (5, 'Dropped');
INSERT INTO `status` (`id`, `name`) VALUES (6, 'Plan To Play');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_game`
-- -----------------------------------------------------
START TRANSACTION;
USE `mygamelistdb`;
INSERT INTO `user_game` (`user_id`, `game_id`, `status_id`, `notes`, `hours_played`, `score`, `start_date`, `finish_date`) VALUES (1, 1, 2, 'some notes', 50.50, 90, '2022-01-06', '2022-01-08');

COMMIT;

