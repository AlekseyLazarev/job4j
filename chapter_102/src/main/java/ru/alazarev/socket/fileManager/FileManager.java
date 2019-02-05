package ru.alazarev.socket.fileManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileManager {
    /**
     * Method start api.
     *
     * @return Result start.
     */
    boolean start();

    /**
     * Method get children in current directory.
     *
     * @return List of children.
     */
    List<File> getChildren();

    /**
     * Method go into child folder.
     *
     * @return Result follow.
     */
    boolean followChild(String path);

    /**
     * Method get root folder.
     *
     * @return Result jump.
     */
    boolean getRoot();

    /**
     * Method get file.
     *
     * @return File.
     */
    File getFile(String fileName);

    /**
     * Method load file.
     *
     * @return Result load.
     */
    boolean loadFile(File file) throws IOException;
}
