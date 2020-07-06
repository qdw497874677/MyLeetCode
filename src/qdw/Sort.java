package qdw;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {4,2,3,10,5,7,6,9,8,1};
        Sort sort = new Sort();
        int[] temp = new int[10];
        sort.mergeSort(arr,temp,0,9);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    public void mergeSort(int[] arr,int[] temp,int left,int right){
        if (left<right){
            int middle = left + (right-left)/2;
            mergeSort(arr,temp,left,middle);
            mergeSort(arr,temp,middle+1,right);
            merge(arr,temp,left,middle,right);
        }

    }
    public void merge(int[] arr,int[] temp,int left,int middle,int right){
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        int i = left;
        int j = middle + 1;
        for (int k = left; k <= right; k++) {
            if (i>middle){
                arr[k] = temp[j++];
            }else if (j>right){
                arr[k] = temp[i++];
            }else if (temp[i] < temp[j]){
                arr[k] = temp[i++];
            }else {
                arr[k] = temp[j++];
            }
        }
    }
}
