@ResourceFiles(
        value = "Foo.txt",
        handler = GenerateStringsFromText.class,
        config = @ResourceFiles.Cfg(key = VISIBILITY, value = Visibility.PUBLIC)
)
package uk.autores.integration.mavencp;

import uk.autores.GenerateStringsFromText;
import uk.autores.ResourceFiles;
import uk.autores.cfg.Visibility;

import static uk.autores.cfg.Visibility.VISIBILITY;
