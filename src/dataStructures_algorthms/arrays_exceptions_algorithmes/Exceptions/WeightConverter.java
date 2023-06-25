package Exceptions;

import Exceptions.textio.TextIO;

/**
 * This program will convert measurements expressed in grams,
 * ounces, pounds, or kilograms into each of the possible units of
 * measure. The measurement is input by the user, followed by
 * the unit of measure. For example: "17 grams", "1 ounce",
 * "2.73 pounds". Several measurements can be combined on
 * one line of input. For example: "2 grams 5 ounces 1 pound".
 * In this case, the measurements are combined into one total.
 * Abbreviations g, oz, lb, and kg are accepted. Negative
 * measurements are not allowed.
 * 
 * The program will continue to read and convert measurements
 * until the user enters an empty line.
 * 
 * The program uses exception handling.
 */
public class WeightConverter {

    /**
     * This nested class is used to represent errors in the user's input.
     * It is a checked exception and so should be handled.
     */
    static class ParseError extends Exception {
        ParseError(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {

        double grams, ounces, pounds, kilograms; // Measurement expressed in each
                                           // possible unit of measure.

        System.out.println("Enter measurements in grams, ounces, pounds, or kilograms.");
        System.out.println("For example:  1 gram   17 ounces  2.73 pounds");
        System.out.println("You can use abbreviations:   g oz lb kg");
        System.out.println("You can combine measurements, as in:  1 g 270 oz 17 lb");
        System.out.println("I will convert your input into each of the four units of measure.");

        while (true) {

            /* Get the user's input, and convert it to inches. */

            System.out.println();
            System.out.println();
            System.out.println("Enter your measurement, or press return to end:");

            skipBlanks();

            if (TextIO.peek() == '\n') // End if there is nothing on the line.
                break;

            try {
                grams = readMeasurement();
            } catch (ParseError e) {
                System.out.println("Error:  " + e.getMessage());
                TextIO.getln(); // Discard the rest of the input line.
                continue; // jump back to the start of the while loop
            }

            /* Convert the measurement in grams to ounce, pound and kilogram. */

            ounces = grams*0.035274;
            pounds = grams*0.00220462;
            kilograms = grams* 0.001;

            /* Output the measurement in terms of each unit of measure. */

            System.out.println();
            System.out.println("That's equivalent to:");
            System.out.printf("%12.5g", grams);
            System.out.println(" grams");
            System.out.printf("%12.5g", ounces);
            System.out.println(" ounces");
            System.out.printf("%12.5g", pounds);
            System.out.println(" pounds");
            System.out.printf("%12.5g", kilograms);
            System.out.println(" kilograms");

            TextIO.getln(); // Discard the rest of the input line before
                            // getting the next line.

        } // end while

        System.out.println();
        System.out.println("OK!  Bye for now.");

    } // end main()

    /**
     * Reads past any blanks and tabs in the input.
     * Postcondition: The next character in the input is an
     * end-of-line or a non-blank character.
     */
    static void skipBlanks() {
        char ch;
        ch = TextIO.peek();
        while (ch == ' ' || ch == '\t') {
            ch = TextIO.getAnyChar();
            ch = TextIO.peek();
        }
    }

    /**
     * Reads the user's input measurement from one line of input.
     * Precondition: The input line is not empty.
     * Postcondition: If the user's input is legal, the measurement
     * is converted to inches and returned.
     * 
     * @throws ParseError if the user's input is not legal.
     */
    static double readMeasurement() throws ParseError {

        double grams; // Total number of grams in user's measurement.

        double measurement; // One measurement, such as the 12 in "12 pounds"
        String units; // The units specified for the measurement, such as "pounds"

        char ch; // Used to peek at next character in the user's input.

        grams = 0; // No grams have yet been read.

        skipBlanks();
        ch = TextIO.peek();

        /*
         * As long as there is more input on the line, read a measurement and
         * add the equivalent number of grams to the variable, grams. If an
         * error is detected during the loop, end the subroutine immediately
         * by throwing a ParseError.
         */

        while (ch != '\n') {

            /*
             * Get the next measurement and the units. Before reading
             * anything, make sure that a legal value is there to read.
             */

            if (!Character.isDigit(ch)) {
                throw new ParseError("Expected to find a number, but found " + ch);
            }
            measurement = TextIO.getDouble();
            skipBlanks();
            if (TextIO.peek() == '\n') {
                throw new ParseError("Missing unit of measure at end of line.");
            }
            units = TextIO.getWord();
            units = units.toLowerCase();

            /* Convert the measurement to grams and add it to the total. */

            if (units.equals("gram") || units.equals("grams")
                || units.equals("g"))
                grams += measurement;
            else if (units.equals("ounce") || units.equals("ounces")
                || units.equals("oz"))
                grams += measurement /0.035274;
            else if (units.equals("pound") || units.equals("pounds")
                || units.equals("lb"))
                grams += measurement /0.00220462;
            else if (units.equals("kilogram") || units.equals("kilograms")
                || units.equals("kg"))
                grams += measurement * 1000;
            else {
                throw new ParseError("\"" + units + "\" is not a legal unit of measure.");
            }

            /* Look ahead to see whether the next thing on the line is the end-of-line. */

            skipBlanks();
            ch = TextIO.peek();

        } // end while

        return grams;

    } // end readMeasurement()

} // end class WeightConverter

