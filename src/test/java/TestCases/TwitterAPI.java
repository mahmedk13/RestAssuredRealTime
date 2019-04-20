package TestCases;



import java.util.List;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Utility.TestSetup;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TwitterAPI extends TestSetup {
	
		/*
		 * Response response = given().auth().oauth("BjApkejjTBjAJLSJqhrBwFSWR",
		 * "lCyAiJcBuafFgk2XExYKFS0nk6SyJB0Wb6xYYDalH3dX6U0m8y",
		 * "1049004757401001984-cGT2UHgJ2mk8FnZA8cfKfuAC0chg1U",
		 * "K5qyT8MTvD1UhiacR7AIWCxnd8dErdtIZ0Gs6Ch59meF4") .queryParam("status",
		 * "Good show by Mamta and Opposition and others").post(
		 * "https://api.twitter.com/1.1/statuses/update.json").then().extract().response
		 * ();
		 * 
		 */
	
		@Test
		public void tc01() {
		
		Response response =given()
		.auth()
		.oauth("BjApkejjTBjAJLSJqhrBwFSWR","lCyAiJcBuafFgk2XExYKFS0nk6SyJB0Wb6xYYDalH3dX6U0m8y","1049004757401001984-cGT2UHgJ2mk8FnZA8cfKfuAC0chg1U","K5qyT8MTvD1UhiacR7AIWCxnd8dErdtIZ0Gs6Ch59meF4")
		
		.queryParam("id", "1092329341747367939")
		.get("/show.json")
		.then().extract().response();
		
		/*
		 * response=given() .auth() .oauth("BjApkejjTBjAJLSJqhrBwFSWR",
		 * "lCyAiJcBuafFgk2XExYKFS0nk6SyJB0Wb6xYYDalH3dX6U0m8y",
		 * "1049004757401001984-cGT2UHgJ2mk8FnZA8cfKfuAC0chg1U",
		 * "K5qyT8MTvD1UhiacR7AIWCxnd8dErdtIZ0Gs6Ch59meF4") //.queryParam("id",
		 * "1091936025889378304") .post("/destroy/"+1091933139365187585L+".json")
		 * .then().extract().response();
		 */
		
		System.out.println(response.statusCode());
		
		JsonPath jp = response.jsonPath();
		List<String> list = jp.get("entities.user_mentions*.screen_name");
		System.out.println(list);
		

		
		
		testLevelLogger.get().log(Status.PASS, "Called API to get status");
		
		
		
	}

}
