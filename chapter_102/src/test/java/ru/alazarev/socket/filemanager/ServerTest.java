package ru.alazarev.socket.filemanager;

import org.junit.Test;
import ru.alazarev.socket.oracle.Server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {

    private static final String LS = System.getProperty("line.separator");

    @Test
    public void serverTest() throws IOException {
        String input = "child";
        String extend = "I don't understand ! =(\r\n\r\n";
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(new ByteArrayInputStream(input.getBytes()));
        when(socket.getOutputStream()).thenReturn(out);
        new Server(socket).start();
        assertThat(out.toString(), is(extend));
    }
}