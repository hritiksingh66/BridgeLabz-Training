package reviews.reviews1;

class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}


class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}


class Calculator {
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        
        System.out.println("Overriding");
        Animal animal = new Animal();
        Animal dog = new Dog();  
        
        animal.sound();  
        dog.sound();  
        
        System.out.println("Overloading ");
        Calculator calc = new Calculator();
        
        System.out.println(calc.add(5, 3));   
        System.out.println(calc.add(5.5, 3.2));    
        System.out.println(calc.add(1, 2, 3));   
    }
}
