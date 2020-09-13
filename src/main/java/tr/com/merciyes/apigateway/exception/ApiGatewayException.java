package tr.com.merciyes.apigateway.exception;

import com.netflix.zuul.exception.ZuulException;
import tr.com.merciyes.apigateway.exception.error.ApiGatewayErrorType;

/**
 * @author orkun.gedik
 */
public class ApiGatewayException extends ZuulException {

  public ApiGatewayException(ApiGatewayErrorType error, String cause) {
    super(error.getTitle(), error.getStatus(), cause);
  }

  public ApiGatewayException(ApiGatewayErrorType error) {
    super(error.getTitle(), error.getStatus(), "");
  }

  public ApiGatewayException(ApiGatewayErrorType error, Throwable throwable) {
    super(throwable, error.getTitle(), error.getStatus(), "");
  }
}
