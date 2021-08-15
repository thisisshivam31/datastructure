public class ArrayUnit {
    public void  printArray(int[]arr){
        int n = arr.length;
        for(int i =0;i<n;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    public void arrayDemo(){
        int[] myArr = new int[5];
        myArr[0]=5;
        myArr[1]=6;
        myArr[2]=8;
        myArr[3]=9;
        myArr[4]=33;
      myArr[0]=3;
      myArr[1]=0;
//        printArray(myArr);
    }
    public void reverse(int numbers[],int start,int end){
        while(start<end){
            int temp = numbers[start];
            numbers[start]=numbers[end];
            numbers[end]=temp;
            start++;
            end--;
        }
    }
    public int findMin(int[]numbers){
        int min = numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]<min){
                min = numbers[i];
            }

        }
        return min;
    }
    public int findMax(int[] numbers){
        int max = numbers[0];
        for (int i =1;i<numbers.length;i++){
            if(numbers[i]>max){
                max = numbers[i];
            }
        }
        return max;
    }
    public void moveZeroesToLast(int[] numbers,int n){
        int j = 0;
        for (int i =0;i<n;i++){
            if(numbers[i]!=0&&numbers[j]==0){
                int temp = numbers[i];
                numbers [i]=numbers[j];
                numbers[j]=temp;
            }
            if(numbers[j]!=0){
                j++;
            }
        }

    }
    public int[] resizeArray(int[]arr,int capacity){
        int temp[] = new int[capacity];
        for(int i =0;i<arr.length;i++){
            temp[i]=arr[i];
        }
        arr = temp;
return arr;

    }
    public int[] merge(int[] arr1,int[] arr2,int n,int m){
        int[] result = new int[n+m];
        int i =0;
        int j=0;
        int k =0;
        while (i<n&&j<m) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
            while(i<n){
                result[k]=arr1[i];
                i++;k++;
            }
            while (j<m){
                result[k]=arr2[j];
                j++;k++;
            }

        return result;
    }
    public boolean isPalindrome(String words){
        int start =0;
        int end = words.length()-1;
        char[] charArray = words.toCharArray();
        while(start<end){
            if(charArray[start]!=charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayUnit arrays = new ArrayUnit();
        arrays.arrayDemo();
        int[] numbers = {0,0,1,4,5};
        int n = numbers.length;
        int[] numbers2 = {1,2,6,8,9};
        int m = numbers2.length;
        int [] result =arrays.merge(numbers,numbers2,n,m);
        arrays.printArray(numbers);
        arrays.printArray(numbers2);
        arrays.printArray(result);
        String word="madam";

        System.out.println(arrays.isPalindrome(word));

//
//        arrays.reverse(numbers,0,numbers.length-1);
//        arrays.printArray(numbers);
//        int min = arrays.findMin(numbers);
//        System.out.println("minimum of arrys is " + min);
//        int max = arrays.findMax(numbers);
//        System.out.println("maximum of array is " + max);
//        arrays.moveZeroesToLast(numbers,n);
////        System.out.println(numbers.length);
//      numbers = arrays.resizeArray(numbers,100);
//        System.out.println(numbers.length);


    }
}
