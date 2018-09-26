package com.moves.movesCelebrity.social.restFB;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moves.movesCelebrity.configuration.MovesConfiguration;
import com.moves.movesCelebrity.social.types.Command;
import com.moves.movesCelebrity.utils.serdeser.ObjectIDGsonDeserializer;
import com.moves.movesCelebrity.utils.serdeser.ObjectIDGsonSerializer;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.TwitterException;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class FBGetUserDetailsByRestFB implements Command<Document, String> {

    String accessToken = MovesConfiguration.FB_ACC_TOKEN;
    FacebookClient fbClient = new DefaultFacebookClient(accessToken);

    private Logger logger = LoggerFactory.getLogger(FBGetUserDetailsByRestFB.class);
    private ObjectMapper mapper = new ObjectMapper();
    private Gson gson = new GsonBuilder()
            .registerTypeAdapter(ObjectId.class, new ObjectIDGsonDeserializer())
            .registerTypeAdapter(ObjectId.class, new ObjectIDGsonSerializer())
            .setPrettyPrinting().create();

    public FBGetUserDetailsByRestFB() {
    }

    @Override
    public CompletableFuture<Document> execute(String post) {
        return CompletableFuture.supplyAsync(() -> {
            Document userDetails = null;
            //Status status = twitter.updateStatus(post);
            try {
                userDetails = fetch(post);
            } catch (IOException | TwitterException e) {
                e.printStackTrace();
            }

            return userDetails;
        });
    }

    public Document fetch(String post) throws TwitterException, IOException {
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        //Status status = twitter.updateStatus(post);

        User me = fbClient.fetchObject("me",User.class);

        System.out.println("Name is : " + me.getName());
        System.out.println("User Id is : " + me.getId());
        return mapper.readValue(gson.toJson(me), new TypeReference<Document>() {});
    }
}
