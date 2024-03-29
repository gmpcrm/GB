# Программа UserProcessor для ввода данных пользователей

UserProcessor - это программа, которая принимает на вход данные пользователя и записывает их в файл. Программа запрашивает у пользователя следующие данные, разделенные пробелом

- Фамилия
- Имя
- Отчество
- Дата рождения (формат: dd.MM.yyyy)
- Номер телефона (целое беззнаковое число без форматирования)
- Пол (m или f)

При этом программа проверяет введенные данные на количество и форматы. Если форматы данных не совпадают, программа выбрасывает исключение с информацией о проблеме. Если все данные введены и обработаны верно, программа создает файл с именем, равным фамилии пользователя, и записывает полученные данные в следующем формате:

`<Фамилия><Имя><Отчество><датарождения><номертелефона><пол>`

Однофамильцы записываются в один и тот же файл в отдельные строки.

Также в программе есть набор тестовых данных, которые можно использовать для проверки работы программы. Тест можно запустить с помощью функции `test()`. При этом программа проверяет, что функция `processUser()` выбрасывает исключения в случае некорректных данных и записывает правильные данные в файл в случае корректных данных.
