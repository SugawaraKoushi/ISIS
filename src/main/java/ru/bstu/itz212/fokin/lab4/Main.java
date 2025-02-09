/**
 * Main
 *
 * version 1.0
 *
 * (с) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab4;

public class Main {
    public static void main(String[] args) {
        String text = """
                [size=20][b]Углублённое руководство по работе с BB-кодами[/b][/size]
                [i]Автор: Александр Александров[/i]
                
                [img]https://example.com/guide_cover.png[/img]
                
                [quote]Предисловие автора:[/quote]
                [i]«BB-коды — мощный инструмент для форматирования текстов на форумах и в блогах. Освоив их, вы сможете создавать профессионально выглядящие сообщения и посты.»[/i]
                
                [hr]
                
                [size=16][b]Глава 1: Основы BB-кодов[/b][/size]
                
                В этой главе мы рассмотрим базовые принципы работы с BB-кодами и их основными элементами.
                
                [list]
                [*]Что такое BB-коды?
                   BB-коды (Bulletin Board Codes) — это набор тегов, используемых для форматирования текста на форумах, блогах и других онлайн-платформах. Они похожи на HTML, но проще в использовании.
                
                [*]Основные теги BB-кода:
                   [list]
                   [*][b]Bold[/b]: Полужирный текст
                   [*][i]Italic[/i]: Курсив
                   [*][u]Underline[/u]: Подчёркнутый текст
                   [*][url=ссылка]Ссылка[/url]: Ссылка на веб-ресурс
                   [*][color=цвет]Цвет текста[/color]: Изменение цвета текста
                   [*][size=размер]Размер шрифта[/size]: Изменение размера шрифта
                   [*][font=шрифт]Шрифт текста[/font]: Изменение шрифта текста
                   [*][list]Список[/list]: Создание списков
                   [*][code]Кодовый блок[/code]: Вставка блоков кода
                   [*][quote]Цитата[/quote]: Цитирование текста
                   [*][table]Таблица[/table]: Создание таблиц
                   [*][tr]Строка таблицы[/tr]: Строка таблицы
                   [*][td]Ячейка таблицы[/td]: Ячейка таблицы
                   [/list]
                
                [*]Примеры использования BB-кодов:
                   [code]
                   [b]Привет![/b] Как твои дела?
                   [url=https://example.com]Посети мой сайт[/url]!
                   [/code]
                
                [*]Советы по использованию BB-кодов:
                   [list]
                   [*]Всегда закрывайте теги, иначе форматирование может нарушиться.
                   [*]Используйте code для вставки примеров кода.
                   [*]Следите за правильностью вложенности тегов.
                   [*]Используйте spoiler для скрытия длинных фрагментов текста.
                   [*]Создавайте аккуратные и читабельные таблицы с помощью table, tr и td.
                   [/list]
                [/list]
                
                [hr]
                
                [size=16][b]Глава 2: Продвинутые техники работы с BB-кодами[/b][/size]
                
                В этой главе мы углубимся в продвинутые методы использования BB-кодов и рассмотрим некоторые сложные примеры.
                
                [list]
                [*]Создание сложных структур:
                   Иногда вам может понадобиться создать сложную структуру, включающую в себя несколько уровней вложенности. Например, создание многоуровневого списка с таблицами внутри.
                
                   [code]
                   [list]
                   [*]Первый уровень
                      [list]
                      [*]Второй уровень
                         [table]
                         [tr]
                         [td]Первая ячейка[/td]
                         [td]Вторая ячейка[/td]
                         [/tr]
                         [tr]
                         [td]Третья ячейка[/td]
                         [td]Четвёртая ячейка[/td]
                         [/tr]
                         [/table]
                      [/list]
                   [*]Ещё один первый уровень
                      [list]
                      [*]Ещё один второй уровень
                         [quote]Цитата внутри второго уровня[/quote]
                      [/list]
                   [/list]
                   [/code]
                
                [*]Работа с таблицами:
                   Таблицы — отличный способ представления данных в структурированном виде. Рассмотрим пример создания сложной таблицы с заголовками и выравниванием текста.
                
                   [code]
                   [table]
                   [tr]
                   [th]Заголовок 1[/th]
                   [th]Заголовок 2[/th]
                   [th]Заголовок 3[/th]
                   [/tr]
                   [tr]
                   [td]текст[/td]
                   [td]текст[/td]
                   [td]текст[/td]
                   [/tr]
                   [tr]
                   [td]текст[/td]
                   [/tr]
                   [/table]
                   [/code]
                
                [*]Использование спойлеров:
                   Спойлеры полезны для скрытия длинного текста или изображений, которые пользователь может раскрыть по своему желанию. Вот пример использования спойлера с вложенными элементами.
                
                   [code]
                   [spoiler="Скрытый текст"]Открой меня, чтобы увидеть содержимое!
                      [list]
                      [*]Первый пункт
                      [*]Второй пункт
                      [/list]
                      [img]https://example.com/hidden_image.jpg[/img]
                   [/spoiler]
                   [/code]
                
                [*]Советы по созданию профессиональных постов:
                   [list]
                   [*]Используйте заголовки и подзаголовки для разделения текста на логические части.
                   [*]Применяйте разные размеры и цвета шрифтов для выделения важных моментов.
                   [*]Добавляйте изображения и графики для визуального оформления.
                   [*]Проверяйте правильность вложенности тегов перед публикацией.
                   [/list]
                [/list]
                
                [hr]
                
                [size=16][b]Заключение[/b][/size]
                
                Мы рассмотрели множество аспектов работы с BB-кодами, начиная от основ и заканчивая продвинутыми техниками. Теперь у вас есть все необходимые инструменты для создания профессиональных и привлекательных сообщений и постов. Удачи в ваших начинаниях!
               
                """;
        System.out.println(text);
        System.out.printf("%n%n%n");
        System.out.println(BBCodeParser.parse(text));
    }
}
