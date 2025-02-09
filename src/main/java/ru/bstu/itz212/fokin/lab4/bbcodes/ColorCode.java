/**
 * ColorCode
 *
 * version 1.0
 *
 * (с) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab4.bbcodes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс для замены BB-кода {@code [color=...]...[/color]} на {@code <span style="color: ...;"...</span>}
 */
public class ColorCode implements BBCode {
    private final Pattern pattern = Pattern.compile("(?s)\\[color=(.+?)](.+?)\\[/color]");
    private final String[] replacement = new String[]{"<span style=\"color: ", ";\">", "</span>"};

    @Override
    public String replaceEntries(String text) {
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            String color = matcher.group(1).replaceAll("\"", "");
            text = matcher.replaceFirst(String.format("%s%s%s$2%s", replacement[0], color,
                    replacement[1], replacement[2]));
            matcher = pattern.matcher(text);
        }

        return text;
    }
}
