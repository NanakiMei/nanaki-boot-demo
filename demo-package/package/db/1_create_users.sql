set character_set_results='utf8';
set character_set_connection='utf8';
set character_set_client='utf8';
set character_set_database='utf8';
set character_set_server='utf8';

create user nanaki;
GRANT ALL PRIVILEGES ON *.* TO 'nanaki'@'%' IDENTIFIED BY 'nanaki@123' WITH GRANT OPTION;