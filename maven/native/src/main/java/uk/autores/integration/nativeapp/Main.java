package uk.autores.integration.nativeapp;

import uk.autores.ByteArrayResources;
import uk.autores.MessageResources;
import uk.autores.Strategy;
import uk.autores.StringResources;

@ByteArrayResources(value = "InlineBytes.txt", strategy = Strategy.INLINE)
@StringResources(value = "InlineString.txt", strategy = Strategy.INLINE)
@MessageResources("InlineMessage.properties")
public class Main {
    public static void main(String[] args) {
        System.out.writeBytes(InlineBytes.bytes());
        System.out.print(InlineString.text());
        System.out.println(InlineMessage.msg("Hello!"));
    }
}
