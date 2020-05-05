package com.github.hiro45.grpc.blog.server;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.proto.blog.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class BlogServerImpl extends BlogServiceGrpc.BlogServiceImplBase {
    private MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    private MongoDatabase database = mongoClient.getDatabase("myDB");
    private MongoCollection<Document> collection = database.getCollection("blog");

    private Blog documentToBlog(Document document){
        return Blog.newBuilder()
                .setAuthorId(document.getString("author_id"))
                .setTitle(document.getString("title"))
                .setContent(document.getString("content"))
                .setId(document.getObjectId("_id").toString())
                .build();
    }

    @Override
    public void createBlog(CreateBlogRequest request, StreamObserver<CreateBlogResponse> responseObserver) {

        System.out.println("Received Create Blog request");
        Blog blog = request.getBlog();
        Document doc = new Document("author_id", blog.getAuthorId())
                .append("title", blog.getTitle())
                .append("content", blog.getContent());

        System.out.println("Inserting blog ...");
        //we insert the document in MongoDB
        collection.insertOne(doc);

        //we retrive the mongoDB generated _id
        String id = doc.getObjectId("_id").toString();
        System.out.println("Inserte blog: "+ id);

//        CreateBlogResponse response = CreateBlogResponse.newBuilder()
//                .setBlog(Blog.newBuilder()
//                    .setAuthorId(blog.getAuthorId())
//                    .setContent(blog.getContent())
//                    .setTitle(blog.getTitle())
//                    .setTitle(id)
//                ).build();

        CreateBlogResponse response = CreateBlogResponse.newBuilder()
                .setBlog(blog.toBuilder().setId(id).build()
                ).build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();

    }

    @Override
    public void readBlog(ReadBlogRequest request, StreamObserver<ReadBlogResponse> responseObserver) {
        String blogId = request.getBlogId();
        Document requestedBlog = null;

        System.out.println("Received th Read Blog request");
        try {
            requestedBlog = collection.find(eq("_id", new ObjectId(blogId)))
                    .first();
        }catch (Exception e){
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("The blog with the corresponding id was not found")
                            .augmentDescription(e.getLocalizedMessage())
                            .asRuntimeException()
            );
        }

        if (requestedBlog == null){
            System.out.println("Document associate with the id requested do no exist");
            responseObserver.onError(
                    Status.NOT_FOUND
                    .withDescription("The blog with the corresponding id was not found")
                    .asRuntimeException()
            );
        }else {
            System.out.println("I'm returning the blog associated with the id requested");
            Blog blogToReturn = documentToBlog(requestedBlog);
            responseObserver.onNext(ReadBlogResponse.newBuilder()
                    .setBlog(blogToReturn)
                    .build());
            responseObserver.onCompleted();
        }

    }

    @Override
    public void updateBlog(UpdateBlogRequest request, StreamObserver<UpdateBlogResponse> responseObserver) {
        String blogId = request.getBlog().getId();
        Blog newBlog = request.getBlog();

        Document requestedBlog = null;

        System.out.println("Received Update Blog request");
        try {
            requestedBlog = collection.find(eq("_id", new ObjectId(blogId)))
                    .first();
        }catch (Exception e){
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("The blog with the corresponding id was not found")
                            .augmentDescription(e.getLocalizedMessage())
                            .asRuntimeException()
            );
        }

        if (requestedBlog == null){
            System.out.println("Document associate with the id requested do no exist");
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("The blog with the corresponding id was not found")
                            .asRuntimeException()
            );
        }else {
            System.out.println("I'm updating the blog associated with the id requested");
            Document replacement = new Document("author_id", newBlog.getAuthorId())
                    .append("title",newBlog.getTitle())
                    .append("content",newBlog.getContent());

            collection.replaceOne(eq("_id", requestedBlog.getObjectId("_id")), replacement);
            Document updatedBlog = collection.find(eq("_id", new ObjectId(blogId))).first();

            System.out.println("I'm returning the blog associated with the id requested");
            Blog blogToReturn = documentToBlog(updatedBlog);
            responseObserver.onNext(UpdateBlogResponse.newBuilder()
                    .setBlog(blogToReturn)
                    .build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void deleteBlog(DeleteBlogRequest request, StreamObserver<DeleteBlogResponse> responseObserver) {

        System.out.println("Received delete blog response");
        String blogId = request.getBlogId();
        DeleteResult result = null;
        try {
            result = collection.deleteOne(eq("_id", new ObjectId(blogId)));
        } catch (Exception e){
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("The blog with the corresponding id was not found")
                            .augmentDescription(e.getLocalizedMessage())
                            .asRuntimeException()
            );
        }
        if (result.getDeletedCount() == 0){
            System.out.println("Blog not found");
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("The blog with the corresponding id was not found")
                            .asRuntimeException()
            );
        }else {
            System.out.println("Blog was deleted");
            responseObserver.onNext(DeleteBlogResponse.newBuilder()
                    .setBlogId(blogId)
                    .build());
            responseObserver.onCompleted();
        }

    }

    @Override
    public void listBlog(ListBlogRequest request, StreamObserver<ListBlogResponse> responseObserver) {
        System.out.println("Receied List Blog Request");

        collection.find().iterator().forEachRemaining(document -> {
            responseObserver.onNext(ListBlogResponse.newBuilder()
                            .setBlog(documentToBlog(document))
                            .build());
        });

        responseObserver.onCompleted();
    }
}
