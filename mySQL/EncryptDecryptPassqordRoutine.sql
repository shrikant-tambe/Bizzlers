USE `bizzlers_authentication`;

DROP procedure IF EXISTS `bizzlers_authentication`.`encrypt_password`;


DELIMITER $$

USE `bizzlers_authentication`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `encrypt_password`(IN user_password VARCHAR(500),

	IN user_username VARCHAR(250),IN key_str VARCHAR(8) , OUT encryptedPassword VARCHAR(500))

	BEGIN

		DECLARE aes_pass VARCHAR(500) ;


		SET aes_pass = AES_ENCRYPT(user_password,key_str);

		SET encryptedPassword = CONCAT(aes_pass,user_username);
		
		
	END

$$


DELIMITER ;

;




USE `bizzlers_authentication`;

DROP procedure IF EXISTS `bizzlers_authentication`.`decrypt_password`;


DELIMITER $$

USE `bizzlers_authentication`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `decrypt_password`(IN encrypted_password VARCHAR(500),

	IN user_username VARCHAR(250),IN key_str VARCHAR(8) , OUT user_password VARCHAR(500))

	BEGIN

		DECLARE aes_pass VARCHAR(500) ;


	    	SET aes_pass = TRIM(TRAILING user_username FROM encrypted_password);
    
		SET user_password = AES_DECRYPT(aes_pass,key_str);

		
	END

$$


DELIMITER ;

;

