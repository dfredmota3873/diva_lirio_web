package com.divalirio.service;

import com.divalirio.exception.BusinessException;
import com.divalirio.model.Address;
import com.divalirio.model.User;
import com.divalirio.repository.AddressRepository;
import com.divalirio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressService extends BaseService {

    private final AddressRepository repository;

    private final UserRepository userRepository;

    public Address create(Address address) {

        User user = userRepository.findById(address.getUser().getId()).orElseThrow(() -> new BusinessException(getMessage("user.notfound")));

        address.setUser(user);

        return repository.save(address);


    }

    public Address findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new BusinessException(getMessage("address.notfound")));
    }

    public List<Address> findAll() {
        return repository.findAll();
    }

    public Address update(UUID id, Address address) {

        Address addressDB = findById(id);

        addressDB.setStreet(address.getStreet());
        addressDB.setState(address.getState());
        addressDB.setNumber(address.getNumber());
        addressDB.setComplement(address.getComplement());
        addressDB.setZipCode(address.getZipCode());
        addressDB.setNeighborhood(address.getNeighborhood());

        return repository.save(addressDB);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }
}
