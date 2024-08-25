package uk.autores.generate;

public @interface Res {
    String name();
    long size();
    boolean text() default false;
}
