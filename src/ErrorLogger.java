/**
 * Created by NCS Customer on 5/7/2015.
 */
public class ErrorLogger
{
    public static void error(String message)
    {
        System.out.println((char)27 +"[31mERROR: " + message + (char)27 +"[0m");

    }
}
