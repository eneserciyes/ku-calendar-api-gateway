package tr.com.merciyes.apigateway.filter;

import com.netflix.discovery.EurekaClient;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import tr.com.merciyes.apigateway.exception.ApiGatewayException;
import tr.com.merciyes.apigateway.wrapper.ProxyFilterWrapper;

import javax.servlet.http.HttpServletRequest;

@Component
public class RequestFilter extends ProxyFilterWrapper {

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    @Override
    public void construct() {
        super.construct(RequestFilter.class, FilterConstants.PRE_TYPE, 1, true);
    }

    @Override
    public Object run() throws ApiGatewayException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        //TODO: Look at what is the problem here?
        logger.info("Request has been interrupted by Pre-Request filter. The http method is {}, target is {}",
                request.getRequestURL());

        return null;
    }
}
