package federigi.primeverifyapp.engine;

public class PrimeUtil {

    public static boolean isCircularPrime(int n) {
        int o = n;
        boolean prime = true;
        do {
            prime = isPrime(n);
            o = orbit(o);
        } while (prime && o != n);
        return prime;
    }

    private static int orbit(int n) {
        int n_10 = n / 10;
        int orbit = n % 10;
        n = n_10;
        while (n != 0) {
            orbit *= 10;
            n /= 10;
        }
        orbit += n_10;
        return orbit;
    }

    private static boolean isPrime(int n) {

        if (n <= 3) {
            return n > 1;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        } else {
            for (int i = 5; i * i <= n; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }

    }

}
