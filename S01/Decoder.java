//Decoder.java
//Aitezaz:Siddiqi:A00431079:csc34146
//Submission 01
//Decoding Encoded Textfiles

/*
 * All the imports.
 */
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

/**
 * A class to decode previously encoded textfiles, one file per run, and
 * write the decoded text to an output textfile. The names of the input
 * and output files are both read from the command line.
 */
public class Decoder 
{
    private static Scanner inputFile;
    private static PrintWriter outputFile;
    private static String linesFromText, decodedText;

    public Decoder
    (
        String inFileName, 
        String outFileName
    ) throws FileNotFoundException 
    {
        inputFile = new Scanner(new File(inFileName));
        outputFile = new PrintWriter(outFileName); 
        linesFromText = ""; 
        decodedText = "";
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        if (args.length == 0)
            displayOpeningAndInfo();
        else if (args.length == 2) 
        {
            Decoder decoder = new Decoder(args[0], args[1]);
            decoder.readEncodedText();
            decoder.decodeEncodedText();
            decoder.writeOutputFile();
            decoder.closeOpenedFiles();
            displaySuccessMessage(args[0], args[1]);
        }
    }

    private static void displaySuccessMessage
    (
      String inputFile, 
        String outputFile
    )
    {
        System.out.println("\nThe input file " + inputFile 
                + " has been decoded and output to the file " 
                + outputFile + ".\n");
        Utils.pause();
    } 

    private static void displayOpeningAndInfo() 
    {
        OpeningScreen opening = new OpeningScreen(
                "Siddiqi:Aitezaz:A00431079:csc34146", 
                "Submission 01", 
                "Decoding Encoded Textfiles");
        opening.display();
        TextItems description = new TextItems(Decoder.class.getResourceAsStream("Decoder.txt"));
        description.displayItem("ProgramInfo");
    }

    public void readEncodedText() 
    {
        StringBuffer textBuilder = new StringBuffer();
        while(inputFile.hasNextLine()) 
            textBuilder.append(inputFile.nextLine() + "\n");
        linesFromText = textBuilder.toString();
    }

    public void decodeEncodedText() 
    {
        StringBuffer decodedBuilder = new StringBuffer();
        Scanner stringScanner = new Scanner(linesFromText);
        while(stringScanner.hasNextLine()) 
            decodedBuilder.append(decode(stringScanner.nextLine()) + "\n");
	//Removes additional \n added
	decodedBuilder.delete(decodedBuilder.length() - 1,
			decodedBuilder.length());
        decodedText = decodedBuilder.toString();
    }

    public void writeOutputFile() 
    {
        outputFile.println(decodedText);
    }

    public void closeOpenedFiles() 
    {
        outputFile.close();
        inputFile.close();
    }

    private static String decode
    (
        String line
    ) 
    {
        int shiftValueTens, shiftValueUnits, lineLengthTens, 
            lineLengthUnits;
        shiftValueTens = (70 - (int) line.charAt(72)); 
        lineLengthTens = 90 - (int) line.charAt(73); 
        shiftValueUnits = (int) line.charAt(74) - 70; 
        lineLengthUnits = (int) line.charAt(75) - 90;
        int shiftValue = (10 * shiftValueTens) + shiftValueUnits;
        int lineLength = ( 10 * lineLengthTens) + lineLengthUnits;
        return decodeLine(line, shiftValue, lineLength);  
    }

    private static String decodeLine
    (
        String line, 
        int shiftValue, 
        int lineLength
    ) 
    {
        StringBuffer decodedLineBuilder = new StringBuffer();
        int toThirtyOne, ASCIIToPrint; //Required when wrapping

        for (int i = 0; i < lineLength; i++) 
        {
            int currentASCII = (int) line.charAt(i);
            char toPrint;
            if (currentASCII - shiftValue > 31)
                toPrint = (char) (currentASCII - shiftValue);
            else
            {
                toThirtyOne = currentASCII - 31;
                ASCIIToPrint = 126 - (shiftValue - toThirtyOne);
                toPrint = (char) ASCIIToPrint;
            } 
            decodedLineBuilder.append("" + toPrint);
        }   
        return decodedLineBuilder.toString();
    }
}
