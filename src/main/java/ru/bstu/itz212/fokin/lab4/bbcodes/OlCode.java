/**
 * OlCode
 *
 * version 1.0
 *
 * (с) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab4.bbcodes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OlCode implements BBCode {
    private final Pattern pattern = Pattern.compile("(?s)\\[ol](.+?)\\[/ol]");
    private final String[] replacement = new String[]{"<ol>", "</ol>"};

    @Override
    public String replaceEntries(String text) {
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            text = matcher.replaceAll(String.format("%s$1%s", replacement[0], replacement[1]));
        }

        return text;
    }
}
