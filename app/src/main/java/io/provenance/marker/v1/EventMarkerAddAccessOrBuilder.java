// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: provenance/marker/v1/marker.proto

package io.provenance.marker.v1;

public interface EventMarkerAddAccessOrBuilder extends
    // @@protoc_insertion_point(interface_extends:provenance.marker.v1.EventMarkerAddAccess)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.provenance.marker.v1.EventMarkerAccess access = 1 [(.gogoproto.nullable) = false];</code>
   * @return Whether the access field is set.
   */
  boolean hasAccess();
  /**
   * <code>.provenance.marker.v1.EventMarkerAccess access = 1 [(.gogoproto.nullable) = false];</code>
   * @return The access.
   */
  io.provenance.marker.v1.EventMarkerAccess getAccess();
  /**
   * <code>.provenance.marker.v1.EventMarkerAccess access = 1 [(.gogoproto.nullable) = false];</code>
   */
  io.provenance.marker.v1.EventMarkerAccessOrBuilder getAccessOrBuilder();

  /**
   * <code>string denom = 2;</code>
   * @return The denom.
   */
  java.lang.String getDenom();
  /**
   * <code>string denom = 2;</code>
   * @return The bytes for denom.
   */
  com.google.protobuf.ByteString
      getDenomBytes();

  /**
   * <code>string administrator = 3;</code>
   * @return The administrator.
   */
  java.lang.String getAdministrator();
  /**
   * <code>string administrator = 3;</code>
   * @return The bytes for administrator.
   */
  com.google.protobuf.ByteString
      getAdministratorBytes();
}
