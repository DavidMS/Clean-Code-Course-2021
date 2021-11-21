package org.cleancode.course.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class TheService {

    // This list contains an array of post
    private List<String[]> theList = new ArrayList<>();
    // This list contains an array of rating for posts
    private List<String[]> theList2 = new ArrayList<>();

    public TheService() {

        // The array of String that forms a post:
        // [0] id of the post
        // [1] title of the post
        // [2] contain of the post
        // [3] author of the post
        // [4] status of the post { 1: DRAFT, 2: PUBLISHED, 3: FEATURED}
        this.theList.addAll(Arrays.asList(
                new String[]{"1", "7 estrategias para ganar a las chapas", "Lorem ipsum...", "Arturo González", "3"},
                new String[]{"2", "Descubre con este cuestionario si sufres del síndrome 'me gusta mas la cama que ir a trabajar'", "Lorem ipsum...", "Pedro Ramírez", "2"},
                new String[]{"3", "Cómo me hice rico escribiendo posts sobre cómo me hice rico", "Lorem ipsum...", "Juan", "3"},
                new String[]{"4", "Esto es un borrador", "...", "Juan", "1"}));

        // The array of String that forms a rate:
        // [0] id of the rate
        // [1] id of the post rated
        // [2] rate number
        // [3] comment if any
        this.theList2.addAll(Arrays.asList(
                new String[]{"1", "1", "3", "Lorem ipsum..."},
                new String[]{"2", "1", "3", "Lorem ipsum..."},
                new String[]{"3", "1", "2", "Lorem ipsum..."},
                new String[]{"4", "1", "1", "Lorem ipsum..."},
                new String[]{"5", "2", "0", "Lorem ipsum..."},
                new String[]{"6", "2", "2", "Lorem ipsum..."},
                new String[]{"7", "3", "3", "Lorem ipsum..."},
                new String[]{"8", "4", "1", "Lorem ipsum..."}));
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
        String[] a = new String[theList.get(--i).length];
        copyStrings(theList.get(--i), a);
        theList.add(a);
        return theList;
    }

    public void copyStrings(String a1[], String a2[]) {
        for (int i = 0; i < a1.length; i++) {
            a2[i] = a1[i];
        }
    }

    public List<String[]> getPRA(String i) {
        List<String[]> pR = theList2
                .stream()
                .filter(r -> r[1].equals(i)).collect(Collectors.toList());
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for(int j = 0; j < pR.size(); j++) {
            switch(pR.get(j)[2]) {
                case "0": a++;
                break;
                case "1": b++;
                break;
                case "2": c++;
                break;
                case "3": d++;
                break;
                default: a++;
                break;
            }
        }
        List<String[]> e = new ArrayList<>();
        e.addAll(Arrays.asList(new String[]{"3 stars", "" + d},new String[]{"2 stars", "" + c},new String[]{"1 stars", "" + b},new String[]{"0 stars", "" + a}));
        return e;
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
