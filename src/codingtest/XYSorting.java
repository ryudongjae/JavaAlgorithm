package codingtest;

public class XYSorting {
    public static void main(String[] args) {
        System.out.println(getDistance(1,1,2,2));
    }
    static double getDistance(int x, int y, int x1, int y1) {
        double d;
        int xd, yd;
        yd = (int) Math.pow((y1-y),2);
        xd = (int) Math.pow((x1-x),2);
        d = Math.sqrt(yd+xd);
        return d;
    }
}
