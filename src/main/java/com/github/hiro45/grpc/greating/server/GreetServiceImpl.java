package com.github.hiro45.grpc.greating.server;

import com.proto.greet.*;
import io.grpc.Context;
import io.grpc.stub.StreamObserver;

import javax.swing.*;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    //implementation of the function for the unary API
    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        //extract the fields we need
        Greeting greeting = request.getGreeting();
        String firstName  = greeting.getFirstName();

        //create the response
        String result = "Hello " + firstName;
        GreetResponse response = GreetResponse.newBuilder().setResult(result).build();

        //send response back to the client
        responseObserver.onNext(response);

        //complete the gRPC call
        responseObserver.onCompleted();

    }


    //Implementation of the function for the SERVER streaming API
    @Override
    public void greetManyTime(GreetManyTimeRequest request, StreamObserver<GreetManyTimeResponse> responseObserver) {
        String firstName = request.getGreeting().getFirstName();
        String secondName = request.getGreeting().getLastName();

        try{
            for (int i = 0; i < 10; i++){
                String result = "Hello" + firstName + "," + secondName + "for the " + i + "time";
                GreetManyTimeResponse response = GreetManyTimeResponse.newBuilder().setResult(result).build();
                responseObserver.onNext(response);
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e){
                e.printStackTrace();
        } finally {
            responseObserver.onCompleted();
        }
    }


    //Implementation of the function for the CLIENT streaming API
    @Override
    public StreamObserver<LongGreetRequest> longGreet(StreamObserver<LongGreetResponse> responseObserver) {

        StreamObserver<LongGreetRequest> requestObserver = new StreamObserver<LongGreetRequest>() {
            String result = "";

            @Override
            public void onNext(LongGreetRequest value) {
                //client send a message
                result += "Hello " + value.getGreeting().getFirstName() + "! ";

            }

            @Override
            public void onError(Throwable t) {
                //client send an error
            }

            @Override
            public void onCompleted() {
                //client is done --> when it is done se sete the response with the final string
                responseObserver.onNext(LongGreetResponse.newBuilder().setResult(result).build());
                responseObserver.onCompleted();
                //this is when we want to return a resonse (responseObserver)
            }
        };

        return requestObserver;
    }

    @Override
    public StreamObserver<GreetEveryOneRequest> greetEveryOne(StreamObserver<GreetEveryOneResponse> responseObserver) {
        StreamObserver<GreetEveryOneRequest> requestObserver = new StreamObserver<GreetEveryOneRequest>() {
            @Override
            public void onNext(GreetEveryOneRequest value) {
                String response = "Hello " + value.getGreeting().getFirstName();
                GreetEveryOneResponse greetEveryOneResponse = GreetEveryOneResponse.newBuilder()
                        .setResult(response)
                        .build();
                responseObserver.onNext(greetEveryOneResponse);
            }

            @Override
            public void onError(Throwable t) {
                //TODO
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };

        return  requestObserver;
    }

    @Override
    public void greetWithDeadline(GreetWithDeadlineRequest request, StreamObserver<GreetWithDeadlineResponse> responseObserver) {

        Context current = Context.current();

        try {
        for (int i = 0; i < 3; i++){
                if (!current.isCancelled()){
                 System.out.println("Selle for 100 ms");
                Thread.sleep(100);
                } else {
                    break;
                }
            }

            System.out.println("Send Response");
            GreetWithDeadlineResponse greetResponse = GreetWithDeadlineResponse.newBuilder()
                    .setResult("Hello" + request.getGreeting().getFirstName())
                    .build();

            responseObserver.onNext(greetResponse);
            responseObserver.onCompleted();

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
