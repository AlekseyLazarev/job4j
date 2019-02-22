package ru.alazarev.finder;

import org.apache.commons.cli.*;

public class Args {
    private Options options = new Options();
    private CommandLineParser parser = new BasicParser();
    private CommandLine cmd = null;
    HelpFormatter help = new HelpFormatter();

    public Args(String[] args) {
        options.addOption("d", "directory", true, "Directory for find.");
        options.addOption("n", "file", true, "File name, or regular for find.");
        options.addOption("m", "mask", false, "Search by mask.");
        options.addOption("f", "full", false, "Search by name.");
        options.addOption("r", "regex", false, "Search by regex.");
        options.addOption("o", "result", true, "Result file.");

        try {
            this.cmd = parser.parse(this.options, args);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    public String getDirectory() {
        return this.cmd.getOptionValue("d");
    }

    public String getSearchFile() {
        return this.cmd.getOptionValue("n");
    }

    public boolean getMask() {

        return this.cmd.hasOption("m");
    }

    public boolean getFull() {
        return this.cmd.hasOption("f");
    }

    public boolean getRegex() {
        return this.cmd.hasOption("r");
    }

    public String getResult() {
        return this.cmd.getOptionValue("o");
    }

    public String typeFind() {
        String result = null;
        if (getMask()) {
            result = "m";
        } else if (getFull()) {
            result = "f";
        } else if (getRegex()) {
            result = "r";
        }
        return result;
    }

    public boolean empty() {
        return getDirectory().isEmpty() && getSearchFile().isEmpty()
                && typeFind().isEmpty() && getResult().isEmpty();
    }

    public void printHelp() {
        this.help.printHelp("java -jar find.jar [-d] [-n] [-m, -f, -r] [-o]", this.options);
    }
}
