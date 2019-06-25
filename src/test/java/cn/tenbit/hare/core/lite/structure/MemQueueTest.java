package cn.tenbit.hare.core.lite.structure;

import cn.tenbit.hare.core.lite.structure.memqueue.HareConcurrentMemoryQueue;
import cn.tenbit.hare.core.lite.structure.memqueue.HareMemoryQueue;
import cn.tenbit.hare.core.lite.structure.memqueue.HareMemoryQueueStatus;
import cn.tenbit.hare.core.lite.util.HareArrayUtils;
import cn.tenbit.hare.core.lite.util.HarePrintUtils;
import cn.tenbit.hare.core.lite.util.HareRandomUtils;
import cn.tenbit.hare.core.lite.util.HareSleepUtils;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 16:48
 */
public class MemQueueTest {

    @Test
    public void test() throws Exception {
        HareMemoryQueue<Integer> queue = new HareConcurrentMemoryQueue<>();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(() -> {
            while (true) {
                int[] arr = HareRandomUtils.randomIntArray(10, 1, Integer.MAX_VALUE);
                List<Integer> list = HareArrayUtils.intArr2IntegerList(arr);
                queue.batchOffer(list);
                HareSleepUtils.sleep(TimeUnit.MILLISECONDS, 1);
            }
        });

        executorService.execute(() -> {
            while (true) {
                List<Integer> list = queue.batchPoll(10);
                HareSleepUtils.sleep(TimeUnit.MILLISECONDS, 10);
            }
        });

        executorService.execute(() -> {
            while (true) {
                Object status = ((HareMemoryQueueStatus) queue).getStatus();
                HarePrintUtils.jsonLogConsole(status);
                HareSleepUtils.sleep(TimeUnit.MILLISECONDS, 100);
            }
        });

        executorService.awaitTermination(60, TimeUnit.SECONDS);
    }

    @Test
    public void test2() throws Exception {
        HareMemoryQueue<Integer> queue = new HareConcurrentMemoryQueue<>(10000);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int idx = 0; idx < 10; idx++) {
            executorService.execute(() -> {
                int num = 0;
                int max = 10000;
                int each = 10;
                while (true) {
                    if (num >= max) {
                        return;
                    }
                    int[] arr = HareRandomUtils.randomIntArray(each, 1, Integer.MAX_VALUE);
                    List<Integer> list = HareArrayUtils.intArr2IntegerList(arr);
                    num += each;
                    queue.batchOffer(list);
                    HareSleepUtils.sleep(TimeUnit.MILLISECONDS, 1);
                }
            });
        }

        for (int idx = 0; idx < 10; idx++) {
            executorService.execute(() -> {
                while (true) {
                    List<Integer> list = queue.batchPoll(10);
                    HareSleepUtils.sleep(TimeUnit.MILLISECONDS, 10);
                }
            });
        }

        /*executorService.execute(() -> {
            while (true) {
                Object status = ((HareMemoryQueueStatus) queue).getStatus();
                HarePrintUtils.jsonLogConsole(status);
                HareSleepUtils.sleep(TimeUnit.MILLISECONDS, 100);
            }
        });*/

        executorService.execute(() -> {
            while (true) {
                HarePrintUtils.jsonLogConsole(queue.size());
                HareSleepUtils.sleep(TimeUnit.MILLISECONDS, 100);
            }
        });

        executorService.awaitTermination(60, TimeUnit.SECONDS);
    }
}
