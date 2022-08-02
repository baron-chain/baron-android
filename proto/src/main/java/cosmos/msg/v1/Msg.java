// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/msg/v1/msg.proto

package cosmos.msg.v1;

public final class Msg {
  private Msg() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
    registry.add(cosmos.msg.v1.Msg.signer);
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public static final int SIGNER_FIELD_NUMBER = 11110000;
  /**
   * <pre>
   * signer must be used in cosmos messages in order
   * to signal to external clients which fields in a
   * given cosmos message must be filled with signer
   * information (address).
   * The field must be the protobuf name of the message
   * field extended with this MessageOption.
   * The field must either be of string kind, or of message
   * kind in case the signer information is contained within
   * a message inside the cosmos message.
   * </pre>
   *
   * <code>extend .google.protobuf.MessageOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.MessageOptions,
      java.util.List<java.lang.String>> signer = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027cosmos/msg/v1/msg.proto\022\rcosmos.msg.v1" +
      "\032 google/protobuf/descriptor.proto:2\n\006si" +
      "gner\022\037.google.protobuf.MessageOptions\030\360\214" +
      "\246\005 \003(\tB/Z-github.com/cosmos/cosmos-sdk/t" +
      "ypes/msgserviceb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.DescriptorProtos.getDescriptor(),
        });
    signer.internalInit(descriptor.getExtensions().get(0));
    com.google.protobuf.DescriptorProtos.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
