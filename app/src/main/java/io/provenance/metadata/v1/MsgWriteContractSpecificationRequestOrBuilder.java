// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: provenance/metadata/v1/tx.proto

package io.provenance.metadata.v1;

public interface MsgWriteContractSpecificationRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:provenance.metadata.v1.MsgWriteContractSpecificationRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * specification is the ContractSpecification you want added or updated.
   * </pre>
   *
   * <code>.provenance.metadata.v1.ContractSpecification specification = 1 [(.gogoproto.nullable) = false];</code>
   * @return Whether the specification field is set.
   */
  boolean hasSpecification();
  /**
   * <pre>
   * specification is the ContractSpecification you want added or updated.
   * </pre>
   *
   * <code>.provenance.metadata.v1.ContractSpecification specification = 1 [(.gogoproto.nullable) = false];</code>
   * @return The specification.
   */
  io.provenance.metadata.v1.ContractSpecification getSpecification();
  /**
   * <pre>
   * specification is the ContractSpecification you want added or updated.
   * </pre>
   *
   * <code>.provenance.metadata.v1.ContractSpecification specification = 1 [(.gogoproto.nullable) = false];</code>
   */
  io.provenance.metadata.v1.ContractSpecificationOrBuilder getSpecificationOrBuilder();

  /**
   * <pre>
   * signers is the list of address of those signing this request.
   * </pre>
   *
   * <code>repeated string signers = 2;</code>
   * @return A list containing the signers.
   */
  java.util.List<java.lang.String>
      getSignersList();
  /**
   * <pre>
   * signers is the list of address of those signing this request.
   * </pre>
   *
   * <code>repeated string signers = 2;</code>
   * @return The count of signers.
   */
  int getSignersCount();
  /**
   * <pre>
   * signers is the list of address of those signing this request.
   * </pre>
   *
   * <code>repeated string signers = 2;</code>
   * @param index The index of the element to return.
   * @return The signers at the given index.
   */
  java.lang.String getSigners(int index);
  /**
   * <pre>
   * signers is the list of address of those signing this request.
   * </pre>
   *
   * <code>repeated string signers = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the signers at the given index.
   */
  com.google.protobuf.ByteString
      getSignersBytes(int index);

  /**
   * <pre>
   * spec_uuid is an optional contract specification uuid string, e.g. "def6bc0a-c9dd-4874-948f-5206e6060a84"
   * If provided, it will be used to generate the MetadataAddress for the contract specification which will override the
   * specification_id in the provided specification. If not provided (or it is an empty string), nothing special
   * happens.
   * If there is a value in specification.specification_id that is different from the one created from this uuid, an
   * error is returned.
   * </pre>
   *
   * <code>string spec_uuid = 3 [(.gogoproto.moretags) = "yaml:&#92;"spec_uuid&#92;""];</code>
   * @return The specUuid.
   */
  java.lang.String getSpecUuid();
  /**
   * <pre>
   * spec_uuid is an optional contract specification uuid string, e.g. "def6bc0a-c9dd-4874-948f-5206e6060a84"
   * If provided, it will be used to generate the MetadataAddress for the contract specification which will override the
   * specification_id in the provided specification. If not provided (or it is an empty string), nothing special
   * happens.
   * If there is a value in specification.specification_id that is different from the one created from this uuid, an
   * error is returned.
   * </pre>
   *
   * <code>string spec_uuid = 3 [(.gogoproto.moretags) = "yaml:&#92;"spec_uuid&#92;""];</code>
   * @return The bytes for specUuid.
   */
  com.google.protobuf.ByteString
      getSpecUuidBytes();
}
