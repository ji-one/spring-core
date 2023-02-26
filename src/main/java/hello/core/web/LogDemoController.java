package hello.core.web;

import hello.core.common.MyLogger;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger; // MyLogger를 찾을 수 있는 애가 주입됨. -> 주입 시점에 주입받을 수 있음.

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = " + myLogger.getClass()); // MyLogger를 상속받은 가짜 프록시 객체 생성
        myLogger.setRequestURL(requestURL); // 실제 기능 호출하는 시점에 진짜 MyLogger를 찾아서 동작

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
