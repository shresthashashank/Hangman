
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//import java.io.OutputStream;


public class hang{
	private String s1 = "bagel";
	private int badGuess = 0;
	private int goodGuess = 0;
	private String input;
	private String d = "";
	private int ind = 0;
	private char[] charArr;
	private char c;
	
	
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
	
	

	
	void levelPrinter() {
		Scanner in = new Scanner(System.in);
		while(badGuess<=5 && goodGuess!=s1.length()) {
			
			System.out.println("\nGuess a letter: ");
			input = in.next();
			if (charChecker(input)) {
				c = input.charAt(0);
				ind = s1.indexOf(input);
				if (ind>0) {
					charArr[s1.indexOf(input)*2] = c;
				}
				else charArr[s1.indexOf(input)] = c;
				System.out.println(charArr);
				goodGuess++;
				if(goodGuess == s1.length()) {
					Win();
				}
			}
			else {
				
				badGuess++;
				if (badGuess==1) Level2();
				if (badGuess==2) Level3();
				if (badGuess==3) Level4();
				if (badGuess==4) Level5();
				if(badGuess==5) Level6();
				if (badGuess==6) {
					Level7();
					End();			
					}
				System.out.println(charArr);
				
			}
	
				
			
		}
		
		//if (goodGuess == s1.length()) System.out.println("You won");
		
	}
	

	void introDisplay() {
		System.out.println("██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗    ████████╗ ██████╗     ██╗  ██╗ █████╗ ███╗   ██╗ ██████╗ ███╗   ███╗ █████╗ ███╗   ██╗\r\n" + 
				"██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ╚══██╔══╝██╔═══██╗    ██║  ██║██╔══██╗████╗  ██║██╔════╝ ████╗ ████║██╔══██╗████╗  ██║\r\n" + 
				"██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗         ██║   ██║   ██║    ███████║███████║██╔██╗ ██║██║  ███╗██╔████╔██║███████║██╔██╗ ██║\r\n" + 
				"██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         ██║   ██║   ██║    ██╔══██║██╔══██║██║╚██╗██║██║   ██║██║╚██╔╝██║██╔══██║██║╚██╗██║\r\n" + 
				"╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       ██║   ╚██████╔╝    ██║  ██║██║  ██║██║ ╚████║╚██████╔╝██║ ╚═╝ ██║██║  ██║██║ ╚████║\r\n" + 
				" ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       ╚═╝    ╚═════╝     ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝\r\n" + 
				"                                                                                                                                                        ");
		System.out.println("╔═╗╦  ╔═╗╔═╗╔═╗╔═╗  ╔═╗╔╗╔╦╗╔═╗╦═╗  ╦ ╦╔═╗╦ ╦╦═╗  ╔╗╔╔═╗╔╦╗╔═╗\r\n" + 
				"╠═╝║  ║╣ ╠═╣╚═╗║╣   ║╣ ║║║║ ║╣ ╠╦╝  ╚╦╝║ ║║ ║╠╦╝  ║║║╠═╣║║║║╣ \r\n" + 
				"╩  ╩═╝╚═╝╩ ╩╚═╝╚═╝  ╚═╝╝╚╝╩ ╚═╝╩╚═   ╩ ╚═╝╚═╝╩╚═  ╝╚╝╩ ╩╩ ╩╚═╝");
	}
	
	void SavePrompt() {
		System.out.println(" ▄▀▀▀▀▄  ▄▀▀█▄   ▄▀▀▄ ▄▀▀▄  ▄▀▀█▄▄▄▄      ▄▀▀▄ ▄▄   ▄▀▀█▀▄    ▄▀▀▄ ▄▀▄      ▄▀▀█▀▄    ▄▀▀▀█▄        ▄▀▀▄ ▄▀▀▄      ▄▀▄▄▄▄   ▄▀▀█▄   ▄▀▀▄ ▀▄ \r\n" + 
				"█ █   ▐ ▐ ▄▀ ▀▄ █   █    █ ▐  ▄▀   ▐     █  █   ▄▀ █   █  █  █  █ ▀  █     █   █  █  █  ▄▀  ▀▄     █   █    █     █ █    ▌ ▐ ▄▀ ▀▄ █  █ █ █ \r\n" + 
				"   ▀▄     █▄▄▄█ ▐  █    █    █▄▄▄▄▄      ▐  █▄▄▄█  ▐   █  ▐  ▐  █    █     ▐   █  ▐  ▐ █▄▄▄▄       ▐  █    █      ▐ █        █▄▄▄█ ▐  █  ▀█ \r\n" + 
				"▀▄   █   ▄▀   █    █   ▄▀    █    ▌         █   █      █       █    █          █      █    ▐         █    █         █       ▄▀   █   █   █  \r\n" + 
				" █▀▀▀   █   ▄▀      ▀▄▀     ▄▀▄▄▄▄         ▄▀  ▄▀   ▄▀▀▀▀▀▄  ▄▀   ▄▀        ▄▀▀▀▀▀▄   █               ▀▄▄▄▄▀       ▄▀▄▄▄▄▀ █   ▄▀  ▄▀   █   \r\n" + 
				" ▐      ▐   ▐               █    ▐        █   █    █       █ █    █        █       █ █                            █     ▐  ▐   ▐   █    ▐   \r\n" + 
				"                            ▐             ▐   ▐    ▐       ▐ ▐    ▐        ▐       ▐ ▐                            ▐                ▐        ");
		
	}
	
	void Man() {
		System.out.println("   _________    .-----------------------------. \r\n" + 
				"          ////////\\\\\\  (Please save me by choosing the correct words or I will be Hanged.... )\r\n" + 
				"         // __   __ \\\\ /'-----------------------------'\r\n" + 
				"        // (()) (()) \\\\\r\n" + 
				"       (_    (___)    _)\r\n" + 
				"         \\  ______  /\r\n" + 
				"          `-._   _.-'\r\n" + 
				"          __.-)_(-,__ \r\n" + 
				"       ./'  \\_\\_/_/  `\\.\r\n" + 
				"      / >   | //\\ |   < \\\r\n" + 
				"     /  \\   | |/| |   /  \\\r\n" + 
				"    /   |\\  | |/| |  /|   \\\r\n" + 
				"   /   /| \\ | |/| | / |\\   \\\r\n" + 
				"  (   ( |  \\| |/| |/  | )   )\r\n" + 
				"   \\   \\|   Y |/| Y   |/   /\r\n" + 
				"    \\   |  o| |/| |-  |   /\r\n" + 
				"     `\\ |   | `^` |   | /'\r\n" + 
				"       `|  o|=[Ll=|-  |'\r\n" + 
				"        |   /     \\   |\r\n" + 
				"        ~~|`  \\    `|~~\r\n" + 
				"          |    |    |\r\n" + 
				"          |    |    |\r\n" + 
				"          |    |    |\r\n" + 
				"          |    |    |\r\n" + 
				"          |    |    |\r\n" + 
				"          |    |    |\r\n" + 
				"          |    |    |\r\n" + 
				"          |    |    |\r\n" + 
				"          |____|____|\r\n" + 
				"          /   / \\   \\\r\n" + 
				"     	  /   /   \\   \\\r\n" + 
				"        `---'     `---`\r\n" + 
				" ");
	}
		
	
	void hang1(){
		System.out.println(" +----+\r\n" + 
				" |    |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"=========");
	}
	void Level1() {
		System.out.println(" +----+\r\n" + 
				" |    |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"=========");
	}
	void Level2() {
		System.out.println(" +---+\r\n" + 
				"  |   |\r\n" + 
				"  O   |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"=========");
	}
	void Level3() {
		System.out.println(" +---+\r\n" + 
				"  |   |\r\n" + 
				"  O   |\r\n" + 
				"  |   |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"=========");
	}
	void Level4() {
		System.out.println("  +---+\r\n" + 
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
		System.out.println(" +---+\r\n" + 
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
	
		System.out.println("▓██   ██▓ ▒█████   █    ██     ██▓    ▓█████▄▄▄█████▓    ███▄ ▄███▓▓█████    ▓█████▄  ██▓▓█████                                                                 \r\n" + 
				" ▒██  ██▒▒██▒  ██▒ ██  ▓██▒   ▓██▒    ▓█   ▀▓  ██▒ ▓▒   ▓██▒▀█▀ ██▒▓█   ▀    ▒██▀ ██▌▓██▒▓█   ▀                                                                 \r\n" + 
				"  ▒██ ██░▒██░  ██▒▓██  ▒██░   ▒██░    ▒███  ▒ ▓██░ ▒░   ▓██    ▓██░▒███      ░██   █▌▒██▒▒███                                                                   \r\n" + 
				"  ░ ▐██▓░▒██   ██░▓▓█  ░██░   ▒██░    ▒▓█  ▄░ ▓██▓ ░    ▒██    ▒██ ▒▓█  ▄    ░▓█▄   ▌░██░▒▓█  ▄                                                                 \r\n" + 
				"  ░ ██▒▓░░ ████▓▒░▒▒█████▓    ░██████▒░▒████▒ ▒██▒ ░    ▒██▒   ░██▒░▒████▒   ░▒████▓ ░██░░▒████▒ ██▓  ██▓  ██▓  ██▓                                             \r\n" + 
				"   ██▒▒▒ ░ ▒░▒░▒░ ░▒▓▒ ▒ ▒    ░ ▒░▓  ░░░ ▒░ ░ ▒ ░░      ░ ▒░   ░  ░░░ ▒░ ░    ▒▒▓  ▒ ░▓  ░░ ▒░ ░ ▒▓▒  ▒▓▒  ▒▓▒  ▒▓▒                                             \r\n" + 
				" ▓██ ░▒░   ░ ▒ ▒░ ░░▒░ ░ ░    ░ ░ ▒  ░ ░ ░  ░   ░       ░  ░      ░ ░ ░  ░    ░ ▒  ▒  ▒ ░ ░ ░  ░ ░▒   ░▒   ░▒   ░▒                                              \r\n" + 
				" ▒ ▒ ░░  ░ ░ ░ ▒   ░░░ ░ ░      ░ ░      ░    ░         ░      ░      ░       ░ ░  ░  ▒ ░   ░    ░    ░    ░    ░                                               \r\n" + 
				" ░ ░         ░ ░     ░            ░  ░   ░  ░                  ░      ░  ░      ░     ░     ░  ░  ░    ░    ░    ░                                              \r\n" + 
				" ░ ░                                                                          ░                   ░    ░    ░    ░                                              \r\n" + 
				" ██▓    █     █░ ██▓ ██▓     ██▓        ██░ ██  ▄▄▄       █    ██  ███▄    █ ▄▄▄█████▓   ▓██   ██▓ ▒█████   █    ██     ███▄    █  ▒█████   █     █░ ▐██▌  ▐██▌ \r\n" + 
				"▓██▒   ▓█░ █ ░█░▓██▒▓██▒    ▓██▒       ▓██░ ██▒▒████▄     ██  ▓██▒ ██ ▀█   █ ▓  ██▒ ▓▒    ▒██  ██▒▒██▒  ██▒ ██  ▓██▒    ██ ▀█   █ ▒██▒  ██▒▓█░ █ ░█░ ▐██▌  ▐██▌ \r\n" + 
				"▒██▒   ▒█░ █ ░█ ▒██▒▒██░    ▒██░       ▒██▀▀██░▒██  ▀█▄  ▓██  ▒██░▓██  ▀█ ██▒▒ ▓██░ ▒░     ▒██ ██░▒██░  ██▒▓██  ▒██░   ▓██  ▀█ ██▒▒██░  ██▒▒█░ █ ░█  ▐██▌  ▐██▌ \r\n" + 
				"░██░   ░█░ █ ░█ ░██░▒██░    ▒██░       ░▓█ ░██ ░██▄▄▄▄██ ▓▓█  ░██░▓██▒  ▐▌██▒░ ▓██▓ ░      ░ ▐██▓░▒██   ██░▓▓█  ░██░   ▓██▒  ▐▌██▒▒██   ██░░█░ █ ░█  ▓██▒  ▓██▒ \r\n" + 
				"░██░   ░░██▒██▓ ░██░░██████▒░██████▒   ░▓█▒░██▓ ▓█   ▓██▒▒▒█████▓ ▒██░   ▓██░  ▒██▒ ░      ░ ██▒▓░░ ████▓▒░▒▒█████▓    ▒██░   ▓██░░ ████▓▒░░░██▒██▓  ▒▄▄   ▒▄▄  \r\n" + 
				"░▓     ░ ▓░▒ ▒  ░▓  ░ ▒░▓  ░░ ▒░▓  ░    ▒ ░░▒░▒ ▒▒   ▓▒█░░▒▓▒ ▒ ▒ ░ ▒░   ▒ ▒   ▒ ░░         ██▒▒▒ ░ ▒░▒░▒░ ░▒▓▒ ▒ ▒    ░ ▒░   ▒ ▒ ░ ▒░▒░▒░ ░ ▓░▒ ▒   ░▀▀▒  ░▀▀▒ \r\n" + 
				" ▒ ░     ▒ ░ ░   ▒ ░░ ░ ▒  ░░ ░ ▒  ░    ▒ ░▒░ ░  ▒   ▒▒ ░░░▒░ ░ ░ ░ ░░   ░ ▒░    ░        ▓██ ░▒░   ░ ▒ ▒░ ░░▒░ ░ ░    ░ ░░   ░ ▒░  ░ ▒ ▒░   ▒ ░ ░   ░  ░  ░  ░ \r\n" + 
				" ▒ ░     ░   ░   ▒ ░  ░ ░     ░ ░       ░  ░░ ░  ░   ▒    ░░░ ░ ░    ░   ░ ░   ░          ▒ ▒ ░░  ░ ░ ░ ▒   ░░░ ░ ░       ░   ░ ░ ░ ░ ░ ▒    ░   ░      ░     ░ \r\n" + 
				" ░         ░     ░      ░  ░    ░  ░    ░  ░  ░      ░  ░   ░              ░              ░ ░         ░ ░     ░                 ░     ░ ░      ░     ░     ░    \r\n" + 
				"                                                                                          ░ ░                                                                   ");
	}
	
	static void Win() {
		System.out.println(" _   _                                 _      _  _                                                                                              \r\n" + 
				"( ) ( )                               ( )    ( )( )                                                                                             \r\n" + 
				"| |_| |   _    _ __  _ __  _ __   _ _ | |__  | || |                                                                                             \r\n" + 
				"|  _  | /'_`\\ ( '__)( '__)( '__)/'_` )|  _ `\\| || |                                                                                             \r\n" + 
				"| | | |( (_) )| |   | |   | |  ( (_| || | | || || |                                                                                             \r\n" + 
				"(_) (_)`\\___/'(_)   (_)   (_)  `\\__,_)(_) (_)(_)(_)                                                                                             \r\n" + 
				"                                             (_)(_)                                                                                             \r\n" + 
				"                                                                                                                                                \r\n" + 
				" _____  _                    _                                   ___                                                                            \r\n" + 
				"(_   _)( )                  ( )                                /'___)                                   _                                       \r\n" + 
				"  | |  | |__     _ _   ___  | |/')     _   _    _    _   _    | (__   _    _ __      ___    _ _  _   _ (_)  ___     __       ___ ___     __     \r\n" + 
				"  | |  |  _ `\\ /'_` )/' _ `\\| , <     ( ) ( ) /'_`\\ ( ) ( )   | ,__)/'_`\\ ( '__)   /',__) /'_` )( ) ( )| |/' _ `\\ /'_ `\\   /' _ ` _ `\\ /'__`\\   \r\n" + 
				"  | |  | | | |( (_| || ( ) || |\\`\\    | (_) |( (_) )| (_) |   | |  ( (_) )| |      \\__, \\( (_| || \\_/ || || ( ) |( (_) |   | ( ) ( ) |(  ___/ _ \r\n" + 
				"  (_)  (_) (_)`\\__,_)(_) (_)(_) (_)   `\\__, |`\\___/'`\\___/'   (_)  `\\___/'(_)      (____/`\\__,_)`\\___/'(_)(_) (_)`\\__  |   (_) (_) (_)`\\____)(_)\r\n" + 
				"                                      ( )_| |                                                                    ( )_) |                        \r\n" + 
				"                                      `\\___/'                                                                     \\___/'                        ");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		hang h = new hang();
		h.introDisplay();
		String name = sc.nextLine();
		h.SavePrompt();
		h.Man();
		h.hang1();
		h.dashGenerator();
		h.levelPrinter();
		
		
	}	
}

