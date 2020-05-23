package br.com.kesley.jobextra.exception;

public class UnsufficientDataException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnsufficientDataException(String message) {
        super(message);
    }
}