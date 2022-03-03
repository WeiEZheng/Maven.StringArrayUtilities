package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {return array[array.length-1];}

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {return array[array.length-2];}

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        return Arrays.asList(array).contains(value);
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
//        Collections.reverse(Arrays.asList(array));
//        return array;
        //was failing the palindromic test
        ArrayList <String> arrayCopy = new ArrayList<String>();
        for (int i= array.length-1;i>= 0;i--)
            arrayCopy.add(array[i]);
        return arrayCopy.toArray(new String[arrayCopy.size()]);
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        return Arrays.equals(StringArrayUtils.reverse(array),array);}

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        Boolean pangramicLower, pangramicUpper,pangramic= true;
        String arrayString =Arrays.toString(array);
        for (int i =0;i<26;i++){
            pangramicLower = arrayString.contains(Character.toString((char)('a'+i)));
            pangramicUpper = arrayString.contains(Character.toString((char)('A'+i)));
            if ((pangramicLower == false) && (pangramicUpper == false)) {
                pangramic=false;
                break;
            }
        }
        return pangramic;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count=0;
        for (String string: array){
            if (string.equals(value))
                count++;
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        ArrayList <String> arrayCopy = new ArrayList<String>();
        for (String string :array){
            if (!string.equals(valueToRemove)){
                arrayCopy.add(string);
            }
        }
        return arrayCopy.toArray(new String[arrayCopy.size()]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> arrayCopy = new ArrayList<String>();
        for (String string: array) {
            if (arrayCopy.size() == 0)
                arrayCopy.add(string);
            else if (!arrayCopy.get(arrayCopy.size()-1).equals(string)){
                arrayCopy.add(string);
            }
        }
        return arrayCopy.toArray(new String[arrayCopy.size()]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> arrayCopy = new ArrayList<String>();
        String concat="";
        for (int i=0;i<array.length;i++){
            if (i== array.length -1) {
                if (array[i]==array[i-1]) {
                    concat+=array[i];
                    arrayCopy.add(concat);
                }
                else
                    arrayCopy.add(array[i]);
            }
            else if (array[i] == array[i+1])
                concat+=array[i];
            else {
                if (i==0)
                    arrayCopy.add(array[0]);
                else if (array[i]==array[i-1]){
                    concat+=array[i];
                    arrayCopy.add(concat);
                    concat="";
                }
                else
                    arrayCopy.add(array[i]);
            }
        }
        System.out.println(arrayCopy);
        return arrayCopy.toArray(new String[arrayCopy.size()]);
    }


}
