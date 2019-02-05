package ru.alazarev.socket.oracle;

import com.google.common.base.Joiner;
import org.junit.Test;

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

    public void serverTest(String input, String extend) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(new ByteArrayInputStream(input.getBytes()));
        when(socket.getOutputStream()).thenReturn(out);
        new Server(socket).start();
        assertThat(out.toString(), is(extend));
    }

    @Test
    public void whenAskExitThen() throws IOException {
        this.serverTest("exit", String.format("Bye, bye my friend =(%s%s", LS, LS));
    }

    @Test
    public void whenAskHelloThenBack() throws IOException {
        this.serverTest(
                Joiner.on(LS).join(
                        "hello",
                        "exit"),
                Joiner.on(LS).join(
                        "Hello, dear friend, I'm a oracle.",
                        "",
                        "Bye, bye my friend =(",
                        LS
                ));
    }

    @Test
    public void whenAskUnsupportedThenBack() throws IOException {
        this.serverTest(Joiner.on(LS).join(
                "ку ку",
                "exit"),
                Joiner.on(LS).join("I don't understand ! =(",
                        "",
                        "Bye, bye my friend =(",
                        LS
                ));
    }

    @Test
    public void whenAskHowThenBack() throws IOException {
        this.serverTest(Joiner.on(LS).join(
                "how are you?",
                "exit"),
                Joiner.on(LS).join("I'm fine! U?",
                        "",
                        "Bye, bye my friend =(",
                        LS
                ));
    }


}