public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor==0) return Integer.MAX_VALUE;
        if (dividend==0) return 0;
        long x,y;
        long result=0;
        if (dividend>0) y=dividend; else y=-(long)dividend;
        if (divisor>0) x=divisor; else x=-(long)divisor;
        
        long[][] s=new long[2][32];
        s[0][0]=1;
        s[1][0]=x;
        int i=0;
        while (s[1][i]<y) {
            s[0][i+1]=s[0][i]+s[0][i];
            s[1][i+1]=s[1][i]+s[1][i];
            i++;
        }
        
        while (y>=x) {
            while (y<s[1][i]) i--;
            result+=s[0][i];
            y-=s[1][i];
            
        }
        if ( (dividend>0 && divisor>0) || (dividend<0 && divisor<0) ) return (int)Math.min(result, Integer.MAX_VALUE); else return (int)-result;
    }
}
