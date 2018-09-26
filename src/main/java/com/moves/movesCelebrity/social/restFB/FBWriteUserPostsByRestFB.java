package com.moves.movesCelebrity.social.restFB;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moves.movesCelebrity.configuration.MovesConfiguration;
import com.moves.movesCelebrity.dao.SocialMediaPostDao;
import com.moves.movesCelebrity.social.types.Command;
import com.moves.movesCelebrity.utils.serdeser.ObjectIDGsonDeserializer;
import com.moves.movesCelebrity.utils.serdeser.ObjectIDGsonSerializer;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class FBWriteUserPostsByRestFB implements Command<Void,ArrayList<Document>> {

    private ObjectMapper mapper = new ObjectMapper();
    private Gson gson = new GsonBuilder()
            .registerTypeAdapter(ObjectId.class, new ObjectIDGsonDeserializer())
            .registerTypeAdapter(ObjectId.class, new ObjectIDGsonSerializer())
            .setPrettyPrinting().create();

    public FBWriteUserPostsByRestFB() {
    }

    @Override
    public CompletableFuture<Void> execute(ArrayList<Document> documents) {
        return CompletableFuture.supplyAsync(() -> {
            //Document trends = null;
            insert(documents);
            return null;
        });
    }

    public void insert(ArrayList<Document> documents) {
        //SocialMediaPostDao.insert(document, MovesConfiguration.COLLECTION_POSTS_TWITTER);
        SocialMediaPostDao.insertMany(documents, MovesConfiguration.COLLECTION_FB_USER_POSTS);
    }
}
