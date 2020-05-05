// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: factorize/factorization.proto

package com.proto.primedcomp;

/**
 * Protobuf type {@code factorization.OutputNumbers}
 */
public  final class OutputNumbers extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:factorization.OutputNumbers)
    OutputNumbersOrBuilder {
private static final long serialVersionUID = 0L;
  // Use OutputNumbers.newBuilder() to construct.
  private OutputNumbers(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OutputNumbers() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new OutputNumbers();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private OutputNumbers(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            decoposedNumbers_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.proto.primedcomp.Factorization.internal_static_factorization_OutputNumbers_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.proto.primedcomp.Factorization.internal_static_factorization_OutputNumbers_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.proto.primedcomp.OutputNumbers.class, com.proto.primedcomp.OutputNumbers.Builder.class);
  }

  public static final int DECOPOSEDNUMBERS_FIELD_NUMBER = 1;
  private int decoposedNumbers_;
  /**
   * <code>int32 decoposedNumbers = 1;</code>
   */
  public int getDecoposedNumbers() {
    return decoposedNumbers_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (decoposedNumbers_ != 0) {
      output.writeInt32(1, decoposedNumbers_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (decoposedNumbers_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, decoposedNumbers_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.proto.primedcomp.OutputNumbers)) {
      return super.equals(obj);
    }
    com.proto.primedcomp.OutputNumbers other = (com.proto.primedcomp.OutputNumbers) obj;

    if (getDecoposedNumbers()
        != other.getDecoposedNumbers()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + DECOPOSEDNUMBERS_FIELD_NUMBER;
    hash = (53 * hash) + getDecoposedNumbers();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.proto.primedcomp.OutputNumbers parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.proto.primedcomp.OutputNumbers parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.proto.primedcomp.OutputNumbers parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.proto.primedcomp.OutputNumbers parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.proto.primedcomp.OutputNumbers parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.proto.primedcomp.OutputNumbers parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.proto.primedcomp.OutputNumbers parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.proto.primedcomp.OutputNumbers parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.proto.primedcomp.OutputNumbers parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.proto.primedcomp.OutputNumbers parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.proto.primedcomp.OutputNumbers parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.proto.primedcomp.OutputNumbers parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.proto.primedcomp.OutputNumbers prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code factorization.OutputNumbers}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:factorization.OutputNumbers)
      com.proto.primedcomp.OutputNumbersOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.proto.primedcomp.Factorization.internal_static_factorization_OutputNumbers_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.proto.primedcomp.Factorization.internal_static_factorization_OutputNumbers_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.proto.primedcomp.OutputNumbers.class, com.proto.primedcomp.OutputNumbers.Builder.class);
    }

    // Construct using com.proto.primedcomp.OutputNumbers.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      decoposedNumbers_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.proto.primedcomp.Factorization.internal_static_factorization_OutputNumbers_descriptor;
    }

    @java.lang.Override
    public com.proto.primedcomp.OutputNumbers getDefaultInstanceForType() {
      return com.proto.primedcomp.OutputNumbers.getDefaultInstance();
    }

    @java.lang.Override
    public com.proto.primedcomp.OutputNumbers build() {
      com.proto.primedcomp.OutputNumbers result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.proto.primedcomp.OutputNumbers buildPartial() {
      com.proto.primedcomp.OutputNumbers result = new com.proto.primedcomp.OutputNumbers(this);
      result.decoposedNumbers_ = decoposedNumbers_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.proto.primedcomp.OutputNumbers) {
        return mergeFrom((com.proto.primedcomp.OutputNumbers)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.proto.primedcomp.OutputNumbers other) {
      if (other == com.proto.primedcomp.OutputNumbers.getDefaultInstance()) return this;
      if (other.getDecoposedNumbers() != 0) {
        setDecoposedNumbers(other.getDecoposedNumbers());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.proto.primedcomp.OutputNumbers parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.proto.primedcomp.OutputNumbers) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int decoposedNumbers_ ;
    /**
     * <code>int32 decoposedNumbers = 1;</code>
     */
    public int getDecoposedNumbers() {
      return decoposedNumbers_;
    }
    /**
     * <code>int32 decoposedNumbers = 1;</code>
     */
    public Builder setDecoposedNumbers(int value) {
      
      decoposedNumbers_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 decoposedNumbers = 1;</code>
     */
    public Builder clearDecoposedNumbers() {
      
      decoposedNumbers_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:factorization.OutputNumbers)
  }

  // @@protoc_insertion_point(class_scope:factorization.OutputNumbers)
  private static final com.proto.primedcomp.OutputNumbers DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.proto.primedcomp.OutputNumbers();
  }

  public static com.proto.primedcomp.OutputNumbers getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OutputNumbers>
      PARSER = new com.google.protobuf.AbstractParser<OutputNumbers>() {
    @java.lang.Override
    public OutputNumbers parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new OutputNumbers(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<OutputNumbers> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OutputNumbers> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.proto.primedcomp.OutputNumbers getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
