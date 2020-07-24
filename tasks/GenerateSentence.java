package main.tasks;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateSentence {
    static String API = "https://random-word-api.herokuapp.com/word?number=15";
    public static ArrayList<String> list = new ArrayList<String>();
    static String sentence;

    public static void parseWords() throws IOException, ParseException {
        list.clear();
        Scanner scan = new Scanner(new URL(API).openStream());
        if(scan.hasNextLine()) {
            String json = scan.nextLine();
            scan.close();
            JSONParser parser = new JSONParser();
            JSONArray obj = (JSONArray) parser.parse(json);
            for(String s : (Iterable<String>) obj) {
                list.add(s);
            }
        }
    }

    public static String makeSentence(List<String> list) {
        sentence = "";
        while((sentence.length() == 0) || (sentence.length() > 200)) {
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    String word = list.get(0);
                    sentence += word.substring(0, 1).toUpperCase() + word.substring(1) + " ";
                    continue;
                }
                sentence += list.get(i) + " ";
            }
        }
        return sentence;
    }
}
