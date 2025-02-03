package com.siva.ems_backend.exception;

//RuntimeException is the superclass of all exceptions that can be thrown during operation
//we can create exception(error) using this class
public class ResourceNotFoundException extends RuntimeException{
    /*the following constructor will create an error in the following template:
        ResourceNotFoundException: message
    */
    public ResourceNotFoundException (String message){
        super(message);
    }
    
}
