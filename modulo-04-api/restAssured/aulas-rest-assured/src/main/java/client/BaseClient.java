package client;

import static io.restassured.RestAssured.*;

// Classe de configs em comum para as requisicoes
public abstract class BaseClient {

    public static void initConfig() {
        baseURI = "http://vemser-dbc.dbccompany.com.br";
        port = 39000;
        basePath = "/vemser/dbc-pessoa-api";

        enableLoggingOfRequestAndResponseIfValidationFails();

    }
}
