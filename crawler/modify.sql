ALTER TABLE `wishplus`.`t_wish_spider_item` MODIFY COLUMN `price` DECIMAL(10,2)  DEFAULT 0;
update `wishplus`.`t_wish_spider_item` set price=price*100;
ALTER TABLE `wishplus`.`t_wish_spider_item` MODIFY COLUMN `price` INT  DEFAULT 0;

ALTER TABLE `wishplus`.`t_wish_spider_item` DROP COLUMN `sale_cnt`;

