/**
 * UrlCode
 *
 * version 1.0
 *
 * (с) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab4.bbcodes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlCode implements BBCode {
    private final Pattern pattern1 = Pattern.compile("(?s)\\[url=(.+?)](.+?)\\[/url]");
    private final Pattern pattern2 = Pattern.compile("(?s)\\[url](.+?)\\[/url]");
    private final String[] replacement = new String[] {"<a href=\"", "\">", "</a>"};

    @Override
    public String replaceEntries(String text) {
        Matcher m = pattern1.matcher(text);

        if (m.find()) {
            return m.replaceAll(String.format("%s$1%s$2%s", replacement[0], replacement[1], replacement[2]));
        }

        m = pattern2.matcher(text);

        if (m.find()) {
            return m.replaceAll(String.format("%s$1%s$1%s", replacement[0], replacement[1], replacement[2]));
        }

        return text;
    }
}
