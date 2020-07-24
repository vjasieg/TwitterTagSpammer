package main;

import main.tasks.GenerateSentence;
import main.tasks.Tasks;
import main.util.Config;
import main.util.ConfigParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException, ParseException, InterruptedException {
        new Config();
        ConfigParser.loadMessages();
        Tasks.launchAndLogin();
        while(true) {
            GenerateSentence.parseWords();
            Tasks.startTweeting(GenerateSentence.makeSentence(GenerateSentence.list));
        }
    }
}
