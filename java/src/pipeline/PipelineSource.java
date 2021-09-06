package pipeline;

import river.AbstractRiverPipeline;
import river.Op;
import sink.SinkChain;
import sink.SourceSink;

import java.util.Spliterator;

/**
 * 表示River的Source，也是Pipeline的第一个阶段(stage_0)
 *
 * @author Zexho
 * @date 2021/9/3 2:28 下午
 */
public class PipelineSource<T> extends AbstractRiverPipeline<T> {

    public PipelineSource(Spliterator<T> source) {
        this.sourceSpliterator = source;
        this.op = Op.source;
        this.source = this;
        this.previous = null;
        this.next = null;
    }
}
