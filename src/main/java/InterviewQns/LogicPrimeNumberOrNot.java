package InterviewQns;

public class LogicPrimeNumberOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int c = 0;
        for(int num=100;num<1000;num++)
        {
            if(isPrime(num))
            {
                System.out.println(num);
                c++;
            }
        }
        System.out.println(c);
    }
    public static boolean isPrime(int num)
    {
        boolean res = true;
        for(int i=2;i<num/2;i++)
        {
            if(num%i==0)
            {
                return false;
            }
        }
        return true;
    }

}
