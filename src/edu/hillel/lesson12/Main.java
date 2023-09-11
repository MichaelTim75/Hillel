package edu.hillel.lesson12;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        //1
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("apple");
        strings.add("apricot");
        strings.add("lemon");
        strings.add("apple");
        strings.add("melon");
        strings.add("kiwi");
        strings.add("kiwi");
        strings.add("citrus");
        strings.add("avocado");
        strings.add("avocado");
        strings.add("watermelon");

        System.out.println("count of kiwi is: "+countOccurrence(strings,"kiwi"));
        System.out.println("count of apple is: "+countOccurrence(strings,"apple"));

        //2 string
        String[] stringArray = new String[5];
        stringArray[0]="apple";
        stringArray[1]="apricot";
        stringArray[2]="lemon";
        stringArray[3]="melon";
        stringArray[4]="avocado";
        List<String> stringList = new ArrayList<>();
        toList(stringArray,stringList);
        System.out.println("New list is: "+stringList);
        //2 int
        Integer[] intArray = new Integer[3];
        intArray[0]=1;
        intArray[1]=2;
        intArray[2]=3;
        List<Integer> intList = new ArrayList<>();
        toList(intArray,intList);
        System.out.println("New list is: "+intList);

        //3
        List<Integer> intList3 = new ArrayList<>();
        intList3.add(1);
        intList3.add(2);
        intList3.add(3);
        intList3.add(4);
        intList3.add(1);
        intList3.add(1);
        intList3.add(6);
        intList3.add(4);
        intList3.add(3);
        List<Integer> uniqueList = new ArrayList<>();
        findUnique(intList3,uniqueList);
        System.out.println("Unique list is: "+uniqueList);

        //4 - calcOccurrence
        List<String> stringList4 = new ArrayList<>();
        stringList4.add("bmw");
        stringList4.add("volvo");
        stringList4.add("audi");
        stringList4.add("volvo");
        stringList4.add("toyota");
        stringList4.add("bmw");
        stringList4.add("toyota");
        stringList4.add("toyota");
        stringList4.add("zaz");
        stringList4.add("toyota");

        calcOccurrence(stringList4);

        //4 findOccurrence
        List<ItemWithCount> items = findOccurrence(stringList4);
        for (ItemWithCount item : items) {
            System.out.println("Item name="+item.getName()+", count of occurrence="+item.getCount());
        }
    }

    private static int countOccurrence(List<String> strings, String stringToFind){
        int cnt=0;
        for (String string : strings) {
            if (string.compareTo(stringToFind)==0){
                cnt++;
            }
        }
        return cnt;
    }

    private static <T> void toList(T[] inArray,List<T> outList){
        outList.addAll(Arrays.asList(inArray));
    }

    private static void findUnique(List<Integer> inList, List<Integer> uniqueList){
        for (Integer i : inList) {
            if (!uniqueList.contains(i)){
                uniqueList.add(i);
            }
        }
    }

    private static void calcOccurrence(List<String> inList){
        Set<String> uniqueSet = new TreeSet<>(inList); //using TreeSet to get sorted unique elements. Than counts each frequency
        for (String s : uniqueSet) {
            System.out.println("Value "+s+" counts:"+Collections.frequency(inList,s));
        }
    }

    private static List<ItemWithCount> findOccurrence(List<String> inList){
        List<ItemWithCount> items = new ArrayList<>();

        Set<String> uniqueSet = new TreeSet<>(inList); //using TreeSet to get sorted unique elements. Than counts each frequency
        for (String s : uniqueSet) {
            items.add(new ItemWithCount(s,Collections.frequency(inList,s)));
        }
        return items;
    }

    private static class ItemWithCount {
        private final String name;
        private final int count;

        public ItemWithCount(String name, int count) {
            this.name=name;
            this.count=count;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }
    }
}
