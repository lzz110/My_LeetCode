package ArraysClass;

public class MultiPlyArray {
/**
 * 题目：
 *      给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 *      其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * 思路：
 *      先算下三角中的连乘，即我们先算出B[i]中的一部分，
 *      然后倒过来按上三角中的分布规律，把另一部分也乘进去。
 */
    public static void main(String[] args) {
        MultiPlyArray multiPlyArray=new MultiPlyArray();
        int[] A={1,2,3,4};
        int[] res=multiPlyArray.multiply(A);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+"    ");
        }
    }
    public int[] multiply(int[] A) {
        int len=A.length;
        int[] B=new int[len];
        if(len!=0){
            //先算下三角 从前往后[i,len-1]
            B[0]=1;
            for(int i=1;i<len;i++){
                B[i]=B[i-1]*A[i-1];
            }
            //算上三角	从后往前[len-2,0]
            int temp=1;
            for(int j=len-2;j>=0;j--){
                temp=temp*A[j+1];
                B[j]=B[j]*temp;
            }
        }
        return B;
    }
}
