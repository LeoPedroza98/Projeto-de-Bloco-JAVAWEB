package com.mapri.webbackend.controller;

import com.mapri.webbackend.domain.Provider;
import com.mapri.webbackend.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("provider")
public class ProviderController {

    @Autowired
    ProviderRepository providerRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Provider> findAll(){
        Iterable<Provider> all = providerRepository.findAll();
        return all;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Provider save (@RequestBody Provider provider){
        Provider p = providerRepository.save(provider);
        return p;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Provider update (@RequestBody Provider provider){
        Provider p = providerRepository.save(provider);
        return p;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete (@RequestBody Provider provider){
        providerRepository.deleteById(provider.getId());
    }
}
