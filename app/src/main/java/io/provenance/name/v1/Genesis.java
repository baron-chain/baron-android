// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: provenance/name/v1/genesis.proto

package io.provenance.name.v1;

public final class Genesis {
  private Genesis() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_provenance_name_v1_GenesisState_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_provenance_name_v1_GenesisState_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n provenance/name/v1/genesis.proto\022\022prov" +
      "enance.name.v1\032\024gogoproto/gogo.proto\032\035pr" +
      "ovenance/name/v1/name.proto\"\202\001\n\014GenesisS" +
      "tate\0220\n\006params\030\001 \001(\0132\032.provenance.name.v" +
      "1.ParamsB\004\310\336\037\000\0226\n\010bindings\030\002 \003(\0132\036.prove" +
      "nance.name.v1.NameRecordB\004\310\336\037\000:\010\350\240\037\000\210\240\037\000" +
      "BK\n\025io.provenance.name.v1P\001Z0github.com/" +
      "provenance-io/provenance/x/name/typesb\006p" +
      "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf2.GoGoProtos.getDescriptor(),
          io.provenance.name.v1.Name.getDescriptor(),
        });
    internal_static_provenance_name_v1_GenesisState_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_provenance_name_v1_GenesisState_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_provenance_name_v1_GenesisState_descriptor,
        new java.lang.String[] { "Params", "Bindings", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.protobuf2.GoGoProtos.equal);
    registry.add(com.google.protobuf2.GoGoProtos.goprotoGetters);
    registry.add(com.google.protobuf2.GoGoProtos.nullable);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.protobuf2.GoGoProtos.getDescriptor();
    io.provenance.name.v1.Name.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
