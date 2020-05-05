package com.github.hiro45.grpc.blog.client;


import com.google.gson.internal.$Gson$Preconditions;
import com.proto.blog.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;
import java.util.List;

public class BlogClient {

    public static void main(String[] args)  {
        System.out.println("Hello I'm a blogfor Client");
        BlogClient main = new BlogClient();
        main.run();
    }

    private void run() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

        BlogServiceGrpc.BlogServiceBlockingStub clientBlog = BlogServiceGrpc.newBlockingStub(channel);

        ////////////////////////////////////////////INSERT BLOG////////////////////////////////////////////
        Blog blog = Blog.newBuilder()
                .setAuthorId("Francesco")
                .setTitle("New Blog!")
                .setContent("Hello world is this my first blog")
                .build();

        CreateBlogResponse createBlogResponse = clientBlog.createBlog(CreateBlogRequest.newBuilder()
                        .setBlog(blog)
                        .build());

        System.out.println("Received blog response");
        System.out.println(createBlogResponse.toString());

        ////////////////////////////////////////////READ A BLOG////////////////////////////////////////////
        String blogId = createBlogResponse.getBlog().getId();

        clientBlog.readBlog(ReadBlogRequest.newBuilder()
                .setBlogId(blogId)
                .build());

        System.out.println(createBlogResponse.toString());

        //trigger a not found error
//        clientBlog.readBlog(ReadBlogRequest.newBuilder()
//                .setBlogId("5d59457ae5edf25e07cd70a9")
//                .build());
    /////////////////////////////////////////////UPDATE BLOG////////////////////////////////////////////

        Blog newBlog = Blog.newBuilder()
                .setId(blogId)
                .setAuthorId("Changed Author")
                .setTitle("Updated blog!")
                .setContent("Hello world this is my first blog! I've added some more content")
                .build();

        System.out.println("Updating blog...");
        UpdateBlogResponse updateBlogResponse =
                clientBlog.updateBlog(UpdateBlogRequest.newBuilder().setBlog(newBlog).build());

        System.out.println("Updated blog");
        System.out.println(updateBlogResponse.toString());

        /////////////////////////////////////////////DELETE BLOG////////////////////////////////////////////

        String blogToDelete = "5d596d77c15da503bb442edd";
        try {
            DeleteBlogRequest deleteBlogRequest = DeleteBlogRequest.newBuilder()
                    .setBlogId(blogToDelete)
                    .build();
            DeleteBlogResponse deleteBlogResponse = clientBlog.deleteBlog(deleteBlogRequest);
            System.out.println("Blog deleted");
            System.out.println(deleteBlogResponse.toString());
        } catch (Exception e){
            System.out.println("The dodcument you want to delete does not exist");
        }



        /////////////////////////////////////////////LIST BLOGS////////////////////////////////////////////
        System.out.println("");
        ListBlogRequest listBlogRequest = ListBlogRequest.newBuilder().build();
        Iterator<ListBlogResponse> listBlogResponse = clientBlog.listBlog(listBlogRequest);

        System.out.println("++++++++++++++Printing All the blogs+++++++++++++++++");
        listBlogResponse.forEachRemaining(Blog -> {
            System.out.println(Blog.toString());
        });

        System.out.println();

    }

}
