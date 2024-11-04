package kyyspring.springbootjspexample;

import jakarta.servlet.http.HttpSession;

public class SessionSubmissionHandler {
    // 세션에 중복 제출 방지 상태를 확인하고 설정하는 메서드
    public static boolean isDuplicateSubmission(HttpSession session, String key) {
        if (session.getAttribute(key) != null) {
            // 이미 제출된 경우 true 반환
            return true;
        }

        // 처음 제출인 경우 세션에 제출 정보 저장
        session.setAttribute(key, true);
        return false;
    }

    // 세션에서 제출 상태를 제거하는 메서드
    public static void clearSubmissionStatus(HttpSession session, String key) {
        session.removeAttribute(key);
    }
}
