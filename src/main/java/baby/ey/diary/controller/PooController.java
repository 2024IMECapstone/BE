package baby.ey.diary.controller;

import baby.ey.diary.dto.GrowthResponseDto;
import baby.ey.diary.dto.PooResponseDto;
import baby.ey.diary.service.PooService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Poo", description = "용변 키워드 API")
public class PooController {
    private final PooService pooService;

    @GetMapping("/api/poo")
    @Operation(summary = "용변 키워드 조회", description = "용변 키워드 조회 후 리스트 반환 API")
    public List<PooResponseDto> getPoo() {
        return pooService.getPoo();
    }

    @GetMapping("/api/poo/{id}")
    @Operation(summary = "용변 키워드 상세 조회", description = "용변 키워드 상세 조회 API")
    public PooResponseDto getPoo(@PathVariable Long id) throws Exception {
        return pooService.getPoo(id);
    }
}
