package com.moves.movesCelebrity.social.commands.fb;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.moves.movesCelebrity.social.types.Command;
import com.moves.movesCelebrity.utils.Constants;
import org.bson.Document;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class FetchAccountsCommand implements Command<Document, String> {


    public FetchAccountsCommand(){

    }

    @Override
    public CompletableFuture<Document> execute(String arg) {
        return CompletableFuture.supplyAsync(() -> {
            Document posts = null;
            try {
                posts = fetchFbAccounts(arg);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return posts;
        });
    }

    private Document fetchFbAccounts(String accessToken) {

        Document doc = null;
        String url = String.format(Constants.FACEBOOK_FETCH_USER_DETAILS, accessToken);
        String response = null;
        try {
            response = Unirest.get(url).asJson().getBody().toString();
            if (response != null && !response.contains("error_code")) {
                 doc = Document.parse( response.toString() );
                System.out.println("Printing document : "+ doc);
                //posts = (ArrayList<Document>) doc.get("data");
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return doc;
    }
}

