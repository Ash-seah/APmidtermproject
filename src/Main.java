import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] randomMatrix = new int[n][n];
        Random r = new Random();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                randomMatrix[i][j] = r.nextInt(1,6);
            }
        }

        Node[][] objectsMatrix = new Node[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){

                // green
                if ((i == 0 && j != n-1) || (j == 0 && i != n-1)){
                    objectsMatrix[i][j] = new Node("black", randomMatrix[i][j], "green", i, j);
                }

                // yellow
                else if ((i == 0 && j == n-1) || (j == 0 && i == n-1)){
                    objectsMatrix[i][j] = new Node("black", randomMatrix[i][j], "yellow", i, j);
                }

                // blue
                else if ((i != 0 && j != n-1) || (j != 0 && i != n-1)){
                    objectsMatrix[i][j] = new Node("black", randomMatrix[i][j], "blue", i, j);
                }

                // pink
                else if ((i != 0 && j == n-1) || (j != 0 && i == n-1)){
                    objectsMatrix[i][j] = new Node("white", randomMatrix[i][j], "pink", i, j);
                }
            }
        }

        String str = "amir";
        String output = "";
        for (int m = 0; m < str.length(); m++) {
            char ch = str.charAt(m);
            int charnum = ch;
            char newchar = (char) (122 - (charnum - 97));
            output += newchar;
        }
        System.out.println(output);


    }

    public static String handler(Node[][] objectsMatrix, Node obj, String str){
        String newstr;
        switch (obj.color){
            case "green":
                newstr = obj.black(str, obj.num);
                handler(objectsMatrix, objectsMatrix[obj.i][obj.j + 1], newstr);
                handler(objectsMatrix, objectsMatrix[obj.i + 1][obj.j], newstr);
                break;
            case "yellow":
                newstr = obj.black(str, obj.num);
                if (obj.i == 0){
                    handler(objectsMatrix, objectsMatrix[obj.i][obj.j + 1], newstr);
                }
                else
                    handler(objectsMatrix, objectsMatrix[obj.i + 1][obj.j], newstr);
                break;
            case "blue":
                break;
            case "pink":
                break;
        }
    }
}