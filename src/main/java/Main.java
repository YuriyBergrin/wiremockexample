import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Main {

	WireMockServer wireMockServer;

	@BeforeEach
	public void setup() {
		wireMockServer = new WireMockServer(8080);
		wireMockServer.start();
	}

	@AfterEach
	public void teardown() {
		wireMockServer.stop();
	}

	@Test
	public void postTest() {
		Response response = given().when().get("http://localhost:8080/test");
		String title = response.jsonPath().get("body.innerTitle.title");
		int code = response.statusCode();
		System.out.println(code);
		System.out.println(title);
	}
}
