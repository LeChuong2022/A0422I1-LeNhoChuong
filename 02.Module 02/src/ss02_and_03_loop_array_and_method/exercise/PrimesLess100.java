package ss02_and_03_loop_array_and_method.exercise;

public class PrimesLess100 {
    public static void main(String[] args) {
        int number = 100;
        int prime = 2;
        System.out.println("Primes less than 100: ");
        while (prime < number) {
            boolean checkPrime = true;
            int i = 2;
            while (i <= Math.sqrt(prime)) {
                if (prime % i == 0) {
                    checkPrime = false;
                    break;
                }
                i++;
            }
            if (checkPrime)
                System.out.print(prime + " ");
            prime++;
        }
    }
}
