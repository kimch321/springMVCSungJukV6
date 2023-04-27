import kimch321.spring4.sungjukv6.dao.SungJukV6DAO;
import kimch321.spring4.sungjukv6.model.SungJukVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

//단위unit 테스트
// 하나의 모듈을 기준으로 독립적으로 진행되는 가장 작은 단위의 테스트
// 모듈은 애플리케이션에서 작동하는 하나의 기능 또는 메소드를 의미
// 애플리케이션을 구성하는 하나의 기능이 올바르게 동작하는지를 독립적으로 테스트하는 것
// "어떤 기능이 실행되면 어떤 결과가 나온다" 수준으로 테스트 함
// 테스트 결과 확인은 assertXxx 메서드를 이용함
// ~equals, ~notequals, ~null, ~notnull, ~true, ~false

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml","classpath:servlet-context.xml"})
public class SungJukV6DAOTest {

    @Autowired
    SungJukV6DAO sjdao;

    @Test // 테스트 슈트(항목)
    public void test1() {
        System.out.println(">> Test 1 시작 <<");
        List<SungJukVO> sjs = sjdao.selectSungJuk();
        //System.out.println(sjs);
        assertNotNull(sjs);
    }

    @Test
    public void test2() {
        System.out.println(">> Test 2 시작 <<");
        SungJukVO sjs = sjdao.selectOneSungJuk(3);
        System.out.println(sjs);
    }

    @Test
    public void test3() {
        System.out.println(">> Test 3 시작 <<");
        SungJukVO sjs = new SungJukVO("송은채", 90,100,80);
        int cnt = sjdao.insertSungJuk(sjs);
        System.out.println(cnt);
    }

    @Test
    public void test4() {
        System.out.println(">> Test 4 시작 <<");
        SungJukVO sj = new SungJukVO(null,11,22,33);
        sj.setSjno(4);
        sj.setTot(0);
        sj.setAvg(0.0);
        sj.setGrd('가');

        assertEquals(1, sjdao.updateSungJuk(sj));
    }

}
