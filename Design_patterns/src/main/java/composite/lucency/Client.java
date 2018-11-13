package composite.lucency;

import java.util.ArrayList;

/**
 * 组合模式 -> 透明设计模式, 子类若添加分支强制报错, 并且不添加接口规范共同方法.
 * Created by hcj on 18-7-8
 */
public class Client {

  public static void main(String[] args) {
    // 如何遍历得到总的关系
//      Branch branch = new Branch();
    IBranch ceo = compositeCorpTree();
    System.out.println(ceo.getInfo());
    System.out.println(getTreeInfo(ceo));

  }

  /**
   * 遍历 Created by hcj on 18-7-8.
   */
  private static String getTreeInfo(IBranch ceo) {
    ArrayList<IBranch> list = ceo.getSuborinateInfo();
    StringBuilder info = new StringBuilder();
    for (IBranch corp : list) {
      if (corp instanceof Leaf) {
        info.append(corp.getInfo()).append("\n");
      } else {
        Branch corp1 = (Branch) corp;
        info.append(corp.getInfo()).append("\n").append(getTreeInfo(corp1));
      }
    }
    return info.toString();
  }

  private static IBranch compositeCorpTree() {
    IBranch ceo = new Branch("王大麻子", 100000, "ceo");
    IBranch codeMangenter = new Branch("刘大瘸子", 50000, "codeMangenter");
    IBranch miss = new Leaf("秘书", 10000, "miss");
    ceo.add(codeMangenter);
    ceo.add(miss);

    IBranch codeLeaderYang = new Branch("杨三", 20000, "codeLeader");
    IBranch coderA = new Leaf("员工A", 8000, "coder");
    IBranch coderB = new Leaf("员工B", 8000, "coder");
    codeMangenter.add(codeLeaderYang);
    codeLeaderYang.add(coderA);
    codeLeaderYang.add(coderB);

    IBranch codeLeaderLiu = new Branch("吴六", 20000, "codeLeader");
    IBranch coderAA = new Leaf("员工A", 8000, "coder");
    IBranch coderBB = new Leaf("员工B", 8000, "coder");
    codeMangenter.add(codeLeaderLiu);
    codeLeaderLiu.add(coderAA);
    codeLeaderLiu.add(coderBB);

    return ceo;

  }
}
