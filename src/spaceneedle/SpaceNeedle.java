/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceneedle;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author s-yinb
 */
public class SpaceNeedle {
    //public static final int LENGTH = 20;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] inputs = new int[4];
        inputs[0] = Integer.parseInt(prompt("tower Width?"));
        inputs[1] = Integer.parseInt(prompt("tower Height?"));
        inputs[2] = Integer.parseInt(prompt("spire Height?"));
        inputs[3] = Integer.parseInt(prompt("thing Height?"));
        String toDraw = drawSpaceNeedle(inputs[0], inputs[1], inputs[2], inputs[3]);
        System.out.println(toDraw)
    }
    public static String prompt(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextLine();
    }

    public static String drawSpaceNeedle(int spireHeight, int towerHeight, int towerWidth, int thingHeight) {
    	String total = spire(spireHeight);
    	total += "      _/||\\_\n"+
    	         "    _/**||**\\_\n"+
    	         "  _/****||****\\_\n"+
    	         "|\"\"\"\"\"\"\"\"\"\"\"\"\"\"|"+
    	         "\\_\"\"\"\"\"\"\"\"\"\"\"\"_/"+
    	         " \\_\"\"\"\"\"\"\"\"\"\"\"_/"+
    	         "  \\_\"\"\"\"\"\"\"\"\"\"_/"+
    	         "   \\_\"\"\"\"\"\"\"\"\"_/"+
    	         "    \\_\"\"\"\"\"\"\"\"_/"+
    	         "     \\_\"\"\"\"\"\"\"_/"+
    	         "      \\_\"\"\"\"\"\"_/"+
    	         "       \\_\"\"\"\"\"_/"+
    	         "        \\_\"\"\"\"_/"+
    	         "         \\_\"\"_/";
    	 total += spire(thingHeight);
    	 total += tower(towerHeight, towerWidth);
    	 total +="      _/||\\_\n"+
    	         "    _/**||**\\_\n"+
    	         "  _/****||****\\_\n";
    	         
    }
    public static String spire(int spireHeight){
        String total = "";	
        for(int i = 0; i < spireHeight-1; i++){
            total += "        ||\n"
    	}
        return total;
    }
    public static String tower(int height, int width){
         String total =  "";
         String given = "";
        for(int i = 0; i < 6-width)
            given += " ";
        given +="|";
        for(int i = 0; i < width;i++)
            given+="%";
        given +="|\n";
        for(int i = 0; i < height; i++)
            total+= given;
         return total;
    }
}
