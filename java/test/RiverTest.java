import river.River;

import java.util.Objects;

/**
 * @author Zexho
 * @date 2021/9/3 2:40 下午
 */
public class RiverTest {

    public static void main(String[] args) {
//        forEachTest();
//        countTest();
        filterTest();
        distinctTest();
        limitTest();
//        sortTest();
    }

    /**
     * 从数组中创建River
     */
    public static River<String> createFromArrayTest() {
        return River.of("1", "1", "2", "3", "3");
    }

    public static void filterTest() {
        System.out.println("filter test:");
        System.out.println("==> !equals(2)");
        createFromArrayTest().filter(e -> !e.equals("2")).forEach(System.out::println);
        System.out.println("==> equals(2)");
        createFromArrayTest().filter(e -> e.equals("2")).forEach(System.out::println);
    }

    public static void distinctTest() {
        System.out.println("distinct test");
        River.of("1", "1", "2", "3", "3").distinct().forEach(System.out::println);
    }

    public static void forEachTest() {
        System.out.println("foreach test");
    }

    public static void countTest() {
        long count2 = River.of("java", "c++", "go", "python", "c", "java")
                .distinct()
                .filter(e -> !e.equals("go") && !e.equals("c++"))
                .count();
        assert count2 == 3;
    }

    public static void limitTest() {
//        long count = River.of("1", "2", "3", "4", "5", "2", "1", "2", "1", "2", "1", "2")
//                .limit(5)
//                .count();
//        assert count == 5 : "limit test fail,count = " + count;

        System.out.println("limit test => foreach");
        River.of("1", "2", "3", "4", "5", "2", "1", "2", "1", "2", "1", "2")
                .limit(5)
                .forEach(System.out::println);
    }

    public static void sortTest() {
        System.out.println("sorted test");
        River.of(2, 1, 5, 4, 0)
                .sort((n1, n2) -> {
                    if (Objects.equals(n1, n2)) {
                        return 0;
                    } else if (n1 > n2) {
                        return 1;
                    } else {
                        return -1;
                    }
                })
                .forEach(System.out::println);
    }

}