package org.example.jmh.constant;

import org.example.jmh.Res;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.infra.Blackhole;
import uk.autores.ByteArrays;
import uk.autores.Strategy;

@ByteArrays(
        value = {
                Res.PATH + "tiny.bin",
                Res.PATH + "small.bin",
                Res.PATH + "medium.bin",
                Res.PATH + "large.bin",
        },
        strategy = Strategy.CONST
)
public class ConstByteArray {
    @Benchmark
    @BenchmarkMode(Mode.All)
    public void tiny(Blackhole blackhole) {
        blackhole.consume(Tiny.bytes());
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    public void small(Blackhole blackhole) {
        blackhole.consume(Small.bytes());
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    public void medium(Blackhole blackhole) {
        blackhole.consume(Medium.bytes());
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    public void large(Blackhole blackhole) {
        blackhole.consume(Large.bytes());
    }
}
