package baby.ey.crying.controller;

import baby.ey.crying.dto.CryingRequestsDto;
import baby.ey.crying.dto.CryingResponseDto;
import baby.ey.crying.service.CryingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Crying", description = "아기 울음소리 API")
public class CryingController {
    private final CryingService cryingService;

    @GetMapping("/api/crying")
    @Operation(summary = "아기 울음소리 조회", description = "아기 울음소리 조회 후 리스트 반환 API")
    public List<CryingResponseDto> getCrying() {
        return cryingService.getCrying();
    }

    @PostMapping("/api/crying/post")
    @Operation(summary = "아기 울음소리 작성", description = "아기 울음소리 기록 API")
    public CryingResponseDto createCrying(@RequestBody CryingRequestsDto requestDto) {
        return cryingService.createCrying(requestDto);
    }
}
