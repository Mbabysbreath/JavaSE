package  Sort;
import Sort.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @author ZhaoMin
 * @date 2019/9/2 18:43
 */
public class PracticeSorts {
    public static void bubbleSorts(Person[] array, Comparator<Person> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                int r = comparator.compare(array[j], array[j + 1]);
                //  int r=array[j].compareTo(array[j+1]);
                if (r > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(Person[] array, int i, int j) {
        Person temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Random random = new Random(20190902);
        Person[] array = new Person[20];
        for (int i = 0; i < array.length; i++) {
            Person p = new Person();
            array[i] = p;
            array[i].age = random.nextInt(100);
            array[i].rank = random.nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        bubbleSorts(array, new Person());
        System.out.println(Arrays.toString(array));
    }
}
