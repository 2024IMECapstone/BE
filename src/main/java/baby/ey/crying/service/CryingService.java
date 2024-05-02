package baby.ey.crying.service;

import baby.ey.crying.dto.CryingRequestsDto;
import baby.ey.crying.dto.CryingResponseDto;
import baby.ey.crying.entity.Crying;
import baby.ey.crying.repository.CryingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CryingService {
    private final CryingRepository cryingRepository;

    @Transactional(readOnly = true)
    public List<CryingResponseDto> getCrying() {
        return cryingRepository.findAllByOrderByCreatedDesc().stream()
                .map(CryingResponseDto::new).toList();
    }

    @Transactional
    public CryingResponseDto createCrying(CryingRequestsDto requestDto) {
        Crying crying = new Crying(requestDto);
        cryingRepository.save(crying);
        return new CryingResponseDto(crying);
    }

}
