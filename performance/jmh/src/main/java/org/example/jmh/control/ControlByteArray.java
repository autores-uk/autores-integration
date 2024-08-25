package org.example.jmh.control;

import com.google.common.io.ByteStreams;
import org.example.jmh.Res;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.infra.Blackhole;

import java.io.IOException;
import java.io.InputStream;

public class ControlByteArray {
    @Benchmark
    @BenchmarkMode(Mode.All)
    public void tiny(Blackhole blackhole) throws IOException {
        blackhole.consume(load("tiny.bin"));
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    public void small(Blackhole blackhole) throws IOException {
        blackhole.consume(load("small.bin"));
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    public void medium(Blackhole blackhole) throws IOException {
        blackhole.consume(load("medium.bin"));
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    public void large(Blackhole blackhole) throws IOException {
        blackhole.consume(load("large.bin"));
    }

    private static byte[] load(String r) throws IOException {
        try(InputStream in = ControlByteArray.class.getResourceAsStream(Res.PATH + r)) {
            return ByteStreams.toByteArray(in);
        }
    }
}
