package uz.pdp.eufloria.exception;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message){
        super(message + " is already exists");
    }
}
