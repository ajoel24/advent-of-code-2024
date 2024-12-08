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