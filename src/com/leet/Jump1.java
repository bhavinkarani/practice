package com.leet;

import java.util.Date;

public class Jump1 {
public static void main(String args[]){

    /*System.out.println(canJump(new int[] {3,2,1,0,4,4}));
    System.out.println(canJump(new int[] {2,3,1,1,4}));
    System.out.println(canJump(new int[] {0,2,3}));
    System.out.println(canJump(new int[] {2,2,0,2,0,2,0,0,2,0}));*/
    //System.out.println(jump(new int[] {2,3,1,1,4}));
    Date newYear  = new Date(1609455600000L);
    Date today  = new Date(1609542000000L);
    System.out.print(today.after(newYear));
}
    public static boolean canJump(int[] nums) {
        int max_index=0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] ==0  && max_index == i ){
                return false;
            }
            if(i + nums[i] > max_index){
                max_index = i + nums[i];
            }
        }
        if(max_index >= nums.length-1){
            return true;
        }
        return false;
    }

    /**
     *
     * 2,3,1,1,4
     *
     * 0 1 1 2 2
     *
     * 0 0 0 1 1
     *
     * @param nums
     * @return
     */

    public static  int jump1(int[] nums) {
        int len = nums.length;
        int jumps[] = new int[len];
        int lastJumps[] = new int[len];
        for(int i=1; i<len ; i++){
            for(int j=0; j<i; j++){
                if(j+ nums[j]  >= i && (j + nums[j] < jumps[i] || jumps[i]==0)){
                    jumps[i] = jumps[j] +1 ;
                    lastJumps[i] = j;
                }
            }
        }
        return jumps[len-1];
    }

    public static int jump2(int[] nums) {

        int initial = 0;
        int jump = nums[0];
        int n = nums.length;
        int result = 0;
        if(n == 1)
            return 0;

        if(n > 1)
            while(initial+jump < n-1)
            {
                int newjump = nums[initial+1];
                int newinitial = initial+1;

                for(int i = initial + 1;i <= initial + jump;i++)
                {
                    if(nums[i]+i-newinitial>= newjump)
                    {newjump = nums[i]; newinitial = i;}
                }
                result++;
                jump = newjump;
                initial = newinitial;
            }

        result++;

        return result;
    }

    public static int jump3(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n=nums.length;
        int[] dist=new int[n];
        int k=1;
        for(int i=0;i<n;i++){
            int p=nums[i];
            int diff=k-i-1;
            p=p-diff;
            while(p-->0 && k<n){
                dist[k]=dist[i]+1;
                k++;
            }
        }
        return dist[n-1];
    }

    public static int jump4(int[] nums) {
        int step = 0;
        for (int i = 0, maxReach = 0, curReach = 0; i < nums.length; i++) {
            if (i > curReach) {
                curReach = maxReach;
                step++;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return step;
    }

    public static int jump5(int[] A){
        if(A==null || A[0]==0 ||A.length==1) return 0;
        int begin = 1;
        int end = A[0];
        int times = 1;
        while(end < A.length -1){
            int max =0;
            //find the max position it can reach
            for(int i=begin; i<=end;i++){
                if(max < i + A[i])
                    max = i+A[i];
            }

            //update begin and end
            begin = end + 1;
            end = max ;
            times++;
        }
        return times;
    }

    public static int jump(int[] A) {
        int remain=A[0];
        int newres=A[0];

        int step=0;
        for (int i=1;i<A.length;i++){
            if (remain>0){
                remain--;
                newres--;
                if (newres<A[i]) newres=A[i];
            } else {
                if (newres>0){
                    remain=newres;
                    step++;
                    remain--;
                    newres--;
                    if (newres<A[i]) newres=A[i];
                } else return -1;
            }
        }
        return A.length==1?0:step+1;
    }
}
