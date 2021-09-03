import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Zexho
 * @date 2021/9/3 2:28 下午
 */
public class RefRiver<T> extends Pipeline<T> implements River<T> {

    /**
     * 追加filter操作
     * 创建一个filter的{@link PipelineStage},然后将该stage追到到Pipeline的尾部
     *
     * @param predicate 过滤的表达式
     * @return 新增的filter对象
     */
    @Override
    public River<T> filter(Predicate<T> predicate) {
        //创建一个新的stage
        River<T> newStage = new PipelineStage<>(this, Op.filter);

        //返回新的stage
        return newStage;
    }

    @Override
    public River<T> distinct() {
        return null;
    }

    @Override
    public void forEach(Consumer<T> consumer) {

    }

    @Override
    public long count() {
        return 0;
    }
}
