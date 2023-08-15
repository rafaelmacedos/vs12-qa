package basico.task02.data;

public abstract class LoginDetails {
    private static String email = "fulano@qa.com";

    private static String senha = "teste";

    public static String retornarStringDeLogin() {
        return "{\"email\": \""+ email + "\", \"password\": \"" + senha + "\"}";
    }
}
