public class Main {
    public static void main(String[] args) throws Exception {
        // Array<Integer> intArr = new Array<Integer>();
        // intArr.add(1);
        // intArr.add(2);
        // System.out.println(intArr + " " + intArr.size());
        // intArr.remove(0);
        // System.out.println(intArr + " " + intArr.size());
        // intArr.remove(1);
        // System.out.println(intArr + " " + intArr.size());

        // DoublyLinkedList<String> strDLList = new DoublyLinkedList<String>();
        // strDLList.add("b");
        // strDLList.add("d");
        // strDLList.add("c");
        // System.out.println(strDLList + " " + strDLList.indexOf("b") + strDLList.indexOf("d") + strDLList.indexOf("c"));
        // System.out.println(strDLList + " " + strDLList.size());
        // strDLList.remove("d");
        // System.out.println(strDLList + " " + strDLList.size());
        // strDLList.remove("b");
        // System.out.println(strDLList + " " + strDLList.size());
        // strDLList.remove("c");
        // System.out.println(strDLList + " " + strDLList.size());

        Stack<Integer> intStack = new Stack<Integer>();
        intStack.push(1);
        intStack.push(2);
        System.out.println(intStack.toString() + ' ' + intStack.peek());
        intStack.pop();
        System.out.println(intStack);
    }   
}
