package baby.ey.diary.service;

import baby.ey.diary.dto.GrowthResponseDto;
import baby.ey.diary.dto.SleepResponseDto;
import baby.ey.diary.repository.SleepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SleepService {
    private final SleepRepository sleepRepository;

    @Transactional(readOnly = true)
    public List<SleepResponseDto> getSleep() {
        return sleepRepository.findAllByOrderByCreatedDesc().stream()
                .map(SleepResponseDto::new).toList();
    }

    @Transactional
    public SleepResponseDto getSleep(Long id) {
        return sleepRepository.findById(id).map(SleepResponseDto::new).orElseThrow(
                () -> new IllegalArgumentException("해당 일기가 없습니다")
        );
    }
}
