use nanaki_schema;

CREATE TABLE IF NOT EXISTS `nanaki_table` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `key` varchar(125) DEFAULT NULL,
    `value` json DEFAULT NULL,
    `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
    `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
    PRIMARY KEY (`ID`),
    UNIQUE KEY `uk_key` (`KEY`)
) ENGINE=InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'demo table';