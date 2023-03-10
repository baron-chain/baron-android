// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: persistence/halving/v1beta1/halving.proto

package persistence.halving.v1beta1;

public final class Halving {
  private Halving() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ParamsOrBuilder extends
      // @@protoc_insertion_point(interface_extends:persistence.halving.v1beta1.Params)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * periodic height at which inflation decreases
     * </pre>
     *
     * <code>uint64 blockHeight = 1 [(.gogoproto.moretags) = "yaml:&#92;"blockHeight&#92;""];</code>
     * @return The blockHeight.
     */
    long getBlockHeight();
  }
  /**
   * <pre>
   * Params holds parameters for the halving module.
   * </pre>
   *
   * Protobuf type {@code persistence.halving.v1beta1.Params}
   */
  public static final class Params extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:persistence.halving.v1beta1.Params)
      ParamsOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Params.newBuilder() to construct.
    private Params(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Params() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new Params();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Params(
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

              blockHeight_ = input.readUInt64();
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
      return persistence.halving.v1beta1.Halving.internal_static_persistence_halving_v1beta1_Params_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return persistence.halving.v1beta1.Halving.internal_static_persistence_halving_v1beta1_Params_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              persistence.halving.v1beta1.Halving.Params.class, persistence.halving.v1beta1.Halving.Params.Builder.class);
    }

    public static final int BLOCKHEIGHT_FIELD_NUMBER = 1;
    private long blockHeight_;
    /**
     * <pre>
     * periodic height at which inflation decreases
     * </pre>
     *
     * <code>uint64 blockHeight = 1 [(.gogoproto.moretags) = "yaml:&#92;"blockHeight&#92;""];</code>
     * @return The blockHeight.
     */
    @java.lang.Override
    public long getBlockHeight() {
      return blockHeight_;
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
      if (blockHeight_ != 0L) {
        output.writeUInt64(1, blockHeight_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (blockHeight_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(1, blockHeight_);
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
      if (!(obj instanceof persistence.halving.v1beta1.Halving.Params)) {
        return super.equals(obj);
      }
      persistence.halving.v1beta1.Halving.Params other = (persistence.halving.v1beta1.Halving.Params) obj;

      if (getBlockHeight()
          != other.getBlockHeight()) return false;
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
      hash = (37 * hash) + BLOCKHEIGHT_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getBlockHeight());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static persistence.halving.v1beta1.Halving.Params parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static persistence.halving.v1beta1.Halving.Params parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static persistence.halving.v1beta1.Halving.Params parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static persistence.halving.v1beta1.Halving.Params parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static persistence.halving.v1beta1.Halving.Params parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static persistence.halving.v1beta1.Halving.Params parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static persistence.halving.v1beta1.Halving.Params parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static persistence.halving.v1beta1.Halving.Params parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static persistence.halving.v1beta1.Halving.Params parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static persistence.halving.v1beta1.Halving.Params parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static persistence.halving.v1beta1.Halving.Params parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static persistence.halving.v1beta1.Halving.Params parseFrom(
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
    public static Builder newBuilder(persistence.halving.v1beta1.Halving.Params prototype) {
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
     * <pre>
     * Params holds parameters for the halving module.
     * </pre>
     *
     * Protobuf type {@code persistence.halving.v1beta1.Params}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:persistence.halving.v1beta1.Params)
        persistence.halving.v1beta1.Halving.ParamsOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return persistence.halving.v1beta1.Halving.internal_static_persistence_halving_v1beta1_Params_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return persistence.halving.v1beta1.Halving.internal_static_persistence_halving_v1beta1_Params_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                persistence.halving.v1beta1.Halving.Params.class, persistence.halving.v1beta1.Halving.Params.Builder.class);
      }

      // Construct using persistence.halving.v1beta1.Halving.Params.newBuilder()
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
        blockHeight_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return persistence.halving.v1beta1.Halving.internal_static_persistence_halving_v1beta1_Params_descriptor;
      }

      @java.lang.Override
      public persistence.halving.v1beta1.Halving.Params getDefaultInstanceForType() {
        return persistence.halving.v1beta1.Halving.Params.getDefaultInstance();
      }

      @java.lang.Override
      public persistence.halving.v1beta1.Halving.Params build() {
        persistence.halving.v1beta1.Halving.Params result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public persistence.halving.v1beta1.Halving.Params buildPartial() {
        persistence.halving.v1beta1.Halving.Params result = new persistence.halving.v1beta1.Halving.Params(this);
        result.blockHeight_ = blockHeight_;
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
        if (other instanceof persistence.halving.v1beta1.Halving.Params) {
          return mergeFrom((persistence.halving.v1beta1.Halving.Params)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(persistence.halving.v1beta1.Halving.Params other) {
        if (other == persistence.halving.v1beta1.Halving.Params.getDefaultInstance()) return this;
        if (other.getBlockHeight() != 0L) {
          setBlockHeight(other.getBlockHeight());
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
        persistence.halving.v1beta1.Halving.Params parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (persistence.halving.v1beta1.Halving.Params) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long blockHeight_ ;
      /**
       * <pre>
       * periodic height at which inflation decreases
       * </pre>
       *
       * <code>uint64 blockHeight = 1 [(.gogoproto.moretags) = "yaml:&#92;"blockHeight&#92;""];</code>
       * @return The blockHeight.
       */
      @java.lang.Override
      public long getBlockHeight() {
        return blockHeight_;
      }
      /**
       * <pre>
       * periodic height at which inflation decreases
       * </pre>
       *
       * <code>uint64 blockHeight = 1 [(.gogoproto.moretags) = "yaml:&#92;"blockHeight&#92;""];</code>
       * @param value The blockHeight to set.
       * @return This builder for chaining.
       */
      public Builder setBlockHeight(long value) {
        
        blockHeight_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * periodic height at which inflation decreases
       * </pre>
       *
       * <code>uint64 blockHeight = 1 [(.gogoproto.moretags) = "yaml:&#92;"blockHeight&#92;""];</code>
       * @return This builder for chaining.
       */
      public Builder clearBlockHeight() {
        
        blockHeight_ = 0L;
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


      // @@protoc_insertion_point(builder_scope:persistence.halving.v1beta1.Params)
    }

    // @@protoc_insertion_point(class_scope:persistence.halving.v1beta1.Params)
    private static final persistence.halving.v1beta1.Halving.Params DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new persistence.halving.v1beta1.Halving.Params();
    }

    public static persistence.halving.v1beta1.Halving.Params getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Params>
        PARSER = new com.google.protobuf.AbstractParser<Params>() {
      @java.lang.Override
      public Params parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Params(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Params> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Params> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public persistence.halving.v1beta1.Halving.Params getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_persistence_halving_v1beta1_Params_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_persistence_halving_v1beta1_Params_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n)persistence/halving/v1beta1/halving.pr" +
      "oto\022\033persistence.halving.v1beta1\032\024gogopr" +
      "oto/gogo.proto\";\n\006Params\022+\n\013blockHeight\030" +
      "\001 \001(\004B\026\362\336\037\022yaml:\"blockHeight\":\004\230\240\037\000B>Z<g" +
      "ithub.com/persistenceOne/persistence-sdk" +
      "/v2/x/halving/typesb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf2.GoGoProtos.getDescriptor(),
        });
    internal_static_persistence_halving_v1beta1_Params_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_persistence_halving_v1beta1_Params_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_persistence_halving_v1beta1_Params_descriptor,
        new java.lang.String[] { "BlockHeight", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.protobuf2.GoGoProtos.goprotoStringer);
    registry.add(com.google.protobuf2.GoGoProtos.moretags);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.protobuf2.GoGoProtos.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
