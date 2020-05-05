package com.proto.primedcomp;

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
    comments = "Source: factorize/factorization.proto")
public final class DecompositionGrpc {

  private DecompositionGrpc() {}

  public static final String SERVICE_NAME = "factorization.Decomposition";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.primedcomp.InputNumber,
      com.proto.primedcomp.OutputNumbers> getDecomposeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Decompose",
      requestType = com.proto.primedcomp.InputNumber.class,
      responseType = com.proto.primedcomp.OutputNumbers.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.primedcomp.InputNumber,
      com.proto.primedcomp.OutputNumbers> getDecomposeMethod() {
    io.grpc.MethodDescriptor<com.proto.primedcomp.InputNumber, com.proto.primedcomp.OutputNumbers> getDecomposeMethod;
    if ((getDecomposeMethod = DecompositionGrpc.getDecomposeMethod) == null) {
      synchronized (DecompositionGrpc.class) {
        if ((getDecomposeMethod = DecompositionGrpc.getDecomposeMethod) == null) {
          DecompositionGrpc.getDecomposeMethod = getDecomposeMethod =
              io.grpc.MethodDescriptor.<com.proto.primedcomp.InputNumber, com.proto.primedcomp.OutputNumbers>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Decompose"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.primedcomp.InputNumber.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.primedcomp.OutputNumbers.getDefaultInstance()))
              .setSchemaDescriptor(new DecompositionMethodDescriptorSupplier("Decompose"))
              .build();
        }
      }
    }
    return getDecomposeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DecompositionStub newStub(io.grpc.Channel channel) {
    return new DecompositionStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DecompositionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DecompositionBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DecompositionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DecompositionFutureStub(channel);
  }

  /**
   */
  public static abstract class DecompositionImplBase implements io.grpc.BindableService {

    /**
     */
    public void decompose(com.proto.primedcomp.InputNumber request,
        io.grpc.stub.StreamObserver<com.proto.primedcomp.OutputNumbers> responseObserver) {
      asyncUnimplementedUnaryCall(getDecomposeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDecomposeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.proto.primedcomp.InputNumber,
                com.proto.primedcomp.OutputNumbers>(
                  this, METHODID_DECOMPOSE)))
          .build();
    }
  }

  /**
   */
  public static final class DecompositionStub extends io.grpc.stub.AbstractStub<DecompositionStub> {
    private DecompositionStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DecompositionStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DecompositionStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DecompositionStub(channel, callOptions);
    }

    /**
     */
    public void decompose(com.proto.primedcomp.InputNumber request,
        io.grpc.stub.StreamObserver<com.proto.primedcomp.OutputNumbers> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getDecomposeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DecompositionBlockingStub extends io.grpc.stub.AbstractStub<DecompositionBlockingStub> {
    private DecompositionBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DecompositionBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DecompositionBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DecompositionBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.proto.primedcomp.OutputNumbers> decompose(
        com.proto.primedcomp.InputNumber request) {
      return blockingServerStreamingCall(
          getChannel(), getDecomposeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DecompositionFutureStub extends io.grpc.stub.AbstractStub<DecompositionFutureStub> {
    private DecompositionFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DecompositionFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DecompositionFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DecompositionFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_DECOMPOSE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DecompositionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DecompositionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DECOMPOSE:
          serviceImpl.decompose((com.proto.primedcomp.InputNumber) request,
              (io.grpc.stub.StreamObserver<com.proto.primedcomp.OutputNumbers>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DecompositionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DecompositionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.primedcomp.Factorization.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Decomposition");
    }
  }

  private static final class DecompositionFileDescriptorSupplier
      extends DecompositionBaseDescriptorSupplier {
    DecompositionFileDescriptorSupplier() {}
  }

  private static final class DecompositionMethodDescriptorSupplier
      extends DecompositionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DecompositionMethodDescriptorSupplier(String methodName) {
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
      synchronized (DecompositionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DecompositionFileDescriptorSupplier())
              .addMethod(getDecomposeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
