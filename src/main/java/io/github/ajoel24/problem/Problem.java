package io.github.ajoel24.problem;

import java.nio.file.Path;
import java.util.Optional;

public interface Problem {
    Optional<String> solve(Path inputFilePath);
}
