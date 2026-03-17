### Примеры применения testcontainers

### перед запуском приложения нужно запустить (При запуске docker-compose не требуется)
docker run --rm --name pg-docker -e POSTGRES_PASSWORD=pwd -e POSTGRES_USER=usr -e POSTGRES_DB=demoDB -p 5430:5432 postgres:16

### сборка образа
gradle jibDockerBuild

### Запуск с помощью docker-compose
docker compose up

### Остановка docker-compose
docker compose down