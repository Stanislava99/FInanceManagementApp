drop table if exists `mcc`;

CREATE TABLE `mcc` (
                       `code` bigint NOT NULL,
                       `merchant_type` varchar(255) NOT NULL,
                       PRIMARY KEY (`code`)
);
DROP TABLE IF EXISTS `transaction`;

CREATE TABLE `transaction` (
                               `id` int(11) NOT NULL ,
                               `beneficiaryName` varchar(255) ,
                               `date` varchar(12) NOT NULL ,
                               `direction` varchar(1) NOT NULL ,
                               `amount` decimal(10,2) NOT NULL,
                               `description` varchar(255) NOT NULL,
                               `currency` varchar(3) NOT NULL,
                               `mcc` bigint,
                               `kind` varchar(3),
                               PRIMARY KEY (`id`),
                               CONSTRAINT `fk_mcc` FOREIGN KEY (`mcc`) REFERENCES `mcc` (`code`)
);




