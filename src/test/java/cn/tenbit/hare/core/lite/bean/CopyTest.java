package cn.tenbit.hare.core.lite.bean;

import cn.tenbit.hare.core.lite.domain.Human;
import cn.tenbit.hare.core.lite.domain.Person;
import cn.tenbit.hare.core.lite.util.HareCopyUtils;
import cn.tenbit.hare.core.lite.util.HarePrintUtils;
import org.junit.Test;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 16:43
 */
public class CopyTest {

    @Test
    public void test() {
        Person person = new Person();
        person.setId(1L);
        person.setName("jack");

        Human human = HareCopyUtils.copyObject(person, Human.class);

        HarePrintUtils.jsonLogConsole(person);
        HarePrintUtils.jsonLogConsole(human);
    }
}
