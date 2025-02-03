package com.lzy.pnaWeb.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {
//    @Autowired
//    private AppUserServiceImpl appUserService;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HashMap<String, String> map = new HashMap<>();
//        //从http请求头获取token
//        String token = request.getHeader("token");
//        if (!(handler instanceof HandlerMethod)){
//            return true;
//        }
//        if (StrUtil.isBlank(token)){
//            throw new ServiceException(ResultCode.UNAUTHORIZED.getCode(),"empty token, please try again!");
//        }
//        String userId;
//        try{
//            userId = JWT.decode(token).getAudience().get(0);
//        }catch (Exception e){
//            throw new ServiceException(ResultCode.UNAUTHORIZED.getCode(),"token verify failed, please try again!");
//        }
//        AppUser user = appUserService.getById(Long.parseLong(userId));
//        if (user == null){
//            throw new ServiceException(ResultCode.UNAUTHORIZED.getCode(),"User does not exist, please try again!");
//        }
//
//        try{
//            TokenUtil.verify(token,user.getPassword());
//        }catch (Exception e){
//            throw new ServiceException(ResultCode.UNAUTHORIZED.getCode(),"token verify failed, please try again!");
//        }
//        return true;
//    }
}
