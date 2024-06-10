package baby.ey.diary.service;

import baby.ey.diary.dto.GrowthResponseDto;
import baby.ey.diary.dto.PooResponseDto;
import baby.ey.diary.repository.PooRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PooService {
    private final PooRepository pooRepository;

    @Transactional(readOnly = true)
    public List<PooResponseDto> getPoo() {
        return pooRepository.findAllByOrderByCreatedDesc().stream()
                .map(PooResponseDto::new).toList();
    }

    @Transactional
    public PooResponseDto getPoo(Long id) {
        return pooRepository.findById(id).map(PooResponseDto::new).orElseThrow(
                () -> new IllegalArgumentException("해당 일기가 없습니다")
        );
    }
}
