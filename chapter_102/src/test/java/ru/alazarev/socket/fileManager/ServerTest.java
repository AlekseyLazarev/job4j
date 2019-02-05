package ru.alazarev.socket.fileManager;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class ServerTest {
    @Test
    public void name() throws IOException {
        Server server = new Server("C:\\Chat");
        server.start();
        List<File> fileList = server.getChildren();
        boolean followChild = server.followChild(fileList.get(fileList.size() - 1).getPath());
        boolean getRoot = server.getRoot();
        File getFile = server.getFile(fileList.get(fileList.size() / 2).getName());
        boolean loadFile = server.loadFile(new File("C:\\clean\\cls.bat"));
    }
}