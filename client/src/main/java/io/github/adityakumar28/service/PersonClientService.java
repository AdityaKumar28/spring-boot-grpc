package io.github.adityakumar28.service;

import io.github.adityakumar28.PersonRequest;
import io.github.adityakumar28.PersonResponse;
import io.github.adityakumar28.PersonServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class PersonClientService {
    @GrpcClient("grpc-person-service")
    PersonServiceGrpc.PersonServiceBlockingStub personServiceBlockingStub;

    public PersonResponse getNameByPerson(PersonRequest personRequest){
        return personServiceBlockingStub.getNameByPerson(personRequest);
    }
}
