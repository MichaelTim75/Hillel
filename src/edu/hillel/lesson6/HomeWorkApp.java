package edu.hillel.lesson6;

public class HomeWorkApp {
    public static void main(String[] args) {
        //2
        printThreeWords();

        //3
        //checkSumSign with params
        checkSumSign(1,5);
        checkSumSign(-6,2);
        //checkSumSign without params as in conditions
        checkSumSign();

        //4
        //printColor with params
        printColor(-15);
        printColor(15);
        printColor(150);
        //printColor without params as in conditions
        printColor();

        //5
        //compareNumbers with params
        compareNumbers(15,5);
        compareNumbers(1,15);
        //compareNumbers with inside initialization of params
        compareNumbers();

        //6
        System.out.println(checkSum(7,8));
        System.out.println(checkSum(2,3));

        //7
        getNumberSign(15);
        getNumberSign(-8);

        //8
        System.out.println("8 is not negative - returned value="+getNumberNegative(8));
        System.out.println("-15 is negative - returned value="+getNumberNegative(-15));

        //9
        printStringNTimes("Some interesting string",7);

        //10
        System.out.println("2022 is a leap year - "+isLeapYear(2022));
        System.out.println("100 is a leap year - "+isLeapYear(100));
        System.out.println("400 is a leap year - "+isLeapYear(400));
        System.out.println("2020 is a leap year - "+isLeapYear(2020));
    }

    private static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    private static void checkSumSign(int a, int b){
//        I decide to initialize a and b out of this method - in this case I can show both type of behavior of this method
        if ((a+b)>=0){
            System.out.println("Sum positive");
        }
        else{
            System.out.println("Sum negative");
        }
    }

    private static void checkSumSign(){
//this realization is as in conditions - but in this case Idea type that condition in if is always true
        int a=5;
        int b=6;
        if ((a+b)>=0){
            System.out.println("Sum positive");
        }
        else{
            System.out.println("Sum negative");
        }
    }

    private static void printColor (int color){
//I decide to do two realization of this method - overloaded - wit input params and without
        if (color<=0){
            System.out.println("Red color");
        }
        else if (color >0 && color<=100) {
            System.out.println("Yellow color");
        }
        else{
            System.out.println("Green color");
        }
    }

    private static void printColor(){
        int color=15;
        if (color<=0){
            System.out.println("Red color");
        }
        else if (color >0 && color<=100) {
            System.out.println("Yellow color");
        }
        else{
            System.out.println("Green color");
        }
    }

    private static void compareNumbers(int a, int b){
//        I decide to initialize a and b out of this method
        if (a>=b){
            System.out.println("a>=b");
        }
        else{
            System.out.println("a<b");
        }
    }

    private static void compareNumbers(){
//        With inside initialization
        int a=15;
        int b=0;
        if (a>=b){
            System.out.println("a>=b");
        }
        else{
            System.out.println("a<b");
        }
    }

    private static boolean checkSum(int a,int b){
        int sum=a+b;
        return (sum>=10 && sum<=20);
    }

    private static void getNumberSign(int a){
        if(a>=0){
            System.out.println("a="+a+" - this is positive");
        }
        else{
            System.out.println("a="+a+" - this is negative");
        }
    }

    private static boolean getNumberNegative(int a){
        return (a<0);
    }

    private static void printStringNTimes(String str,int n){
        if (n<=0){
            //I think that is better to throw an exception here, but we haven't learned exceptions yet
            System.out.println("n="+n+" - this is incorrect for number of lines!");
        }
        else{
            for (int i=1;i<=n;i++)
                System.out.println(str);
        }
    }

    private static boolean isLeapYear(int year){
        return(year%4==0 && (year%100!=0 || year%400==0));
    }
}
