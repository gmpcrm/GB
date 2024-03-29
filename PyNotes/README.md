# Приложение заметки (Python)

Программа представляет собой консольное приложение для управления заметками. Она позволяет создавать, просматривать, редактировать и удалять заметки. Заметки хранятся в файле notes.json.

Вариант использования программы

    usage: notes.py [-h] {add,list,edit,delete}

В данной программе используются следующие параметры командной строки:

* **id** - идентификатор заметки при опциях edit и delete. Обязательный параметр.
* **command** - определяет, какую операцию необходимо выполнить. Должен быть одним из следующих значений: add, list, edit, delete.

* **-title** - заголовок заметки при добавлении или изменении заметки. Обязательный параметр для опций add и edit.

* **-msg** - текст заметки при добавлении или изменении заметки. Обязательный параметр для опций add и edit.

* **-date** - дата фильтрации списка заметок при опции list. Если задан, программа выводит только те заметки, которые были созданы в указанную дату.

При запуске программы без аргументов выводится главное меню, где пользователь может выбрать одну из следующих опций: добавить заметку, просмотреть список заметок, редактировать заметку, удалить заметку или выйти из программы.

* Когда выбирается опция добавления заметки, пользователь должен указать заголовок и тело заметки.
* При выборе опции просмотра списка заметок, программа выводит список всех заметок, хранящихся в файле notes.json. При указании аргумента -date программа выводит только те заметки, которые были созданы в указанную дату.
* При выборе опции редактирования заметки, пользователь должен указать идентификатор заметки, которую он хочет отредактировать, а также новый заголовок и тело заметки.
* При выборе опции удаления заметки, пользователь должен указать идентификатор заметки, которую он хочет удалить.

Все изменения заметок сохраняются в файл notes.json. Если при чтении или сохранении файла происходит ошибка, программа выводит соответствующее сообщение.

## Примеры использования программы с командной строки

### Добавление заметки

``` $ python notes.py add -title "Встреча с клиентом" -msg "Встреча с клиентом состоится завтра в 15:00" ```

    Заметка успешно сохранена

## Просмотр списка всех заметок

```$ python notes.py list```

    ID: 1
    Заголовок: Встреча с клиентом
    Сообщение: Встреча с клиентом состоится завтра в 15:00
    Время: 2023-03-23 13:12:48.760076

    ID: 2
    Заголовок: Написать отчет
    Сообщение: Нужно написать отчет к концу недели
    Время: 2023-03-23 13:13:19.360120

    ID: 3
    Заголовок: Купить продукты
    Сообщение: Купить молоко, яйца, овощи
    Время: 2023-03-23 13:13:38.240107

## Просмотр списка заметок за определенную дату

```$ python notes.py list -date "2023-03-23"```

    ID: 1
    Заголовок: Встреча с клиентом
    Сообщение: Встреча с клиентом состоится завтра в 15:00
    Время: 2023-03-23 13:12:48.760076

    ID: 2
    Заголовок: Написать отчет
    Сообщение: Нужно написать отчет к концу недели
    Время: 2023-03-23 13:13:19.360120

    ID: 3
    Заголовок: Купить продукты
    Сообщение: Купить молоко, яйца, овощи
    Время: 2023-03-23 13:13:38.240107

## Редактирование заметки

```$ python notes.py edit 1 -title "Измененный заголовок" -msg "Измененное сообщение"```

    Заметка успешно отредактирована

## Удаление заметки:

```$ python notes.py delete 2```

    Заметка успешно удалена
