package com.moves.movesCelebrity.social.commands.fb;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.moves.movesCelebrity.social.types.Command;
import com.moves.movesCelebrity.utils.Constants;
import org.bson.Document;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class FetchUserLikedPages implements Command<ArrayList<Document>, String> {

    public FetchUserLikedPages() {
    }

    @Override
    public CompletableFuture<ArrayList<Document>> execute(String arg) {
        return CompletableFuture.supplyAsync(() -> {
            ArrayList<Document> posts = null;
            try {
                posts = fetchFbUserLikedPages(arg);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return posts;
        });
    }

    private ArrayList<Document> fetchFbUserLikedPages(String accessToken) {

        ArrayList<Document> posts = null;
        String url = String.format(Constants.FACEBOOK_FETCH_ACCOUNTS_LIKED_PAGES, accessToken);
        String response = null;
        try {
            response = Unirest.get(url).asJson().getBody().toString();
            if (response != null && !response.contains("error_code")) {
                Document doc = Document.parse( response.toString() );
                posts = (ArrayList<Document>) doc.get("data");
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return posts;
    }
}
