package com.dora.algorithm.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Sort<T extends Comparable<T>> {
	
	
	public T[] selectionSort(T[] arr) {
		
		T minValue, temp;
		int minIdx;
		for(int i = 0; i < arr.length; i++) {
			
			minValue = arr[i];
			minIdx = i;
			
			for(int j = i + 1; j < arr.length; j++) {
				
				if(arr[j].compareTo(minValue) < 0) {
					minValue = arr[j];
					minIdx = j;
				}
				
			}
			
			temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
		}
		
		return arr;
	}
	
	
	public T[] insertionSort(T[] arr) {
		
		for(int i = 1; i < arr.length; i++) {
			
			T key = arr[i];
			
			int j = i - 1;
			while(j >= 0 && arr[j].compareTo(key) > 0){
				arr[j + 1] = arr[j];
				j--;
			}
			
			arr[j + 1] = key;
			
		}
		
		return arr;
		
	}
	
	public T[] bubbleSort(T[] arr) {
		
		T temp;
		for(int i = 0; i < arr.length; i++) {
			
			for(int j = 1; j  < arr.length - i; j++) {
				
				if(arr[j - 1].compareTo(arr[j]) > 0) {
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
				
			}
			
		}
		
		return arr;
	}
	
	
	public T[] heapSort(T[] arr) {
		
		PriorityQueue<T> pq = new PriorityQueue<>(new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				return -o1.compareTo(o2); 
			}
		});
		
		for(int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		
		for(int i = arr.length - 1; i >= 0; i--) {
			arr[i] = pq.poll();
		}
		
		return arr;
	}
	
	
	public T[] mergeSort(T[] arr) {
		partition(arr, 0, arr.length - 1);
		return arr;
	}
	
	public T[] quickSort(T[] arr) {
		
		quickSort(arr, 0, arr.length - 1);
		
		return arr;
		
	}
	
	public void quickSort(T[] arr, int left, int right) {
		
		T pivot = arr[(left + right) / 2];
		int low = left;
		int high = right;
		
		T temp;
		while(low <= high) {
			
			while(arr[low].compareTo(pivot) < 0) {	
				++low;
			}
		
			while(arr[high].compareTo(pivot) > 0) {
				--high;
			}
			
			if(low <= high) {
				temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				++low;
				--high;
			}			
		}
	
		if(left < high) quickSort(arr, left, high);
		if(right > low) quickSort(arr, low, right);

	
	}
	
	
	private void partition(T[] arr, int left, int right) {
	
		if(left < right) {
			int mid = (left + right) / 2;
			partition(arr, left, mid);
			partition(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
		
	}
	
	private void merge(T[] arr, int left, int mid, int right) {
		
		T[] tempArr = (T[]) new Comparable[arr.length];
		int l = left;
		int r = mid + 1;
		int k = left;
		
		while(l <= mid && r <= right) {
			if(arr[l].compareTo(arr[r]) < 0) tempArr[k++] = arr[l++];
			else tempArr[k++] = arr[r++];
		}
		
		int i = (mid < l) ? r : l;
		
		while(k <= right) {
			tempArr[k++] = arr[i++];
		}
		
		for(int j = left; j <= right; j++) {
			arr[j] = tempArr[j];
		}
		
	}
	
}
