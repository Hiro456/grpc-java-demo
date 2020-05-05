package com.github.computeAvarage;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: computeAvarage/computeAarage.proto")
public final class AvarageServiceGrpc {

  private AvarageServiceGrpc() {}

  public static final String SERVICE_NAME = "computeAvarage.AvarageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.github.computeAvarage.InputSeries,
      com.github.computeAvarage.Avarage> getComputeAvarageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComputeAvarage",
      requestType = com.github.computeAvarage.InputSeries.class,
      responseType = com.github.computeAvarage.Avarage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.github.computeAvarage.InputSeries,
      com.github.computeAvarage.Avarage> getComputeAvarageMethod() {
    io.grpc.MethodDescriptor<com.github.computeAvarage.InputSeries, com.github.computeAvarage.Avarage> getComputeAvarageMethod;
    if ((getComputeAvarageMethod = AvarageServiceGrpc.getComputeAvarageMethod) == null) {
      synchronized (AvarageServiceGrpc.class) {
        if ((getComputeAvarageMethod = AvarageServiceGrpc.getComputeAvarageMethod) == null) {
          AvarageServiceGrpc.getComputeAvarageMethod = getComputeAvarageMethod =
              io.grpc.MethodDescriptor.<com.github.computeAvarage.InputSeries, com.github.computeAvarage.Avarage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ComputeAvarage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.computeAvarage.InputSeries.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.computeAvarage.Avarage.getDefaultInstance()))
              .setSchemaDescriptor(new AvarageServiceMethodDescriptorSupplier("ComputeAvarage"))
              .build();
        }
      }
    }
    return getComputeAvarageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AvarageServiceStub newStub(io.grpc.Channel channel) {
    return new AvarageServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AvarageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AvarageServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AvarageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AvarageServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AvarageServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.github.computeAvarage.InputSeries> computeAvarage(
        io.grpc.stub.StreamObserver<com.github.computeAvarage.Avarage> responseObserver) {
      return asyncUnimplementedStreamingCall(getComputeAvarageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getComputeAvarageMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.github.computeAvarage.InputSeries,
                com.github.computeAvarage.Avarage>(
                  this, METHODID_COMPUTE_AVARAGE)))
          .build();
    }
  }

  /**
   */
  public static final class AvarageServiceStub extends io.grpc.stub.AbstractStub<AvarageServiceStub> {
    private AvarageServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AvarageServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AvarageServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AvarageServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.github.computeAvarage.InputSeries> computeAvarage(
        io.grpc.stub.StreamObserver<com.github.computeAvarage.Avarage> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getComputeAvarageMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class AvarageServiceBlockingStub extends io.grpc.stub.AbstractStub<AvarageServiceBlockingStub> {
    private AvarageServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AvarageServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AvarageServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AvarageServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class AvarageServiceFutureStub extends io.grpc.stub.AbstractStub<AvarageServiceFutureStub> {
    private AvarageServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AvarageServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AvarageServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AvarageServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_COMPUTE_AVARAGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AvarageServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AvarageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPUTE_AVARAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.computeAvarage(
              (io.grpc.stub.StreamObserver<com.github.computeAvarage.Avarage>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AvarageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AvarageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.github.computeAvarage.ComputeAarage.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AvarageService");
    }
  }

  private static final class AvarageServiceFileDescriptorSupplier
      extends AvarageServiceBaseDescriptorSupplier {
    AvarageServiceFileDescriptorSupplier() {}
  }

  private static final class AvarageServiceMethodDescriptorSupplier
      extends AvarageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AvarageServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AvarageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AvarageServiceFileDescriptorSupplier())
              .addMethod(getComputeAvarageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
