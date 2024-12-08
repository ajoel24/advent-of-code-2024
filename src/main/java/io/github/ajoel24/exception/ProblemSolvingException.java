package io.github.ajoel24.exception;

import java.io.Serial;

public class ProblemSolvingException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -2081177425516518926L;

    public ProblemSolvingException(String message) {
        super(message);
    }
}
