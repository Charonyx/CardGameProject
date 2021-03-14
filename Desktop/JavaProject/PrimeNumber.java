public class PrimeNumber {

    public static void main(String[] args) {
        int nCount=0;
        for(int i=2;nCount<100;i++)
        {
            // check prime
            boolean isPrime=true;
            boolean isPalindrome=false;
            for(int j=2;j <=i/2 ;j++)
            {
                if(i % j == 0) isPrime = false;
            }

            //check palindrome
            int temp = 0;
            int k=i;
            while( k!= 0)
            {
                temp *= 10;
                temp += k % 10;
                k /= 10;
            }
            if(i==temp)  isPalindrome = true;

            if(isPrime == true && isPalindrome == true)
            {
                System.out.printf("%5d ", i);
                nCount++;
                if(nCount % 10 == 0 && i != 0)System.out.println();
            }

        }
    }
}
