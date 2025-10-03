package InterviewQns;

public class LogicLcmOf3Nmbrs {
	
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int num1 = 32;
        int num2 = 54;
        int num3 = 67;
        int finalLcm = lcmOfThree(num1,num2,num3);
        System.out.println(finalLcm);
        
    }
    public static int gcd(int a,int b){
            while(b!=0)
            {
                int temp = b;
                b = a%b;
                a = temp;
            }
            return a;
        }
    
    public static int lcmOfThree(int a, int b, int c)
    {
        int lcmb = (a*b)/gcd(a,b);
        int finalLcm = (lcmb*c)/gcd(lcmb,c);
        return finalLcm;
    }
}
