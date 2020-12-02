public class Main {
    public static void main(String[] args) throws Exception {
        Array<Integer> intArr = new Array<Integer>();
        intArr.add(1);
        intArr.add(2);
        System.out.println(intArr + " " + intArr.size());
        intArr.remove(0);
        System.out.println(intArr + " " + intArr.size());
        intArr.remove(1);
        System.out.println(intArr + " " + intArr.size());
    }
}
