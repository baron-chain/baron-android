// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: provenance/marker/v1/marker.proto

package io.provenance.marker.v1;

public interface EventDenomUnitOrBuilder extends
    // @@protoc_insertion_point(interface_extends:provenance.marker.v1.EventDenomUnit)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string denom = 1;</code>
   * @return The denom.
   */
  java.lang.String getDenom();
  /**
   * <code>string denom = 1;</code>
   * @return The bytes for denom.
   */
  com.google.protobuf.ByteString
      getDenomBytes();

  /**
   * <code>string exponent = 2;</code>
   * @return The exponent.
   */
  java.lang.String getExponent();
  /**
   * <code>string exponent = 2;</code>
   * @return The bytes for exponent.
   */
  com.google.protobuf.ByteString
      getExponentBytes();

  /**
   * <code>repeated string aliases = 3;</code>
   * @return A list containing the aliases.
   */
  java.util.List<java.lang.String>
      getAliasesList();
  /**
   * <code>repeated string aliases = 3;</code>
   * @return The count of aliases.
   */
  int getAliasesCount();
  /**
   * <code>repeated string aliases = 3;</code>
   * @param index The index of the element to return.
   * @return The aliases at the given index.
   */
  java.lang.String getAliases(int index);
  /**
   * <code>repeated string aliases = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the aliases at the given index.
   */
  com.google.protobuf.ByteString
      getAliasesBytes(int index);
}
