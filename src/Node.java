public class Node {
    String arrow;
    int num;
    String color;
    int i;
    int j;
    public Node(String arrow, int num, String color, int i, int j){
        this.arrow = arrow;
        this.color = color;
        this.num = num;
        this.i = i;
        this.j = j;
    }

    public static String white(String str1, String str2, int num){
        String output = "";
        switch (num){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
        return output;
    }

    public static String black(String str, int num){
        String output = "";
        switch (num){
            case 1:
                for (int m = 0; m < str.length(); m++)
                {
                    char ch = str.charAt(m);
                    output += ch;
                }
                break;
            case 2:
                for (int m = 0; m < str.length(); m++) {
                    output += str.charAt(m);
                    output += str.charAt(m);
                }
                break;
            case 3:
                output += str;
                output += str;
                break;
            case 4:
                output += str.charAt(str.length() - 1);
                output += str.substring(0, str.length() - 1);
                break;
            case 5:
                for (int m = 0; m < str.length(); m++) {
                    char ch = str.charAt(m);
                    int charnum = ch;
                    char newchar = (char) (122 - (charnum - 97));
                    output += newchar;
                }
                break;
        }
        return output;
    }
}
