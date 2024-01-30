package com.example.kafkaexample.message;

import com.example.kafkaexample.repository.Foo;
import com.example.kafkaexample.repository.FooRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
class FooService {

    private final FooRepository fooRepository;

    public FooService(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    public String getFoo() {
        var foo = new Foo();
        fooRepository.save(foo);
        System.out.println("foo = " + foo);
        return "foo";
    }

}
