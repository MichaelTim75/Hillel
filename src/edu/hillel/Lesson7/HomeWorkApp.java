package edu.hillel.Lesson7;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {
    public static void main(String[] args) {
        //2
        //first variant
        System.out.println("'a' occurs in 'asasasas' "+findSymbolOccurrence("asasasas",'a')+" times");
        System.out.println("'d' occurs in 'abcdabcd' "+findSymbolOccurrence("abcdabcd",'d')+" times");
        System.out.println("'Y' occurs in 'abcdabcd' "+findSymbolOccurrence("abcdabcd",'Y')+" times");
        //second variant
        System.out.println("'a' occurs in 'asasasas' "+findSymbolOccurrenceContains("asasasas",'a')+" times");
        System.out.println("'d' occurs in 'abcdabcd' "+findSymbolOccurrenceContains("abcdabcd",'d')+" times");
        System.out.println("'Y' occurs in 'abcdabcd' "+findSymbolOccurrenceContains("abcdabcd",'Y')+" times");

        //3
        System.out.println("first index of 'word' int string 'this is word' is "+findWordPosition("this is word","word"));
        System.out.println("first index of 'my' int string 'my new world' is "+findWordPosition("my new world","my"));
        System.out.println("first index of 'my' int string 'this is word' is "+findWordPosition("this is word","my"));

        //4
        System.out.println("reverse 'qwerty' is "+stringReverse("qwerty"));
        //4 version 2
        System.out.println("reverse 'asdfgh' is "+stringReverseV2("asdfgh"));

        //5
        System.out.println("'ERE' is palindrome? "+isPalindrome("ERE"));
        System.out.println("'ERE' is palindrome (v2)? "+isPalindromeV2("ERE"));
        System.out.println("'Allo' is palindrome? "+isPalindrome("Allo"));

        //6
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado" , "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        String myWord = words[(int)Math.round((words.length-1) * random.nextDouble())];

        System.out.println("Try to guess my word!\n");
        int attempt=0;

        Scanner scanner=new Scanner(System.in);
        String playerWord = scanner.nextLine();

        while (!guessWords(myWord,playerWord)){
            attempt++;
            System.out.println("Your attempt - "+attempt);
            playerWord=scanner.nextLine();
        }
        System.out.println("Your guess my word in " + ++attempt + " attempts!!");
    }

    private static int findSymbolOccurrence(String s, char symbol){
        //correct name of function - right is "occurrence"
        //this method doesn't create new Strings in memory
        int counter=0;
        int position=-1;
        while (true) {
            position=s.indexOf(symbol,position+1);
            if (position==-1) break;
            else counter++;
        }
        return counter;
    }

    private static int findSymbolOccurrenceContains(String s, char symbol){
        //correct name of function - right is "occurrence"
        //this method creates new Strings in memory
        int counter=0;
        while (s.contains(Character.toString(symbol))) {
            counter++;
            s=s.substring(s.indexOf(symbol)+1);
        }
        return counter;
    }

    private static int findWordPosition(String source, String target){
        return source.indexOf(target);
    }

    private static String stringReverse(String s){
        //first variant using StringBuilder
        StringBuilder stringBuilder=new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }
    private static String stringReverseV2(String s){
        //using charAt - but creates new strings in memory when concatenates
        String target="";
        int position=s.length()-1;
        while (position>=0){
            target = target+s.charAt(position);
            position--;
        }
        return target;
    }

    private static boolean isPalindrome(String s){
        return (s.equals(stringReverse(s)));
    }
    private static boolean isPalindromeV2(String s){
        //this method using compare after intern
        return (s.intern() == stringReverse(s).intern());
    }

    private static boolean guessWords(String myWord, String playerWord){
        boolean done=myWord.equals(playerWord);
        if (!done){
            int index=0;
            String guessedString="";
            while(index<Math.min(myWord.length(),playerWord.length())){
                if (myWord.charAt(index)==playerWord.charAt(index)){
                    guessedString=guessedString+myWord.charAt(index);
                }
                else
                    break;
                index++;
            }
            if (guessedString.length()<15){
                guessedString=guessedString.concat("#".repeat(15-guessedString.length()));
            }
            System.out.println("Your word is: "+guessedString+". Try again!");
        }
        return done;
    }
}
