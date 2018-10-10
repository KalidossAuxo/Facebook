package com.moves.movesCelebrity.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.bson.Document;
import org.json.JSONObject;

import static com.moves.movesCelebrity.configuration.MovesConfiguration.FB_APP_ID;
import static com.moves.movesCelebrity.configuration.MovesConfiguration.FB_APP_SECRET;
import static com.moves.movesCelebrity.utils.Constants.FACEBOOK_GRAPH_API_URL;
import static com.moves.movesCelebrity.utils.Constants.FB_PAGE_ACCESS_TOKEN;
import static com.moves.movesCelebrity.utils.Constants.FB_PAGE_ACCESS_TOKEN_EXTENDED;

public class TestFBPageExtendedAccessToken {
    public static void main(String[] args) {
        String url = String.format(FB_PAGE_ACCESS_TOKEN);

        HttpResponse<JsonNode> httpResponse = null;
        try {
            httpResponse = Unirest.get(url).asJson();

            JSONObject jsonObject = new JSONObject(httpResponse.getBody().toString());
            String pageAccessToken = jsonObject.getString("access_token");

            System.out.println("The page access token from Http response is : "+httpResponse.getBody().toString());
            System.out.println("The page Access token is : " + pageAccessToken);

            if (pageAccessToken != null) {
                String url1 = String.format(FACEBOOK_GRAPH_API_URL + "/oauth/access_token?client_id=" + FB_APP_ID +
                        "&client_secret=" + FB_APP_SECRET + "&grant_type=fb_exchange_token&fb_exchange_token=" + pageAccessToken);

                httpResponse = Unirest.get(url1).asJson();
                String pageAccessToken1 = httpResponse.getBody().toString();
                System.out.println("The access token in extended part is : "+pageAccessToken);
                System.out.println("The Extended Access Token is : " + pageAccessToken1);
            }
            } catch (UnirestException e) {
            e.printStackTrace();
        }

        }
    }


