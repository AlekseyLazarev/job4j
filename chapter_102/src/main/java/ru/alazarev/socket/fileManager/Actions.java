package ru.alazarev.socket.filemanager;

import java.io.*;
import java.util.*;
import java.util.function.Function;

/**
 * Class ServerActions решение задачи части 002. 2. Сетевой менеджер файлов. [#863].
 *
 * @author Aleksey Lazarev
 * @since 26.02.2019
 */
public class Actions {
    private final Map<String, Function<String, List<String>>> actions = new HashMap<>();
    private final ArrayList commands = new ArrayList();
    private FileManagerServer server;
    private FileManagerClient client;

    /**
     * Constructor with server param.
     *
     * @param server File manager server.
     */
    public Actions(FileManagerServer server) {
        this.server = server;
    }

    /**
     * Constructor with client param.
     * @param client File manager client.
     */
    public Actions(FileManagerClient client) {
        this.client = client;
    }

    /**
     * Initiate method.
     *
     * @return this Actions.
     */
    Actions init() {
        if (this.server != null) {
            this.load("help", "help - View help.", this.help());
            this.load("div", "div - View all files and catalogs in current folder.", this.div());
            this.load("cd", "cd \"catalog\" - Go to the subdirectory.", this.cd());
            this.load("root", "root - Go to root directory.", this.root());
            this.load("get", "get \"filename\" \"path\"- Get file by name.", this.getServer());
            this.load("upload", "upload \"filename\" - Upload file by name.", this.uploadServer());
        } else if (this.client != null) {
            this.load("get", "get \"filename\" \"path\"- Get file by name.", this.getClient());
            this.load("upload", "upload \"filepath\" - Upload file by name.", this.uploadClient());
            this.load("exit", "exit - Exit.", this.exitClient());
        }
        return this;
    }

    /**
     * Method load command into map.
     *
     * @param command Trigger command.
     * @param handle  Function.
     */
    private void load(String command, String description, Function<String, List<String>> handle) {
        this.actions.put(command, handle);
        this.commands.add(description);
    }

    /**
     * Method view help.
     *
     * @return Commands description.
     */
    private Function<String, List<String>> help() {
        return param -> {
            return this.commands;
        };
    }

    /**
     * Method view catalogs and files in current folder.
     *
     * @return List of catalogs and files.
     */
    private Function<String, List<String>> div() {
        return param -> {
            List<String> result = new ArrayList<>();
            Arrays.asList(new File(this.server.getCurrentCatalog()).listFiles())
                    .stream().forEach(f -> result.add(f.getPath()));
            return result;
        };
    }

    /**
     * Method go to subdirectory.
     *
     * @return Current directory path.
     */
    private Function<String, List<String>> cd() {
        return param -> {
            List<String> result = new ArrayList<>();
            String path = this.server.getCurrentCatalog() + "\\" + param.split(" ")[1];
            if (new File(path).exists()) {
                this.server.setCurrentCatalog(new File(path).getPath());
                result.add(this.server.getCurrentCatalog());
            }
            return result;
        };
    }

    /**
     * Method return to root folder.
     *
     * @return Root path.
     */
    private Function<String, List<String>> root() {
        return param -> {
            List<String> result = new ArrayList<>();
            if (new File(this.server.getRoot()).exists()) {
                this.server.setCurrentCatalog(this.server.getRoot());
                result.add(this.server.getCurrentCatalog());
            }
            return result;
        };
    }

    /**
     * Method get file by name.
     *
     * @return Get result.
     */
    private Function<String, List<String>> getServer() {
        return param -> {
            List<String> result = new ArrayList<>();
            File currentFile = new File(this.server.getCurrentCatalog() + "\\" + param.split(" ")[1]);
            byte[] file = new byte[(int) currentFile.length()];
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(this.server.getSocket().getOutputStream());
                dataOutputStream.writeUTF(String.valueOf(currentFile.length()));
                FileInputStream fis = new FileInputStream(currentFile);
                int count;
                while ((count = fis.read(file)) != -1) {
                    dataOutputStream.write(file, 0, count);
                }
                result.add("Download file " + param.split(" ")[1] + " complete.");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            return result;
        };
    }

    /**
     * Method upload file.
     *
     * @return Result upload.
     */
    private Function<String, List<String>> uploadServer() {
        return param -> {
            List<String> result = new ArrayList<>();
            String[] split = param.split(" ")[1].split("\\\\");
            String currentPath = this.server.getCurrentCatalog() + "\\" + split[split.length - 1];
            if (!new File(currentPath).exists()) {
                try {
                    DataInputStream dataInputStream = new DataInputStream(this.server.getSocket().getInputStream());
                    byte[] upload = new byte[Integer.valueOf(dataInputStream.readUTF())];
                    FileOutputStream fos = new FileOutputStream(new File(currentPath));
                    dataInputStream.read(upload);
                    fos.write(upload);
                    fos.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            result.add("Upload file " + param.split(" ")[1] + " complete.");
            return result;
        };
    }

    /**
     * Method view help.
     *
     * @return Commands description.
     */
    private Function<String, List<String>> getClient() {
        return param -> {
            String[] split = param.split(" ");
            File file = new File(split[2] + "\\" + split[1]);
            try {
                this.client.setDataInputStream(new DataInputStream(this.client.getSocket().getInputStream()));
                byte[] download = new byte[Integer.valueOf(this.client.getDataInputStream().readUTF())];
                FileOutputStream fos = new FileOutputStream(file);
                this.client.getDataInputStream().read(download);
                fos.write(download);
                fos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return new ArrayList<>();
        };
    }

    /**
     * Method view help.
     *
     * @return Commands description.
     */
    private Function<String, List<String>> uploadClient() {
        return param -> {
            String[] split = param.split(" ");
            File uploadFile = new File(split[1]);
            byte[] upload = new byte[(int) uploadFile.length()];
            try {
                this.client.setDataOutputStream(new DataOutputStream(this.client.getSocket().getOutputStream()));
                this.client.getDataOutputStream().writeUTF(String.valueOf(uploadFile.length()));
                FileInputStream fis = new FileInputStream(uploadFile);
                int count;
                while ((count = fis.read(upload)) != -1) {
                    this.client.getDataOutputStream().write(upload, 0, count);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return new ArrayList<>();
        };
    }

    /**
     * Method view help.
     *
     * @return Commands description.
     */
    private Function<String, List<String>> exitClient() {
        return param -> {
            System.out.println("Bye bye.");
            return this.commands;
        };
    }

    /**
     * Method execute command.
     *
     * @param command for execute.
     * @return
     */
    List<String> sent(final String command) {
        List<String> result = new ArrayList<>();
        String currentCommand = command.split(" ")[0];
        if (this.actions.get(currentCommand) != null) {
            result = this.actions.get(currentCommand).apply(command);
        } else {
            result.add("I don't understand ! =(");
        }
        return result;
    }
}
