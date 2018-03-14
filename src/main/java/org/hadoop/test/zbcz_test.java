package org.hadoop.test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: dingzhenying
 * Date: 2018-03-10
 * Time: 16:51
 */
public class zbcz_test {
    public static int biSearch(int []array,int a){
        int lo=0;
        int hi=array.length-1;
        int mid;
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(array[mid]==a){
                return mid+1;
            }else if(array[mid]<a){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return -1;
    }


}
