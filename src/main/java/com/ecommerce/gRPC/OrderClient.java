package com.ecommerce.gRPC;

import com.ecommerce.entity.Bestellung;
import com.ecommerce.gRPC.generated.GRPC;
import com.ecommerce.gRPC.generated.OrderServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class OrderClient {
    public static void sendOrderRequest(Bestellung bestellung) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        OrderServiceGrpc.OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);

        GRPC.KaufauftragRequest request = GRPC.KaufauftragRequest.newBuilder()
                .setOrderId(bestellung.getOrderID())
                .setCustomerId(bestellung.getCustomerID())
                .setProductId(bestellung.getProductID())
                .setQuantity(Integer.toString(bestellung.getQuantity()))
                .build();

        GRPC.KaufauftragReply reply = stub.newOrder(request);

        System.out.println("GRPC: Lieferdatum: " + reply.getLieferdatum());
        System.out.println("GRPC: Lieferstatus: " + reply.getLieferstatus());

        channel.shutdown();
    }
}