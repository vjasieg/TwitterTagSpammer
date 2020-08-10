package main;

import main.threads.ThreadStartSpammer;
import main.util.Config;
import main.util.ConfigParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException, ParseException, InterruptedException {
        new Config();
        ConfigParser.loadMessages();
        ThreadStartSpammer thread = new ThreadStartSpammer(Config.username, Config.password);
        thread.start();
    }
}
