// Name :Sugumar Raja
//Java Project-Tiktac game

package javaproject;
import java.util.Scanner;

public class TikTacProject {
	 static int playercount=0;
	public static String tiktacboard[][]= {{"00","01","02"},{"10","11","12"},{"20","21","22"}};
	public static void printboard() {
		for(int i=0;i<tiktacboard.length;i++) {
			for( int j=0;j<tiktacboard[i].length;j++) {
				System.out.print(tiktacboard[i][j]+" |");	
			}
			System.out.println();
		}
	}
	public static void greetings(Scanner scanner) {
		int x=0;
		int y=0;
		System.out.println(playercount%2==0?"player X":"player O");
		System.out.println("Enter x value");
		x=scanner.nextInt();
		System.out.println("Enter y value");
		y=scanner.nextInt();
		System.out.println(insert(x,y,playercount%2==0?" X":"O"));
	}
	public static String insert(int x,int y,String playername) {
		if((x<3&&x>=0)&&(y<3&&y>=0)) {
			if(!tiktacboard[x][y].equals("X")&&!tiktacboard[x][y].equals("O")) {
				tiktacboard[x][y]=playername;
				printboard();
				playercount++;
				if(check()) {
					System.out.println(playername+"WINS !!!");
					System.exit(0);
				}
				else if(playercount==9) {
					System.out.println("DRAW MATCH !!!");
					System.exit(0);
				}
				return "inserted";
			}
			return "Already Occupied";
		}
		return "unexpected index location";
	}
	public static boolean check() {
        //Row
		for(int i=0;i<3;i++) {
			if(tiktacboard[i][0].equals(tiktacboard[i][1])
			   &&tiktacboard[i][1].equals(tiktacboard[i][2])
			   &&!tiktacboard[i][0].equals("")) {
				return true;
			}}
       //Column
			for(int j=0;j<3;j++) {
				if(tiktacboard[0][j].equals(tiktacboard[1][j])
				   &&tiktacboard[2][j].equals(tiktacboard[0][j])
				   &&!tiktacboard[j][0].equals("")) {
					return true;
				}
		}
        //Diagonal
			if(tiktacboard[0][2].equals(tiktacboard[1][1])
			 &&tiktacboard[1][1].equals(tiktacboard[2][0])
			 &&!tiktacboard[0][2].equals("")) {
				return true;
			}
			if(tiktacboard[0][0].equals(tiktacboard[1][1])
					 &&tiktacboard[1][1].equals(tiktacboard[2][2])
					 &&!tiktacboard[0][0].equals("")) {
						return true;
					}	
			return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
	 while(true) {
	     greetings(scanner);
	 }
		
	}

}
