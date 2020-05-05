package com.github.hiro45.grpc.greating.client;

import com.proto.dummy.DummyServiceGrpc;
import com.proto.greet.*;
import io.grpc.*;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.net.ssl.SSLException;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GreetingClient {

    public static void main(String[] args) throws SSLException {
        System.out.println("Hello I'm a gPRC client");
        GreetingClient main = new GreetingClient();
        main.run();
    }

    private void run() throws SSLException {
        ManagedChannel channel;
        channel = ManagedChannelBuilder.forAddress("localhost",50051)
                .usePlaintext()
                .build();

        //for production use secureChannel
        ManagedChannel secureChannel = NettyChannelBuilder.forAddress("localhost", 50051)
                .sslContext(GrpcSslContexts.forClient().trustManager(new File("ssl/ca.crt")).build())
                .build();

        doUnaryCall(channel);
        //doServerStreamingCall(channel);
        //doClientStreamingCall(channel);
        //doBiDirectionalCall(channel);
        //doUneryCallWithDeadline(channel);

        System.out.println("Shutting down channel");
        channel.shutdown();
    }

    private void doUnaryCall(ManagedChannel channel){
        System.out.println("Creating stub");
        GreetServiceGrpc.GreetServiceBlockingStub greetClient = GreetServiceGrpc.newBlockingStub(channel);

        Greeting greeting = Greeting.newBuilder()
                .setFirstName("Francesco")
                .setLastName("Giopp")
                .build();

        //create a protocol buffer for a GreetingRequst
        GreetRequest greetRequest = GreetRequest.newBuilder()
                .setGreeting(greeting)
                .build();

        //call RPC and get back a GreetResponse (protocol buffer)
        GreetResponse greetResponse = greetClient.greet(greetRequest);
        System.out.println(greetResponse.getResult());
    }

    private void doServerStreamingCall(ManagedChannel channel){
        System.out.println("Creating stub");
        GreetServiceGrpc.GreetServiceBlockingStub greetClient = GreetServiceGrpc.newBlockingStub(channel);
        // ##################### Server Streaming #####################
        //we prepare the request
        GreetManyTimeRequest greetManyTimeRequest = GreetManyTimeRequest.newBuilder()
                .setGreeting(Greeting.newBuilder().setFirstName("Francesco").setLastName("Giopp"))
                .build();

        //we stream the response (in a blocking manner)
        //as long the server don't send completed, forEachRemaining expect the response
        greetClient.greetManyTime(greetManyTimeRequest).forEachRemaining(greetManyTimeResponse ->
                System.out.println(greetManyTimeResponse.getResult())
        );
    }

    private void doClientStreamingCall(ManagedChannel channel){
        //creating stub
        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);

        //creating the latch for the async Client
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<LongGreetRequest> requestObserver = asyncClient.longGreet(new StreamObserver<LongGreetResponse>() {
            @Override
            public void onNext(LongGreetResponse value) {
                //we get a response from the server
                System.out.println("Received a response from the server");
                System.out.println(value.getResult());
                //onNext will be called only once
            }

            @Override
            public void onError(Throwable t) {
                //we get an error from the server
            }

            @Override
            public void onCompleted() {
                //the server is done sending us data
                //onClempeted will ber called right after onNewst
                System.out.println("Server has completed sending us something");
                latch.countDown();
            }
        });
        //streaming message #1
        System.out.println("Sending message 1");
        requestObserver.onNext(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("Francesco")
                        .setLastName("Giopp"))
                .build());

        //streaming message #2
        System.out.println("Sending message 2");
        requestObserver.onNext(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("Eleonora")
                        .setLastName("Dalla Rosa"))
                .build());

        //streaming message #3
        System.out.println("Sending message 3");
        requestObserver.onNext(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("bho")
                        .setLastName("final"))
                .build());

        //we tell the server that te Client is down sending data
        requestObserver.onCompleted();

        try {
            latch.await(3L, TimeUnit.SECONDS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    private void doBiDirectionalCall(ManagedChannel channel){
        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<GreetEveryOneRequest> requestObserver = asyncClient.greetEveryOne(
                new StreamObserver<GreetEveryOneResponse>() {
            @Override
            public void onNext(GreetEveryOneResponse value) {
                System.out.println("Response from Server: " + value.getResult());
            }

            @Override
            public void onError(Throwable t) {
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Server is done sending data");
                latch.countDown();
            }
        });

        Arrays.asList("Francesco", "Eleonora", "bho").forEach(
                name -> {
                    System.out.println("Sending: " + name);
                    requestObserver.onNext(GreetEveryOneRequest.newBuilder()
                        .setGreeting(Greeting.newBuilder().setFirstName(name))
                        .build());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        requestObserver.onCompleted();

        try {
            latch.await(3L,TimeUnit.SECONDS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    private void doUneryCallWithDeadline(ManagedChannel channel){
        GreetServiceGrpc.GreetServiceBlockingStub blockingClient =
                GreetServiceGrpc.newBlockingStub(channel);

        //first call 3000
        try {
            System.out.println("Sending a request with a deadline with 3000 ms");
            GreetWithDeadlineResponse response = blockingClient.withDeadline(Deadline.after(3000, TimeUnit.MILLISECONDS))
                    .greetWithDeadline(GreetWithDeadlineRequest.newBuilder()
                            .setGreeting(Greeting.newBuilder().setFirstName("Francesco"))
                            .build());
            System.out.println(response.getResult());
        }catch (StatusRuntimeException e){
            if (e.getStatus() == Status.DEADLINE_EXCEEDED){
                System.out.println("Deadline have been eceeded we don't want the response");
            } else {
                e.printStackTrace();
            }
        }

        //first call 100
        try {
            System.out.println("Sending a request with a deadline with 100 ms");
            GreetWithDeadlineResponse response = blockingClient.withDeadline(Deadline.after(100, TimeUnit.MILLISECONDS))
                    .greetWithDeadline(GreetWithDeadlineRequest.newBuilder()
                            .setGreeting(Greeting.newBuilder().setFirstName("Francesco"))
                            .build());
            System.out.println(response.getResult());
        }catch (StatusRuntimeException e){
            if (e.getStatus() == Status.DEADLINE_EXCEEDED){
                System.out.println("Deadline have been eceeded we don't want the response");
            } else {
                e.printStackTrace();
            }
        }

    }

}//fine class
