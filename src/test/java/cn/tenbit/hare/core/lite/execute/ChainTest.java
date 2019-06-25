package cn.tenbit.hare.core.lite.execute;

import cn.tenbit.hare.core.lite.domain.Person;
import cn.tenbit.hare.core.lite.execute.chain.HareExecuteChain;
import cn.tenbit.hare.core.lite.util.HarePrintUtils;
import org.junit.Test;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 16:44
 */
public class ChainTest {

    @Test
    public void test() throws Exception {
        HareExecuteChain<Person> chain = HareExecuteChain.<Person>newBuilder()
                .then(e -> {
                    e.setName("hh");
                })
                .then(e -> {
                    e.setId(2L);
                })
                .onFinally(HarePrintUtils::jsonConsole)
                .build();

        Person target = new Person();
        Person person = chain.execute(target);

        HarePrintUtils.jsonLogConsole(target);
        HarePrintUtils.jsonLogConsole(person);
    }
}
