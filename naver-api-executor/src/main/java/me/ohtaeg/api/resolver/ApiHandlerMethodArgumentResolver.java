package me.ohtaeg.api.resolver;

import me.ohtaeg.api.dto.SearchWord;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@Component
public class ApiHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(final MethodParameter parameter) {
        return parameter.getParameterType().equals(SearchWord.class);
    }

    @Override
    public Object resolveArgument(final MethodParameter parameter, final ModelAndViewContainer mavContainer, final NativeWebRequest webRequest, final WebDataBinderFactory binderFactory) throws Exception {
        if (supportsParameter(parameter)) {
            ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
            HttpServletRequest request = servletWebRequest.getRequest();
            String query = request.getParameter("query");
            String display = request.getParameter("display");
            String start = request.getParameter("start");
            String sort = request.getParameter("sort");
            return new SearchWord(query, Integer.parseInt(display), Integer.parseInt(start), sort);
        }
        /**
         * 예외처리를 하지 않는 이유는 InvocableHandlerMethod의 invokeForRequest에서 커스텀한 resolver가 지원하지 않는 파라미터 타입이면
         * 예외처리하도록 구성되어 있어서 쓰기만 하면 된다.
         */
        //throw new IllegalArgumentException("잘못된 쿼리스트링 입니다.");
        return null;
    }
}
