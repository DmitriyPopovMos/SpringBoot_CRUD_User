SpringBoot_CRUD_User Application

♣ Функционал

• Добавление нового User:
POST /user-create
Параметры: id, firstName, lastName


• Получить список всех User:
GET /users
Параметры: id, firstName, lastName


• Обновление / изменение данных User:
POST /user-update
Параметры: id, firstName, lastName


• Удаление User по id:
GET /user-delete/id
Параметры: Удаляет id, firstName, lastName
