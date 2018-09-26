package com.moves.movesCelebrity.social.restFB;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moves.movesCelebrity.configuration.MovesConfiguration;
import com.moves.movesCelebrity.social.models.FBPost;
import com.moves.movesCelebrity.social.types.Command;
import com.moves.movesCelebrity.utils.serdeser.ObjectIDGsonDeserializer;
import com.moves.movesCelebrity.utils.serdeser.ObjectIDGsonSerializer;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Post;
import com.restfb.types.User;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.TwitterException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FBGetUserPostsByRestFB implements Command <ArrayList<Document>, String> {

    String accessToken = MovesConfiguration.FB_ACC_TOKEN;
    FacebookClient fbClient = new DefaultFacebookClient(accessToken);

    private Logger logger = LoggerFactory.getLogger(FBGetUserPostsByRestFB.class);
    private ObjectMapper mapper = new ObjectMapper();
    private Gson gson = new GsonBuilder()
            .registerTypeAdapter(ObjectId.class, new ObjectIDGsonDeserializer())
            .registerTypeAdapter(ObjectId.class, new ObjectIDGsonSerializer())
            .setPrettyPrinting().create();

    public FBGetUserPostsByRestFB() {
    }

    @Override
    public CompletableFuture <ArrayList<Document>> execute(String post) {
        return CompletableFuture.supplyAsync(() -> {
            ArrayList<Document> userPosts = null;
            try {
                userPosts = fetch();
            } catch(Exception e){
                e.printStackTrace();
            }
            return userPosts;
        });
    }

    public ArrayList<Document> fetch() throws IOException {
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

        Connection<Post> result = fbClient.fetchConnection("/me/feed",Post.class);

        List<FBPost> userPosts = new ArrayList<>();

        int counter = 0;
        for(List<Post> page : result){
            for(Post aPost : page){
                Post  post = fbClient.fetchObject(aPost.getId(),Post.class,
                        Parameter.with("fields", "from,to,likes.limit(0).summary(true),comments.limit(0).summary(true),shares.limit(0).summary(true)"));
                FBPost posts = new FBPost();

                posts.setPostId(aPost.getId());
                posts.setPostContent(aPost.getMessage());
                posts.setLikesCount(post.getLikesCount());
                posts.setShareCount(post.getSharesCount());
                posts.setCommentsCount(post.getCommentsCount());

                System.out.println("id: "+ aPost.getId());
                System.out.println("message : "+aPost.getMessage());
                System.out.println("Likes : "+post.getLikesCount());
                System.out.println("Comments : " + post.getCommentsCount());
                userPosts.add(posts);
            }
        }
        return mapper.readValue(gson.toJson(userPosts), new TypeReference <List<Document>>() {});
    }
}
