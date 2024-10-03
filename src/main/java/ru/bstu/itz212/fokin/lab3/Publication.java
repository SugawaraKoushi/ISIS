package ru.bstu.itz212.fokin.lab3;

import java.util.Date;
import java.util.Scanner;

public abstract class Publication {
    public abstract void init(Scanner scanner);
    public abstract String getName();
    public abstract Date getDatePublication();
    public abstract String toString();
}
