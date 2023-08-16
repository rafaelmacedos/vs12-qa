package utils;

import data.LoginDetails;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Login {

    public static String tokenAdmin() {
        String token =
                // obter token
                given()
                        .contentType(ContentType.JSON)
                        .body(LoginDetails.retornarStringDeLogin())
                .when()
                        .post("http://localhost:3000/login")
                .then()
                        .extract().response().jsonPath().getString("authorization");
        return token;

    }
}
