package uk.autores.integration.nativeapp;

import uk.autores.GenerateByteArraysFromFiles;
import uk.autores.ResourceFiles;
import uk.autores.cfg.Strategy;

import static uk.autores.cfg.Strategy.STRATEGY;

@ResourceFiles(
        value = "InlineBytes.txt",
        handler = GenerateByteArraysFromFiles.class,
        config = @ResourceFiles.Cfg(key = STRATEGY, value = Strategy.INLINE)
)
public class Main {
    public static void main(String[] args) {
        System.out.writeBytes(InlineBytes.bytes());
    }
}
