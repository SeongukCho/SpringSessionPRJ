package kopo.poly.controller;

import jakarta.servlet.http.HttpSession;
import kopo.poly.dto.SessionDTO;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/session")
public class SessionController {

    @GetMapping("test")
    public SessionDTO sessionTest(HttpSession session) {

        log.info(this.getClass().getName() + ".test Start!");

        // 세션 ID확인(다른 서버에서도 동일한 ID가 출력되는지 확인용)
        String sessionId = session.getId();

        // 세션 저장하기
        session.setAttribute("test", "springSession1 서버에서 저장한 값");

        // 세션 가져오기
        String test = CmmUtil.nvl((String) session.getAttribute("test"));

        // 화면에 보여줄 값 출력을 위해 DTO 생성하고, 값 넣어줌
        SessionDTO dto = SessionDTO.builder().sessionName("test").sessionValue(test).sessionId(sessionId).build();

        // 가져온 세션 출력하기
        log.info("dto : " + dto);

        log.info(this.getClass().getName() + ".test End!");

        return dto;
    }
}
