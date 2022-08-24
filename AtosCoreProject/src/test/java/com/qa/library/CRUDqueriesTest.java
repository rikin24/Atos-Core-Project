package com.qa.library;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CRUDqueriesTest {

	CRUDqueries qu = new CRUDqueries();
	Customer cm = new Customer("James", "Smith", "54 West Lane", "LB2 7AB");
	Customer c;
	
	@BeforeAll
	public static void start() {
		System.out.println("Before All");
		
	}
	
	@Test
	public void testCreate() {
		qu.create(cm);
		String out = "Customer [id=0, fName=James, sName=Smith, address=54 West Lane, postcode=LB2 7AB]";
		Assertions.assertEquals(out, cm.toString());
		System.out.println("Test 9");
	}
	
	@Test
	public void testRead() {
		qu.read();
		String out = "Customer [id=0, fName=James, sName=Smith, address=54 West Lane, postcode=LB2 7AB]";
		Assertions.assertEquals(out, cm.toString());
		System.out.println("Test 10");
	}
	
	@Test
	public void testUpdate() {
		qu.update(0, "Bob");
		qu.read();
		String out = "Customer [id=0, fName=Bob, sName=Smith, address=54 West Lane, postcode=LB2 7AB]";
	//	Assertions.assertEquals(out, cm.toString());
		System.out.println("Test 11");
	}
	
	@Test
	public void testDelete() {
		qu.delete(0);
		qu.read();
		String out = "Customer []";
	//	Assertions.assertEquals(out, cm.toString());
		System.out.println("Test 12");
	}
	
	@AfterEach
	public void clean() {
		System.out.println("After Each");
	}
	
	@AfterAll
	public static void stop() {
		System.out.println("After all");
	}
	
}
