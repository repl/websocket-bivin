import com.google.gson.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;
import netscape.javascript.JSObject;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String s[]) throws IOException, WebSocketException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("op", "unconfirmed_sub");
        System.out.println("Sending message " + jsonObject.toString());
        new WebSocketFactory()
                .createSocket("wss://ws.blockchain.info/inv")
                .addListener(new WebSocketAdapter() {
                    @Override
                    public void onTextMessage(WebSocket ws, String message) {
                        // Received a response. Print the received message.
                        System.out.println("Received message: " + message);

                        // Close the WebSocket connection.
                        //ws.disconnect();
                    }
                })
                .connect()
                .sendText(jsonObject.toString());
    }
}
