// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: provenance/metadata/v1/tx.proto

package io.provenance.metadata.v1;

public interface MsgDeleteScopeOwnerRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:provenance.metadata.v1.MsgDeleteScopeOwnerRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * scope MetadataAddress for removing data access
   * </pre>
   *
   * <code>bytes scope_id = 1 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "MetadataAddress", (.gogoproto.moretags) = "yaml:&#92;"scope_id&#92;""];</code>
   * @return The scopeId.
   */
  com.google.protobuf.ByteString getScopeId();

  /**
   * <pre>
   * AccAddress owner addresses to be removed from scope
   * </pre>
   *
   * <code>repeated string owners = 2 [(.gogoproto.moretags) = "yaml:&#92;"owners&#92;""];</code>
   * @return A list containing the owners.
   */
  java.util.List<java.lang.String>
      getOwnersList();
  /**
   * <pre>
   * AccAddress owner addresses to be removed from scope
   * </pre>
   *
   * <code>repeated string owners = 2 [(.gogoproto.moretags) = "yaml:&#92;"owners&#92;""];</code>
   * @return The count of owners.
   */
  int getOwnersCount();
  /**
   * <pre>
   * AccAddress owner addresses to be removed from scope
   * </pre>
   *
   * <code>repeated string owners = 2 [(.gogoproto.moretags) = "yaml:&#92;"owners&#92;""];</code>
   * @param index The index of the element to return.
   * @return The owners at the given index.
   */
  java.lang.String getOwners(int index);
  /**
   * <pre>
   * AccAddress owner addresses to be removed from scope
   * </pre>
   *
   * <code>repeated string owners = 2 [(.gogoproto.moretags) = "yaml:&#92;"owners&#92;""];</code>
   * @param index The index of the value to return.
   * @return The bytes of the owners at the given index.
   */
  com.google.protobuf.ByteString
      getOwnersBytes(int index);

  /**
   * <pre>
   * signers is the list of address of those signing this request.
   * </pre>
   *
   * <code>repeated string signers = 3;</code>
   * @return A list containing the signers.
   */
  java.util.List<java.lang.String>
      getSignersList();
  /**
   * <pre>
   * signers is the list of address of those signing this request.
   * </pre>
   *
   * <code>repeated string signers = 3;</code>
   * @return The count of signers.
   */
  int getSignersCount();
  /**
   * <pre>
   * signers is the list of address of those signing this request.
   * </pre>
   *
   * <code>repeated string signers = 3;</code>
   * @param index The index of the element to return.
   * @return The signers at the given index.
   */
  java.lang.String getSigners(int index);
  /**
   * <pre>
   * signers is the list of address of those signing this request.
   * </pre>
   *
   * <code>repeated string signers = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the signers at the given index.
   */
  com.google.protobuf.ByteString
      getSignersBytes(int index);
}
