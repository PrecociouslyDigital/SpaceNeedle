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
        int[] inputs = new int[6];
        inputs[0] = Integer.parseInt(prompt("tower Width?"));
        inputs[1] = Integer.parseInt(prompt("tower Height?"));
        inputs[2] = Integer.parseInt(prompt("top Width?"));
        inputs[3] = Integer.parseInt(prompt("base Width?"));
        inputs[4] = Integer.parseInt(prompt("spire Height?"));
        inputs[5] = Integer.parseInt(prompt("thing Height?"));
        ArrayList<String> toDraw = drawSpaceNeedle(inputs[0], inputs[1], inputs[2], inputs[3], inputs[4], inputs[5]);
        for(String s : toDraw)
            System.out.println(s);
    }
    public static String prompt(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextLine();
    }

    public static ArrayList<String> drawSpaceNeedle(int towerWidth, int towerHeight, int topWidth, int baseWidth, int spireHeight, int thingHeight) {
    	ArrayList<String> total = new ArrayList<>();
    	total.addAll(spire(spireHeight, topWidth));
        total.addAll(recursiveTop(topWidth*2, topWidth*2));
        String draw = "|";
        for(int i = 0; i < topWidth; i++)
            draw += "\"\"\"\"\"\"";
        draw += "|";
        total.add(draw);
        total.addAll(recursiveBottom(topWidth*3, 0));
        total.addAll(spire(thingHeight, topWidth));
        total.addAll(tower(towerHeight, towerWidth));
        total.addAll(recursiveTop(baseWidth, baseWidth));
        return total;
    }
    public static ArrayList<String> spire(int spireHeight, int topWidth){
        ArrayList<String> total = new ArrayList<>();	
        for(int i = 0; i < spireHeight-1; i++){
            String draw = "";
    		for(int j = 0; j < topWidth * 6; j++){
    			draw = draw + " ";
    		}
            total.add(draw);
    	}
        return total;
    }
    public static ArrayList<String> recursiveTop(int length, int space){
        if(length == 1){
            return new ArrayList<String>();
        }else{
        ArrayList tot = new ArrayList<>();
        tot.addAll(recursiveTop(length-1,space+1));
        String total = "";
        for(int i = 0; i < space; i++)
            total+="   ";
        total+= "_/";
        for(int i = 0; i < length; i++){
            total+=":::";
        }
        total += "||";
        for(int i = 0; i < length; i++){
            total+=":::";
        }
        total += "\\_";
        return tot;
        }
    }
    public static ArrayList<String> recursiveBottom(int length, int space){
        if(length == 1){
            return new ArrayList<String>();
        }else{
            
        ArrayList<String> total = new ArrayList<>();
        String tot = "";
        for(int i = 0; i < space; i++)
            tot+="  ";
        tot += "\\_";
        
        for(int i = 0; i<length-1; i += 2){
            tot +="/\\";
        }
        tot+="_/";
        total.add(tot);
        total.addAll(recursiveBottom(length-1, space+1));
        return total;
        }
    }
    public static ArrayList<String> tower(int height, int width){
         ArrayList<String> total = new ArrayList<>();
         String draw = "|";
         for(int i = 0; i < width; i++)
             draw+="%";
         draw+="|";
         for(int i = 0; i < width; i++)
             draw+="%";
         draw+="|";
         for(int i = 0; i < height; i++)
            total.add(draw);
         return total;
    }
}
