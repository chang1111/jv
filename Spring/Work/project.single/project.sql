DROP DATABASE IF EXISTS project;

CREATE DATABASE project;

use project;

-- POST
CREATE TABLE postview (
	postno INT(10) NOT NULL AUTO_INCREMENT,
	author VARCHAR(50) NOT NULL,
	regdate DATETIME NOT NULL,
	content MEDIUMTEXT NOT NULL,
	countgood INT(11) NOT NULL DEFAULT '0',
	countbad INT(11) NOT NULL DEFAULT '0',
	PRIMARY KEY (postno)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

-- Comment
CREATE TABLE comments (
	commentno INT(10) NOT NULL AUTO_INCREMENT,
	postno INT(10) NOT NULL,
	memo VARCHAR(4000) NOT NULL,
	regdate DATETIME NOT NULL,
	PRIMARY KEY (commentno),
	INDEX FK_comments_postview (postno),
	CONSTRAINT FK_comments_postview FOREIGN KEY (postno) REFERENCES postview (postno)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

-- IMAGE
CREATE TABLE attachimage (
	attachimageno INT(10) NOT NULL AUTO_INCREMENT,
	fileName VARCHAR(50) NOT NULL,
	fileSize INT(11) NOT NULL,
	contentType VARCHAR(30) NOT NULL,
	imageBytes LONGBLOB NOT NULL,
	imageBase64 LONGTEXT NOT NULL,
	postno INT(10) NOT NULL,
	PRIMARY KEY (attachimageno),
	INDEX FK_attachimage_postview (postno),
	CONSTRAINT FK_attachimage_postview FOREIGN KEY (postno) REFERENCES postview (postno)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;