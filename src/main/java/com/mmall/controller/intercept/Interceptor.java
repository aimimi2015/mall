package com.mmall.controller.intercept;//package com.mmall.controller.intercept;
//
//import com.mmall.common.Const;
//import com.mmall.common.ResponseCode;
//import com.mmall.common.ServerResponse;
//import com.mmall.pojo.User;
//import net.sf.json.JSONObject;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
///**
// * session拦截器
// * Created by ${aimimi2015} on 2017/8/24.
// */
//@Controller
//public class Interceptor implements HandlerInterceptor{
//
//    //    进入handle方法之前
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        User user=(User)request.getSession().getAttribute(Const.CURRENT_USER);
//        if (user != null) {
//
//            return true;
//        }
////        if (request.getHeader("x-requested-with") != null) {
//
//            /*
//            * 这个地方不知道怎么处理ajax请求
//            * */
//            /* 设置格式为text/json */
//
//            response.setContentType("text/json");
//
//		/* 设置字符集为'UTF-8' */
//
//        response.setCharacterEncoding("UTF-8");
//        try {
//
//            PrintWriter write = response.getWriter();
//            response.reset();
//
//            String jsonstr = "{\"tatus\":\"0\",\"msg\":\"buguo\"}";
//            JSONObject json_test = JSONObject.fromObject(jsonstr);
//
//            write.write(json_test.toString());
//
//            write.flush();
//
//            write.close();
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//
//        }
//
//
////        else {
//////
////            request.getRequestDispatcher("/user/relogin").forward(request, response);
////        }
//
//        return false;
//
//
//    }
//
//
//
//
//    //进入方法之后
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//
//    }
//}
//
