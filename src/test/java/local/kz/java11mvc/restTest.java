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
                " \"paperContent\": \"Content\", \n" +
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
                " \"clientSurname\": \"cleintSurname\", \n" +
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
    @Test
    public void deletePaper(){
        String queryBody = "{\n" +
                "\"id\": \"1\" \n" +
                "}";
        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(queryBody)
                .get(localUrl+ "deletePaper")
                .then()
                .statusCode(200);
    }
    @Test
    public void deleteUser(){
        String queryBody = "{\n" +
                "\"id\": \"1\" \n" +
                "}";
        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(queryBody)
                .get(localUrl+ "deleteUser")
                .then()
                .statusCode(200);
    }
    @Test
    public void updatePaper(){
        String queryBody = "{\n" +
                "\"paperName\": \"modifiedPaper\", \n" +
                " \"paperContent\": \"modifiedContent\", \n" +
                " \"clientId\": \"1\"\n" +
                "}";
        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(queryBody)
                .get(localUrl+ "updateUser")
                .then()
                .statusCode(200);
    }
    @Test
    public void updateUser(){
        String queryBody = "{\n" +
                "\"clientName\": \"Иван\", \n" +
                " \"clientSurname\": \"Иванов\", \n" +
                " \"clientEmail\": \"Ivan@mail.ru\" \n" +
                "}";
        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(queryBody)
                .get(localUrl+ "updateUser")
                .then()
                .statusCode(200);
    }
    @Test
    public void readUser(){
        String queryBody = "{\n" +
                "\"id\": \"1\" \n" +
                "}";
        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(queryBody)
                .get(localUrl+ "readUser")
                .then()
                .statusCode(200);
    }

    @Test
    public void readPaper(){
        String queryBody = "{\n" +
                "\"id\": \"1\" \n" +
                "}";
        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(queryBody)
                .get(localUrl+ "readPaper")
                .then()
                .statusCode(200);
    }

}
