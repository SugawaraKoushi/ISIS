/**
 * HrCode
 *
 * version 1.0
 *
 * (с) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab4.bbcodes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HrCode implements BBCode {
    private final Pattern pattern = Pattern.compile("\\[hr]");
    private final String replacement = "<hr />";

    @Override
    public String replaceEntries(String text) {
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            text = matcher.replaceAll(replacement);
        }

        return text;
    }
}
