package JavaCollectionssrc.Ch0A;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class GetFields {

    static String names[] = { "AbstractCollection", "AbstractList", "AbstractMap", "AbstractSequentialList",
            "AbstractSet", "ArrayList", "Arrays", "BitSet", "Collection", "Collections", "Comparator", "Dictionary",
            "Enumeration", "HashMap", "HashSet", "Hashtable", "Iterator", "LinkedList", "List", "ListIterator", "Map",
            "Map$Entry", "Properties", "Set", "SortedMap", "SortedSet", "Stack", "TreeMap", "TreeSet", "Vector",
            "WeakHashMap" };

    public static void main(String args[]) throws Exception {
        for (int i = 0, n = names.length; i < n; i++) {
            String className = "java.util." + names[i];
            Class theClass = Class.forName(className);
            Field fields[] = theClass.getDeclaredFields();
            for (int j = 0, m = fields.length; j < m; j++) {
                System.out.println(names[i] + ", " + fields[j].getName() + ", " + fields[j].getType().getName() + ", "
                                   + Modifier.toString(fields[j].getModifiers()));
            }
        }
    }
}
