//https://stackoverflow.com/questions/2943297/how-send-message-facebook-friend-through-graph-api-using-accessstoken

package com.moves.movesCelebrity.social.commands.fb;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.moves.movesCelebrity.configuration.MovesConfiguration;
import com.moves.movesCelebrity.social.types.Command;
import com.moves.movesCelebrity.utils.Constants;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class FBSendMessage implements Command<Document,String> {

    private static Logger logger = LoggerFactory.getLogger(FBSendMessage.class);

    public FBSendMessage() {
    }

    public CompletableFuture<Document> execute(String message){
        return CompletableFuture.supplyAsync(()->{
            Document doc = null;
            doc = sendMessage(message);
            return doc;
        });
    }
    public Document sendMessage(String message){
        HttpResponse<JsonNode> httpResponse = null;
        Document doc = null;
        String receiverId =null;

        try{
            String url = String.format(Constants.FB_SEND_MESSAGE,receiverId);
            httpResponse = Unirest.post(url).queryString("message",message).asJson();
            doc = Document.parse(httpResponse.getBody().toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        return doc;
    }
}
