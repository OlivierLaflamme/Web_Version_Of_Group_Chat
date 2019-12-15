@Slf4j
@Component
@ServerEndpoint("/groupChat/{sid}/{username}")
public class GroupChatController {

// Save the mapping relationship of group id-> group members
    private static ConcurrentHashMap<String, List<Session>> groupMemberInfoMap = new ConcurrentHashMap<>();

// method called when received message, group member sends message
    @OnMessage
    public void onMessage(@PathParam("sid") String sid,
                          @PathParam("username") String username, String message) {
        List<Session> sessionList = groupMemberInfoMap.get(sid);
// First members of a group send a message
        sessionList.forEach(item -> {
            try {
                String text = username + ": " + message;
                item.getBasicRemote().sendText(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

// Method for establishing connection, group members join
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        List<Session> sessionList = groupMemberInfoMap.get(sid);
        if (sessionList == null) {
            sessionList = new ArrayList<>();
            groupMemberInfoMap.put(sid,sessionList);
        }
        sessionList.add(session);
        log.info("Connection connected");
        log.info("sid: {}, sessionList size: {}", sid, sessionList.size());
    }

// Close the connection call method, the group member exits
    @OnClose
    public void onClose(Session session, @PathParam("sid") String sid) {
        List<Session> sessionList = groupMemberInfoMap.get(sid);
        sessionList.remove(session);
        log.info("Connection closed");
        log.info("sid: {}, sessionList size: {}", sid, sessionList.size());
    }

// method called when transmitting a message error
    @OnError
    public void OnError(Throwable error) {
        log.info("Connection error");
    }
}
