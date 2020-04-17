package ro.uaic.info.exception;

public class DuplicateEntry extends Exception {
    public DuplicateEntry(){
        super("Tried to insert duplicate row into database");
    }
}
