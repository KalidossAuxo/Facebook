package com.moves.movesCelebrity.social.commands.fb;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.moves.movesCelebrity.social.types.Command;
import com.moves.movesCelebrity.utils.Constants;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

public class FBPostPublishVideoCommand implements Command<Document,String > {

    private Logger logger = LoggerFactory.getLogger(FBPostPublishVideoCommand.class);

    public FBPostPublishVideoCommand() {
    }

    @Override
    public CompletableFuture<Document> execute(String post){
        return CompletableFuture.supplyAsync(()->{
            Document posts = null;
            try {
                posts = fetch(post);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return posts;
        });
    }

    public Document fetch(String post) throws MalformedURLException {
        String fileURL = "https://youtu.be/La70hsgf7wQ?list=PLWUagoeqmhs7r_2QGP9kgn6ZsuFP-mcIN";
        String fileFromLocal = "";
        URL fileURLFromLocal = new File(fileFromLocal).toURI().toURL();
        String url = String.format(Constants.FB_PAGE_POSTS_VIDEO);
        HttpResponse<JsonNode> httpResponse = null;
        Document doc = null;
        try{
            httpResponse = Unirest.post(url).queryString("message",post).queryString("url",fileURL).asJson();
            doc= Document.parse(httpResponse.getBody().toString());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
