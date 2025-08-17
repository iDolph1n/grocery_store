# 🛍️ Grocery Store (Магазин продуктов)

Описание

Это приложение-магазин, написанное на языке Java, демонстрирующее принципы Чистого кода и SOLID.
Пользователи могут просматривать товары, фильтровать их, добавлять в корзину, оформлять заказы и получать рекомендации.

## 🧮 Functional features (Функциональные особенности):

- Просмотр всех доступных товаров
- Фильтрация товаров по ключевым словам
- Добавление товаров в корзину
- Просмотр содержимого корзины и подсчет общей суммы
- Оформление заказа и отслеживание его статуса
- Простая система рекомендаций по производителю

## 🛠 Technologies (Технологии):

- IntelliJ IDEA (рекомендуемая IDE)
- Java 17 (OpenJDK 17.0.15)
- Стандартная библиотека Java (`java.util.List`, `Scanner`, `Stream API`)

## SOLID Principles Applied (Применение принципов SOLID)

1. **Single Responsibility Principle** – Принцип единственной ответственности.

*Пример: Класс [`Cart.java`](https://github.com/iDolph1n/grocery_store/blob/main/src/Cart.java) отвечает только за управление корзиной (добавление, удаление товаров, подсчет общей суммы и т.д.).*

2. **Open/Closed Principle** – Принцип открытости/закрытости.

*Пример: Интерфейс [`ProductFilter.java`](https://github.com/iDolph1n/grocery_store/blob/main/src/ProductFilter.java) позволяет добавлять новые типы фильтров без изменения существующего кода.*

3. **Liskov Substitution Principle** – Принцип подстановки Барбары Лисков.

*Пример: Любая реализация интерфейса [`CartOperations.java`]() может быть подставлена вместо переменной типа интерфейса в [`Main.java`](), и программа продолжит работать корректно без изменения остального кода.*

4. **Interface Segregation Principle** – Принцип разделения интерфейсов.

*Пример: Интерфейсы [`CartOperations.java`]() (операция с корзиной) и [`ProductFilter.java`]() (фильтрация товаров) разделены, классы [`Cart.java`](https://github.com/iDolph1n/grocery_store/blob/main/src/Cart.java) и [`NameFilter.java`](). реализуют только те методы, которые им нужны.*

5. **Dependency Inversion Principle** – Принцип инверсии зависимостей.

*Пример: Программа опирается на интерфейс [`CartOperations.java`](), а не на конкретную реализацию [`Cart.java`](https://github.com/iDolph1n/grocery_store/blob/main/src/Cart.java).*

## 🚀 Project launch (Запуск проекта)

### Installation (Установка)

```bash
# Клонируем репо с проектом
git clone git@github.com:iDolph1n/grocery_store.git
# Переходим в папку проекта
cd shop_netology
# Компилируем Java-код
javac Main.java
# Запускаем программу
java Main
```

## 🤝 How to support the project (Как помочь проекту):

1. Форкните репозиторий.
2. Создайте ветку для фичи или исправления.
3. Запуште изменения.
4. Инициируйте запрос на пул реквест.

## 📄 License MIT (Лицензия)

Ознакомиться подробнее можно в файле [LICENSE](./LICENSE/).

---

> С уваженеи, ваш [iDolph1n](https://github.com/iDolph1n) 🐬
