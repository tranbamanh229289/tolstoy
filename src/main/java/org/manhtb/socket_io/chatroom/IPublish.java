package org.manhtb.socket_io.chatroom;

import java.net.Socket;

@FunctionalInterface
public interface IPublish {
    public void publishMessage(String message, Socket currentSocket);
}
