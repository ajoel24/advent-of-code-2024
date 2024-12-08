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

package io.github.ajoel24.problem.dayone;

import io.github.ajoel24.problem.Problem;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DayOneTest {

    @Test
    void shouldSolveFirstProblem() throws IOException {
        Problem problem = new DayOneQuestionOneProblem();
        URL problemUrl = DayOneTest.class.getClassLoader().getResource("problems/day-1-1.txt");
        assertNotNull(problemUrl);
        Path problemPath = Path.of(problemUrl.getPath());

        URL solutionUrl = DayOneTest.class.getClassLoader().getResource("solutions/day-1-1.txt");
        assertNotNull(solutionUrl);
        Path solutionPath = Path.of(solutionUrl.getPath());
        String solution = Files.readString(solutionPath);

        Optional<String> result = problem.solve(problemPath);

        assertTrue(result.isPresent());
        assertEquals(solution, result.get());
    }
}