package org.zy.cloud.zuul.server.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulConfigFilter extends ZuulFilter {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info(String.format("Zuul路由网关 : %s -> %s", request.getMethod(), request.getRequestURL()));
		String token = request.getParameter("token");
		if (StringUtils.isEmpty(token)) {
			logger.warn("Zuul路由网关 : token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			ctx.setResponseBody(JSON.toJSONString(ResponseCode.FAILURE));
			return null;
		}
		logger.info("Zuul路由网关 : OK");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

}