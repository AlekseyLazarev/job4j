package ru.alazarev.socket.fileManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileManager {

    /**
     * Method get children in current directory.
     *
     * @return List of children.
     */
    boolean getChildren();

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
    boolean getFile(String fileName) throws IOException;

    /**
     * Method load file.
     *
     * @return Result load.
     */
    boolean loadFile(File file) throws IOException;
}