@Component
@ServerEndpoint("/websocket")
public class WebSocketServerController {

// method called after receiving the message
    @OnMessage
    public void onMessage(String message) {
        System.out.println("收到的消息为 " + message);
    }

// method to establish a connection
    @OnOpen
    public void onOpen() {
        System.out.println("Client connected");
    }

// method called to close the connection
    @OnClose
    public void onClose() {
        System.out.println("Connection closed");
    }

// method called when transmitting a message error
    @OnError
    public void OnError(Throwable error) {
        System.out.println("Connection error");
    }
}
