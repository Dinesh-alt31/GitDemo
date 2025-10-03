package InterviewQns;

public class ArrayBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = {2, 4, 6, 8, 10, 12, 14}; // Sorted array
        int target = 10;

        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }

	}
	
	public static int binarySearch(int[] arr, int key) {
		int start = 0;
		int end = arr.length-1;
		while(start <= end)
		{
			int mid = (start + end)/2;
			if(key == arr[mid])
			{
				return mid;
			}
			else if(key>arr[mid])
			{
				start = mid +1;
			}
			else
			{
				end = mid -1;
			}
		}

        return -1; // Target not found
    }

}
