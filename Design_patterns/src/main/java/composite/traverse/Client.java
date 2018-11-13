package composite.traverse;

import java.util.ArrayList;

/**
 * 添加父类, 从中间进行遍历 Created by hcj on 18-7-8
 */
public class Client {

  public static void main(String[] args) {
    // 如何遍历得到总的关系
//      Branch branch = new Branch();
    Branch ceo = compositeCorpTree();
//    System.out.println(ceo.getInfo());
    StringBuilder sb = new StringBuilder(8196);
    // root 向下遍历
//    System.out.println(getTreeInfo(ceo));

    Branch o = (Branch) ceo.getSuborinateInfo().get(0);
    Branch o1 = (Branch) o.getSuborinateInfo().get(0);
    Branch o2 = (Branch) o1.getSuborinateInfo().get(0);
    // 从某一个节点向下遍历数据 杨三向下遍历
//    System.out.println(getTreeInfoForDown(o1));
    // 从中间状态向上遍历
    System.out.println(getTreeInfoForUp(o2));

  }

  private static String getTreeInfoForUp(Corp branch) {
    StringBuilder info = new StringBuilder();
    Branch branch1 = (Branch) branch;
    Branch parent = (Branch) branch1.getParent();
    // 向上取一层
//    ArrayList<Branch> list = (ArrayList<Branch>)parent.getSuborinateInfo();
    if (parent == null) {
      // 当前branch1
      return info.append(branch1.getInfo()).append("\n").toString();
    }

    while (true) {
      Branch  parent1 = (Branch) parent.getParent();
      if (parent1 == null) {
        // 只有一层, 老板
        return info.append(parent.getInfo()).append("\n").toString();
      }
//      info.append(parent1.getInfo()).append("\n");
      ArrayList suborinateInfo = parent1.getSuborinateInfo();
      for (Object subbranch : suborinateInfo) {
        Branch subbranch1 = (Branch) subbranch;
        info.append(subbranch1.getInfo()).append("\n");
      }
      // 向上一层
      parent=(Branch) parent.getParent();
    }
//    return info.toString();
//    for (Corp corp : list) {
//      if (corp.getParent()==null) {
//        // 遍历到根节点 ,返回
//        info.append(corp.getInfo()).append("\n");
//        break;
//      } else {
//        Branch corp1 = (Branch) corp;
//        info.append(corp.getInfo()).append("\n").append(getTreeInfoForUp(corp1));
//      }
//    }

  }


  private static String getTreeInfoForDown(Branch branch) {
    StringBuilder info = new StringBuilder();
    ArrayList<Branch> list = (ArrayList<Branch>) branch.getSuborinateInfo();
    for (Corp corp : list) {
      if (corp instanceof Leaf) {
        info.append(corp.getInfo()).append("\n");
      } else {
        Branch corp1 = (Branch) corp;
        info.append(corp.getInfo()).append("\n").append(getTreeInfoForDown(corp1));
      }
    }
    return info.toString();
  }

  /**
   * 遍历 Created by hcj on 18-7-8.
   */
  private static String getTreeInfo(Branch ceo) {
    StringBuilder info = new StringBuilder();
    ArrayList<Corp> list = ceo.getList();
    for (Corp corp : list) {
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
    Corp coderA = new Branch("员工A", 8000, "coder");
    Corp coderB = new Branch("员工B", 8000, "coder");
    codeMangenter.add(codeLeaderYang);
    codeLeaderYang.add(coderA);
    codeLeaderYang.add(coderB);

    Branch codeLeaderLiu = new Branch("吴六", 20000, "codeLeader");
    Corp coderAA = new Branch("员工A", 8000, "coder");
    Corp coderBB = new Branch("员工B", 8000, "coder");
    codeMangenter.add(codeLeaderLiu);
    codeLeaderLiu.add(coderAA);
    codeLeaderLiu.add(coderBB);

    return ceo;

  }
}
