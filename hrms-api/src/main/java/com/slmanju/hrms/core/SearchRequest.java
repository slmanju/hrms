package com.slmanju.hrms.core;

import lombok.Data;

/**
 * This class holds search request dto.
 *
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
public class SearchRequest<T> {

  public static final int DEFAULT_SIZE = 20;

  protected int start;

  protected int end;

  protected int size = DEFAULT_SIZE;

}
