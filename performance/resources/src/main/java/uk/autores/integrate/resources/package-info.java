@Generate({
        @Res(name = "tiny.bin", size = 64),
        @Res(name = "small.bin", size = 512),
        @Res(name = "medium.bin", size = 2*1024*1024),
        @Res(name = "large.bin", size = 8*1024*1024),
})
package uk.autores.integrate.resources;

import uk.autores.generate.Generate;
import uk.autores.generate.Res;
