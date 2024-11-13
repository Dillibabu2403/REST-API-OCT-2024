package week3assignments;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateChangeRequest {

	public static void main(String[] args) {
		String url="https://dev230083.service-now.com/api/now/table/{tableName}";
		String requestBody= "{\r\n"
				+ "    \"short_description\":\"Automation API testing\",\r\n"
				+ "    \"description\":\"Dillibabu\"\r\n"
				+ "}";
				
				RestAssured.given()
		        .auth()
		        .basic("admin", "Babu@2403")
		        .pathParam("tableName", "change_request")
		        .header("Content-Type","application/json")
		        .log().all()
		        .when()
		        .body(requestBody)
		        .post(url)
		        .then()
		        .log().all()
		        .assertThat()
		        .statusCode(201)
		        .and()
		        .statusLine(Matchers.containsString("Created"))
		        .and()
		        .contentType(ContentType.JSON)
		        .and()
		        .time(Matchers.lessThan(9000L));
			}

		}
