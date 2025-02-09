/**
 * BBCode
 *
 * version 1.0
 *
 * (с) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab4.bbcodes;

/**
 * Интерфейс описывает поведение замены BB-кода на его соответствие html-тэгу
 */
public interface BBCode {
    /**
     * Заменяет вхождение BB-кода на его соответствие html-тэга
     * @param text текст, в котором нужно заменить BB-код на html-тэг
     * @return отформатированный текст
     */
    String replaceEntries(String text);
}
