package lombok;

import lombok.experimental.SuperBuilder;

/**
 * @Author WangYong
 * @Date 2019/12/09
 * @Time 13:54
 */
@Data
@NoArgsConstructor
@SuperBuilder
@ToString
public class Father extends Person {
    String city;
}
