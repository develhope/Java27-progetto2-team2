package Exceptions;

public class ProductDoesntExistException extends Exception{

    public ProductDoesntExistException(String message){
        super(message);
    }
}
