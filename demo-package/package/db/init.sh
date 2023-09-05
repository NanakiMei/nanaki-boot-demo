#!/bin/sh
export LANG="en_US.UTF-8"

declare -a SQL_PATH
SQL_PATH=(
	./1_create_users.sql
	./2_create_schema.sql
	./3_create_table.sql
)

function run()
{
	# cd mysql命令目录
	for sql in ${SQL_PATH[@]}
	do
		echo "======>>> exce sql file: ${sql}"
		mysql -u root -p"hzmc321#" < ${sql}
		if [ $? -ne 0 ]; then
			echo "======>>> import sql fail!, file: ${sql}"
			exit -1
		fi
	done
	cd -
}

# 执行run
run