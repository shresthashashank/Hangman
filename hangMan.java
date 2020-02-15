
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import javax.sound.sampled.*;



public class hangMan {
	private String s1;
	private int badGuess = 0;
	private int goodGuess = 0;
	private String input;
	private String d = "";
	private int ind = 0;
	private char[] charArr;
	private char c;
	private int diff;
	private String hint;
	
	public static final Random RANDOM = new Random();
	public static final String[] EASY = {"bagel", "change", "vista", "gnome"};
	public static final String[] MEDIUM = {"abruptly", "bachelor", "cabinets", "egyptian"};
	public static final String[] HARD = {"artichokes", "binoculars", "blacksmith", "chivalrous"};
	
	
	private String newWord() {
		if (diff==1)
			return EASY[RANDOM.nextInt(EASY.length)];
		if(diff==2)
			return MEDIUM[RANDOM.nextInt(MEDIUM.length)];
		
		return HARD[RANDOM.nextInt(HARD.length)];
		

	}
	
	
	
	public static void playMusic(File Sound) {
		try {
			
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(Sound);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
			
		}
		catch(Exception e) {
			
		}
	}
	
	hangMan() {
		HashMap<String , String> easy_map = new HashMap<>();
		HashMap<String , String> medium_map = new HashMap<>();
		HashMap<String ,String> hard_map = new HashMap<>();
		
		easy_map.put("bagel","Type of Bread");
		easy_map.put("change","Make or become different");
		easy_map.put("vista","A pleasing view");
		easy_map.put("gnome","A dwarf who guards treasure");
		medium_map.put("abruptly","Suddenly and unexpectedly");
		medium_map.put("bachelor","An unmarried male");
		medium_map.put("cabinets","A cupboard with shelves");
		medium_map.put("egyptian","A person from Egypt");
		hard_map.put("artichokes","A European plant resembling a thistle");
		hard_map.put("binoculars","An optical instrument.");
		hard_map.put("blacksmith","Person who repairs and makes things in iron by hand");
		hard_map.put("chivalrous","Courteous and Gallant");
		
		System.out.println(" __    __       ___      .__   __.   _______ .___  ___.      ___      .__   __. \r\n" + 
				"|  |  |  |     /   \\     |  \\ |  |  /  _____||   \\/   |     /   \\     |  \\ |  | \r\n" + 
				"|  |__|  |    /  ^  \\    |   \\|  | |  |  __  |  \\  /  |    /  ^  \\    |   \\|  | \r\n" + 
				"|   __   |   /  /_\\  \\   |  . `  | |  | |_ | |  |\\/|  |   /  /_\\  \\   |  . `  | \r\n" + 
				"|  |  |  |  /  _____  \\  |  |\\   | |  |__| | |  |  |  |  /  _____  \\  |  |\\   | \r\n" + 
				"|__|  |__| /__/     \\__\\ |__| \\__|  \\______| |__|  |__| /__/     \\__\\ |__| \\__| \r\n" + 
				"                                                                                ");
		
		System.out.println("Created by Shashank Shrestha, Diresh Shrestha and Cameron Emfinger");
		System.out.println();
		Scanner in = new Scanner(System.in);
		System.out.println("Select Difficulty");
		System.out.println("1. EASY\n2. MEDIUM\n3. HARD");
		diff = in.nextInt();
		s1 = newWord();
		
		if(diff==1) hint = easy_map.get(s1);

		if(diff==2)	hint = medium_map.get(s1);
		
		if(diff==3) hint = hard_map.get(s1);

		System.out.println(" +----+\r\n" + 
				" |    |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"=========");
	}
	
	boolean charChecker(String a) {
		if (s1.contains(a)) {
			return true;
		}
		return false;
		
	}
	
	
	String dashGenerator() {
		for (int i=0; i<s1.length(); i++) {
			d = d + "_ ";
		}
		charArr = d.toCharArray();
		System.out.println(d);
		return d;
		
	}
	
	
	void levelPrinter() throws IOException {
		File right = new File("right.wav");
		File bad = new File("wrong.wav");
		
		
		Scanner in = new Scanner(System.in);
		HashSet<String> hs = new HashSet<>();
		while(badGuess<=5 && goodGuess!=s1.length()) {
			
			System.out.println("\nGuess a letter: ");
			input = in.next();
			Reader reader = new StringReader(input);
			if (charChecker(input)) {
				playMusic(right);
				c = input.charAt(0);
				ind = s1.indexOf(input);
				if (ind>0) {
					charArr[s1.indexOf(input)*2] = c;
				}
				else charArr[s1.indexOf(input)] = c;
				System.out.println(charArr);
				
				if(hs.contains(input)) {
					System.out.println("You've already tried that letter");
				}
				else {
				hs.add(input);
				goodGuess++;
				}
				//old_input = c;
				
			}
			else {
				playMusic(bad);
				if (hs.contains(input)) System.out.println("You've already tried that letter");
				hs.add(input);
				
				Iterator<String> i = hs.iterator();
				
				badGuess++;
				if (badGuess==1) Level2();
				if (badGuess==2) Level3();
				if (badGuess==3) Level4();
				if (badGuess==4) {
					Level5();
					System.out.println("Do you want a hint(y/n): ");
					Scanner sc = new Scanner(System.in);
					String input1 = sc.next();
					if(input1.equalsIgnoreCase("Y")){
						System.out.println(hint);
					}
					
				}
				if(badGuess==5) Level6();
				if (badGuess==6) {
					Level7();
					End();			
					}
				
				System.out.println(charArr);
				System.out.println();

				System.out.println("Letters you've tried: ");
				while(i.hasNext()) {
					System.out.print(i.next() + " ");
				}
				
			}
			reader.reset();
	
				
			
		}
		
		if (goodGuess == s1.length()) {
			System.out.println("____    ____   ______    __    __      __       __  ____    ____  _______  _______  \r\n" + 
					"\\   \\  /   /  /  __  \\  |  |  |  |    |  |     |  | \\   \\  /   / |   ____||       \\ \r\n" + 
					" \\   \\/   /  |  |  |  | |  |  |  |    |  |     |  |  \\   \\/   /  |  |__   |  .--.  |\r\n" + 
					"  \\_    _/   |  |  |  | |  |  |  |    |  |     |  |   \\      /   |   __|  |  |  |  |\r\n" + 
					"    |  |     |  `--'  | |  `--'  |    |  `----.|  |    \\    /    |  |____ |  '--'  |\r\n" + 
					"    |__|      \\______/   \\______/     |_______||__|     \\__/     |_______||_______/ \r\n" + 
					"                                                                                    ");
		}
		
	}
	
	void Level1() {
		System.out.println(" \n+----+\r\n" + 
				" |    |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"=========");
	}
	void Level2() {
		System.out.println(" \n+---+\r\n" + 
				"  |   |\r\n" + 
				"  O   |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"=========");
	}
	void Level3() {
		System.out.println(" \n+---+\r\n" + 
				"  |   |\r\n" + 
				"  O   |\r\n" + 
				"  |   |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"=========");
	}
	void Level4() {
		System.out.println("  \n+---+\r\n" + 
				"  |   |\r\n" + 
				"  O   |\r\n" + 
				" /|   |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"=========");
	}
	void Level5() {
		System.out.println("\r\n" + 
				"  +---+\r\n" + 
				"  |   |\r\n" + 
				"  O   |\r\n" + 
				" /|\\  |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"=========\r\n" + 
				"");
	}
	void Level6() {
		System.out.println(" \n+---+\r\n" + 
				"  |   |\r\n" + 
				"  O   |\r\n" + 
				" /|\\  |\r\n" + 
				" /    |\r\n" + 
				"      |\r\n" + 
				"=========");
	}
	void Level7() {
		System.out.println("\r\n" + 
				"  +---+\r\n" + 
				"  |   |\r\n" + 
				"  O   |\r\n" + 
				" /|\\  |\r\n" + 
				" / \\  |\r\n" + 
				"      |\r\n" + 
				"=========");
	}
	static void End() {
		System.out.println(" |_______________``\\\r\n" + 
				"    [/]           [  ]\r\n" + 
				"    [\\]           | ||\r\n" + 
				"    [/]           |  |\r\n" + 
				"    [\\]           |  |\r\n" + 
				"    [/]           || |\r\n" + 
				"   [---]          |  |\r\n" + 
				"   [---]          |@ |\r\n" + 
				"   [---]          |  |\r\n" + 
				"  oOOOOOo         |  |\r\n" + 
				" oOO___OOo        | @|\r\n" + 
				"oO/|||||\\Oo       |  |\r\n" + 
				"OO/|||||\\OOo      |  |\r\n" + 
				"*O\\ x x /OO*      |  |\r\n" + 
				"/*|  c  |O*\\      |  |\r\n" + 
				"   \\_O_/    \\     |  |\r\n" + 
				"    \\#/     |     |  |\r\n" + 
				" |       |  |     | ||\r\n" + 
				" |       |  |_____| ||__\r\n" + 
				"_/_______\\__|  \\  ||||  \\\r\n" + 
				"/         \\_|\\  _ | ||\\  \\\r\n" + 
				"|    V    |\\  \\//\\  \\  \\  \\\r\n" + 
				"|    |    | __//  \\  \\  \\  \\\r\n" + 
				"|    |    |\\|//|\\  \\  \\  \\  \\\r\n" + 
				"------------\\--- \\  \\  \\  \\  \\\r\n" + 
				"\\  \\  \\  \\  \\  \\  \\  \\  \\  \\  \\\r\n" + 
				"_\\__\\__\\__\\__\\__\\__\\__\\__\\__\\__\\\r\n" + 
				"__|__|__|__|__|__|__|__|__|__|__|\r\n" + 
				"|___| |___|\r\n" + 
				"|###/ \\###|\r\n" + 
				"\\##/   \\##/\r\n" + 
				" ``     `` \r\n" + 
				"\r\n" + 
				"");
		System.out.println("____    ____   ______    __    __      _______   __   _______  _______  \r\n" + 
				"\\   \\  /   /  /  __  \\  |  |  |  |    |       \\ |  | |   ____||       \\ \r\n" + 
				" \\   \\/   /  |  |  |  | |  |  |  |    |  .--.  ||  | |  |__   |  .--.  |\r\n" + 
				"  \\_    _/   |  |  |  | |  |  |  |    |  |  |  ||  | |   __|  |  |  |  |\r\n" + 
				"    |  |     |  `--'  | |  `--'  |    |  '--'  ||  | |  |____ |  '--'  |\r\n" + 
				"    |__|      \\______/   \\______/     |_______/ |__| |_______||_______/ \r\n" + 
				"                                                                        \r\n" + 
				"");
	}
	
	
	public static void main(String[] args) throws IOException {
		
		hangMan h = new hangMan();
		
		h.dashGenerator();
		h.levelPrinter();
		
		
	}



	

}



	
