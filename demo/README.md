# Backend Security Service

Серверная часть проекта с аутентификацией, авторизацией, настройками HTTPS и подключением к PostgreSQL.

## Аутентификация

- `POST /auth/register` — регистрация пользователя с ролью `USER`.
- `POST /auth/login` — выдача JWT access/refresh токенов.
- `POST /auth/refresh` — обновление пары токенов по refresh-токену.

## Авторизация

В проекте используется ролевая модель:

- `USER` — базовый пользователь.
- `MANAGER` — расширенные права для внутренних операций.
- `ADMIN` — полный административный доступ.

Правила доступа описаны в `src/main/java/com/example/demo/security/SecurityConfig.java`.

## Конфигурация

- PostgreSQL подключается через переменные окружения `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`.
- JWT настраивается через `JWT_SECRET`, `JWT_ACCESS_TTL_MINUTES`, `JWT_REFRESH_TTL_MINUTES`.
- Данные стартового администратора задаются через `ADMIN_EMAIL` и `ADMIN_PASSWORD`.
- HTTPS включается через `SSL_ENABLED=true` и параметры `SSL_KEY_STORE`, `SSL_KEY_STORE_PASSWORD`, `SSL_KEY_STORE_TYPE`, `SSL_KEY_ALIAS`.
- Пример переменных находится в `.env.example`.

## CI/CD

Pipeline находится в `.github/workflows/backend.yml` и содержит отдельные шаги:

- `test` — запуск тестов;
- `build` — сборка приложения.
