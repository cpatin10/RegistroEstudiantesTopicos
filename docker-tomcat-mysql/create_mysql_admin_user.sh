#!/bin/bash

/usr/bin/mysqld_safe > /dev/null 2>&1 &

RET=1
while [[ RET -ne 0 ]]; do
    echo "=> Waiting for confirmation of MySQL service startup"
    sleep 5
    mysql -uroot -e "status" > /dev/null 2>&1
    RET=$?
done

PASS=123456
_word=$( [ ${MYSQL_PASS} ] && echo "preset" || echo "random" )
echo "=> Creating MySQL admin user with ${_word} password"

# mysql -uroot -e 'CREATE DATABASE IF NOT EXISTS SW CHARACTER SET UTF8'
# mysql -uroot -e 'CREATE TABLE IF NOT EXISTS SW.ESTUDIANTES(id INT NOT NULL AUTO_INCREMENT, nombre VARCHAR(100) NOT NULL, PRIMARY KEY ( id ))'
# mysql -uroot -e "CREATE USER IF NOT EXISTS 'admin'@'%' IDENTIFIED BY '$PASS'"
# mysql -uroot -e "GRANT ALL PRIVILEGES ON *.* TO 'admin'@'%' WITH GRANT OPTION"

mysql -uroot -e 'CREATE DATABASE IF NOT EXISTS estudiantesbd CHARACTER SET UTF8'
mysql -uroot -e 'CREATE TABLE IF NOT EXISTS estudiantesbd.estudiante ( idestudiante int(11) primary key, nombre varchar(45), codigo varchar(45), telefono varchar(45), semestre varchar(45) )'
mysql -uroot -e "CREATE USER IF NOT EXISTS 'admin'@'%' IDENTIFIED BY '$PASS'"
mysql -uroot -e "GRANT ALL PRIVILEGES ON *.* TO 'admin'@'%' WITH GRANT OPTION"

echo "=> Done!"

echo "========================================================================"
echo "You can now connect to this MySQL Server using:"
echo ""
echo "    mysql -uadmin -p$PASS -h<host> -P<port>"
echo ""
echo "Please remember to change the above password as soon as possible!"
echo "MySQL user 'root' has no password but only allows local connections"
echo "========================================================================"

mysqladmin -uroot shutdown
