package mergesort;

public class MergeSort {

	public static void main(String[] args) {
		int[] array1 = {11,43,87,27,54,8,32,71,44,12};
		
		
		showArray(array1);
		mergeSort(array1);
		//showArray(array1);
		
	}
	
	public static void showArray(int[] theArray) {
		int index;
		
		System.out.printf("[");
		for(index=0;index<theArray.length;index++) {
			if(index!=0) {
				System.out.printf(", ");
			}
			System.out.printf("%d",theArray[index]);
		}
		System.out.printf("]\n");
	}
		/*
		public static void partition(int[] theArray) {
			int mid=theArray.length/2;
			int[] left;
			int[] right;
			if((mid*2)==theArray.length) {
				left = new int[mid];
				right=new int[mid];
			}else {
				left = new int[mid];
				right=new int[mid+1];
			}
			
			for(int i=0; i<theArray.length; i++) {
				if(i<mid) {
					left[i]=theArray[i];
				}else if(i>=mid) {
					right[i-mid]=theArray[i];
					}
			}
			showArray(left);
			showArray(right);
		}//Partition
	*/
	

	
	private static void mergeSort(int[] theArray, int left, int right) {
		//**************************************************************
		//*  Recursive Merge Sort                                      *
		//*------------------------------------------------------------*
		//*  1. Divide or partition the array section into 2 halves.   *
		//*  2. Create a subArray for each partition (half)            *
		//*  3. Merge the two subArrays to create one sorted array     *
		//*  4. Replace the original array section with the merged     *
		//*     array.                                                 *
		//**************************************************************
		
		int mid=theArray.length/2;
		int[] leftArray;
		int[] rightArray;
		int[] newArray= new int[theArray.length];
		int leftI=0;
		int rightI=0;
		int index=0;
		
		if((mid*2)==theArray.length) {
			leftArray = new int[mid];
			rightArray=new int[mid];
		}else {
			leftArray = new int[mid];
			rightArray=new int[mid+1];
		}
		
		for(int i=0; i<theArray.length; i++) {
			if(i<mid) {
				leftArray[i]=theArray[i];
			}else if(i>=mid) {
				rightArray[i-mid]=theArray[i];
				}
		}
		showArray(leftArray);
		showArray(rightArray);
		
		if(leftArray.length==1 && rightArray.length==1) {
			//return;
		}else if(leftArray.length==1 && rightArray.length==2) {
			mergeSort(rightArray);
		}else if(leftArray.length==2 && rightArray.length==1) {
			mergeSort(leftArray);
		}else {
			mergeSort(leftArray);
			mergeSort(rightArray);
		}
		
		while(leftI<leftArray.length && rightI<rightArray.length) {
			if(leftArray[leftI]<= rightArray[rightI]) {
				newArray[index]=leftArray[leftI];
				leftI++;
			}else {
				newArray[index]=rightArray[rightI];
				rightI++;
			}
			index++;
		}//while
		
		while(leftI<leftArray.length) {
			newArray[index]= leftArray[leftI];
			leftI++;
			index++;
		}
		
		while(rightI<rightArray.length) {
			newArray[index]= rightArray[rightI];
			rightI++;
			index++;
		}
		
		//Other parts need to see the sorted array instead of new array.
		for(int i=0; i<theArray.length; i++) {
			theArray[i]=newArray[i];
		}
		
		showArray(newArray);

	}//MergeSort
	
	public static void mergeSort(int[] array) {
		//**********************************************
		//*  Class Wrapper for the recursive mergeSort *
		//**********************************************
		mergeSort(array,0,array.length-1);
	}
}
