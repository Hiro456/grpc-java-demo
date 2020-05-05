package com.github.hiro45.grpc.findMax.server;

import com.proto.findMax.FindMaximumGrpc;
import com.proto.findMax.InputNumbers;
import com.proto.findMax.Max;
import io.grpc.stub.StreamObserver;

class FindMaxServiceImpl extends FindMaximumGrpc.FindMaximumImplBase {

    @Override
    public StreamObserver<InputNumbers> findMax(StreamObserver<Max> responseObserver) {

        StreamObserver<InputNumbers> requestObserver = new StreamObserver<InputNumbers>() {
            Integer currentMax = 0;
            @Override
            public void onNext(InputNumbers value) {
                Integer lastArrivedNumber = value.getInputNumbers();
                if (lastArrivedNumber > currentMax) {
                    currentMax = lastArrivedNumber;
                    responseObserver.onNext(Max.newBuilder().setMax(currentMax).build());
                }
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };

        return requestObserver;
    }
}