package data;

public class LoginDetails {
    private static final String EMAIL = "fulano@qa.com";

    private static final String SENHA = "teste";

    public static String retornarStringDeLogin() {
        return "{\"email\": \""+ EMAIL + "\", \"password\": \"" + SENHA + "\"}";
    }
}
