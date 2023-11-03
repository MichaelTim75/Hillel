package edu.hillel.lesson13;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add("path1",new FileData("name1",123,"path1"));
        fileNavigator.add("path1",new FileData("name2",256,"path1"));
        fileNavigator.add("path1",new FileData("name3",345,"path1"));
        fileNavigator.add("path1",new FileData("name4",12,"path1"));

        //getting count added for path1
        System.out.println("path1 count files="+fileNavigator.find("path1").size());

        //add file with the same name and check count
        fileNavigator.add("path1",new FileData("name4",12,"path1"));
        System.out.println("path1 count files="+fileNavigator.find("path1").size());

        //we don't need to save same filename under the same path  - that's why I made path+name - key
        //try to add file with incorrect path
        fileNavigator.add("path1",new FileData("name4",12,"path2"));

        //show method find - print all files under the specified path
        System.out.println("Show method find - print all files under the specified path");
        for (FileData f: fileNavigator.find("path1")) {
            System.out.println(f);
        }

        //adding for other paths
        fileNavigator.add("path2",new FileData("name21",1234,"path2"));
        fileNavigator.add("path2",new FileData("name22",1,"path2"));
        fileNavigator.add("path3",new FileData("name31",5678,"path3"));
        fileNavigator.add("path3",new FileData("name32",589,"path3"));

        //show method filterBySize - print all files under the specified size
        System.out.println("Show method filterBySize - print all files under the specified size");
        for (FileData f: fileNavigator.filterBySize(300)) {
            System.out.println(f);
        }

        System.out.println("Show method remove");
        fileNavigator.remove("path3");
        System.out.println("Paths in fileNavigator after remove:");
        for (String s : fileNavigator.getPaths().keySet()) {
            System.out.println(s);
        }

        System.out.println("Show method sortBySize");
        for (FileData fileData : fileNavigator.sortBySize()) {
            System.out.println(fileData);
        }
    }
}
