
CREATE TABLE `mcc` (
  `code` int(4) NOT NULL,
  `merchant_type` varchar(255) NOT NULL,
  PRIMARY KEY (`code`)
);

CREATE TABLE `category` (
    `code` varchar(5) NOT NULL,
    `parentCode` varchar(5) ,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`code`),
    CONSTRAINT `fk_parent_code` FOREIGN KEY (`parentCode`) REFERENCES `category` (`code`)

);

CREATE TABLE `transaction` (
                               `id` int(11) NOT NULL ,
                               `beneficiaryName` varchar(255) ,
                               `date` varchar(12) NOT NULL ,
                               `amount` decimal(10,2) NOT NULL,
                               `description` varchar(255) NOT NULL,
                               `currency` varchar(3) NOT NULL,
                               `mcc` int(11),
                               `kind` varchar(3),
                               PRIMARY KEY (`id`),
                               CONSTRAINT `fk_mcc` FOREIGN KEY (`mcc`) REFERENCES `mcc` (`code`)
)
