package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @Test
    void findAll() {
        Set<Visit> visitSet = new HashSet<>();
        visitSet.add(new Visit());

        when(visitRepository.findAll()).thenReturn(visitSet);

        Set<Visit> foundVisitSet = service.findAll();

        assertThat(foundVisitSet).isNotNull();

        verify(visitRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        Visit visit = new Visit();

        when(visitRepository.findById(1L))
                .thenReturn(Optional.of(visit));

        Visit foundVisit = service.findById(1L);

        assertThat(foundVisit).isNotNull();

        verify(visitRepository, times(1)).findById(anyLong());
    }

    @Test
    void save() {
        Visit visit = new Visit();

        when(visitRepository.save(visit)).thenReturn(visit);

        Visit savedVisit = service.save(visit);

        assertThat(savedVisit).isNotNull();

        verify(visitRepository, times(1)).save(any(Visit.class));
    }

    @Test
    void delete() {
        Visit visit = new Visit();

        service.delete(visit);

        verify(visitRepository).delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(visitRepository).deleteById(anyLong());
    }
}