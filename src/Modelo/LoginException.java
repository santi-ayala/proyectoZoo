package Modelo;

public class LoginException extends Exception{// uso en el sistema de login, para los campos vacios

    public LoginException(String message) {
        super(message);
    }

}
