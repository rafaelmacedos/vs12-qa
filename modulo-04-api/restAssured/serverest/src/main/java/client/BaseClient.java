package client;

// Classe de configs em comum para as requisicoes
import static io.restassured.RestAssured.*;

public abstract class BaseClient {

    public static void initConfig() {
        baseURI = "http://localhost";
        port = 3000;

        enableLoggingOfRequestAndResponseIfValidationFails();

    }
}
