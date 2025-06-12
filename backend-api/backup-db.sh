#!/bin/bash

# === Configuration ===
DB_NAME="personal_db"
DB_USER="root"
DB_PASSWORD="root"
DB_HOST="127.0.0.1"
DB_PORT="3366"
BACKUP_DIR="./db_backups"
TIMESTAMP=$(date +"%Y-%m-%d_%H-%M-%S")
BACKUP_FILE="$BACKUP_DIR/${DB_NAME}_backup_$TIMESTAMP.sql"

# === Create backup directory if it doesn't exist ===
mkdir -p "$BACKUP_DIR"

# === Run the MySQL backup ===
mysqldump -h "$DB_HOST" -P "$DB_PORT" -u "$DB_USER" -p"$DB_PASSWORD" "$DB_NAME" > "$BACKUP_FILE"

# === Check the result ===
if [ $? -eq 0 ]; then
  echo "✅ Backup successful: $BACKUP_FILE"
else
  echo "❌ Backup failed"
fi
