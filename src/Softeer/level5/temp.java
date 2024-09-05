package Softeer.level5;

public class temp {

        public static void main(String[] args) {
            String blank =" ";
            String star = "*";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getStringBySize(11,blank)).append(getStringBySize(9,star)).append(getStringBySize(11,blank)).append("\n");
            stringBuilder.append(getStringBySize(5,blank)).append(getStringBySize(5,star)).append(getStringBySize(9,blank)).append(getStringBySize(4,star)).append(getStringBySize(7,blank)).append("\n");

            System.out.println(stringBuilder.toString());

        }

        public static String getStringBySize(int size, String str){
            StringBuilder result = new StringBuilder();
            while (result.length() < size) {
                result.append(str);
            }
            return result.toString();
        }
}
