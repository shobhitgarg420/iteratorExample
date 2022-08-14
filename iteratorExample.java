import java.util.*;
public class iteratorExample {

    //iterator program
    public static void main(String[] args) {
        List<Integer> numberList=new ArrayList<Integer>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        iterate(numberList);
    }


    public static void iterate (List<Integer> numberList) {
        ListIterator<Integer> it = numberList.listIterator(1);
        System.out.println(it.next());
        it.next();
        it.previous();
        System.out.println(it.next());
    }
}
