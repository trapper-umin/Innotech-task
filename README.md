## Getting Started
- Сначала выполните команду `mvn clean install` для компиляции кода в jar файл
- Далее выполните команду `java -jar .\target\com-0.0.1-SNAPSHOT.jar` для запуска jar файла

### API

| Method | API | Request | Response |
|--------| ----------- |---------|----------|
| GET    | /api/v1.0/string   |   `{"string":"aaaaabcccc"}`      |        `{"result": {"a": 5,"c": 4,"b": 1 }}`    |
| GET    | /api/v1.0/string   |     `{"string":""}`     |   `{"message": "string: minimum length is 1 character"}`    |

### Test coverage

**Service:** 83% methods, 96% lines