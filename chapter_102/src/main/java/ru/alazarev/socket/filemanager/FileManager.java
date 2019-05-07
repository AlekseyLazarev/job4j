package ru.alazarev.socket.filemanager;

import java.io.IOException;
import java.util.List;

public interface FileManager {

    /**
     * Method get children in current directory.
     *
     * @return List of children.
     */
    List<String> getChildren();

    /**
     * Method go into child folder.
     *
     * @return Result follow.
     */
    List<String> followChild(String path);

    /**
     * Method get root folder.
     *
     * @return Result jump.
     */
    List<String> getRoot();

    /**
     * Method get file.
     *
     * @return File.
     */
    List<String> getFile(String fileName) throws IOException;

    /**
     * Method load file.
     *
     * @return Result load.
     */
    List<String> loadFile(String fileName) throws IOException;
}