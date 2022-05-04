docker build -t account-service:latest .
docker-compose -f docker-compose.yml up -d --build --force-recreate