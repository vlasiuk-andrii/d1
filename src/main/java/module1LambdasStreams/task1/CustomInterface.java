package module1LambdasStreams.task1;

import java.util.Arrays;

@FunctionalInterface
public interface CustomInterface<T> {

    T perform(double i1, double i2);

    default String standartisizeString(String word){
        char[] firstLetter = new char[1];
        word.getChars(0,1, firstLetter, 0);
        return String.valueOf(firstLetter[0]).toUpperCase()
                + word.replaceFirst(String.valueOf(firstLetter[0]), "").toLowerCase();
    }

    default String cutLastLetter(String word){
        return (String) word.subSequence(0, word.length()-1);
    }

    static String returnHardcodedString(){
        return "Some hardcoded String";
    }

    static String concatenateStrings(String s1, String s2){
        return s1 + s2;
    }
}
