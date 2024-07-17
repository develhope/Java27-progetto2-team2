package Exceptions;

public class ProductAlreadyExistException extends Exception{

    public ProductAlreadyExistException(String message){
        super(message);
    }
}
