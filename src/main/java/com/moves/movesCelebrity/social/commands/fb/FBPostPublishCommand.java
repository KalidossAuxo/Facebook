package com.moves.movesCelebrity.social.commands.fb;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.moves.movesCelebrity.configuration.MovesConfiguration;
import com.moves.movesCelebrity.social.types.Command;
import com.moves.movesCelebrity.utils.Constants;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class FBPostPublishCommand implements Command<Document,String> {

    private Logger logger = LoggerFactory.getLogger(FBPostFetchCommand.class);

    public FBPostPublishCommand() {
    }

    @Override
    public CompletableFuture<Document> execute( String post) {
        return CompletableFuture.supplyAsync(() -> {
            //return fetch( pageDetails.get("post"));
            Document posts = null;
            posts = fetch(post);
            return posts;
        });

    }

    public Document fetch(String post){
        HttpResponse<JsonNode> httpResponse = null;
        Document doc = null;
        try {
            String url = String.format(Constants.FB_PAGE_POSTS);
            httpResponse = Unirest.post(url).queryString("message",post).asJson();

             doc =  Document.parse(httpResponse.getBody().toString());;
               // posts = (Document) doc.get("data");
            //System.out.println("Document response is : " + doc);
            //System.out.println("Post response is : " + posts);

        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
