package ar.com.ada.api.xmen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.xmen.entities.Human;
import ar.com.ada.api.xmen.repositories.HumanRepository;

@Service
public class HumanService {

    @Autowired
    HumanRepository humanRepository;

    public boolean created(Human human) {
        humanRepository.save(human);
        return true;

    }

}
