/**
 * TableCode
 *
 * version 1.0
 *
 * (с) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab4.bbcodes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableCode implements BBCode {
    private final Pattern pattern = Pattern.compile("(?s)\\[table](.+?)\\[/table]");
    private final String[] replacement = new String[]{"<table>", "</table>"};

    @Override
    public String replaceEntries(String text) {
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            text = matcher.replaceFirst(String.format("%s$1%s", replacement[0], replacement[1]));
            matcher = pattern.matcher(text);
        }

        return text;
    }
}
