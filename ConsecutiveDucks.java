//22.11.2020 - my solution for Kata named: Consecutive Ducks


public class ConsecutiveDucks {
    public static boolean consecutiveDucks(int n) {
        if (n<3){
            return false;
        }
//Setting bounds of mathematical possible upper limit of range
        int highLimRangeEnd=n/2+1;
        int lowLimRangeEnd=(int)(Math.sqrt(n));
//setting initial values of range
        int rangeBeginsWith= 1;
        int rangeEndsWith= lowLimRangeEnd;
//first range sum calculation
        int consecSum=sumAtoB(rangeBeginsWith,rangeEndsWith);
//if consecutive sum equals n return true
        if (consecSum==n){
            System.out.println("Consecutive sum of numbers between "+rangeBeginsWith+" and "+rangeEndsWith+ "gives "+consecSum+ " (given n="+n);
            return true;
        }
//else - look for the range minimum range end, that gives consecSum>=n
        rangeEndsWith=nextEnd(rangeBeginsWith, rangeEndsWith, highLimRangeEnd, n);
//feedback to the console about basic settings
        System.out.println("\"fast\" algorythm variables: highLimRangeEnd = "+highLimRangeEnd+", lowLimRangeEnd = "+lowLimRangeEnd+", curr range end: "+rangeEndsWith);

//whlie loop that checks possible solutions until it finds solution or checks last condition (n/2 + n/2+1)
        while (rangeBeginsWith<highLimRangeEnd){
            consecSum=sumAtoB(rangeBeginsWith,rangeEndsWith);
//            System.out.println("startNum ="+rangeBeginsWith+", endNum ="+rangeEndsWith +", consecSum="+consecSum);
            if (consecSum==n){
                System.out.println("Consecutive sum of numbers between "+rangeBeginsWith+" and "+rangeEndsWith+ "gives "+consecSum+ " (given n="+n);
                return true;
            } else if (consecSum<n){ //if sum of this range is smaller then N - its needed to extend range to the point where it is equal or greater then N
                //the sum is twice higher every time we add another number to the range
                rangeEndsWith++;
            } else if (consecSum>n){
                //using method to find range start giving the summ closest to N
                rangeBeginsWith=nextStart(rangeBeginsWith,rangeEndsWith,n);
            }
        }
        //if all possible solutions were checked, return false;
        return false;
    }
//method returns sum of consecutive numbers between min->max
    public static int sumAtoB(int min, int max){
        double minD=min*1.0d-1.0d;
        double maxD=max*1.0d;
        double result= (maxD-minD)*(maxD+minD+1.0)/2.0;
        //System.out.println("conseqSum between min: "+min+" max: "+max+ " equals: "+result+", sum of two  digits= "+ (minD+maxD));
        return (int)result;
    }
//method return the Ceil result of expression (a+b)/2
    public static int divByTwo (int a, int b){
        return (a+b)/2+(((a+b)%2==0)? 0:1);
    }
//method for finding next "endIndex" which is giving sum higher then n
    public static int nextEnd(int lastStart, int lastEnd, int maxEnd, int n){
        int tempEnd=divByTwo(lastEnd,maxEnd);//(lastEnd+maxEnd)/2;
        int newSum=sumAtoB(lastStart, tempEnd);
        int newSum_1=sumAtoB(lastStart,tempEnd-1);
        int limEndLow=lastEnd;
        int limEndHigh=maxEnd;
//look for new end of range until sum of that range is greater or equal n while range with one number less is smaller then n
        while (!(newSum>=n && newSum_1<n)){
             if (newSum>n){
                 limEndHigh=tempEnd;
                tempEnd=divByTwo(limEndLow,tempEnd);//(limEndLow+tempEnd)/2
            } else if (newSum<n){
                 limEndLow=tempEnd;
                tempEnd=divByTwo(tempEnd,limEndHigh);//(tempEnd+limEndHigh)/2
            }
            newSum=sumAtoB(lastStart, tempEnd);
            newSum_1=sumAtoB(lastStart,tempEnd-1);
        }
        return tempEnd;
    }
//method returns next "startIndex" which is giving sum smaller or equal then n
    public static int nextStart(int lastStart, int lastEnd, int n){
        int tempStart=divByTwo(lastStart,lastEnd);//(lastStart+lastEnd)/2;
        int newSum=sumAtoB(tempStart, lastEnd);
        int newSum_1=sumAtoB(tempStart-1,lastEnd);
        int limStartHigh=lastEnd;
        int limStartLow=lastStart;

        while (!(newSum<=n && newSum_1>n)){
            if (newSum>n){
                limStartLow=tempStart;
                tempStart=divByTwo(tempStart,limStartHigh);//(tempStart+limStartHigh)/2;
            } else if (newSum<n){
                limStartHigh=tempStart;
                tempStart=divByTwo(limStartLow, tempStart);//(limStartLow+tempStart)/2;
            }
            newSum=sumAtoB(tempStart, lastEnd);
            newSum_1=sumAtoB(tempStart-1,lastEnd);
        }
        return tempStart;
    }
    // Below solution works but is too slow
    public static boolean slowConsecutiveDucks(int n) {
        if (n<3){
            return false;
        }

        int consecSum=0;
        int maxNum=(int)(n/3*2);

        for (int i =1; i<=maxNum; i++){
            int currNum=i;
            consecSum=0;
            while (consecSum<n){
                consecSum+=currNum;
                currNum++;
            }
            if (consecSum==n) {
                System.out.println("Consecutive summ starting with: "+i+" ends with: "+(currNum-1)+" is giving: "+ consecSum);
                return true;
            }
        }
        return false;
    }
}
//below some "n" numbers creating very long execution times.
//542965043
//810948673
//2147483647
//not so long ;)
//1941656238