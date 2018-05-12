package sort;

public class MergeSort {
	
	public static void main(String args[]){
		int[] nums = {3,2,4,5,8,1,1,2};
		int[] temp = new int[nums.length];
		int low = 0;
		int high = nums.length -1;
		mergesort(nums,temp,low,high);
		System.out.println("Merge Sort");
		for(int i=0; i<=high; i++){
			System.out.print(nums[i]);
			System.out.print(";");
		}
	}
	
	public static void mergesort(int[] nums, int[] temp,int low, int high){
		if(low<high){
			int mid = low+(high-low)/2;
			mergesort(nums,temp,low,mid);
			mergesort(nums,temp,mid+1,high);
			merge(nums,temp,low,mid+1,high);
		}
	}
		
	public static void merge(int[] nums,int[] temp, int left, int right, int rightEnd){
		int leftEnd = right-1;
		int k = left;
		int length = rightEnd-left + 1;
		
		while(left<=leftEnd && right<=rightEnd){
			if(nums[left]<=nums[right]){
				temp[k]=nums[left];
				k++;
				left++;
			}else{
				temp[k]=nums[right];
				k++;
				right++;
			}
		}
		
		while(left<=leftEnd){
			temp[k]=nums[left];
			k++;
			left++;
		}
		while(right<=rightEnd){
			temp[k++]=nums[right++];
		}
		
		for(int i=0; i<length; i++){
			nums[rightEnd]=temp[rightEnd];
			rightEnd--;
		}		
    }
}
