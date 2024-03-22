package uk.autores.integration.nativeapp;

import uk.autores.*;

@ByteArrays(value = "InlineBytes.txt", strategy = Strategy.INLINE)
@Texts(value = "InlineString.txt", strategy = Strategy.INLINE)
@Messages("InlineMessage.properties")
public class Main {
    public static void main(String[] args) {
        System.out.writeBytes(InlineBytes.bytes());
        System.out.print(InlineString.text());
        System.out.println(InlineMessage.msg("Hello!"));
    }
}
