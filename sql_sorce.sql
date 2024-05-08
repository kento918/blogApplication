create database blogApp;
drop table `blogApp`.`user`;
CREATE TABLE `blogapp`.`user` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL UNIQUE,
  `password` CHAR(60) NOT NULL,
  `password_salt` BINARY(16) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE `blogapp`.`category` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL,
  `description` TEXT,
  `parent_id` INT NOT NULL DEFAULT 0,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `order` INT NOT NULL DEFAULT 0,
  `image` MEDIUMBLOB,
  FOREIGN KEY (`parent_id`) REFERENCES `blogapp`.`category`(`id`)
);
CREATE TABLE `blogapp`.`post` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `title` VARCHAR(255) NOT NULL,
  `body` TEXT NOT NULL,
  `createdAt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `authorId` INT NOT NULL,
  `categoryId` INT NOT NULL,
  `published` BOOLEAN NOT NULL DEFAULT FALSE,
  `slug` VARCHAR(255) NOT NULL UNIQUE,postid
  FOREIGN KEY (`authorId`) REFERENCES `blogapp`.`user`(`id`),
  FOREIGN KEY (`categoryId`) REFERENCES `blogapp`.`category`(`id`)
);

