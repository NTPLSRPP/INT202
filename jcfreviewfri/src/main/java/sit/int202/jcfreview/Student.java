package sit.int202.jcfreview;

import lombok.*;

import java.util.Comparator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double gpax;
    public static final Comparator<Student> SORT_BY_GPAX = (o1, o2) -> {
        if (o1.gpax < o2.gpax) {
            return 1;
        } else if (o1.gpax > o2.gpax) {
            return -1;
        } else {
            return o1.name.compareTo(o2.name);
        }
    };
    public static final Comparator<Student> SORT_BY_NAME = Comparator.comparing(o -> o.name);

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }
}
