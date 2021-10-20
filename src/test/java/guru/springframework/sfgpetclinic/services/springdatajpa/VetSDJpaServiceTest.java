package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {
    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetSDJpaService service;

    @Test
    void delete() {
        Vet toDelete = new Vet(1L, "Igor", "Stojanovic", new HashSet<>());
        service.delete(toDelete);

        verify(vetRepository, atLeastOnce()).delete(toDelete);
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(vetRepository, atLeastOnce()).deleteById(1L);
    }
}