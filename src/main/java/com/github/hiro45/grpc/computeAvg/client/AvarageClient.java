package com.github.hiro45.grpc.computeAvg.client;

import com.github.computeAvarage.Avarage;
import com.github.computeAvarage.AvarageServiceGrpc;
import com.github.computeAvarage.InputSeries;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AvarageClient {



    private void run(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        AvarageServiceGrpc.AvarageServiceStub asyncClient = AvarageServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<InputSeries> requestObserver = asyncClient.computeAvarage(new StreamObserver<Avarage>() {
            @Override
            public void onNext(Avarage value) {
                System.out.println("The avarage of the series is: "+ value.getAvarage());
            }
            @Override
            public void onError(Throwable t) {
                //TODO
            }
            @Override
            public void onCompleted() {
                System.out.println("Serer has completed");
                latch.countDown();
            }
        });

        //Streaming messaggesso to the server
        System.out.println("Sending Messagges");
        for (int i=1; i<5;i++){
            System.out.println(i);
        requestObserver.onNext(InputSeries.newBuilder().setInputNumber(i).build());
        }

        requestObserver.onCompleted();

        try {
            latch.await(3L, TimeUnit.SECONDS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }



    }


    public static void main(String[] args) {
        AvarageClient main = new AvarageClient();
        main.run();
    }

}
