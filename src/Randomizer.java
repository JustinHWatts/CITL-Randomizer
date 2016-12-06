import java.io.*;
import java.util.Random;

/**
 * Randomizer.java - Takes data for genres, dialog, and props for use by the CITL department
 * of Radford University in the Spring Film Festival and randomly groups together one from each 
 * category. These groups are then generated into text documents for teams entering the film
 * festival.
 *
 * @author Justin Watts
 * @version 03/22/2016
 */
public class Randomizer
{
	private String[] genres, dialog, props;
	
	/**
	 * Constructor for Randomizer class. Contains genre, dialog, and prop data.
	 */
	public Randomizer()
	{
		this.genres = new String[] {"Drama", "Dystopia", "Love", "Mystery", "Science Fiction", "Time Travel"};
		
		this.dialog = new String[] {"You keep using that word. I do not think it means what you think it means.", 
				"Be afraid. Be very afraid.", 
				"Laugh it up, fuzzball!", 
				"No sir, I didn’t see you playing with your dolls again!", 
				"Ever seen a guy say goodbye to a shoe?", 
				"I was dreaming about dogs.", 
				"I am insane. And you are my insanity.",
				"Do you want me to send you back to where you were? Unemployed, in Greenland?!!",
				"This is what I call my punching face."};
		
		this.props = new String[] {"Football", "How-To Book", "Musical Instrument", "Mustard Bottle", 
				"Newspaper", "Scarf", "Stuffed Bear", "Tiara"};
	}
	
	/**
	 * Takes an array and randomizes its contents
	 * @param array array to be randomized
	 * @return shuffled array
	 */
	public String[] shuffle(String[] array)
	{
		Random rgen = new Random();	
 
		for (int i=0; i<array.length; i++)
		{
		    int randomPosition = rgen.nextInt(array.length);
		    String temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
		return array;
	}
	
	/**
	 * Randomly groups values from genres, dialog, and props and generates a document for
	 * each group based on the input value.
	 * @param value integer value which dictates number of documents to generate
	 */
	public void run(int value)
	{
		int i = 1;
		int genreCount = 1;
		int dialogCount = 1;
		int propCount = 1;
		String filename = "";
		String genreChoice = "";
		String dialogChoice = "";
		String propChoice = "";
		
		this.genres = shuffle(this.genres);
		this.dialog = shuffle(this.dialog);
		this.props = shuffle(this.props);
		
		String genreResult = "";
		String dialogResult = "";
		String propResult = "";
		
		BufferedWriter writer = null;
		
		while (i <= value)
		{
			if (genreCount == 6) //shuffle array once fully run through
			{
				genreChoice = this.genres[genreCount - 1];
				this.genres = shuffle(this.genres);
				genreCount = 1;
			}
			else
			{
				genreChoice = this.genres[genreCount - 1];
				genreCount++;
			}
			
			if (dialogCount == 9) //shuffle array once fully run through
			{
				dialogChoice = this.dialog[dialogCount - 1];
				this.dialog = shuffle(this.dialog);
				dialogCount = 1;
			}
			else
			{
				dialogChoice = this.dialog[dialogCount - 1];
				dialogCount++;
			}
			
			if (propCount == 8) //shuffle array once fully run through
			{
				propChoice = this.props[propCount - 1];
				this.props = shuffle(this.props);
				propCount = 1;
			}
			else
			{
				propChoice = this.props[propCount - 1];
				propCount++;
			}
			
			filename = "FilmChallengeSet" + i + ".txt";
			genreResult = "Genre: " + genreChoice;
			dialogResult = "Dialog: " + dialogChoice;
			propResult = "Prop: " + propChoice;
			
			try
			{
	            File file = new File(filename);

	            writer = new BufferedWriter(new FileWriter(file));
	            writer.write(genreResult);
				writer.newLine();
				writer.write(dialogResult);
				writer.newLine();
				writer.write(propResult);
				writer.newLine();
				writer.newLine();
				writer.write("MOVIE TITLE: ___________________________________________________________");
				writer.newLine();
				writer.newLine();
				writer.write("TEAM MEMBERS: __________________________________________________________");
				writer.newLine();
				writer.newLine();
				writer.write("CONTACT EMAIL: _________________________________________________________");
				writer.close();
	        }
			catch (Exception e)
			{
	            e.printStackTrace();
	        }
			finally
			{
	            try
	            {
	                writer.close();
	            }
	            catch (Exception e)
	            {
	            }
	        }
			
			i++;
		}
	}
}