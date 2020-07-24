package main.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.ArrayList;

public class ConfigParser {
    static JSONObject json;
    public ConfigParser() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\jasie\\Desktop\\config.json")));
        StringBuffer sr = new StringBuffer();
        String line;
        while((line = br.readLine()) != null){
            sr.append(line);
        }
        json = (JSONObject) parser.parse(sr.toString());
    }

    public static void loadMessages() {
        ArrayList<String> list = new ArrayList<String>();
        JSONArray msg = (JSONArray) json.get("messages");
        for (String s : (Iterable<String>) msg) {
            list.add(s);
        }
        Config.setMessages(list);
    }

}
