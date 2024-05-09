package baby.ey.baby.service;

import baby.ey.baby.dto.BabyRequestsDto;
import baby.ey.baby.dto.BabyResponseDto;
import baby.ey.baby.entity.Baby;
import baby.ey.baby.repository.BabyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BabyService {
    private final BabyRepository babyRepository;

    @Transactional(readOnly = true)
    public List<BabyResponseDto> getBaby() {
        return babyRepository.findAllByOrderByCreatedDesc().stream()
                .map(BabyResponseDto::new).toList();
    }

    @Transactional
    public BabyResponseDto createBaby(BabyRequestsDto babyRequestsDto) {
        Baby baby = new Baby(babyRequestsDto);
        babyRepository.save(baby);
        return new BabyResponseDto(baby);
    }
}