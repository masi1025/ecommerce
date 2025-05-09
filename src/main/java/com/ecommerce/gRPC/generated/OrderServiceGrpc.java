package com.ecommerce.gRPC.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Definition des gRPC-Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: gRPC.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OrderServiceGrpc {

  private OrderServiceGrpc() {}

  public static final String SERVICE_NAME = "com.avg.OrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ecommerce.gRPC.generated.GRPC.KaufauftragRequest,
      com.ecommerce.gRPC.generated.GRPC.KaufauftragReply> getNewOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "newOrder",
      requestType = com.ecommerce.gRPC.generated.GRPC.KaufauftragRequest.class,
      responseType = com.ecommerce.gRPC.generated.GRPC.KaufauftragReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ecommerce.gRPC.generated.GRPC.KaufauftragRequest,
      com.ecommerce.gRPC.generated.GRPC.KaufauftragReply> getNewOrderMethod() {
    io.grpc.MethodDescriptor<com.ecommerce.gRPC.generated.GRPC.KaufauftragRequest, com.ecommerce.gRPC.generated.GRPC.KaufauftragReply> getNewOrderMethod;
    if ((getNewOrderMethod = OrderServiceGrpc.getNewOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getNewOrderMethod = OrderServiceGrpc.getNewOrderMethod) == null) {
          OrderServiceGrpc.getNewOrderMethod = getNewOrderMethod =
              io.grpc.MethodDescriptor.<com.ecommerce.gRPC.generated.GRPC.KaufauftragRequest, com.ecommerce.gRPC.generated.GRPC.KaufauftragReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "newOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ecommerce.gRPC.generated.GRPC.KaufauftragRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ecommerce.gRPC.generated.GRPC.KaufauftragReply.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("newOrder"))
              .build();
        }
      }
    }
    return getNewOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OrderServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceStub>() {
        @java.lang.Override
        public OrderServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceStub(channel, callOptions);
        }
      };
    return OrderServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingStub>() {
        @java.lang.Override
        public OrderServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceBlockingStub(channel, callOptions);
        }
      };
    return OrderServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceFutureStub>() {
        @java.lang.Override
        public OrderServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceFutureStub(channel, callOptions);
        }
      };
    return OrderServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Definition des gRPC-Service
   * </pre>
   */
  public static abstract class OrderServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Kaufauftrag verarbeiten
     * </pre>
     */
    public void newOrder(com.ecommerce.gRPC.generated.GRPC.KaufauftragRequest request,
        io.grpc.stub.StreamObserver<com.ecommerce.gRPC.generated.GRPC.KaufauftragReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getNewOrderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getNewOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.ecommerce.gRPC.generated.GRPC.KaufauftragRequest,
                com.ecommerce.gRPC.generated.GRPC.KaufauftragReply>(
                  this, METHODID_NEW_ORDER)))
          .build();
    }
  }

  /**
   * <pre>
   * Definition des gRPC-Service
   * </pre>
   */
  public static final class OrderServiceStub extends io.grpc.stub.AbstractAsyncStub<OrderServiceStub> {
    private OrderServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Kaufauftrag verarbeiten
     * </pre>
     */
    public void newOrder(com.ecommerce.gRPC.generated.GRPC.KaufauftragRequest request,
        io.grpc.stub.StreamObserver<com.ecommerce.gRPC.generated.GRPC.KaufauftragReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getNewOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Definition des gRPC-Service
   * </pre>
   */
  public static final class OrderServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<OrderServiceBlockingStub> {
    private OrderServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Kaufauftrag verarbeiten
     * </pre>
     */
    public com.ecommerce.gRPC.generated.GRPC.KaufauftragReply newOrder(com.ecommerce.gRPC.generated.GRPC.KaufauftragRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNewOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Definition des gRPC-Service
   * </pre>
   */
  public static final class OrderServiceFutureStub extends io.grpc.stub.AbstractFutureStub<OrderServiceFutureStub> {
    private OrderServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Kaufauftrag verarbeiten
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ecommerce.gRPC.generated.GRPC.KaufauftragReply> newOrder(
        com.ecommerce.gRPC.generated.GRPC.KaufauftragRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getNewOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_NEW_ORDER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OrderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OrderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NEW_ORDER:
          serviceImpl.newOrder((com.ecommerce.gRPC.generated.GRPC.KaufauftragRequest) request,
              (io.grpc.stub.StreamObserver<com.ecommerce.gRPC.generated.GRPC.KaufauftragReply>) responseObserver);
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

  private static abstract class OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ecommerce.gRPC.generated.GRPC.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrderService");
    }
  }

  private static final class OrderServiceFileDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier {
    OrderServiceFileDescriptorSupplier() {}
  }

  private static final class OrderServiceMethodDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OrderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (OrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OrderServiceFileDescriptorSupplier())
              .addMethod(getNewOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
