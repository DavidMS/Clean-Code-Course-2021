package org.cleancode.course.io;

import java.io.PrintWriter;

public class Screen {

    private PrintWriter printWriter;

    public Screen() {
        printWriter = new PrintWriter(System.out);
    }

    public Screen(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public void print(String value) {
        printWriter.print(value);
        printWriter.flush();
    }

    public void printLine() {
        printWriter.println();
    }

    public void printLine(String value) {
        printWriter.println(value);
    }

    public void printFormat(String value, Object ...values) {
        printWriter.printf(value, values);
    }
}
