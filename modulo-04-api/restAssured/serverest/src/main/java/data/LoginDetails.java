package data;

import utils.Manipulation;

public class LoginDetails {
    private static final String EMAIL =  Manipulation.getProp().getProperty("email");

    private static final String SENHA = Manipulation.getProp().getProperty("senha");

    public static String retornarStringDeLogin() {
        return "{\"email\": \""+ EMAIL + "\", \"password\": \"" + SENHA + "\"}";
    }
}
