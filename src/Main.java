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


        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
            System.out.print(objectsMatrix[i][j].i);
            System.out.print(objectsMatrix[i][j].j);
            }
            System.out.println();
        }

        String inp = scn.nextLine();
        String[][] result = handler(objectsMatrix, objectsMatrix[0][0], inp, 0, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    public static String[][] handler(Node[][] objectsMatrix, Node obj, String str, int i, int j){
        String newstr;
        int Matrixlen = objectsMatrix[0].length;
        String[][] newstrMatrix = new String[Matrixlen][Matrixlen];
        for (int k = 0; k < Matrixlen; k++){
            for (int l = 0; l < Matrixlen; l++){
                if (objectsMatrix[k][l].color == "pink"){
                    newstrMatrix[k][l] = "";
                }
            }
        }
        switch (obj.color){
            case "green":
                newstr = obj.black(str, obj.num);
                newstrMatrix[obj.i][obj.j] = newstr;
                handler(objectsMatrix, objectsMatrix[obj.i][obj.j + 1], newstr, obj.i, obj.j);
                handler(objectsMatrix, objectsMatrix[obj.i + 1][obj.j], newstr, obj.i, obj.j);
                break;
            case "yellow":
                newstr = obj.black(str, obj.num);
                newstrMatrix[obj.i][obj.j] = newstr;
                if (obj.i == 0){
                    handler(objectsMatrix, objectsMatrix[obj.i + 1][obj.j], newstr, obj.i, obj.j);
                }
                else
                    handler(objectsMatrix, objectsMatrix[obj.i][obj.j + 1], newstr, obj.i, obj.j);
                break;
            case "blue":
                newstr = obj.black(str, obj.num);
                newstrMatrix[obj.i][obj.j] = newstr;
                if (i == obj.i){
                    handler(objectsMatrix, objectsMatrix[obj.i + 1][obj.j], newstr, obj.i, obj.j);
                }
                else
                    handler(objectsMatrix, objectsMatrix[obj.i][obj.j + 1], newstr, obj.i, obj.j);
                break;
            case "pink":

                break;
        }
        return newstrMatrix;
    }
}