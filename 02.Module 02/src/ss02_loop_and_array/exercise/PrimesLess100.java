package ss02_loop_and_array.exercise;

public class PrimesLess100 {
    public static void main(String[] args) {
        int number = 100;
        int prime = 2;
        System.out.println("Primes less than 100: ");
        while (prime < number) {
            int checkPrime = 0;
            int i = 2;
            while (i <= Math.sqrt(prime)) {
                if (prime % i == 0) {
                    checkPrime++;
                    break;
                }
                i++;
            }
            if (checkPrime == 0)
                System.out.print(prime + " ");
            prime++;
        }
    }
}
