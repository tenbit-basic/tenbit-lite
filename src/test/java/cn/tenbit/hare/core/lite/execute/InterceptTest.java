package cn.tenbit.hare.core.lite.execute;

import cn.tenbit.hare.core.lite.domain.Person;
import cn.tenbit.hare.core.lite.execute.intercept.HareInterceptChain;
import cn.tenbit.hare.core.lite.util.HarePrintUtils;
import org.junit.Test;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 16:44
 */
public class InterceptTest {

    @Test
    public void test() throws Exception {
        HareInterceptChain<Person> chain = HareInterceptChain.<Person>newBuilder()
                .then(e -> {
                    Person person = new Person();
                    person.setId(2L);
                    return person;
                })
                .then(e -> {
                    e.setName("tom");
                    return e;
                })
                .build();

        Person target = new Person();
        target.setName("jack");
        target.setId(1L);

        Person person = chain.execute(target);

        HarePrintUtils.jsonLogConsole(target);
        HarePrintUtils.jsonLogConsole(person);
    }
}
