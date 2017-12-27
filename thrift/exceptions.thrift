namespace java com.pangramia.services.exceptions

/**
 * Common Error Codes
 */
enum PBErrorCode {
  /** No information available about the error */
  UNKNOWN = 1,

  /** The format of the request data was incorrect */
  BAD_DATA_FORMAT = 2,

  /** Not permitted to perform action */
  PERMISSION_DENIED = 3,

  /** Unexpected problem with the service */
  INTERNAL_ERROR = 4,

  /** A required parameter/field was absent */
  DATA_REQUIRED = 5,

  /** Operation denied due to data model limit */
  LIMIT_REACHED = 6,

  /** Operation denied due to user storage limit */
  QUOTA_REACHED = 7,

  /** Username and/or password incorrect */
  INVALID_AUTH = 8,

  /** Authentication token expired */
  AUTH_EXPIRED = 9,

  /** Change denied due to data model conflict */
  DATA_CONFLICT = 10,

  /** Content of submitted note was malformed */
  VALIDATION = 11,

  /** Service shard with account data is temporarily down */
  SHARD_UNAVAILABLE = 12,

  /** Operation denied due to data model limit, where something such
   *  as a string length was too short */
  LEN_TOO_SHORT = 13,

  /** Operation denied due to data model limit, where something such
   *  as a string length was too long */
  LEN_TOO_LONG = 14,

  /** Operation denied due to data model limit, where there were
   *  too few of something. */
  TOO_FEW = 15,

  /** Operation denied due to data model limit, where there were
   *  too many of something. */
  TOO_MANY = 16,

  /** Operation denied because it is currently unsupported. */
  UNSUPPORTED_OPERATION = 17,

  /** Operation denied because access to the corresponding object is
   *  prohibited in response to a take-down notice. */
  TAKEN_DOWN = 18,

  /**
   * Operation denied because the calling application has reached
   * its hourly API call limit for this user. */
  RATE_LIMIT_REACHED = 19,

  /** The given resource is not found */
  NOT_FOUND = 20
}

/**
* Basic Service exception, that occurs due to service malformed behaviour
**/
exception PBServiceException {
   1: required PBErrorCode errorCode,
   2: string message
}

/**
* Basic User exception, that triggered by user misuse of the service or  improper arguments
**/
exception PBUserException {
   1: required PBErrorCode errorCode,
   2: string message
}
