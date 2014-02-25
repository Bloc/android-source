package com.bloc.collections;

import java.util.*;

/**
 * Follow the Interface declaration (http://docs.oracle.com/javase/7/docs/api/java/util/List.html)
 * to fill in the methods where indicated
 */
public class MyArrayList<E> extends Object implements List<E> {

	// Use this object array as your backing data storage
	private Object[] mList;

	public MyArrayList() {
		mList = new Object[0];
	}

	@Override
	public boolean add(E e) {
		// YOUR WORK HERE
		return false;
	}

	@Override
	public void add(int index, E element) {
		// YOUR WORK HERE
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	@Override
	public void clear() {
		// YOUR WORK HERE
	}

	@Override
	public boolean contains(Object o) {
		// YOUR WORK HERE
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

	@Override
	public E get(int index) {
		// YOUR WORK HERE
		return null;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public int indexOf(Object o) {
		// YOUR WORK HERE
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// YOUR WORK HERE
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}

	@Override
	public E remove(int index) {
		// YOUR WORK HERE
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// YOUR WORK HERE
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public E set(int index, E element) {
		// YOUR WORK HERE
		return null;
	}

	@Override
	public int size() {
		// YOUR WORK HERE
		return 0;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}
}