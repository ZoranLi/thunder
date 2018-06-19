package okhttp3;

enum HttpUrl$Builder$ParseResult {
    SUCCESS,
    MISSING_SCHEME,
    UNSUPPORTED_SCHEME,
    INVALID_PORT,
    INVALID_HOST
}
