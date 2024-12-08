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

import io.github.ajoel24.exception.ProblemSolvingException;
import io.github.ajoel24.problem.AdventOfCodeProblem;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import static io.github.ajoel24.util.Utils.SPACE_REGEX_PATTERN;

/**
 * Link to problem: <a href="https://adventofcode.com/2024/day/1">Advent of Code 2024: Day 1</a>
 */
public class DayOne implements AdventOfCodeProblem {
    private static final Logger LOGGER = Logger.getLogger(DayOne.class.getName());

    /**
     * Solution to the first problem of Day One.
     *
     * @param inputFilePath Path of the text file that contains the input data.
     * @return An {@link Optional} that contains the solution.
     * If no solution is found, returns an empty {@link Optional}.
     */
    @Override
    public Optional<String> solveFirstProblem(Path inputFilePath) {
        try {
            List<String> lines = Files.readAllLines(inputFilePath);
            var firstList = new ArrayList<Integer>();
            var secondList = new ArrayList<Integer>();

            lines.stream()
                    .map(line -> {
                        String[] elements = line.split(SPACE_REGEX_PATTERN);
                        return Map.entry(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
                    }).forEach(entry -> {
                        firstList.add(entry.getKey());
                        secondList.add(entry.getValue());
                    });
            var sortedFirstList = firstList.stream()
                    .sorted(Comparator.naturalOrder())
                    .toList();
            var sortedSecondList = secondList.stream().sorted(Comparator.naturalOrder()).toList();
            int result = IntStream.range(0, sortedFirstList.size())
                    .map(index -> Math.abs(sortedFirstList.get(index) - sortedSecondList.get(index)))
                    .sum();
            return Optional.of(String.valueOf(result));
        } catch (Exception exception) {
            LOGGER.severe("An error occurred: %s".formatted(exception.getMessage()));
            return Optional.empty();
        }
    }

    /**
     * Solution to the second problem of Day One.
     *
     * @param inputFilePath Path of the text file with input data.
     * @return An {@link Optional} that contains the solution.
     * If no solution is found, returns an empty {@link Optional}
     */
    @Override
    public Optional<String> solveSecondProblem(Path inputFilePath) {
        try {
            List<String> lines = Files.readAllLines(inputFilePath);
            var firstList = new ArrayList<Integer>();
            var secondList = new ArrayList<Integer>();

            lines.stream()
                    .map(line -> {
                        String[] elements = line.split(SPACE_REGEX_PATTERN);
                        return Map.entry(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
                    }).forEach(entry -> {
                        firstList.add(entry.getKey());
                        secondList.add(entry.getValue());
                    });
            var cardinalityMap = new HashMap<Integer, Integer>();
            secondList.forEach(number -> {
                if (cardinalityMap.containsKey(number)) {
                    var existingCount = cardinalityMap.get(number);
                    var updatedCount = existingCount + 1;
                    cardinalityMap.put(number, updatedCount);
                } else {
                    cardinalityMap.put(number, 1);
                }
            });

            int result = firstList.stream()
                    .map(number -> number * cardinalityMap.getOrDefault(number, 0))
                    .reduce(Integer::sum)
                    .orElseThrow(() -> new ProblemSolvingException("Result is empty"));
            
            return Optional.of(String.valueOf(result));
        } catch (Exception exception) {
            LOGGER.severe("An error occurred: %s".formatted(exception.getMessage()));
            return Optional.empty();
        }
    }
}
