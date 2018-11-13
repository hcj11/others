package Response;

/**
 * Created by hcj on 18-7-8
 */
public class Women implements IWomen {

  private String request = "";
  private int type = 0;

  public Women(String request, int type) {
    this.type=type;
    // 判断一波
    switch (this.type) {
      case 1:
        this.request = "向父亲请示,"+request;
        break;
      case 2:
        this.request = "向丈夫请示,"+request;
        break;
      case 3:
        this.request = "向儿子请示,"+request;
        break;
    }
  }

  @Override
  public int getType() {
    // 身份: 女儿
    return this.type;
  }

  public void setType(int type) {
    this.type = type;
  }

  @Override
  public String getRequest() {
    // 我想请求同意,
    return request;
  }
}
