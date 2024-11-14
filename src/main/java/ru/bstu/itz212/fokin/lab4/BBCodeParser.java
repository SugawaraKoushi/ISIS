package ru.bstu.itz212.fokin.lab4;

import ru.bstu.itz212.fokin.lab4.bbcodes.*;

import java.util.ArrayList;
import java.util.List;

public class BBCodeParser {
    private static List<IBBCode> bbCodes = new ArrayList<>();

    static {
        bbCodes.add(new BCode());
        bbCodes.add(new UCode());
        bbCodes.add(new ICode());
        bbCodes.add(new SCode());
        bbCodes.add(new UrlCode());
        bbCodes.add(new ImgCode());
        bbCodes.add(new QuoteCode());
        bbCodes.add(new CodeCode());
        bbCodes.add(new SizeCode());
        bbCodes.add(new ColorCode());
        bbCodes.add(new UlCode());
        bbCodes.add(new OlCode());
        bbCodes.add(new LiCode());
        bbCodes.add(new ListCode());
        bbCodes.add(new SpoilerCode());
        bbCodes.add(new HrCode());
        bbCodes.add(new TableCode());
        bbCodes.add(new TrCode());
        bbCodes.add(new ThCode());
        bbCodes.add(new TdCode());
        bbCodes.add(new FontCode());
    }

    public static String parse(String text) {
        for (IBBCode bbCode : bbCodes) {
            text = bbCode.replaceEntries(text);
        }

        return text;
    }
}
