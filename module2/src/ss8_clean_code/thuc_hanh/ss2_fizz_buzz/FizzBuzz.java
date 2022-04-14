package ss8_clean_code.thuc_hanh.ss2_fizz_buzz;

public class FizzBuzz {
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public static String fizzBuzz(int number){
        boolean isBuzz = number % 5 == 0;
        boolean isFizz = number % 3 == 0;
        if(isFizz && isBuzz)
            return FIZZ + BUZZ;

        if(isFizz)
            return FIZZ;

        if(isBuzz)
            return BUZZ;

        return number + "";
    }
}
