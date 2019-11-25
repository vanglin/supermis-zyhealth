package com.smartpro.mis.rest.modular.auth.filter;

import com.smartpro.mis.core.base.tips.ErrorTip;
import com.smartpro.mis.core.util.RenderUtil;
import com.smartpro.mis.rest.common.exception.BizExceptionEnum;
import com.smartpro.mis.rest.config.properties.JwtProperties;
import com.smartpro.mis.rest.modular.auth.util.JwtTokenUtil;
import com.smartpro.mis.core.base.tips.ErrorTip;
import com.smartpro.mis.core.util.RenderUtil;
import com.smartpro.mis.rest.common.exception.BizExceptionEnum;
import com.smartpro.mis.rest.config.properties.JwtProperties;
import com.smartpro.mis.rest.modular.auth.util.JwtTokenUtil;
import io.jsonwebtoken.JwtException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对客户端请求的jwt token验证过滤器
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:04
 */
public class AuthFilter extends OncePerRequestFilter {

    private final Log logger = LogFactory.getLog(this.getClass());

//    @Autowired
    private JwtTokenUtil jwtTokenUtil =new JwtTokenUtil();

//    @Autowired
    private JwtProperties jwtProperties = new JwtProperties();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("##################################"+request.getServletPath());
        if (request.getServletPath().equals("/"+jwtProperties.getAuthPath() )) {
            chain.doFilter(request, response);
            return;
        }
        final String requestHeader = request.getHeader(jwtProperties.getHeader());
        System.out.println("Header+++++++++++++++++++++++++++++"+requestHeader);
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);
            System.out.println("Toekn=============="+authToken);

            //验证token是否过期,包含了验证jwt是否正确
            try {
                System.out.println("++++++++++++isTokenExpired+++++++++++++++++");
                boolean flag = jwtTokenUtil.isTokenExpired(authToken);
                System.out.println("Header+++++++++++++++++++++++++++++"+flag);
                if (flag) {
                    RenderUtil.renderJson(response, new ErrorTip(BizExceptionEnum.TOKEN_EXPIRED.getCode(), BizExceptionEnum.TOKEN_EXPIRED.getMessage()));
                    return;
                }
            } catch (JwtException e) {
                //有异常就是token解析失败
                RenderUtil.renderJson(response, new ErrorTip(BizExceptionEnum.TOKEN_ERROR.getCode(), BizExceptionEnum.TOKEN_ERROR.getMessage()));
                return;
            }
        } else {
            //header没有带Bearer字段
            System.out.println("Header+++++++++++++++++Bearer++++++++++++");
            RenderUtil.renderJson(response, new ErrorTip(BizExceptionEnum.TOKEN_ERROR.getCode(), BizExceptionEnum.TOKEN_ERROR.getMessage()));
            return;
        }
        chain.doFilter(request, response);
    }
}