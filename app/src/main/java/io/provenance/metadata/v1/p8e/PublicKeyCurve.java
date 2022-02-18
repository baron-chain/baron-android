// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: provenance/metadata/v1/p8e/p8e.proto

package io.provenance.metadata.v1.p8e;

/**
 * Protobuf enum {@code provenance.metadata.v1.p8e.PublicKeyCurve}
 */
public enum PublicKeyCurve
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>SECP256K1 = 0;</code>
   */
  SECP256K1(0),
  /**
   * <code>P256 = 1;</code>
   */
  P256(1),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>SECP256K1 = 0;</code>
   */
  public static final int SECP256K1_VALUE = 0;
  /**
   * <code>P256 = 1;</code>
   */
  public static final int P256_VALUE = 1;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static PublicKeyCurve valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static PublicKeyCurve forNumber(int value) {
    switch (value) {
      case 0: return SECP256K1;
      case 1: return P256;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<PublicKeyCurve>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      PublicKeyCurve> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<PublicKeyCurve>() {
          public PublicKeyCurve findValueByNumber(int number) {
            return PublicKeyCurve.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return io.provenance.metadata.v1.p8e.P8E.getDescriptor().getEnumTypes().get(1);
  }

  private static final PublicKeyCurve[] VALUES = values();

  public static PublicKeyCurve valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private PublicKeyCurve(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:provenance.metadata.v1.p8e.PublicKeyCurve)
}

