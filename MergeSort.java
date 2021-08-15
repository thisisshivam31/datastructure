import java.util.Arrays;

public class MergeSort {
    void merge(int a[],int b[],int c[],int m,int n){
        m=a.length;
        n=b.length;
        int i,j,k;
        i=j=k=0;
        while(i<m&&j<n){
            if(a[i]<b[j]){
                c[k]=a[i];
                i++;k++;
            }
            else{
                c[k]=b[j];
                k++;j++;
            }

        }
        while(i<m){
            c[k]=a[i];
            i++;k++;
        }
        while(j<n){
            c[k]=b[j];
            k++;j++;
        }

    }
    void print(int c[]){
        for(int i =0;i<c.length;i++){
            System.out.print(c[i] + " ");
        }
    }
    public static void main(String[] args) {
        int a[]=new int[]{5,6,4,3};
        Arrays.sort(a);

        int b[] = new int[]{1,2,3,4,5,88,99};
        Arrays.sort(b);
        int m = a.length;
        int n = b.length;
        int c[] =new int[a.length+b.length];
        MergeSort ms = new MergeSort();
        ms.merge(a,b,c,m,n);
        ms.print(c);


    }
}
