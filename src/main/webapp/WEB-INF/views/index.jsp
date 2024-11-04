<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Boot + JSP + Gradle Example</title>
    <!-- jQuery 라이브러리 추가 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


</head>
<body>
<h1>Welcome to Spring Boot with JSP (Gradle Project)</h1>
<p>현재 페이지는 Spring Boot와 JSP를 사용하여 렌더링되었습니다.</p>

<h1>${message}</h1>
<!-- HTML 폼 -->
<form action="/postAction" id="formWeb" method="post">
    <label for="webName">이름:</label>
    <input name="webName" type="text">
    <button type="submit">click</button>
</form>

<!-- jQuery 코드 -->
<script>
    $(document).ready(function() {
        // 폼의 submit 이벤트 처리
        $('#formWeb').on('submit', function(event) {
            event.preventDefault(); // 기본 submit 동작을 막음

            // 추가 로직을 여기에 작성할 수 있습니다.
            const webNameValue = $('input[name="webName"]').val();
            console.log('Form submitted with value:', webNameValue);

            // 폼을 실제로 제출하고 싶을 경우 아래 코드 실행
            this.submit();
        });
    });
</script>
</body>
</html>
