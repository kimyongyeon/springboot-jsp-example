package kyyspring.springbootjspexample;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @PostMapping("/postAction")
    public String handlePostRequest(@RequestParam("webName") String webName, HttpSession session, Model model) {
        // 세션에서 중복 제출 여부 확인 (공통 로직 사용)
        String submissionKey = "isSubmitted";
        // 세션에서 중복 제출 여부 확인 (공통 로직 사용)
        if (SessionSubmissionHandler.isDuplicateSubmission(session, submissionKey)) {
            // 이미 제출된 경우 중복 제출 처리
            model.addAttribute("message", "이미 요청이 처리 중입니다. 잠시 후 다시 시도해주세요.");
            return "result"; // result.jsp로 이동하여 경고 메시지 표시
        }
        successRequest(webName, session, model, submissionKey);
//        String submissionKey = "isSubmitted";
//        if (SessionSubmissionHandler.isDuplicateSubmission(session, submissionKey)) {
//            // 이미 제출된 경우 중복 제출 처리
//            model.addAttribute("message", "이미 요청이 처리 중입니다. 잠시 후 다시 시도해주세요.");
//            return "result"; // result.jsp로 이동하여 경고 메시지 표시
//        }
//        try {
//            try {
//                // Intentional delay added by server side (wait for 5 seconds)
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            // 폼 데이터를 처리하는 로직 수행
//            System.out.println("Received webName: " + webName);
//            model.addAttribute("message", "폼 제출이 성공적으로 처리되었습니다. 입력값: " + webName);
//        }  finally {
//            // 처리 완료 후 세션에서 제출 상태 제거 (공통 로직 사용)
//            SessionSubmissionHandler.clearSubmissionStatus(session, submissionKey);
//        }

//        failRequest(webName, model);

        // 결과를 보여줄 JSP 페이지로 이동 (e.g. result.jsp)
        return "result";
    }

    private void successRequest(String webName, HttpSession session, Model model, String submissionKey) {


        try {
            try {
                // Intentional delay added by server side (wait for 5 seconds)
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 폼 데이터를 처리하는 로직 수행
            System.out.println("Received webName: " + webName);
            model.addAttribute("message", "폼 제출이 성공적으로 처리되었습니다. 입력값: " + webName);
        }  finally {
            // 처리 완료 후 세션에서 제출 상태 제거 (공통 로직 사용)
            SessionSubmissionHandler.clearSubmissionStatus(session, submissionKey);
        }
    }

    private void failRequest( String webName, Model model) {
        try {
            // Intentional delay added by server side (wait for 5 seconds)
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 폼 데이터를 처리하는 로직 수행
        System.out.println("Received webName: " + webName);
        model.addAttribute("message", "폼 제출이 성공적으로 처리되었습니다. 입력값: " + webName);
    }
}
