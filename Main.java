import java.util.ArrayList;

class IntClass{
        private int intValue ;

        public int getIntValue() {
            return intValue;
        }

        public void setIntValue(int intValue) {
            this.intValue = intValue;
        }

        public IntClass(int intValue){
            this.intValue = intValue;
        }

}

public class Main {
    
    public static void main(String[] args) {
        ArrayList<IntClass> intArrayList = new ArrayList<IntClass>();
        ArrayList<String> stringArray = new ArrayList<String>();

        stringArray.add("my");
        System.out.println(stringArray.get(0));

        intArrayList.add(new IntClass(4));
        intArrayList.get(0);

        ArrayList<Integer> myIntList = new ArrayList<Integer>();
        // for (int i = 0; i <= 10; i++) {
        //     myIntList.add(Integer.valueOf(i));
        // }

        // for (int i = 0; i <= 10; i++) {
        //     System.out.println(i + " --> " + myIntList.get(i).intValue());
        // }
        // for (int i = 0; i <= 10; i++) {
        //     myIntList.add(i);
        // }

        // for (int i = 0; i <= 10; i++) {
        //     System.out.println(i + " --> " + myIntList.get(i));
        // }

        ArrayList<Double> doubleList = new ArrayList<Double>();
        for (double i = 0.0; i <= 10.0; i+=0.5) {
            doubleList.add(Double.valueOf(i));
        }
        for (int i = 1; i < doubleList.size(); i++) {
            System.out.println(i + " --> " + doubleList.get(i).doubleValue());
        }
        
    }
    
}