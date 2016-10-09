/**
 * 
 */
package JavaCollectionssrc.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author tracy.lu
 * @date:2013-8-6 下午4:50:46
 * @version :
 */
public class Iterator {

    // public static void main(String[] args) {
    // List<String> list = new ArrayList<String>();
    // list.add("3");
    // java.util.Iterator<String> it = list.iterator();
    // while (it.hasNext()) {
    // System.out.println(it.next());
    // }
    // }
    static class Person {

        private String fname;
        private String lname;
        private int    age;

        public Person(String fname, String lname, int age) {
            this.fname = fname;
            this.lname = lname;
            this.age = age;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getLname() {
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person("Ted", "Neward", 39), new Person("Ron", "Reynolds", 39),
                                             new Person("Charlotte", "Neward", 38), new Person("Matthew", "McCullough",
                                                                                               18));
        SortedSet ss = new TreeSet(new Comparator<Person>() {

            public int compare(Person lhs, Person rhs) {
                return lhs.getLname().compareTo(rhs.getLname());
            }
        });
        ss.addAll(persons);
        System.out.println(ss.toString());
    }

}
