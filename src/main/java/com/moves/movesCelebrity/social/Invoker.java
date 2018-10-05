package com.moves.movesCelebrity.social;

import com.moves.movesCelebrity.social.commands.fb.*;
import com.moves.movesCelebrity.social.restFB.FBGetUserDetailsByRestFB;
import com.moves.movesCelebrity.social.restFB.FBGetUserPostsByRestFB;
import com.moves.movesCelebrity.social.restFB.FBWriteUserDetailsByRestFB;
import com.moves.movesCelebrity.social.restFB.FBWriteUserPostsByRestFB;
import com.moves.movesCelebrity.social.types.Command;
import com.moves.movesCelebrity.utils.FBUtilsPageAccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Singleton
public class Invoker {
    private static Logger logger = LoggerFactory.getLogger(Invoker.class);
    private Map<String, Command> commands = new HashMap<>();
    private static Invoker instance;
    private ExecutorService invokerExecPool = Executors.newFixedThreadPool(10);


    public static Invoker getInstance() {
        if (instance == null) {
            instance = new Invoker();
        }
        return instance;
    }

    @Inject
    public Invoker() {
    }

    public CompletableFuture<Void> init() {
        return CompletableFuture.supplyAsync(() -> {

            commands.put("fb.userDetails.posts.fetch" , new FetchAccountsCommand());
            commands.put("fb.userDetails.posts.write" , new WriteAccountsCommand());
            commands.put("fb.accountsPages.posts.fetch" , new FetchAccountsPagesCommand());
            commands.put("fb.accountsPages.posts.write" , new WriteAccountsPagesCommand());
            commands.put("fb.likedPages.posts.fetch" , new FetchUserLikedPages());
            commands.put("fb.likedPages.posts.write" , new WriteUserLikedPages());
            commands.put("fb.userGroups.posts.fetch" , new FetchUserAdminGroups());
            commands.put("fb.userGroups.posts.write" , new WriteUserAdminGroups());
            commands.put("fb.likedGroups.posts.fetch" , new FetchUserLikedGroups());
            commands.put("fb.likedGroups.posts.write" , new WriteUserLikedGroups());
            commands.put("fb.userPosts.posts.fetch" , new FetchUserPosts());
            commands.put("fb.userPosts.posts.write" , new WriteUserPosts());
            commands.put("fb.timelinePosts.posts.fetch" , new FetchUserTimelinePosts());
            commands.put("fb.timelinePosts.posts.write" , new WriteUserTimelinePosts());

            commands.put("fb.insights.posts.fetch" , new FBAccountInsightsFetchCommand());
            commands.put("fb.pagePosts.posts.fetch" , new FBPostFetchCommand());
            commands.put("fb.accounts.posts.insights.fetch" , new FBAccountInsightsFetchCommand());
            commands.put("fb.accounts.posts.publish.fetch" , new FBPostPublishCommand());
            commands.put("fb.accounts.posts.publish.write" , new FBPostPublishWriteCommand());
            commands.put("fb.accounts.posts.publish.media.fetch" , new FBPostPublishMediaCommand());
            commands.put("fb.accounts.posts.publish.video.fetch" , new FBPostPublishVideoCommand());
            commands.put("fb.accounts.posts.fetch.pageAccessToken" , new FBUtilsPageAccessToken());

            //Commands for RestFB testing
            commands.put("fb.posts.fetch.userDetails" , new FBGetUserDetailsByRestFB());
            commands.put("fb.posts.write.userDetails" , new FBWriteUserDetailsByRestFB());
            commands.put("fb.posts.fetch.userPosts" , new FBGetUserPostsByRestFB());
            commands.put("fb.posts.write.userPosts" , new FBWriteUserPostsByRestFB());

            return commands;
        }).thenAccept(stringCommandMap -> logger.info("Commands registered " + commands.toString()));
    }

    public CompletableFuture execute(String messageHandle, Object value) {
        logger.info("executing ------>  " + messageHandle);
        return commands.get(messageHandle).execute(value);
    }
}

