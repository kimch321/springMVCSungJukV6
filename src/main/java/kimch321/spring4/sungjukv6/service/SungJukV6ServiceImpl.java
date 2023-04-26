package kimch321.spring4.sungjukv6.service;


import kimch321.spring4.sungjukv6.dao.SungJukV6DAO;
import kimch321.spring4.sungjukv6.dao.SungJukV6DAOImpl;
import kimch321.spring4.sungjukv6.model.SungJukVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sjsrv")
public class SungJukV6ServiceImpl implements SungJukV6Service {
    private static final Logger logger = LogManager.getLogger(SungJukV6ServiceImpl.class);
    private SungJukV6DAO sjdao = null;

    @Autowired
    public SungJukV6ServiceImpl(SungJukV6DAO sjdao) {
        this.sjdao = sjdao;
    }

    public boolean newSungJuk(SungJukVO sj) {
        this.computeSungJuk(sj);
        logger.info(sj);

        return sjdao.insertSungJuk(sj) > 0;
    }

    // 성적 리스트 받아옴
    public List<SungJukVO> readSungJuk() {

        return sjdao.selectSungJuk();
    }

    public SungJukVO readOneSungJuk(int sjno) {

        return sjdao.selectOneSungJuk(sjno);
    }

    public boolean modifySungJuk(SungJukVO sj) {

        return false;
    }

    public boolean removeSungJuk(int sjno) {

        return sjdao.deleteSungJuk(sjno) > 0;
    }

    public void computeSungJuk(SungJukVO sj) {
        sj.setTot( sj.getKor() + sj.getEng() + sj.getMat() );
        sj.setAvg( (double) sj.getTot() / 3 );

        switch ((int)(sj.getAvg()/10)) {
            case 10: case 9: sj.setGrd('수'); break;
            case 8: sj.setGrd('우'); break;
            case 7: sj.setGrd('미'); break;
            case 6: sj.setGrd('양'); break;
            default: sj.setGrd('가'); break;
        }
    }

}