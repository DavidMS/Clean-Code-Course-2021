package org.cleancode.course.service;

import org.springframework.stereotype.Component;

@Component
public class GenerateCountMessage {

    private String number;
    private String verb;
    private String pluralModifier;

    public String makeMessage(int numberOfOccurrences, char candidate) {
        createPluralMessageParts(numberOfOccurrences);
        return String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
    }

    private void createPluralMessageParts(int numberOfOccurrences) {
        if(numberOfOccurrences == 0) {
            thereAreNoLetters();
        } else if(numberOfOccurrences == 1) {
            thereIsOneLetter();
        } else {
            thereAreManyLetters(numberOfOccurrences);
        }
    }

    private void thereAreNoLetters() {
        number = "no";
        verb = "are";
        pluralModifier = "s";
    }

    private void thereIsOneLetter() {
        number = "1";
        verb = "is";
        pluralModifier = "";
    }

    private void thereAreManyLetters(int numberOfOccurrences) {
        number = Integer.toString(numberOfOccurrences);
        verb = "are";
        pluralModifier = "s";
    }
}
