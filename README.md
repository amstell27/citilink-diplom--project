# Проект по автоматизации тестирования интернет-магазина Ситилинк
## <a target="_blank" href="https://www.citilink.ru/">Интернет-магазин Ситилинк</a>

## :floppy_disk: Содержание:

- <a href="#computer-технологии-и-инструменты">Технологии и инструменты</a>
- <a href="#notebook_with_decorative_cover-реализованные-проверки">Реализованные проверки</a>
- <a href="#electric_plug-сборка-в-Jenkins">Сборка в Jenkins</a>
- <a href="#arrow_forward-запуск-из-терминала">Запуск из терминала</a>
- <a href="#open_book-allure-отчет">Allure отчет</a>
- <a href="#robot-отчет-в-telegram">Отчет в Telegram</a>
- <a href="#film_projector-видео-пример-прохождения-тестов">Видео пример прохождения тестов</a>

## :computer: Технологии и инструменты
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

## :notebook_with_decorative_cover: Реализованные проверки
- Смена региона
- Проверка раздела "Популярные категории"
- Проверка перехода на страницу "Популярное в ТОП-100"
- Добавление товара в корзину
- Проверка поиска


## :electric_plug: Сборка в Jenkins
### <a target="_blank" href="https://jenkins.autotests.cloud/job/С11-Amstell27-Diplom-project/">Сборка в Jenkins</a>
<p align="center">
<img title="Jenkins Dashboard" src="images/screenshots/jenkins-dashboard.png">
</p>  

## :arrow_forward: Запуск из терминала
Локальный запуск:
```
gradle clean test
```

Удаленный запуск:
```
clean
test
```

## :open_book: Allure отчет
- ### Главный экран отчета, локальный запуск
<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/allure-main-page.png">
</p>

- ### Страница с проведенными тестами, локальный запуск
<p align="center">
<img title="Allure Test Page" src="images/screenshots/allure-test-page.png">
</p>

## :robot: Отчет в Telegram
<p align="center">
<img title="Telegram notification message" src="images/screenshots/telegram-bot_local.png">
</p>

## :film_projector: Видео примеры прохождения тестов
> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Selenoid Video" src="images/gif/test-run.gif">
</p>