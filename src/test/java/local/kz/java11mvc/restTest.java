package local.kz.java11mvc;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class restTest {
    @Test
    public void test1(){
        String str = "{\n" +
                "\"paperName\": \"paperr\", \n" +
                " \"paperContent\": \"contentt\"\n" +
                " \"clientId\": \"10\"\n" +
                "}";
        RestAssured
                .given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(str)
                .post("localhost:8081/createPaper")
                .then()
                .statusCode(200);
    }
}
