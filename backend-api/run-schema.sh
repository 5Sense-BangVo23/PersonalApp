#!/bin/bash

# Biến cấu hình kết nối MySQL
MYSQL_HOST="127.0.0.1"
MYSQL_PORT="3366"
MYSQL_USER="root"
MYSQL_PASSWORD="root"

# Đường dẫn file SQL
SQL_FILE="schema.sql"

# Chạy lệnh
mysql -h "$MYSQL_HOST" -P "$MYSQL_PORT" -u "$MYSQL_USER" -p"$MYSQL_PASSWORD" < "$SQL_FILE"
