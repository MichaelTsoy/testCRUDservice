package local.kz.java11mvc;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class restTest {
    private final String localUrl = "localhost:8081/";
    @Test
    public void createPaper(){
        String queryBody = "{\n" +
                "\"paperName\": \"new Paper\", \n" +
                " \"paperContent\": \"Content\"\n" +
                " \"clientId\": \"1\"\n" +
                "}";
        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(queryBody)
                .post(localUrl+ "createPaper")
                .then()
                .statusCode(200);
    }

    @Test
    public void createUser(){
        String queryBody = "{\n" +
                "\"clientName\": \"clientName\", \n" +
                " \"clientSurname\": \"cleintSurname\"\n" +
                " \"clientEmail\": \"clientEmail\"\n" +
                "}";
        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(queryBody)
                .post(localUrl+ "createUser")
                .then()
                .statusCode(200);
    }

    @Test
    public void readUsers(){
        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .get(localUrl+ "Users")
                .then()
                .statusCode(200);
    }

    @Test
    public void readPapers(){
        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .get(localUrl+ "Papers")
                .then()
                .statusCode(200);
    }
}
