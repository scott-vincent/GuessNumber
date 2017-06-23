package com.scottlv;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessNumber 
{
    public static void main( String[] args )
    {
        if (args.length != 2) {
            System.out.println("Usage: GuessNumber <num_digits> <count>");
            System.exit(1);
        }
        
        int numDigits = Integer.parseInt(args[0]);
        int numCount = Integer.parseInt(args[1]);
        
        if (numDigits < 1) {
            System.out.println("Number of digits must be 1 or more");
            System.exit(1);
        }
        
        int min = (int)Math.pow(10, numDigits - 1);
        int max = (int)Math.pow(10, numDigits) - 1;
                
        if (numCount > (1 + max - min)) {
            System.out.println("IMPOSSIBLE: There aren't " + numCount + " unique numbers between " + min + " and " + max);
            System.exit(1);
        }
        
        System.out.println("Generating " + numCount + " unique numbers between " + min + " and " + max);
        
        List<Integer> numbers = new ArrayList<Integer>();
        
        System.out.println();
        
        Random rand = new Random();
        while (numbers.size() < numCount) {
            int num = min + rand.nextInt(1 + max - min);
            
            // insert number in sorted order, discard if not unique
            int pos = 0;
            while (pos <= numbers.size()) {
                if (pos == numbers.size()) {
                    // add number at end of list
                    numbers.add(num);
                    break;
                }
                else if (num <= numbers.get(pos)) {
                    // only insert number if it is not a duplicate
                    if (num < numbers.get(pos)) {
                        numbers.add(pos, num);
                    }
                    break;
                }
                else {
                    pos++;
                }
            }
        }
        
        // Required list has been created so output it
        for (Integer num : numbers) {
            System.out.println(num);
        }
    }
}
