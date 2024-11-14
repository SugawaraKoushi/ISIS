package ru.bstu.itz212.fokin.lab4.bbcodes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FontCode implements IBBCode {
    private final Pattern pattern = Pattern.compile("(?s)\\[font=(.+?)](.+?)\\[/font]");
    private final String[] replacement = new String[]{"<span style=\"font-style: ", ";\">", "</span>"};

    @Override
    public String replaceEntries(String text) {
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String sizeValue = matcher.group(1).replaceAll("\"", "");
            text = matcher.replaceFirst(String.format("%s%s%s$2%s", replacement[0], sizeValue,
                    replacement[1], replacement[2]));
            matcher = pattern.matcher(text);
        }

        return text;
    }
}
