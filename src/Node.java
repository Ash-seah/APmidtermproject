public class Node {
    String arrow;
    int num;
    String color;
    int i;
    int j;
    String result;
    public Node(String arrow, int num, String color, int i, int j){
        this.arrow = arrow;
        this.color = color;
        this.num = num;
        this.i = i;
        this.j = j;
    }

    public static String white(String str1, String str2, int num){
        String output = "";
        StringBuilder result = new StringBuilder();
        int len1 = str1.length();
        int len2 = str2.length();
        switch (num){
            case 1:
                for (int m = 0; m < Math.max(len1, len2); m++) {
                    if (m < len1) {
                        result.append(str1.charAt(m));
                    }
                    if (m < len2) {
                        result.append(str2.charAt(m));
                    }
                }
                break;
            case 2:
                result.append(str1);
                result.append(new StringBuilder(str2).reverse());
                break;
            case 3:
                for (int m = 0; m < Math.max(len1, len2); m++) {
                    if (m < len1) {
                        result.append(str1.charAt(m));
                    }
                    if (m < len2) {
                        result.append(str2.charAt(len2 - 1 - m));
                    }
                }
                break;
            case 4:
                if (len1 % 2 == 0) {
                    result.append(str1);
                } else {
                    result.append(str2);
                }
                break;
            case 5:
                int minLength = Math.min(len1, len2);
                for (int m = 0; m < minLength; m++) {
                    char char1 = str1.charAt(m);
                    char char2 = str2.charAt(m);
                    int sum = (char1 - 'a' + char2 - 'a') % 26 + 'a';
                    result.append((char) sum);
                }
                if (len1 > len2) {
                    result.append(str1.substring(len2));
                }
                else if (len2 > len1) {
                    result.append(str2.substring(len1));
                }
                break;
        }
        return result.toString();
    }

    public static String black(String str, int num){
        String output = "";
        StringBuilder result = new StringBuilder();
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
