package com.moves.movesCelebrity.social.commands.fb;

import com.moves.movesCelebrity.configuration.MovesConfiguration;
import com.moves.movesCelebrity.dao.SocialMediaPostDao;
import com.moves.movesCelebrity.social.types.Command;
import org.bson.Document;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class WriteUserAdminGroups implements Command<Void, ArrayList<Document>> {

    @Override
    public CompletableFuture<Void> execute(ArrayList<Document> docs) {
        insert(docs);
        return null;
    }

    private void insert(ArrayList<Document> documents) {
        if (documents != null && documents.size() != 0) {
            SocialMediaPostDao.insertMany(documents, MovesConfiguration.COLLECTIONS_ACCOUNTS_USER_GROUPS_LIST);
        }
    }
}
