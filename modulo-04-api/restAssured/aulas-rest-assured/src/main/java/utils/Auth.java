package utils;

import io.restassured.http.ContentType;


import static io.restassured.RestAssured.given;

public class Auth {

    public static String tokenAdmin() {
        return
        // obter token
                given()
                        .contentType(ContentType.JSON)
                        .body("{\"login\": \"admin\" , \"senha\":\"123\"}")
                .when()
                        .post("http://vemser-dbc.dbccompany.com.br:39000/vemser/dbc-pessoa-api/auth")
                .then()
                        .extract().asString();

    }
}
