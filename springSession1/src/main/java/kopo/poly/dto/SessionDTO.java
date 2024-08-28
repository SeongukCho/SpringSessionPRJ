package kopo.poly.dto;

import lombok.Builder;

@Builder
public record SessionDTO(
        String sessionName,     // 세션에 저장한 이름
        String sessionValue,    // 세션에 저장한 값
        String sessionId        // 브라우저에서 체크하는 ID 값
) {
}
