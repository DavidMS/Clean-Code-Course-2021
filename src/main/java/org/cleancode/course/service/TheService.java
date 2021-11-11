package org.cleancode.course.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class TheService {

    private int d; // Elapsed time in days

    private List<String[]> theList = new ArrayList<>();

    public TheService() {
        this.theList.addAll(Arrays.asList(
                new String[]{"1", "7 estrategias para ganar a las chapas", "Lorem ipsum...", "Arturo González", "3"},
                new String[]{"2", "Descubre con este cuestionario si sufres del síndrome 'me gusta mas la cama que ir a trabajar'", "Lorem ipsum...", "Pedro Ramírez", "2"},
                new String[]{"3", "Cómo me hice rico escribiendo posts sobre cómo me hice rico", "Lorem ipsum...", "Juan", "3"},
                new String[]{"4", "Esto es un borrador", "...", "Juan", "1"}));
    }

    public List<String[]> getThemAll() {
        return theList;
    }

    //
    public List<String[]> getThem() {
        List<String[]> list1 = new ArrayList<String[]>();
        for(String[] x: theList) // ¿Qué contiene theList?
            if(x[4] == "3") // ¿Qué significado tiene el subindice 4 en un elemento de theList?
                list1.add(x); // ¿Qué importancia tiene el valor 3?

            return list1; // ¿Cómo se usa la lista devuelta?
    }

    public List<String[]> duplicateOneAndReturnThemAll(int i) {
        String[] copy = new String[theList.get(i).length];
        copyStrings(theList.get(--i), copy);
        theList.add(copy);
        return theList;
    }

    public void copyStrings(String a1[], String a2[]) {
        for (int i = 0; i < a1.length; i++) {
            a2[i] = a1[i];
        }
    }

    public String countPostLetters(char a, int i) {
        String[] post = theList.get(i);
        int n = 0;
        for(int j = 0; j < post[2].toCharArray().length; j++) {
            if(post[2].toLowerCase(Locale.ROOT).toCharArray()[j] == a) {
                n++;
            }
        }
        String number;
        String verb;
        String pluralModifier;
        if (n == 0) {
            number = "no";
            verb = "are";
            pluralModifier = "s";
        } else if (n == 1) {
            number = "1";
            verb = "is";
            pluralModifier = "";
        } else {
            number = Integer.toString(n);
            verb = "are";
            pluralModifier = "s";
        }
        String message = String.format("There %s %s %s%s", verb, number, a, pluralModifier);
        return message;
    }
}
