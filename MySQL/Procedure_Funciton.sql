USE `northwind` ;

-- -----------------------------------------------------
-- function find_by_name
-- -----------------------------------------------------

DELIMITER $$
USE `northwind`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `find_by_name`(name varchar(50)) RETURNS varchar(50) CHARSET utf8mb4
    DETERMINISTIC
begin
	declare addressVar varchar(50);
	select address into addressVar from customer_info where CustomerName = name limit 1;
    return addressVar;
end$$

DELIMITER ;

-- -----------------------------------------------------
-- function get_price
-- -----------------------------------------------------

DELIMITER $$
USE `northwind`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `get_price`(price int) RETURNS varchar(50) CHARSET utf8mb4
    DETERMINISTIC
begin
declare priceLevel varchar(20);
if price > 10 then
	set priceLevel = 'Poor';
    else
    set priceLevel = 'rich';
end if;
return priceLevel;
end$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure outParam
-- -----------------------------------------------------

DELIMITER $$
USE `northwind`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `outParam`(IN name varchar(50), OUT contact varchar(50), OUT total int)
Begin SELECT contactName INTO contact FROM customer_info WHERE customerName = name limit 1; SELECT count(*) into total FROM customer_info where customerName = name group by customerName; End$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure pro_example1
-- -----------------------------------------------------

DELIMITER $$
USE `northwind`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_example1`(customer_existed_name varchar(50))
BEGIN
declare id varchar(255);
select * from customer_info where customerName LIKE concat('%',customer_existed_name,'%');
END$$

DELIMITER ;
