package tr.com.merciyes.apigateway.filter;

import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import tr.com.merciyes.apigateway.wrapper.ProxyFilterWrapper;

import javax.servlet.http.HttpServletResponse;

/**
 * @author orkun.gedik
 */
public class ErrorFilter extends ProxyFilterWrapper {

    @Override
    public void construct() {
        super.construct(ErrorFilter.class, FilterConstants.ERROR_TYPE, 1, true);
    }

    @Override
    public Object run() {
        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();

        logger.info("{}: response status is {}.", response.getStatus());

        return null;
    }
}