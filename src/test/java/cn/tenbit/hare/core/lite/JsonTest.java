package cn.tenbit.hare.core.lite;

import cn.tenbit.hare.core.lite.domain.Person;
import cn.tenbit.hare.core.lite.util.HarePrintUtils;
import org.junit.Test;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 16:40
 */
public class JsonTest {

    @Test
    public void test(){
        Person person = new Person();
        person.setId(1L);
        person.setName("jack");

        HarePrintUtils.prettyJsonLogConsole(person);
    }
}
