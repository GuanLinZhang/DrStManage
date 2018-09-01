package cn.drst.bean;

public class LoginBean {
   //图片路径
   private String loginPic;
   //临时token
   private String tempTok;
   //状态
   private String status;

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getTempTok() {
      return tempTok;
   }

   public void setTempTok(String tempTok) {
      this.tempTok = tempTok;
   }

   public String getLoginPic() {
      return loginPic;
   }

   public void setLoginPic(String loginPic) {
      this.loginPic = loginPic;
   }
}
