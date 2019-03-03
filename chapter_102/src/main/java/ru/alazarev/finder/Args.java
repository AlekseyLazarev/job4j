package ru.alazarev.finder;

import org.apache.commons.cli.*;

/**
 * Class Args решение задачи части 002. Тестовое задание. [#783].
 *
 * @author Aleksey Lazarev
 * @since 22.02.2019
 */
public class Args {
    private Options options = new Options();
    private CommandLineParser parser = new BasicParser();
    private CommandLine cmd = null;
    HelpFormatter help = new HelpFormatter();

    /**
     * Constructor.
     *
     * @param args Arguments.
     */
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

    /**
     * Method return value of directory option.
     *
     * @return Directory.
     */
    public String getDirectory() {
        return this.cmd.getOptionValue("d");
    }

    /**
     * Method return search file, mask or regex.
     *
     * @return Search expression.
     */
    public String getSearchFile() {
        return this.cmd.getOptionValue("n");
    }

    /**
     * Method сhecks if there is an option mask.
     *
     * @return Check result.
     */
    public boolean getMask() {
        return this.cmd.hasOption("m");
    }

    /**
     * Method checks if there is an option full.
     *
     * @return Check result.
     */
    public boolean getFull() {
        return this.cmd.hasOption("f");
    }

    /**
     * Method checks if there is an option regex.
     *
     * @return Check result.
     */
    public boolean getRegex() {
        return this.cmd.hasOption("r");
    }

    /**
     * Method return result file path.
     *
     * @return Result file path.
     */
    public String getResult() {
        return this.cmd.getOptionValue("o");
    }

    /**
     * Method select one of the three options.
     *
     * @return Result select.
     */
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

    /**
     * Method checks the presence of all necessary parameters.
     *
     * @return Result check.
     */
    public boolean empty() {
        return getDirectory().isEmpty() && getSearchFile().isEmpty()
                && typeFind().isEmpty() && getResult().isEmpty();
    }

    /**
     * Method print help.
     */
    public void printHelp() {
        this.help.printHelp("java -jar find.jar [-d] [-n] [-m, -f, -r] [-o]", this.options);
    }
}
