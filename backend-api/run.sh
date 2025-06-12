#!/bin/bash

echo "🔄 Cleaning and compiling Spring Boot project..."

# Chạy Maven clean và compile
./mvnw clean compile

# Kiểm tra kết quả
if [ $? -eq 0 ]; then
  echo "✅ Compilation successful!"
else
  echo "❌ Compilation failed."
  exit 1
fi
