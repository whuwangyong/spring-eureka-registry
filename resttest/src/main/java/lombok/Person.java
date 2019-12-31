package lombok;

import lombok.experimental.SuperBuilder;

/**
 * @Author WangYong
 * @Date 2019/12/09
 * @Time 13:54
 */
@SuperBuilder
@Data
@NoArgsConstructor
@ToString
public class Person {
    String name;
    String age;

}
