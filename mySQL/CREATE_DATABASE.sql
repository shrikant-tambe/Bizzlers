DROP SCHEMA IF EXISTS `BIZZLERS_AUTHENTICATION`;
DROP SCHEMA IF EXISTS `BIZZLERS`;


CREATE SCHEMA `BIZZLERS` ;

CREATE  TABLE `BIZZLERS`.`USER_INFO`(
`user_info_id` INT AUTO_INCREMENT,
`first_name` VARCHAR(145)  ,
`middle_name` VARCHAR(145) ,
`last_name` VARCHAR(145),
`gender` VARCHAR(35),
`dob` DATETIME NULL ,
 PRIMARY KEY (`user_info_id`));


CREATE SCHEMA `BIZZLERS_AUTHENTICATION` ;

CREATE  TABLE `BIZZLERS_AUTHENTICATION`.`USER` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `login_id` VARCHAR(145) NOT NULL ,
  `login_password` BLOB NOT NULL ,
  `status` INT NOT NULL DEFAULT 1 ,
  `last_login` DATETIME NULL ,
   user_info INT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_info_id`
    FOREIGN KEY (`user_info` )
    REFERENCES `BIZZLERS`.`USER_INFO` (`user_info_id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE
 );

CREATE  TABLE `BIZZLERS`.`CATEGORY` (

  `category_id` INT NOT NULL AUTO_INCREMENT,

  `name` VARCHAR(145) NOT NULL ,

  `description` VARCHAR(400) NULL ,
   flag int NULL,

  PRIMARY KEY (`category_id`) );

CREATE  TABLE `BIZZLERS`.`BUSINESS` (

  `b_id` INT NOT NULL AUTO_INCREMENT,

  `b_name` VARCHAR(145) NOT NULL ,

  `tagline` VARCHAR(145) NULL ,

  `category` INT NULL ,

  `form` VARCHAR(45) NULL ,

  `founded_place` VARCHAR(145) NULL ,

  `founded_date` DATE NULL ,

  `website` VARCHAR(145) NULL ,
  	
  `flag` INT NOT NULL DEFAULT 1 ,

  PRIMARY KEY (`b_id`) ,

  INDEX `category` (`category` ASC) ,

  CONSTRAINT `category`

    FOREIGN KEY (`category` )

    REFERENCES `BIZZLERS`.`CATEGORY` (`category_id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE);

CREATE  TABLE `BIZZLERS`.`CONTACT_CARD` (

  `contact_card_id` INT NOT NULL AUTO_INCREMENT,

  `address_line_1` VARCHAR(245) NULL ,

  `address_line_2` VARCHAR(245) NULL ,

  `city` VARCHAR(145) NOT NULL ,

  `state` VARCHAR(145) NOT NULL ,

  `pin` INT NOT NULL ,

  `mobile` NUMERIC(20) NULL ,

  `landline` NUMERIC(20) NULL ,

  `user_info_id` INT NULL ,

  `business_id` INT NOT NULL ,

  PRIMARY KEY (`contact_card_id`) ,

  INDEX `user_info_id` (`user_info_id` ASC) ,

  CONSTRAINT `user_info_id`

    FOREIGN KEY (`user_info_id` )

    REFERENCES `BIZZLERS`.`USER_INFO` (`user_info_id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE,

  CONSTRAINT `business_id`

    FOREIGN KEY (`business_id` )

    REFERENCES `BIZZLERS`.`BUSINESS` (`b_id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE);



CREATE  TABLE `BIZZLERS`.`USER_RELATION` (
  `user_id` INT NULL,
  `business_id` INT NULL,
  `relation` VARCHAR(145) NOT NULL ,
  `additional_information` VARCHAR(300) NULL ,
  `since_date` DATETIME NULL ,
  `till_date` DATETIME NULL ,
  PRIMARY KEY (`user_id`,`business_id`) ,
  INDEX `user_id_index` (`user_id` ASC) ,
  INDEX `buss_id_index` (`business_id` ASC),
CONSTRAINT `USER_INFO_UR`

    FOREIGN KEY (`user_id`)

    REFERENCES `BIZZLERS`.`USER_INFO` (`user_info_id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE,
CONSTRAINT `business_id_ur`

    FOREIGN KEY (`business_id` )

    REFERENCES `BIZZLERS`.`BUSINESS` (`b_id`)

    ON DELETE CASCADE

    ON UPDATE CASCADE
    );


CREATE  TABLE `BIZZLERS`.`SERVICES` (

  `service_id` INT NOT NULL AUTO_INCREMENT,

  `service_name` VARCHAR(145) NOT NULL ,

  `service_cat` INT NULL ,

  `description` VARCHAR(300) NULL ,

  PRIMARY KEY (`service_id`) ,

  INDEX `service_cat` (`service_cat` ASC) ,

  CONSTRAINT `service_cat`

    FOREIGN KEY (`service_cat` )

    REFERENCES `BIZZLERS`.`CATEGORY` (`category_id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE);

CREATE  TABLE `BIZZLERS`.`PRODUCTS` (

  `product_id` INT NOT NULL AUTO_INCREMENT,

  `product_name` VARCHAR(145) NOT NULL ,

  `product_cat` INT NULL ,

  `description` VARCHAR(300) NULL ,

  PRIMARY KEY (`product_id`) ,

  INDEX `product_id` (`product_id` ASC) ,

  CONSTRAINT `product_cat`

    FOREIGN KEY (`product_id` )

    REFERENCES `BIZZLERS`.`CATEGORy` (`category_id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE);
    

CREATE  TABLE `BIZZLERS`.`TAGS` (

  `tag_id` INT NOT NULL AUTO_INCREMENT,

  `tag_name` VARCHAR(145) NOT NULL ,

  `tag_cat` INT NULL ,

  `description` VARCHAR(300) NULL ,

  PRIMARY KEY (`tag_id`) ,

  INDEX `tag_cat` (`tag_cat` ASC) ,

  CONSTRAINT `tag_cat`

    FOREIGN KEY (`tag_cat` )

    REFERENCES `BIZZLERS`.`CATEGORY` (`category_id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE);


CREATE  TABLE `BIZZLERS`.`UNCONTROLLED_CATEGORY_DATA` (

  `id` INT NOT NULL AUTO_INCREMENT,

  `business` INT NULL ,

  `datatype` INT NULL ,

  `reference` INT NULL ,

  `category_id` INT NULL ,

  PRIMARY KEY (`id`) ,

  INDEX `CATEGORY_id_index` (`category_id` ASC) ,

  CONSTRAINT `CATEGORY_id_UCD`

    FOREIGN KEY (`category_id` )

    REFERENCES `BIZZLERS`.`CATEGORY` (`category_id` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION);
    
    
    CREATE  TABLE `bizzlers`.`news` (

  `n_id` INT NOT NULL AUTO_INCREMENT ,

  `title` VARCHAR(145) NULL ,

  `description` VARCHAR(545) NULL ,

  `b_id` INT NULL ,
  
  `ndate` DATETIME NULL ,

  PRIMARY KEY (`n_id`) ,

  INDEX `bidnews` (`b_id` ASC) ,

  CONSTRAINT `bidnews`

    FOREIGN KEY (`b_id` )

    REFERENCES `bizzlers`.`business` (`b_id` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION) ;
    
    
        CREATE  TABLE `bizzlers`.`adminnews` (

  `n_id` INT NOT NULL AUTO_INCREMENT ,

  `title` VARCHAR(145) NULL ,

  `description` VARCHAR(545) NULL ,
  
  `ndate` DATETIME NULL ,

  PRIMARY KEY (`n_id`)

   ) ;
        
INSERT INTO `bizzlers`.`user_info` (`user_info_id`, `first_name`, `middle_name`, `last_name`, `gender`, `dob`) VALUES (1, 'admin', 'admin', 'admin', 'admin', '2012-03-20 00:00:00');
INSERT INTO `bizzlers_authentication`.`user` (`user_id`, `login_id`, `login_password`, `status`, `user_info`) VALUES (1, 'admin@bizz.com',AES_ENCRYPT('bizzpass','admin@bizz.com'), 1, 1);