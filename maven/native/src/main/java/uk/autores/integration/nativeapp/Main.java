package uk.autores.integration.nativeapp;

import uk.autores.*;

import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

@ByteArrays(name = "BytData", value = "InlineBytes.txt", strategy = Strategy.INLINE)
@Texts(name = "StrData", value = "InlineString.txt", strategy = Strategy.INLINE)
@Messages(value = "InlineMessage.properties", noneType = String.class, numberType = Integer.class, dateTimeType = TemporalAccessor.class)
public class Main {
    public static void main(String[] args) {
        System.out.writeBytes(BytData.inlineBytes());
        System.out.print(StrData.inlineString());
        System.out.println(InlineMessage.msg("Hello!"));

        var now = ZonedDateTime.now();
        String c = InlineMessage.complex(Locale.US, now, 100, "sundial");
        System.out.println(c);
    }
}
