package JavaCollectionssrc.Ch0A;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GetMethods {

    static String names[] = { "AbstractCollection", "AbstractList", "AbstractMap", "AbstractSequentialList",
            "AbstractSet", "ArrayList", "Arrays", "BitSet", "Collection", "Collections", "Comparator", "Dictionary",
            "Enumeration", "HashMap", "HashSet", "Hashtable", "Iterator", "LinkedList", "List", "ListIterator", "Map",
            "Map$Entry", "Properties", "Set", "SortedMap", "SortedSet", "Stack", "TreeMap", "TreeSet", "Vector",
            "WeakHashMap" };

    public static void main(String args[]) throws Exception {
        for (int i = 0, n = names.length; i < n; i++) {
            String className = "java.util." + names[i];
            Class theClass = Class.forName(className);
            Method methods[] = theClass.getDeclaredMethods();
            for (int j = 0, m = methods.length; j < m; j++) {
                if ((Modifier.isPublic(methods[j].getModifiers())) || (Modifier.isProtected(methods[j].getModifiers()))) {
                    System.out.println(methods[j].getName() + "(), " + names[i]);
                }
            }
        }
    }
}
