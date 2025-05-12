package uk.autores.integrate.lists;

import uk.autores.Messages;

import java.util.List;
import java.util.Locale;

@Messages("jdk23.properties")
public class Main {
    public static void main(String[] args) {
        var l = Locale.getDefault();
        var list = List.of("foo", "bar", "baz");

        System.out.println(Jdk23.standard(l, list));
        System.out.println(Jdk23.unit(l, list));
        System.out.println(Jdk23.or(l, list));

        System.out.println(Jdk23.compactLong(l, 8 * 1024));
        System.out.println(Jdk23.compactShort(l, 16 * 1024));
    }
}