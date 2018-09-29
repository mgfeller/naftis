package net.mgfeller.naftis;

public class BookNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3505708637155884561L;

    public BookNotFoundException(String message) {
        super(message);
    }

}
