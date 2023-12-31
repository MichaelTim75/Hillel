package edu.hillel.lesson23.factory;

public class Main {
    public static void main(String[] args) {

        Factory metalFactory = new MetalFactory();
        Factory woodFactory = new WoodFactory();

        Store store1 = new Store(metalFactory);
        Bed bed1 = store1.getFactory().createBed();
        System.out.println("Bed 1: " + bed1.getMaterial() + ", Am I antic = " + bed1.isAntic());
        Table table1 = store1.getFactory().createTable();
        System.out.println("Table 1: " + table1.getMaterial() + ", count legs = " + table1.getLegsCount());

        Store store2 = new Store(woodFactory);
        Bed bed2 = store2.getFactory().createBed();
        System.out.println("Bed 2: " + bed2.getMaterial() + ", Am I antic = " + bed2.isAntic());
        Table table2 = store2.getFactory().createTable();
        System.out.println("Table 2: " + table2.getMaterial() + ", count legs = " + table2.getLegsCount());
    }
}
