/**
 * SpoilerCode
 *
 * version 1.0
 *
 * (с) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab4.bbcodes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Класс для замены BB-кода {@code [spoiler=...]...[/spoiler]} на {@code <details><summary>...</summary>...</details>}
 */
public class SpoilerCode implements BBCode {
    private final Pattern pattern = Pattern.compile("(?s)\\[spoiler=(.+?)](.+?)\\[/spoiler]");
    private final String[] replacement = new String[]{"<details>\n\t<summary>", "</summary>\n\t", "</details>"};

    @Override
    public String replaceEntries(String text) {
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            text = matcher.replaceFirst(String.format("%s$1%s$2%s", replacement[0], replacement[1], replacement[2]));
            matcher = pattern.matcher(text);
        }

        return text;
    }
}
