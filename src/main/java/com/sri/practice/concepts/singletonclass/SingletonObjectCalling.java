package com.sri.practice.concepts.singletonclass;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingletonObjectCalling {

    SingletonClass class1 = SingletonClass.getObjectofThisClass();
    SingletonClass class2 = SingletonClass.getObjectofThisClass();

    public void printingObject() {
	log.info("class 1 object address " + class1);
	log.info("class 2 object address " + class2);
    }

    public static void main(String[] args) {
	SingletonObjectCalling calling = new SingletonObjectCalling();
	calling.printingObject();
    }

    /**
     * class 1 object address com.sri.practice.concepts.singletonclass.SingletonClass@e720b71 class 2
     * object address com.sri.practice.concepts.singletonclass.SingletonClass@e720b71
     */
}
