/**
 * Driver.java - Driver to test and run the Randomizer program.
 * The program groups a random genre, dialog, and prop together and
 * generates a text document for use by teams entering the Spring
 * Film Festival at Radford University.
 *
 * @author Justin Watts
 * @version 03/22/2016
 */
public class Driver
{
	/**
	 * Main method of Randomizer program. Begins the program.
	 */
	public static void main(String[] args)
	{
		RandomizerWindow window = new RandomizerWindow();
		window.start();
	}
}