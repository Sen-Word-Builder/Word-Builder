/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbuilder;
import edu.smu.tspell.wordnet.*;
import java.util.Scanner;





/**
 * Displays word forms and definitions for synsets containing the word form
 * specified on the command line. To use this application, specify the word
 * form that you wish to view synsets for, as in the following example which
 * displays all synsets containing the word form "airplane":
 * <br>
 * java TestJAWS airplane
 */
/**
 *
 * @author snooze-wake
 */
public class ApiFetch {
    


	/**
	 * Main entry point. The command-line arguments are concatenated together
	 * (separated by spaces) and used as the word form to look up.
	 */
	public static void main (String[] args)
	{
		if (true)
		{
			//  Concatenate the command-line arguments
			StringBuffer buffer = new StringBuffer();
			/*for (int i = 0; i < args.length; i++)
			{
				buffer.append((i > 0 ? " " : "") + args[i]);
			}*/
                    
		//	String wordForm = buffer.toString();
                        Scanner in = new Scanner(System.in);
                        String wordForm = in.nextLine();
			WordSense []test = new WordSense[1];
			System.out.println(wordForm);
			//  Get the synsets containing the wrod form
			WordNetDatabase database = WordNetDatabase.getFileInstance();
			Synset[] synsets = database.getSynsets(wordForm);
			//System.out.println(database.getTagCount("kick"));
			//  Display the word forms and definitions for synsets retrieved
			if (synsets.length > 0)
			{
				System.out.println("The following synsets contain '" +
						wordForm + "' or a possible base form " +
						"of that text:");
				for (int i = 0; i < synsets.length; i++)
				{
					System.out.println("");
					String[] wordForms = synsets[i].getWordForms();
					//System.out.println(synsets[i].getTagCount("kick"));
					test = synsets[i].getAntonyms("left");
					//if (test[0] != null)
					//System.out.println(test[0]);
					for (int j = 0; j < wordForms.length; j++)
					{
					//	System.out.print((j > 0 ? ", " : "") +
								System.out.print(wordForms[j]);
					}
					System.out.println(": " + synsets[i].getDefinition());
				}
			}
			else
			{
				System.err.println("No synsets exist that contain " +
						"the word form '" + wordForm + "'");
			}
		}
		else
		{
			System.err.println("You must specify " +
					"a word form for which to retrieve synsets.");
		}
	}

}