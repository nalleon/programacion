package ies.puerto;
import java.util.Arrays;
/**
 * @author Nabil
 */


public class Ejercicio2 {
    /**
     * function that fills an array of lenght 10 of integer numbers until
     * it's full, or it finds a negative number
     * @param array to evalue
     * @return array completed
     */
    public int [] arrayMapper (int [] array){
        int [] result = new int [10];

        for (int i =0; i < array.length; i++){
            if(array [i] <= 0) {
                return Arrays.copyOfRange(result, 0, i);
            }
            result [i] = array[i];
        }
        return result;
    }
}