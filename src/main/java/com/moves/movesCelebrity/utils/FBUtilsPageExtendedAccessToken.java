package com.moves.movesCelebrity.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.moves.movesCelebrity.social.types.Command;
import org.bson.Document;

import java.util.concurrent.CompletableFuture;

import static com.moves.movesCelebrity.utils.Constants.FB_PAGE_ACCESS_TOKEN_EXTENDED;

public class FBUtilsPageExtendedAccessToken implements Command<Document, String> {

    @Override
    public CompletableFuture<Document> execute(String pageId) {
        return CompletableFuture.supplyAsync(() -> {
            Document pageAccessToken = null;
            pageAccessToken = getPageAccessToken();
            return pageAccessToken;
        });
    }


    public Document getPageAccessToken(){

        String url = String.format(FB_PAGE_ACCESS_TOKEN_EXTENDED);

        HttpResponse<JsonNode> httpResponse = null;
        try {
            httpResponse = Unirest.get(url).asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        System.out.println(httpResponse.getBody().toString());
        return Document.parse(httpResponse.getBody().toString());
    }
}
