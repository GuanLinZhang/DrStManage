package cn.drst.app_controller;

import cn.drst.app_service.AppWelcomeImageService;
import cn.drst.base.RetData;
import cn.drst.bean.ResponseBean;
import cn.drst.bean.WelcomeBean;
import cn.drst.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppMobileWelcomeImageController {
    private final AppWelcomeImageService appWelcomeImageService;

    @Autowired
    public AppMobileWelcomeImageController(AppWelcomeImageService appWelcomeImageService) {
        this.appWelcomeImageService = appWelcomeImageService;
    }

    @RequestMapping(value = "/AppWelcomeImage.do", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean<WelcomeBean> PresentImage() {
        ResponseBean<WelcomeBean> rb = new ResponseBean<WelcomeBean>();
        List<String> tokens = TokenUtil.GetUUID();

        //将Token传入数据库
        String imgUrl = appWelcomeImageService.getImage();
        if(imgUrl.equals("")){
            rb.setState(200);
            rb.setMessage("系统错误");
            return rb;
        }
        //输入Token
        appWelcomeImageService.insertToken(tokens.get(0),tokens.get(1));
        //创建结果状态数据集
        RetData<WelcomeBean> retWe = new RetData<WelcomeBean>();
        List<WelcomeBean> lisWe = new ArrayList<WelcomeBean>();
        WelcomeBean welcomeB = new WelcomeBean();
        welcomeB.setToken(tokens.get(0));
        welcomeB.setImage(imgUrl);
        welcomeB.setState(1);
        //添加结果数据集
        lisWe.add(welcomeB);
        retWe.setListData(lisWe);
        rb.setRetData(retWe);
        rb.setState(100);
        rb.setMessage("成功");
        return rb;
    }
}
