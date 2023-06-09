package kimch321.spring4.sungjukv6.controller;

import kimch321.spring4.sungjukv6.model.SungJukVO;
import kimch321.spring4.sungjukv6.service.SungJukV6Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SungJukController {

    private SungJukV6Service sjsrv;

    @Autowired
    public SungJukController(SungJukV6Service sjsrv) {
        this.sjsrv = sjsrv;
    }

    // 성적 리스트 처리
    @GetMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();

        // sungjuklist.jsp에 성적조회결과 데이터를 sjs라는 이름으로 넘김
        mv.addObject("sjs", sjsrv.readSungJuk());
        mv.setViewName("sungjuklist"); // 뷰 이름 지정

        return mv;
    }

    // 성적 입력 폼 표시
    @GetMapping("/add")
    public String add() {

        return "sungjuk";
    }

    // 성적 입력 처리
    @PostMapping("/add")
    public ModelAndView addok(SungJukVO sj) {
        ModelAndView mv = new ModelAndView();
        String view = "sungjukfail";

        if (sjsrv.newSungJuk(sj)) {
            mv.addObject("sj",sj);
            view = "sungjukok";
        }
        mv.setViewName(view);

        return mv;
    }

    // 성적 본문조회 처리
    @GetMapping("/view")
    public ModelAndView view(@RequestParam int sjno) {
        ModelAndView mv = new ModelAndView();
        String view = "sungjukfail";

        SungJukVO sj = sjsrv.readOneSungJuk(sjno);
        if (sj != null) {
            mv.addObject("sj", sj);
            view = "sungjukview";
        }
        mv.setViewName(view);

        return mv;
    }

    @GetMapping("/remove")
    public String remove(@RequestParam int sjno){

        sjsrv.removeSungJuk(sjno);

        return "redirect:/list";
    }

    @GetMapping("/modify")
    public ModelAndView modify(@RequestParam int sjno) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("sj",sjsrv.readOneSungJuk(sjno));
        mv.setViewName("sjmodify");

        return mv;
    }

    @PostMapping("/modify")
    public ModelAndView modifyok(SungJukVO sj){
        ModelAndView mv = new ModelAndView();
        String view = "sungjukfail";

        if(sjsrv.modifySungJuk(sj)) view = "redirect:/view?sjno=" + sj.getSjno();
        mv.setViewName(view);

        return mv;
    }

}
