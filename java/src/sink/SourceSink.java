package sink;

/**
 * @author Zexho
 * @date 2021/9/3 5:43 下午
 */
public class SourceSink<T> extends SinkChain<T> {

    @Override
    public void begin(int n) {
        this.next.begin(-1);
    }

    @Override
    public void accept(T t) {
        this.next.accept(t);
    }
}
