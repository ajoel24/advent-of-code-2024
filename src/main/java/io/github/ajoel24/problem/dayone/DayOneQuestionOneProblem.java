package io.github.ajoel24.problem.dayone;

import io.github.ajoel24.problem.Problem;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import static io.github.ajoel24.util.Utils.SPACE_REGEX_PATTERN;

/**
 * Link to problem: <a href="https://adventofcode.com/2024/day/1">Advent of Code 2024: Day 1</a>
 */
public class DayOneQuestionOneProblem implements Problem {
    private static final Logger LOGGER = Logger.getLogger(DayOneQuestionOneProblem.class.getName());

    @Override
    public Optional<String> solve(Path inputFilePath) {
        try {
            List<String> lines = Files.readAllLines(inputFilePath);
            List<Integer> firstList = new ArrayList<>();
            List<Integer> secondList = new ArrayList<>();

            lines.stream()
                    .map(line -> {
                        String[] elements = line.split(SPACE_REGEX_PATTERN);
                        return Map.entry(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
                    }).forEach(entry -> {
                        firstList.add(entry.getKey());
                        secondList.add(entry.getValue());
                    });
            List<Integer> sortedFirstList = firstList.stream()
                    .sorted(Comparator.naturalOrder())
                    .toList();
            List<Integer> sortedSecondList = secondList.stream().sorted(Comparator.naturalOrder()).toList();
            long result = IntStream.range(0, sortedFirstList.size())
                    .map(index -> Math.abs(sortedFirstList.get(index) - sortedSecondList.get(index)))
                    .sum();
            return Optional.of(String.valueOf(result));
        } catch (Exception exception) {
            LOGGER.severe("An error occurred: %s".formatted(exception.getMessage()));
            return Optional.empty();
        }
    }
}
