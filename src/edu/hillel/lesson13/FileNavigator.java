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

        Comparator<FileData> comparator = new Comparator<FileData>() {
            @Override
            public int compare(FileData o1, FileData o2) {
                return Integer.compare(o1.getSize(),o2.getSize());
            }
        };
        Set<FileData> fileDataTreeset = new TreeSet<>(comparator);
        Set<FileData> fileDataOutSet = new TreeSet<>(comparator);
        for (Set<FileData> files : paths.values()) {
            fileDataTreeset.addAll(files);
        }

        FileData[] fileDataArr = fileDataTreeset.toArray(new FileData[0]);
        int index = binarySearchIndexMaxNotGreater(fileDataArr,maxSize);
        if (index>=0){
            fileDataOutSet.addAll(Arrays.asList(Arrays.copyOfRange(fileDataArr,0,index)));
        }

        return fileDataOutSet;
    }
    private int binarySearchIndexMaxNotGreater(FileData[] fileDataArr, int maxSize)
    {
        int low = 0;
        int high = fileDataArr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (fileDataArr[mid].getSize() <= maxSize){
                if ((mid+1)==fileDataArr.length || fileDataArr[mid+1].getSize()>maxSize){
                    return mid;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                high = mid - 1;
            }
        }

        return -1;
    }
/*
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
*/

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
