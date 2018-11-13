package composite.base;

import java.util.ArrayList;

/**
 * 组合模式 Created by hcj on 18-7-8
 */
public class Client {

  public static void main(String[] args) {
    // 如何遍历得到总的关系
//      Branch branch = new Branch();
    Branch ceo = compositeCorpTree();
    System.out.println(ceo.getInfo());
    StringBuilder sb = new StringBuilder(8196);
    System.out.println(getTreeInfo(ceo));

  }

  /**
   * 遍历 Created by hcj on 18-7-8.
   */
  private static String getTreeInfo(Branch ceo) {
    StringBuilder info = new StringBuilder();
    ArrayList<ICorp> list = ceo.getList();
    for (ICorp corp : list) {
      if (corp instanceof Leaf) {
        info.append(corp.getInfo()).append("\n");
      } else {
        Branch corp1 = (Branch) corp;
        info.append(corp.getInfo()).append("\n").append(getTreeInfo(corp1));
      }
    }
    return info.toString();
  }

  private static Branch compositeCorpTree() {
    Branch ceo = new Branch("王大麻子", 100000, "ceo");
    Branch codeMangenter = new Branch("刘大瘸子", 50000, "codeMangenter");
    Branch miss = new Branch("秘书", 10000, "miss");
    ceo.add(codeMangenter);
    ceo.add(miss);

    Branch codeLeaderYang = new Branch("杨三", 20000, "codeLeader");
    ICorp coderA = new Branch("员工A", 8000, "coder");
    ICorp coderB = new Branch("员工B", 8000, "coder");
    codeMangenter.add(codeLeaderYang);
    codeLeaderYang.add(coderA);
    codeLeaderYang.add(coderB);

    Branch codeLeaderLiu = new Branch("吴六", 20000, "codeLeader");
    ICorp coderAA = new Branch("员工A", 8000, "coder");
    ICorp coderBB = new Branch("员工B", 8000, "coder");
    codeMangenter.add(codeLeaderLiu);
    codeLeaderLiu.add(coderAA);
    codeLeaderLiu.add(coderBB);

    return ceo;

  }
}
