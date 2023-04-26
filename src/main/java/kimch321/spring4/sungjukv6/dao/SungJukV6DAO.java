package kimch321.spring4.sungjukv6.dao;

import kimch321.spring4.sungjukv6.model.SungJukVO;

import java.util.List;

public interface SungJukV6DAO {
    int insertSungJuk(SungJukVO sj);
    List<SungJukVO> selectSungJuk();
    SungJukVO selectOneSungJuk(int sjno);
    int updateSungJuk(SungJukVO sj);
    int deleteSungJuk(int sjno);
}