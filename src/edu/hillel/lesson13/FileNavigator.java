package edu.hillel.lesson13;

import java.util.*;

public class FileNavigator {
    private final Map<String, Set<FileData>> paths;

    public FileNavigator() {
        paths = new HashMap<>();
    }

    public void add(String path, FileData fileData){
        if(!path.equals(fileData.getPath())){
            System.out.println("Error adding file - key path "+path+" don't equal to path in file properties "+fileData.getPath());
            return;
        }
        if(paths.containsKey(path)){
            //if we have already such path - add file
            paths.get(path).add(fileData);
        }
        else {
            Comparator<FileData> comparator = new Comparator<FileData>() {
                @Override
                public int compare(FileData o1, FileData o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            };
            //I want to save files in alphabetical order - so I decided to use TreeSet
            Set<FileData> files = new TreeSet<>(comparator);
            files.add(fileData);
            paths.put(path,files);
        }
    }

    public Set<FileData> find (String path){
        return paths.get(path);
    }

    public Set<FileData> filterBySize(int maxSize){
        Set<FileData> fileDataSet = new HashSet<>();
        for (Set<FileData> files : paths.values()) {
            for (FileData file : files) {
                if(file.getSize()<=maxSize){
                    fileDataSet.add(file);
                }
            }
        }
        return fileDataSet;
    }

    public void remove (String path){
        paths.remove(path);
    }

    public List<FileData> sortBySize (){
        List<FileData> fileDataList = new ArrayList<>();
        for (Set<FileData> fileDataSet : paths.values()) {
            fileDataList.addAll(fileDataSet);
        }
        Comparator<FileData> comparator = new Comparator<FileData>() {
            @Override
            public int compare(FileData o1, FileData o2) {
                return Integer.compare(o1.getSize(),o2.getSize());
            }
        };
        fileDataList.sort(comparator);
        return fileDataList;
    }
    public Map<String, Set<FileData>> getPaths() {
        return paths;
    }

}
