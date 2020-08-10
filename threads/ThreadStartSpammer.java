package main.threads;

import static main.tasks.Tasks.startSpammer;

public class ThreadStartSpammer extends Thread {

    String username;
    String password;

    public ThreadStartSpammer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void run(){
        startSpammer(username, password);
    }
}
