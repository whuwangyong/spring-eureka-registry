package lombok;

import lombok.experimental.SuperBuilder;

/**
 * @Author WangYong
 * @Date 2019/12/09
 * @Time 13:55
 */
@Data
@SuperBuilder
@NoArgsConstructor
@ToString
public class Son extends Father {
    String garden;
}
