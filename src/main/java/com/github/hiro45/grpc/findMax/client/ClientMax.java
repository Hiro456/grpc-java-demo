package com.github.hiro45.grpc.findMax.client;

import com.proto.findMax.FindMaximumGrpc;
import com.proto.findMax.InputNumbers;
import com.proto.findMax.Max;
import com.proto.primedcomp.InputNumber;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ClientMax {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        FindMaximumGrpc.FindMaximumStub asyncClient = FindMaximumGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<InputNumbers> requestObserver = asyncClient.findMax(new StreamObserver<Max>() {
            @Override
            public void onNext(Max value) {
                System.out.println("The max value is: " + value.getMax());
            }

            @Override
            public void onError(Throwable t) {
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("The server is done sending data");
                latch.countDown();
            }
        });

//        List<Integer> serieOfNumbers = new ArrayList<Integer>();
//        serieOfNumbers.add(1);
//        serieOfNumbers.add(5);
//        serieOfNumbers.add(3);
//        serieOfNumbers.add(6);
//        serieOfNumbers.add(2);
//        serieOfNumbers.add(20);

        List<Integer> serieOfNumbers = Arrays.asList(1,5,3,6,2,20);

        serieOfNumbers.forEach(
                name -> {
                    System.out.println("Sending the number" + name);
                    requestObserver.onNext(InputNumbers.newBuilder().setInputNumbers(name).build());
                }
        );

        requestObserver.onCompleted();

        try {
            latch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
