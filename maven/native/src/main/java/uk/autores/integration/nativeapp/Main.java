package uk.autores.integration.nativeapp;

import uk.autores.*;

@ByteArrays(name = "BytData", value = "InlineBytes.txt", strategy = Strategy.INLINE)
@Texts(name = "StrData", value = "InlineString.txt", strategy = Strategy.INLINE)
@Messages("InlineMessage.properties")
public class Main {
    public static void main(String[] args) {
        System.out.writeBytes(BytData.inlineBytes());
        System.out.print(StrData.inlineString());
        System.out.println(InlineMessage.msg("Hello!"));
    }
}
