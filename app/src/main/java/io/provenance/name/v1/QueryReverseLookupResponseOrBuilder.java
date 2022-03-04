// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: provenance/name/v1/query.proto

package io.provenance.name.v1;

public interface QueryReverseLookupResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:provenance.name.v1.QueryReverseLookupResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * an array of names bound against a given address
   * </pre>
   *
   * <code>repeated string name = 1;</code>
   * @return A list containing the name.
   */
  java.util.List<java.lang.String>
      getNameList();
  /**
   * <pre>
   * an array of names bound against a given address
   * </pre>
   *
   * <code>repeated string name = 1;</code>
   * @return The count of name.
   */
  int getNameCount();
  /**
   * <pre>
   * an array of names bound against a given address
   * </pre>
   *
   * <code>repeated string name = 1;</code>
   * @param index The index of the element to return.
   * @return The name at the given index.
   */
  java.lang.String getName(int index);
  /**
   * <pre>
   * an array of names bound against a given address
   * </pre>
   *
   * <code>repeated string name = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the name at the given index.
   */
  com.google.protobuf.ByteString
      getNameBytes(int index);

  /**
   * <pre>
   * pagination defines an optional pagination for the request.
   * </pre>
   *
   * <code>.cosmos.base.query.v1beta1.PageResponse pagination = 2;</code>
   * @return Whether the pagination field is set.
   */
  boolean hasPagination();
  /**
   * <pre>
   * pagination defines an optional pagination for the request.
   * </pre>
   *
   * <code>.cosmos.base.query.v1beta1.PageResponse pagination = 2;</code>
   * @return The pagination.
   */
  cosmos.base.query.v1beta1.Pagination.PageResponse getPagination();
  /**
   * <pre>
   * pagination defines an optional pagination for the request.
   * </pre>
   *
   * <code>.cosmos.base.query.v1beta1.PageResponse pagination = 2;</code>
   */
  cosmos.base.query.v1beta1.Pagination.PageResponseOrBuilder getPaginationOrBuilder();
}