package examples;

//import java.util.Arrays;
import java.util.*;


public class Examples {
    public static void main(String[] args) {
        //StingBuffer and swap
        int x = 0x123F;
        int y = 'r';
        print(x);
        int[] arr = new int[10];
        System.out.println(Arrays.toString(arr));
        StringBuffer a = new StringBuffer("one");
        StringBuffer b = new StringBuffer("two");
        
        swap(a, b);
        System.out.println(a+ " " + b);
        
        
        B bb = new B();
        bb.printX();
        
        int[] A1 = {1, 2, 3};
        for (int i = 0; i < 2; i++) 
        A1[i] = 0;
        print(A1);
        char s = ';';
        
        result(3);
       
        
    }
    static void swap(StringBuffer a, StringBuffer b) {
        a.append(" more ");
        b = a;
    } 
    
    public static void print(String x) {
        System.out.println(x);
    }
    public static void print(int x) {
        System.out.println(x);
    }
    public static void print(int[] x) {
        System.out.println(Arrays.toString(x));
    }
    public static void print(String[] x) {
        System.out.println(Arrays.toString(x));
    
    }
    public static void inc(Integer x) {
        x =  x+1;
    }
    static void result(int a) {
        Integer x = a;
        inc(x);
        System.out.println(x);
        
    }
    
}

class A {
    String x = "a";
    void printX() {
        System.out.println(x);
    }
}

class B extends A {
    String x = "b";
    B() {
        x = null;
    }
}

class C {
    String a;
    int b;
    
    
}


interface Base {
    boolean m1();
    byte m2(short s);

}

interface Class2 implements Base {}



/*
class Person {
    protected String name, surname;
    
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    
    
    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", surname=" + surname + '}';
    }
}

class Student extends Person {
    protected int mark;
    public Student(String name, String surname) {
        super(name, surname);
    }
    public Student(String name, String surname, int mark) {
        super(name, surname);
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", surname=" + surname + ", mark=" + mark + '}';
    }
    
}
*/