package com.moves.movesCelebrity.social.commands.fb;

import com.moves.movesCelebrity.configuration.MovesConfiguration;
import com.moves.movesCelebrity.dao.SocialMediaPostDao;
import com.moves.movesCelebrity.social.types.Command;
import org.bson.Document;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class FBPostPublishWriteCommand implements Command<Void, Document> {

    @Override
    public CompletableFuture<Void> execute(Document docs) {
        insert(docs);
        return null;
    }

    private void insert(Document documents) {
        if (documents != null && documents.size() != 0) {
            SocialMediaPostDao.insert(documents, MovesConfiguration.COLLECTIONS_ACCOUNTS_USER_POSTED_PAGE_POSTS);
        }
    }
}
