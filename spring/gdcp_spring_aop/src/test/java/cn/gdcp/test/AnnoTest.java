package cn.gdcp.test;

import cn.gdcp.anno.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-anno.xml")
public class AnnoTest {

    @Resource(name = "target")
    private TargetInterface targetInterface;

    @Test
    public void test(){
        targetInterface.save();
    }
}
