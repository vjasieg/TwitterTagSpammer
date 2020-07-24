package main.util;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class Config {
    static ConfigParser cp;
    public static String username;
    public static String password;
    public static long interval;
    public static String tags;
    static List<String> messages;

    public Config() throws IOException, ParseException {
        cp = new ConfigParser();
        username = ConfigParser.json.get("username").toString();
        password = ConfigParser.json.get("password").toString();
        interval = Long.parseLong(ConfigParser.json.get("interval").toString());
        tags = ConfigParser.json.get("tags").toString();
        ConfigParser.loadMessages();
    }

    public static List<String> getMessages() {
        return messages;
    }

    public static void setMessages(List<String> list) {
        messages = list;
    }

    public static ConfigParser getCp() {
        return cp;
    }
}
