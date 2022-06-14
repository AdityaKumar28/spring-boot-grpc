package io.github.adityakumar28.service;

import io.github.adityakumar28.PersonRequest;
import io.github.adityakumar28.PersonResponse;
import io.github.adityakumar28.PersonServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PersonService extends PersonServiceGrpc.PersonServiceImplBase {
    @Override
    public void getNameByPerson(PersonRequest request, StreamObserver<PersonResponse> responseObserver) {
        System.out.println("Received message: " + request);
        PersonResponse personResponse = PersonResponse
                .newBuilder()
                .setName(request.getName())
                .build();
        responseObserver.onNext(personResponse);
        responseObserver.onCompleted();
    }
}
