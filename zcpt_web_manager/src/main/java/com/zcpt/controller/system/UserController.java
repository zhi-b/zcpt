//package com.zcpt.controller.system;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.zcpt.entity.ResponseData;
//import com.zcpt.pojo.users.User;
//import com.zcpt.realname.IUserService;
//import com.zcpt.utils.JWTUtils;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Date;
//
//@RestController
//@RequestMapping("/manager/system")
//@Api(tags = "登录接口")
//public class UserController {
//    @Reference
//    private IUserService userService;
//
//
//    @PostMapping("/login")
//    @ApiOperation(value = "登录接口",notes = "根据用户名和密码认证用户")
//    @ApiImplicitParams({
//            @ApiImplicitParam(value = "登录账号",paramType = "query",required = true,name = "username",dataType = "String"),
//            @ApiImplicitParam(value = "登录密码",paramType = "query",required = true,name = "password",dataType = "String"),
//    })
//
//    public ResponseData<User> login(@RequestParam String username, @RequestParam String password){
//        System.out.println(username+"++++++++++++++"+password);
////        Admin admin = adminService.queryAdminByNameAndPwd(loginname,pass);
////        ResponseData responseData = ResponseData.success();
////        if(admin != null){
////            String token = JWTUtil.generToken(admin.getId().toString(),"LiuLiu@Mall",admin.getName());
////            //向浏览器返回token
////            responseData.putDataVule("token",token);
////            //返回用户信息
////            responseData.putDataVule("admin",admin);
////        }else {
////            responseData = ResponseData.cusstomerError("用户名或密码错误");
////        }
//
//        ResponseData responseData = null;
//        //根据用户名查询用户信息
//        User user = userService.queryUserByNameAndPwd(username,"1");
//        if(user == null){
//            responseData = ResponseData.cusstomerError("用户不存在");
//        }else{
//            boolean checkPw =  BCrypt.checkpw(password,user.getPassword());
//            if(checkPw){
//                String token =  JWTUtils.generToken(user.getId().toString(),"zcpt@no2",user.getUsername());
//                responseData = ResponseData.success().putDataVule("token",token).putDataVule("user",user);
//                //Session
//
////                HttpSession session = request.getSession(true);
////                session.setAttribute("id",admin.getId());
////                session.setAttribute("loginName", admin.getId());
//                responseData = ResponseData.success().putDataVule("token",token).putDataVule("user",user);//.putDataVule("session",session);
//            }else{
//                responseData = ResponseData.cusstomerError("用户认证失败");
//            }
//        }
//        return responseData;
//    }
//
//
//
//    //待完善
//
////    @GetMapping("/updata")
////    @ApiOperation(value = "更新个人信息接口", notes = "填写更新个人信息")
////    //@ApiImplicitParam(value = "个人信息", name = "admin", required = true, paramType = "query", dataTypeClass = Admin.class)
////    public ResponseData<User> updata(@RequestBody User user){
////        try{
////            userService.upuserdata(user);
////            return ResponseData.success();
////        } catch (Exception e) {
////            return ResponseData.serverInternalError();
////        }
////    }
//
//    //用户注册
//
//    @GetMapping("/add")
//    @ApiOperation(value = "注册接口",notes = "用户注册")
//    @ApiImplicitParams({
//            @ApiImplicitParam(value = "账号",paramType ="query",required = true,name = "username",dataType = "String"),
//            @ApiImplicitParam(value = "密码",paramType ="query",required = true,name = "password",dataType = "String")
//    })
//
//    public ResponseData<User> add(@RequestParam String username,@RequestParam String password,@RequestParam String nick_name){
//        boolean che =check(username,password);
//        if (che == true) {
//            try {
//                User user = new User();
//                user.setUsername(username);
//                //获取烟
//                String salt = BCrypt.gensalt();//29个字符  随机生成
//                System.out.println(salt);
//                String newPassword = BCrypt.hashpw(password, salt);
//                user.setPassword(newPassword);
//                //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//                user.setNickName(nick_name);
//                user.setCreated(new Date());
//                user.setIsRealnameCheck("0");
////                userService.addUser(user);
//                return ResponseData.success();
//            } catch (Exception e) {
//                return ResponseData.serverInternalError();
//            }
//        }else {
//            return ResponseData.cusstomerError("用户名已存在！");
//        }
//    }
//
//
//
//    //管理员对用户删除（根据用户名）
////    @GetMapping("/delete")
////    @ApiOperation(value = "删除用户接口",notes = "用户删除")
////    @ApiImplicitParam(value = "账号",paramType ="query",required = true,name = "username",dataType = "String")
////    public ResponseData<User> deleteuser(@RequestParam String username){
////        try{
////            userService.deleteuser(username);
////            return ResponseData.success();
////        }catch (Exception e) {
////            return ResponseData.serverInternalError();
////        }
////    }
//
//    public boolean check(String username,String password){
//        ResponseData<User> aa= login(username,"1");
////        User user = userService.queryUserByNameAndPwd(username,"1");
//        if (user == null){
//            return true;
//        }else
//            return false;
//    }
//
//}
