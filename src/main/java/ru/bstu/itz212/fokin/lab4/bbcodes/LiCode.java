/**
 * LiCode
 *
 * version 1.0
 *
 * (с) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab4.bbcodes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс для замены BB-кода {@code [li]...[/li]} на {@code <li>...</li>}
 */
public class LiCode implements BBCode {
    private final Pattern pattern1 = Pattern.compile("(?s)\\[li](.+?)\\[/li]");
    private final Pattern pattern2 = Pattern.compile("\\[\\*](.+)");
    private final String[] replacement = new String[]{"<li>", "</li>"};

    @Override
    public String replaceEntries(String text) {
        Matcher matcher = pattern1.matcher(text);

        if (matcher.find()) {
            return matcher.replaceAll(String.format("%s$1%s", replacement[0], replacement[1]));
        }

        matcher = pattern2.matcher(text);

        if (matcher.find()) {
            return matcher.replaceAll(String.format("%s$1%s", replacement[0], replacement[1]));
        }

        return text;
    }
}
