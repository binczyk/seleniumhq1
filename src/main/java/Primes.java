import java.util.ArrayList;
import java.util.List;

public class Primes {

    public boolean prime(int n) {
        if (n > 2) {
            double sq = Math.sqrt(n);
            if (n % 2 == 0)
                return false;
            else {
                for (int i = 3; i <= sq; i += 2) {
                    if (n % i == 0) {
                        return false;
                    }
                }
                return true;
            }
        } else if (n == 2) return true;
        return false;
    }

    public String getListOfPrimes(String range) {
        List<Integer> list = new ArrayList<Integer>();

        for (String retval : range.split(", ..., ")) {
            list.add(Integer.parseInt(retval));
        }

        StringBuilder sb = new StringBuilder();
        try {
            for (int i = list.get(0) + 1; i < list.get(1); i++) {
                if (prime(i)) {
                    sb.append(",");
                    sb.append(i);
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println(" nie jest liczba calkowita");

        }
        return sb.toString();
    }
}
