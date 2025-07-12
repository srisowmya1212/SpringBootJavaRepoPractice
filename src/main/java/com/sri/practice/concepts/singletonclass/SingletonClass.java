package com.sri.practice.concepts.singletonclass;

/**
 * A Singleton class in Java is a design pattern that ensures only one instance of the class is
 * created throughout the application's lifecycle and provides a global access point to that
 * instance. Key Features of Singleton: 
 * 1)Single instance only. 
 * 2)Private constructor to restrict instantiation. 
 * 3)Static method to provide the single instance. 
 * 4)Thread safety (optional but recommended in multi-threaded applications).
 **/

//Lazy Initialization (Not Thread-safe)
public class SingletonClass {
    
    /** 1)create instance of Singleton class object with static
     * 2) create a private constructor of that class
     * 3) create a public method and static method to get that instance everytime;
     **/
    
    private SingletonClass() {}
    
    private static SingletonClass instance=new SingletonClass();
    
    public static SingletonClass getObjectofThisClass() {
	return instance;
    }
}

