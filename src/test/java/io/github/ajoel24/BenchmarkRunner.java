/*
 * Copyright 2024 Andrew Joel
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

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
