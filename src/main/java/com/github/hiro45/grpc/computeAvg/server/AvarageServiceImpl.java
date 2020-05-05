package com.github.hiro45.grpc.computeAvg.server;

import com.github.computeAvarage.Avarage;
import com.github.computeAvarage.AvarageServiceGrpc;
import com.github.computeAvarage.InputSeries;
import io.grpc.stub.StreamObserver;

public class AvarageServiceImpl extends AvarageServiceGrpc.AvarageServiceImplBase {
    @Override
    public StreamObserver<InputSeries> computeAvarage(StreamObserver<Avarage> responseObserver) {
        StreamObserver<InputSeries> inputSeriesStreamObserver = new StreamObserver<InputSeries>() {
            Integer sum = 0;
            Integer count = 0;
            @Override
            public void onNext(InputSeries value) {
                sum += value.getInputNumber();
                count += 1;
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                Double avg = (double) sum / (double)count;
                responseObserver.onNext(Avarage.newBuilder().setAvarage(avg).build());
                responseObserver.onCompleted();
            }
        };


        return inputSeriesStreamObserver;
    }
}
