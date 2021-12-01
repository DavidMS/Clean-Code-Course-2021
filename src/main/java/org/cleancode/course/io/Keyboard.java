package org.cleancode.course.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keyboard {

    private BufferedReader input;

    public Keyboard() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public Keyboard(InputStreamReader in) {
        input = new BufferedReader(in);
    }

    public String readLine() throws IOException {
        return input.readLine();
    }
}
