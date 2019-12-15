# Web_Version_Of_Group_Chat

## Disclaimer My GF is chinese so some I know that some of my chinese translations are not "proper" but idc....    

-----

Using WebSocket which is a protocol provided by HTML5 for full-duplex communication over a single TCP connection.   

With that in mind WebSocket makes data exchange between the client and server easier, allowing the server to actively push data to the client. In the WebSocket API, the browser and server only need to complete a handshake, and the two can directly create a persistent connection and perform two-way data transmission. It can be said that the emergence of WebSocket has enabled the browser to have the ability of real-time two-way communication.    

In the WebSocket API, the browser and server only need to perform a handshake action, and then a fast channel is formed between the browser and the server. Data can be transferred directly between the two.    

In order to implement push, many companies use Ajax polling, that is, the browser sends HTTP requests to the server at specific intervals, and then the server returns the latest data to the client's browser. This traditional model brings a very obvious disadvantage, that is, the browser needs to continuously make requests to the server, but the HTTP request may contain a long header, and the truly effective data may only be a small part, which obviously will be wasted. A lot of bandwidth and other resources. Websocket can solve these problems.    

----- 

References / Good atricles:    
1. https://www.jianshu.com/p/d79bf8174196     
2. http://www.cnblogs.com/hz1124/p/6094890.html     
3. http://www.cnblogs.com/xdp-gacl/p/5193279.html?utm_source=tuicool&utm_medium=referral     
4. https://www.ibm.com/developerworks/cn/web/1112_huangxa_websocket/     
5. http://docs.oracle.com/javaee/7/api/javax/websocket/package-summary.html      
6. https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API   

