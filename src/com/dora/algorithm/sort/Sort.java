package com.dora.algorithm.sort;

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
}
