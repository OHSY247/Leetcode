import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @author straycamel
 * @date 2021/6/23
 */
public class ArrayListLinkedListVector {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>(new Integer(0x7ffffff));
        for (int i = 0; i < 17; i++) {
            list.add(i);
            System.out.format("ArrayList Size: %2d, Capacity: %2d%n",
                              list.size(), getCapacity(list));
        }
        LinkedList<Integer> link = new LinkedList<Integer>();
        for (int i = 0; i < 17; i++) {
            link.add(i);
            System.out.format("LinkedList Size: %2d\n",
                              link.size());
        }
        Vector<Integer> t=new Vector<Integer>();
        for (int i = 0; i < 17; i++) {
            t.add(i);
            System.out.format("ArrayList Size: %2d,%2d\n",
                              t.size(),t.capacity());
        }
        System.out.println(t);

    }
    /**
     * 获取ArrayList的容量
     * @author straycamel
     * @date 2021/6/23
     */
    static int getCapacity(ArrayList<?> l) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }
}
