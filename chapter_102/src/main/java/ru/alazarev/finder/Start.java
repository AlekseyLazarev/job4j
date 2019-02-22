package ru.alazarev.finder;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {
        Args params = new Args(args);
        if (params.empty()) {
            params.printHelp();
        } else {
            Finder finder = new Finder(params.getDirectory(), params.getSearchFile(), params.typeFind(), params.getResult());
            finder.start();
        }
    }
}
