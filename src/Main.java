import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String inp = scn.next();
        int[][] randomMatrix = new int[n][n];
        Random r = new Random();
//
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < n; j++){
//                randomMatrix[i][j] = r.nextInt(1,6);
//            }
//        }
//        int[][] randomMatrix = new int[8][8];
//        randomMatrix = [[2, 5, 5, 4, 2, 1, 5, 5 ], [2, 1, 2, 4, 4, 1, 5, 4 ], [4, 4, 1, 1 ,1, 5, 1, 4], [4, 1, 4, 4 ,1, 4, 5, 1 ], [1, 1, 1, 5, 1, 4, 4, 5 ], [4, 4 ,5, 4, 5, 1, 5, 5], [1, 4, 4, 4, 1, 1, 1, 4], [4, 5, 4, 5, 5, 1, 4, 4 ]];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                randomMatrix[i][j] = scn.nextInt();
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


//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < n; j++){
//            System.out.print(objectsMatrix[i][j].i);
//            System.out.print(objectsMatrix[i][j].j);
//            }
//            System.out.println();
//        }

        objectsMatrix[0][0].result = objectsMatrix[0][0].black(inp, objectsMatrix[0][0].num);

        calculate(objectsMatrix, n);

        String str1 = objectsMatrix[n-2][n-2].result;

        Node[][] transpose = new Node[n][n];
        transpose(transpose, objectsMatrix, n);
        objectsMatrix = transpose;

        calculate(objectsMatrix, n);

        String str2 = objectsMatrix[n-2][n-2].result;

        String ans = objectsMatrix[n-1][n-1].white(str1, str2, objectsMatrix[n-1][n-1].num);

        System.out.print(ans);
    }

    public static void calculate(Node[][] objectsMatrix, int n){
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (i == 0 && j == 0){
                    continue;
                }
                if ((j == n - 1 || i == n - 1) && (i != 0 && j != 0)){
                    objectsMatrix[i][j].result = objectsMatrix[i][j].white(objectsMatrix[i - 1][j].result, objectsMatrix[i][j - 1].result, objectsMatrix[i][j].num);
                }
                else if (i == 0){
                    objectsMatrix[i][j].result = objectsMatrix[i][j].black(objectsMatrix[i][j - 1].result, objectsMatrix[i][j].num);
                } else {
                    objectsMatrix[i][j].result = objectsMatrix[i][j].black(objectsMatrix[i - 1][j].result, objectsMatrix[i][j].num);
                }
//                System.out.print(i);
//                System.out.print(j);
//                System.out.println(objectsMatrix[i][j].result);
            }
        }
    }
    public static Node[][] transpose(Node[][] transpose, Node[][] objectsMatrix, int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                transpose[i][j]=objectsMatrix[j][i];
            }
        }
        return transpose;
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