package com.bloc.objects;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public class Main extends Object {

	public static void main(String [] args) {
		Constructor<?> artistConstructor = getConstructor(String.class, String.class);
		Artist bono = (Artist) artistConstructor.newInstance("Bono", null);

		System.out.println("/************************/");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/* Nice work, you pass! */");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/************************/\n");
	}

	private static Constructor<?> getConstructor(Class<?> cls, Class<?>... parameterTypes) {
		try {
			return cls.getConstructor(parameterTypes);
		} catch (Exception e) {
			System.out.println("Missing or incorrect constructor in " + cls.getName());
			System.exit(1);
		}
		return null;
	}
}
