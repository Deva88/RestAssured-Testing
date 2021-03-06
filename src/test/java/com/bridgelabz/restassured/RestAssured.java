package com.bridgelabz.restassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class RestAssured {

    public String token = "";

    @BeforeTest
    public void setUp() {
        token = "Bearer BQAay-vFF5J6qyHVNZwcts0IGEcW1RJio1ox_GCcO4QwmjtsXVyr5mgtkJvAbOLFM5Cd_XiYZBOTQSA-lSRyofI1vr6VfMTo" +
                "8cTFSBaIWXYqh0zcpAP2yzbBHsHxtRMavKfT3GQUFgWbZD26_G9fUXcS7UJkkSlwMJWtZ-tE4rmZyUoWo1g0noJaR3mFCH-wbv-q5wQ" +
                "4_n65ZAJAeSrsDxTdhH39BzIW3LDggYNj1tKuME8RVIz2wt76S7lVianJ9On72hBQkk_TaAMQR1btfA46zu_jZGseGp5l-LyewETt";
    }
    //Gets current profile data
    @Test
    public void get_Current_profile() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/" + userID + "/");
        response.prettyPrint();
    }

    @Test
    public void get_Current_Users_Playlist() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/" + userID + "/playlists");
        response.prettyPrint();
    }
    //playlist cover image
    @Test
    public void get_Current_Users_Playlist_CoverImage() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/playlists/" + playlistId + "/images");
        response.prettyPrint();
    }
}