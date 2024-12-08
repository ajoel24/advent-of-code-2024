package io.github.ajoel24;

import io.github.ajoel24.problem.dayone.DayOneQuestionOneProblem;
import org.openjdk.jmh.annotations.Benchmark;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public void run() throws URISyntaxException {
        Path path = Paths.get(BenchmarkRunner.class.getClassLoader().getResource("problems/day-1-1.txt").toURI());
        new DayOneQuestionOneProblem().solve(path);
    }
}
